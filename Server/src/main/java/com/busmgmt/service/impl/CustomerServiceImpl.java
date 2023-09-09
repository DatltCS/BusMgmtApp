/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.service.impl;

import com.busmgmt.pojo.Customers;
import com.busmgmt.pojo.Users;
import com.busmgmt.repository.CustomerRepository;
import com.busmgmt.repository.UserRepository;
import com.busmgmt.service.CustomerService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Customers> getCustomer(Map<String, String> params) {
        return this.customerRepository.getCustomer(params);
    }

    @Override
    public Customers getCustomerById(int id) {
        return this.customerRepository.getCustomerById(id);
    }

    @Override
    public Customers addCustomer(Customers c) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String name = authentication.getName();
            Users u = this.userRepository.getUserByUsername(name);

            c.setUserId(u);

            return this.customerRepository.addCustomer(c);
        }
        return null;
    }

}