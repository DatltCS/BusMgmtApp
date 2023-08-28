/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.busmgmt.service;

import com.busmgmt.pojo.Reviews;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ReviewService {
    List<Reviews> getReivewsByTripId(int tripId, int page);
    
}
