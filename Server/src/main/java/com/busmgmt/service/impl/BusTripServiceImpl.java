/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.service.impl;

import com.busmgmt.pojo.Bus;
import com.busmgmt.pojo.Busroutes;
import com.busmgmt.pojo.Bustrips;
import com.busmgmt.repository.BusTripRepository;
import com.busmgmt.service.BusTripService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class BusTripServiceImpl implements BusTripService {

    @Autowired
    private BusTripRepository busTripRepository;

    @Override
    public List<Bustrips> getBustrips(Map<String, String> params) {
        return this.busTripRepository.getBustrips(params);
    }

    @Override
    public Long countBusTrip() {
        return this.busTripRepository.countBusTrip();
    }

    @Override
    public boolean updateBusTrip(Bustrips bt) {
        return this.busTripRepository.updateBusTrip(bt);
    }

    @Override
    public Bustrips getBusTripById(int id) {
        return this.busTripRepository.getBusTripById(id);
    }

    @Override
    public Bustrips addBustrip(Bustrips bt) {
        Bus b = bt.getLicensePlateId();
        Busroutes br = bt.getRouteId();
        
        return this.busTripRepository.addBustrip(bt,br.getRouteId(), b.getLicensePlateId());
    }

}
