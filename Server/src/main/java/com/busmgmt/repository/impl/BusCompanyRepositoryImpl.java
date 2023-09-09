/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.repository.impl;

import com.busmgmt.pojo.Buscompanies;
import com.busmgmt.repository.BusCompanyRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
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
public class BusCompanyRepositoryImpl implements BusCompanyRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public List<Buscompanies> getBuscompanies() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Buscompanies");
        
        return q.getResultList();
    }

    @Override
    public boolean addBuscompanies(Buscompanies buscompanies) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            s.save(buscompanies);

            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean activeBuscompanies(Buscompanies buscompanies) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            s.update(buscompanies);

            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean lockBuscompanies(Buscompanies buscompanies) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            s.update(buscompanies);

            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public Buscompanies getBusCompanyById(int id) {
        Session s = this.factory.getObject().getCurrentSession();

        return s.get(Buscompanies.class, id);
    }
    
}
