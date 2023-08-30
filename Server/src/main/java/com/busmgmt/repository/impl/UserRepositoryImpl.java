/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.repository.impl;

import com.busmgmt.pojo.Users;
import com.busmgmt.repository.UserRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private BCryptPasswordEncoder passEncoder;
//    private AtomicInteger maxUserId = new AtomicInteger(12);

    @Override
    public Users getUserByUsername(String username) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Users WHERE username=:un");
        q.setParameter("un", username);

        return (Users) q.getSingleResult();
    }
    
    @Override
    public boolean authUser(String username, String password) {
        Users  u = this.getUserByUsername(username);
        return this.passEncoder.matches(password, u.getPassword());
    }
    

    @Override
    public boolean addUser(Users users) {
        Session s = this.factory.getObject().getCurrentSession();
//        int newUserId = maxUserId.incrementAndGet();
//        users.setUserId(newUserId + 1);
        try {
            s.save(users);

            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

//    @Override
//    public int getMaxUserId() {
//        return maxUserId.get();
//    }
    
//    @Override
//    public Users addUserClient(Users u) {
//        Session s = this.factory.getObject().getCurrentSession();
//        s.save(u);
//        
//        return u;
//    }

}
