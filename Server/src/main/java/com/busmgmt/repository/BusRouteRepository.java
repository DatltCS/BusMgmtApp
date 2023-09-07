/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.busmgmt.repository;

import com.busmgmt.pojo.Busroutes;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface BusRouteRepository {
    List<Busroutes> getBusroute(Map<String, String> params);
    Busroutes getBusRouteById(int id);
    Busroutes addBusroute(Busroutes br);
    Busroutes updateBusroute(Busroutes br);
    boolean deleteBustrip(int id);
    
}
