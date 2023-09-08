/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.service.impl;

import com.busmgmt.pojo.Bustrips;
import com.busmgmt.pojo.Customers;
import com.busmgmt.pojo.Orders;
import com.busmgmt.pojo.Tickets;
import com.busmgmt.repository.TicketRepository;
import com.busmgmt.service.TicketService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class TicketServiceImpl implements TicketService{
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public List<Tickets> getTicket(Map<String, String> params) {
        return this.ticketRepository.getTicket(params);
    }

    @Override
    public Tickets getTicketById(int id) {
        return this.ticketRepository.getTicketById(id);
    }

    @Override
    public Tickets addTicket(Tickets t) {
        Orders o = t.getOrderId();
        Bustrips bt = t.getTripId();
        
        return this.ticketRepository.addTicket(t,o.getOrderId(), bt.getTripId());
    }

    @Override
    public Tickets updateTicket(Tickets t) {
        Orders o = t.getOrderId();
        Bustrips bt = t.getTripId();
        
        return this.ticketRepository.updateTicket(t,o.getOrderId(), bt.getTripId());
    }

    @Override
    public boolean deleteTicket(int id) {
        return this.ticketRepository.deleteTicket(id);
    }
    
}