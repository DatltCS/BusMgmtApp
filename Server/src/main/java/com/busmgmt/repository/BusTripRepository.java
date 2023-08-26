/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.busmgmt.repository;

import com.busmgmt.pojo.Bustrips;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface BusTripRepository {
    List<Bustrips> getBustrips(Map<String, String> params);
    Long countBusTrip();
    boolean updateBusTrip(Bustrips bt);
    Bustrips getBusTripById(int id);
}
