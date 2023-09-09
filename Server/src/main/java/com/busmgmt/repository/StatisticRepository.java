/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.busmgmt.repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface StatisticRepository {
    List<Object[]> statsTripByRouteByYear(Long startY, Long endY);
    List<Object[]> statsTripByRouteByQuarter(Long start, Long end);
    List<Object[]> statsTripByRouteByMonth(Long year);
    
    
    List<Object[]> statsRevenueTicketsByYear(Long startY, Long endY);
    List<Object[]> statsRevenueTicketsByQUater(Long startY, Long endY);
    List<Object[]> statsRevenueTicketsByMonth(Long startY, Long endY);
}
