/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.service.impl;

import com.busmgmt.pojo.Bus;
import com.busmgmt.repository.BusRepository;
import com.busmgmt.service.BusService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class BusServiceImpl implements BusService{
    @Autowired
    private BusRepository busRepository;
    
    @Override
    public List<Bus> getBus(Map<String, String> params) {
        return this.busRepository.getBus(params);
    }

    @Override
    public Long countBus() {
        return this.busRepository.countBus();
    }
}
