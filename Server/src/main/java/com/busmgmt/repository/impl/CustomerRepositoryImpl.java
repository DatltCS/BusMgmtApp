/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.repository.impl;

import com.busmgmt.pojo.Customers;
import com.busmgmt.pojo.Users;
import com.busmgmt.repository.CustomerRepository;
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
public class CustomerRepositoryImpl implements CustomerRepository {

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
        Session s = this.factory.getObject().getCurrentSession();
        s.save(c);
        s.flush();
        return c;

    }

}
