/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.busmgmt.repository;

import com.busmgmt.pojo.Buscompanies;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface BusCompanyRepository {
    List<Buscompanies> getBuscompanies();
//    boolean addBuscompanies(Buscompanies buscompanies);
}
