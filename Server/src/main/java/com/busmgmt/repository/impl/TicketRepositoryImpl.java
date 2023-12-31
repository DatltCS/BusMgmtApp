/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.repository.impl;

import com.busmgmt.pojo.Bustrips;
import com.busmgmt.pojo.Customers;
import com.busmgmt.pojo.Orders;
import com.busmgmt.pojo.Tickets;
import com.busmgmt.repository.TicketRepository;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
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
public class TicketRepositoryImpl implements TicketRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;

    @Override
    public List<Tickets> getTicket(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Tickets");

        return q.getResultList();
    }

    @Override
    public Tickets getTicketById(int id) {
        Session s = this.factory.getObject().getCurrentSession();

        return s.get(Tickets.class, id);
    }

    @Override
    public Tickets addTicket(Tickets t, int orderId, int tripId) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (orderId != 0 && tripId != 0) {
                Orders o = s.get(Orders.class,orderId);
                Bustrips bt = s.get(Bustrips.class, tripId);
                if (o != null && bt != null) {
                    t.setOrderId(o);
                    t.setTripId(bt);
                    s.save(t);
                    s.flush();
                    return t;
                }
            }
            return null;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Tickets updateTicket(Tickets t, int orderId, int tripId) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (orderId != 0 && tripId != 0) {
                Orders o = s.get(Orders.class,orderId);
                Bustrips bt = s.get(Bustrips.class, tripId);
                if (o != null && bt != null) {
                    t.setOrderId(o);
                    t.setTripId(bt);
                    s.update(t);
                    s.flush();
                    return t;
                }
            }
            return null;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    

    @Override
    public boolean deleteTicket(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        
        Tickets t = this.getTicketById(id);
        try {
            s.delete(t);
            
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
