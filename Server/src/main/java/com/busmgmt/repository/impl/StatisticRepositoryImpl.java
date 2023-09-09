/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.repository.impl;

import com.busmgmt.pojo.Busroutes;
import com.busmgmt.pojo.Bustrips;
import com.busmgmt.pojo.Customers;
import com.busmgmt.pojo.Deliveries;
import com.busmgmt.pojo.Orders;
import com.busmgmt.pojo.Tickets;
import com.busmgmt.repository.StatisticRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class StatisticRepositoryImpl implements StatisticRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private SimpleDateFormat f;

    @Override
    public List<Object[]> countTripByRoute() {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root rBt = q.from(Bustrips.class);
        Root rBr = q.from(Busroutes.class);

        q.multiselect(rBr.get("routeId"), rBr.get("routeName"), b.count(rBt.get("tripId")));

        q.where(b.equal(rBt.get("bustrips"), rBr.get("routeId")));
        q.groupBy(rBr.get("routeId"));

        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public List<Object[]> statsRevenue(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root rBt = q.from(Bustrips.class);
        Root rT = q.from(Tickets.class);
        Root rO = q.from(Orders.class);

        q.multiselect(rBt.get("tripId"), rBt.get("tripName"), b.sum(rT.get("price")));

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rT.get("tripId"), rBt.get("tripId")));
        predicates.add(b.equal(rT.get("orderId"), rO.get("orderId")));

        String fd = params.get("fromDate");
        if (fd != null && !fd.isEmpty()) {
            try {
                predicates.add(b.greaterThanOrEqualTo(rO.get("createdDate"), f.parse(fd)));
            } catch (ParseException ex) {
                Logger.getLogger(StatisticRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        String td = params.get("toDate");
        if (td != null && !td.isEmpty()) {
            try {
                predicates.add(b.lessThanOrEqualTo(rO.get("createdDate"), f.parse(td)));
            } catch (ParseException ex) {
                Logger.getLogger(StatisticRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        String quarter = params.get("quarter");
        if (quarter != null && !quarter.isEmpty()) {
            String year = params.get("year");
            if (year != null && !year.isEmpty()) {
                predicates.addAll(Arrays.asList(
                        b.equal(b.function("YEAR", Integer.class, rO.get("createdDate")), Integer.parseInt(year)),
                        b.equal(b.function("QUARTER", Integer.class, rO.get("createdDate")), Integer.parseInt(quarter))
                ));
            }
        }

        q.where(predicates.toArray(Predicate[]::new));

        q.groupBy(rBt.get("tripId"));

        Query query = session.createQuery(q);
        return query.getResultList();

    }
}
