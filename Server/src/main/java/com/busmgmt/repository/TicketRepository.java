/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.busmgmt.repository;

import com.busmgmt.pojo.Tickets;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface TicketRepository {
    List<Tickets> getTicket(Map<String, String> params);
    Tickets getTicketById(int id);
    Tickets addTicket(Tickets t, int orderId, int tripId);
    Tickets updateTicket(Tickets t, int orderId, int tripId);
    boolean deleteTicket(int id);
}