/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.busmgmt.service;

import com.busmgmt.pojo.Busroutes;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface BusRouteService {
    List<Busroutes> getBusroute(Map<String, String> params);
    Busroutes getBusRouteById(int id);
    Busroutes addBusroute(Busroutes br);
    Busroutes updateBusroute(Busroutes br);
    boolean deleteBusroute(int id);
}
