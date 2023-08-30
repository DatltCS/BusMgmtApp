/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.busmgmt.service;

import com.busmgmt.pojo.Users;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetailsService;


/**
 *
 * @author Admin
 */
public interface UserService extends UserDetailsService {

    Users getUserByUsername(String username);

    boolean authUser(String username, String password);

    Users addUser(Map<String, String> params);
}
