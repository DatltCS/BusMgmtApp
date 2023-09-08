/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.service.impl;

import com.busmgmt.pojo.Busroutes;
import com.busmgmt.repository.BusRouteRepository;
import com.busmgmt.service.BusRouteService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class BusRouteServiceImpl implements BusRouteService{
    @Autowired
    private BusRouteRepository busRouteRepository;

    @Override
    public List<Busroutes> getBusroute(Map<String, String> params) {
        return this.busRouteRepository.getBusroute(params);
    }

    @Override
    public Busroutes addBusroute(Busroutes br) {
        return this.busRouteRepository.addBusroute(br);
    }

    @Override
    public Busroutes updateBusroute(Busroutes br) {
        return this.busRouteRepository.updateBusroute(br);
    }

    @Override
    public Busroutes getBusRouteById(int id) {
        return this.busRouteRepository.getBusRouteById(id);
    }

    @Override
    public boolean deleteBusroute(int id) {
        return this.busRouteRepository.deleteBustrip(id);
    }
}