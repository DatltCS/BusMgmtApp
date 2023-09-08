/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.repository.impl;

import com.busmgmt.pojo.Customers;
import com.busmgmt.repository.CustomerRepository;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

/**
 *
 * @author Admin
 */
public class CustomerRepositoryImpl implements CustomerRepository{
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Customers> getCustomer(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Customers");

        return q.getResultList();
    }

    @Override
    public Customers getCustomerById(int id) {
        Session s = this.factory.getObject().getCurrentSession();

        return s.get(Customers.class, id);
    }

    @Override
    public Customers addCustomer(Customers c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
