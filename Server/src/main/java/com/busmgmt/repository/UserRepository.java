/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.busmgmt.repository;

import com.busmgmt.pojo.Users;

/**
 *
 * @author Admin
 */
public interface UserRepository {
    Users getUserByUsername(String username);
    boolean addUser(Users users);
//    int getMaxUserId();
    boolean authUser(String username, String password);
    Users addUsers(Users users);
}
