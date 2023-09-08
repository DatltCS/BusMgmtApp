/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.repository.impl;

import com.busmgmt.pojo.Busroutes;
import com.busmgmt.repository.BusRouteRepository;
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
public class BusRouteRepositoryImpl implements BusRouteRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;

    @Override
    public List<Busroutes> getBusroute(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Busroutes");

        return q.getResultList();
    }

    @Override
    public Busroutes addBusroute(Busroutes br) {
        Session s = this.factory.getObject().getCurrentSession();
        s.save(br);
        s.flush();
        return br;
    }

    @Override
    public Busroutes updateBusroute(Busroutes br) {
        Session s = this.factory.getObject().getCurrentSession();
        s.update(br);
        s.flush();
        return br;
    }

    @Override
    public boolean deleteBustrip(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        
        Busroutes br = this.getBusRouteById(id);
        try {
            s.delete(br);
            
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Busroutes getBusRouteById(int id) {
        Session s = this.factory.getObject().getCurrentSession();

        return s.get(Busroutes.class, id);
    }
}