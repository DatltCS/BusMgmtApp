/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.repository.impl;

import com.busmgmt.pojo.Bustrips;
import com.busmgmt.pojo.Customers;
import com.busmgmt.pojo.Reviews;
import com.busmgmt.pojo.Users;
import com.busmgmt.repository.ReviewRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
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
public class ReviewRepositoryImpl implements ReviewRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Reviews> getReivewsByTripId(int tripId) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Reviews> query = b.createQuery(Reviews.class);
        
        Root root = query.from(Reviews.class);
        
        query = query.where(b.equal(root.get("tripId"),tripId));
        query = query.orderBy(b.desc(root.get("reviewId")));
        
        Query q = session.createQuery(query);
        
        return q.getResultList();
    }

    @Override
    public Reviews addReview(Reviews r, int tripId) {
        Session session = this.factory.getObject().getCurrentSession();
        try {
            if (tripId != 0) {
                Bustrips bt = session.get(Bustrips.class,tripId);
//                Users u = session.get(Users.class,userId);
                if (bt != null) {
//                    r.setUserId(u);
                    r.setTripId(bt);
                    session.save(r);
                    return r;
                }
            }
            return null;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
