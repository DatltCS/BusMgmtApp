/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.repository.impl;

import com.busmgmt.pojo.Cart;
import com.busmgmt.pojo.Tickets;
import com.busmgmt.repository.ReceiptRepository;
import com.busmgmt.repository.UserRepository;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Admin
 */
@Repository
public class ReceiptRepositoryImpl implements ReceiptRepository{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LocalSessionFactoryBean  factory;
    
    @Override
    public boolean addReceipt(Map<String, Cart> carts) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        
        Tickets ticket = new Tickets();
        return true;
    }
    
}
