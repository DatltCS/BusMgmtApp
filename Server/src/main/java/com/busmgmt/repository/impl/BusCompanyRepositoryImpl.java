/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.repository.impl;

import com.busmgmt.pojo.Buscompanies;
import com.busmgmt.repository.BusCompanyRepository;
import java.util.List;
import javax.persistence.Query;
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
    
}
