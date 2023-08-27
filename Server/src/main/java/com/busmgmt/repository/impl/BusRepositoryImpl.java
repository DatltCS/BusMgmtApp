/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.repository.impl;

import com.busmgmt.pojo.Bus;
import com.busmgmt.repository.BusRepository;
import java.math.BigInteger;
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
public class BusRepositoryImpl implements BusRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;

    @Override
    public List<Bus> getBus(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Bus> q = b.createQuery(Bus.class);
        Root root = q.from(Bus.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                predicates.add(b.like(root.get("busName"), String.format("%%%s%%", kw)));
            }

            String companyId = params.get("companyId");
            if (companyId != null && !companyId.isEmpty()) {
                predicates.add(b.equal(root.get("companyId"), Integer.parseInt(companyId)));
            }

            q.where(predicates.toArray(Predicate[]::new));
        }

        q.orderBy(b.asc(root.get("licensePlateId")));

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
    public Long countBus() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT Count(*) FROM Bus");

        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public boolean updateBus(Bus b) {
        Session s = this.factory.getObject().getCurrentSession();

        try {
            int licensePlateId = b.getLicensePlateId();
            int exists = isLicensePlateIdExists(licensePlateId);
            if (exists > 0) {
                s.update(b);
            } else{
                s.save(b);
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

    @Override
    public Bus getBusById(int id) {
        Session s = this.factory.getObject().getCurrentSession();

        return s.get(Bus.class, id);
    }

    public int isLicensePlateIdExists(int licensePlateId) {
        Session session = this.factory.getObject().getCurrentSession();
        String sql = "SELECT COUNT(*) FROM Bus WHERE licensePlateId = :licensePlateId";
        Object result = session.createNativeQuery(sql)
                .setParameter("licensePlateId", licensePlateId)
                .getSingleResult();
        return ((Number) result).intValue();
    }

    @Override
    public boolean deleteBus(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        
        Bus b = this.getBusById(id);
        try {
            s.delete(b);
            
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
