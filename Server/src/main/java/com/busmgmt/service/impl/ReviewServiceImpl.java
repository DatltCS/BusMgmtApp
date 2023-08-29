/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.service.impl;

import com.busmgmt.validator.*;
import com.busmgmt.pojo.Reviews;
import com.busmgmt.repository.ReviewRepository;
import com.busmgmt.service.ReviewService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class ReviewServiceImpl implements ReviewService{
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<Reviews> getReivewsByTripId(int tripId) {
        return this.reviewRepository.getReivewsByTripId(tripId);
    }
    
}
