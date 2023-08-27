/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.repository.impl;

import com.busmgmt.pojo.Bustrips;
import com.busmgmt.repository.BusTripRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
@PropertySource("classpath:configs.properties")
public class BusTripRepositoryImpl implements BusTripRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;

    @Override
    public List<Bustrips> getBustrips(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Bustrips> q = b.createQuery(Bustrips.class);
        Root root = q.from(Bustrips.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                predicates.add(b.like(root.get("tripName"), String.format("%%%s%%", kw)));
            }

            String routeId = params.get("routeId");
            if (routeId != null && !routeId.isEmpty()) {
                predicates.add(b.equal(root.get("routeId"), Integer.parseInt(routeId)));
            }

            q.where(predicates.toArray(Predicate[]::new));
        }

        q.orderBy(b.asc(root.get("tripId")));

        Query query = session.createQuery(q);

        if (params != null) {
            String page = params.get("page");
            if (page != null && !page.isEmpty()) {
                int p = Integer.parseInt(page);
                int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));

                query.setMaxResults(pageSize);
                query.setFirstResult((p - 1) * pageSize);
            }
        }

        return query.getResultList();

    }

    @Override
    public Long countBusTrip() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT Count(*) FROM Bustrips");

        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public boolean updateBusTrip(Bustrips bt) {
        Session s = this.factory.getObject().getCurrentSession();

        try {
            int tripId = bt.getTripId();
            int exists = isTripIdExists(tripId);
            if (exists > 0) {
                s.update(bt);
            } else {
                s.save(bt);
            }
//              if (b.getLicensePlateId() != null){
//                  s.save(b);
//              }
//              else {
//                  s.update(b);
//              }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public int isTripIdExists(int tripId) {
        Session session = this.factory.getObject().getCurrentSession();
        String sql = "SELECT COUNT(*) FROM Bustripd WHERE tripId = :tripId";
        Object result = session.createNativeQuery(sql)
                .setParameter("tripId", tripId)
                .getSingleResult();
        return ((Number) result).intValue();
    }

    @Override
    public Bustrips getBusTripById(int id) {
        Session s = this.factory.getObject().getCurrentSession();

        return s.get(Bustrips.class, id);
    }
}
