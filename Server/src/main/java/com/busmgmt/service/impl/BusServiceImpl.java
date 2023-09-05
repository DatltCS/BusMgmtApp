/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.service.impl;

import com.busmgmt.pojo.Bus;
import com.busmgmt.pojo.Buscompanies;
import com.busmgmt.repository.BusRepository;
import com.busmgmt.service.BusService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusRepository busRepository;
    
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Bus> getBus(Map<String, String> params) {
        return this.busRepository.getBus(params);
    }

    @Override
    public Long countBus() {
        return this.busRepository.countBus();
    }

    @Override
    public boolean updateBus(Bus b) {
//        b.setImage("https://res.cloudinary.com/dc9dlukr6/image/upload/v1692612156/assets/xe_phuong_trang_to30yn.jpg");
//        
        if (!b.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(b.getFile().getBytes(),ObjectUtils.asMap("resource_type", "auto"));
                b.setImage(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(BusServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return this.busRepository.updateBus(b);
    }

    @Override
    public Bus getBusById(int id) {
        return this.busRepository.getBusById(id);
    }

    @Override
    public boolean deleteBus(int id) {
        return this.busRepository.deleteBus(id);
    }

    @Override
    public Bus addBus(Bus b) {
        Buscompanies bc = b.getCompanyId();
        return this.busRepository.addBus(b,bc.getCompanyId());
    }

    @Override
    public Bus updateBuses(Bus b) {
        Buscompanies bc = b.getCompanyId();
        return this.busRepository.updateBuses(b,bc.getCompanyId());
    }
}
