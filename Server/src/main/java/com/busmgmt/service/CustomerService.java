/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.busmgmt.service;

import com.busmgmt.pojo.Customers;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface CustomerService {
    List<Customers> getCustomer(Map<String, String> params);
    Customers getCustomerById(int id);
    Customers addCustomer(Customers c);
}
