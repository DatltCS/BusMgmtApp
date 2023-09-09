/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.busmgmt.repository.impl;

import com.busmgmt.pojo.Bustrips;
import com.busmgmt.pojo.Deliveries;
import com.busmgmt.pojo.Orders;
import com.busmgmt.pojo.Tickets;
import com.busmgmt.repository.DeliveryRepository;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
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
public class DeliveryRepositoryImpl implements DeliveryRepository{
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Deliveries> getDelivery(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Deliveries");

        return q.getResultList();
    }
    
    @Override
    public Deliveries getDeliveryById(int id) {
        Session s = this.factory.getObject().getCurrentSession();

        return s.get(Deliveries.class, id);
    }

    @Override
    public Deliveries addDelivery(Deliveries c, int orderId, int tripId) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (orderId != 0 && tripId != 0) {
                Orders o = s.get(Orders.class,orderId);
                Bustrips bt = s.get(Bustrips.class, tripId);
                if (o != null && bt != null) {
                    c.setOrderId(o);
                    c.setTripId(bt);
                    s.save(c);
                    s.flush();
                    return c;
                }
            }
            return null;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
}