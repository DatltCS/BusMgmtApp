/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.service.impl;

import com.busmgmt.pojo.Bustrips;
import com.busmgmt.pojo.Deliveries;
import com.busmgmt.pojo.Orders;
import com.busmgmt.repository.DeliveryRepository;
import com.busmgmt.service.DeliveryService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class DeliveryServiceImpl implements DeliveryService{
    @Autowired
    private DeliveryRepository deliveryRepository;

    @Override
    public List<Deliveries> getDelivery(Map<String, String> params) {
        return this.deliveryRepository.getDelivery(params);
    }

    @Override
    public Deliveries getDeliveryById(int id) {
        return this.deliveryRepository.getDeliveryById(id);
    }

    @Override
    public Deliveries addDelivery(Deliveries t) {
        Orders o = t.getOrderId();
        Bustrips bt = t.getTripId();
        
        return this.deliveryRepository.addDelivery(t,o.getOrderId(), bt.getTripId());
    }
 
}
