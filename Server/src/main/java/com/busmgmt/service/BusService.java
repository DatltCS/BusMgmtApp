/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.busmgmt.service;

import com.busmgmt.pojo.Bus;
import com.busmgmt.pojo.Buscompanies;
import java.util.List;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
public interface BusService {
    List<Bus> getBus(Map<String, String> params);
    Long countBus();
    boolean updateBus(Bus b);
    Bus getBusById(int id);
    boolean deleteBus(int id);
    
    Bus addBus(Bus b);
    Bus updateBuses(Bus b);
}
