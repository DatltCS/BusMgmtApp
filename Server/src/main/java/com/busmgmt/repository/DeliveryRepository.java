/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.busmgmt.repository;

import com.busmgmt.pojo.Deliveries;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface DeliveryRepository {
    List<Deliveries> getDelivery(Map<String, String> params);
    Deliveries getDeliveryById(int id);
    Deliveries addDelivery(Deliveries c, int orderId, int tripId);
}