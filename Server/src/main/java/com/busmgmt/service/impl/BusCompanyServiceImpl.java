/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.service.impl;

import com.busmgmt.pojo.Buscompanies;
import com.busmgmt.repository.BusCompanyRepository;
import com.busmgmt.service.BusCompanyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class BusCompanyServiceImpl implements BusCompanyService{
    @Autowired
    private BusCompanyRepository busCompanyRepository;
    
    
    @Override
    public List<Buscompanies> getBuscompanies() {
        return this.busCompanyRepository.getBuscompanies();
    }
    
}
