/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.service.impl;

import com.busmgmt.pojo.Buscompanies;
import com.busmgmt.repository.BusCompanyRepository;
import com.busmgmt.service.BusCompanyService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class BusCompanyServiceImpl implements BusCompanyService {

    @Autowired
    private BusCompanyRepository busCompanyRepository;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Buscompanies> getBuscompanies() {
        return this.busCompanyRepository.getBuscompanies();
    }

    @Override
    public boolean addBuscompanies(Buscompanies buscompanies) {
        if (!buscompanies.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(buscompanies.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                buscompanies.setAvatar(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(BusCompanyServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.busCompanyRepository.addBuscompanies(buscompanies);
    }

    @Override
    public boolean activeBuscompanies(Buscompanies buscompanies) {
        buscompanies.setStatus(Boolean.TRUE);
        
        return this.busCompanyRepository.activeBuscompanies(buscompanies);
    }

    @Override
    public boolean lockBuscompanies(Buscompanies buscompanies) {
        buscompanies.setStatus(Boolean.FALSE);
        return this.busCompanyRepository.lockBuscompanies(buscompanies);
    }

    @Override
    public Buscompanies getBusCompanyById(int id) {
        return this.busCompanyRepository.getBusCompanyById(id);
    }

}