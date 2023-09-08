/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.service.impl;

import com.busmgmt.pojo.Bustrips;
import com.busmgmt.validator.*;
import com.busmgmt.pojo.Reviews;
import com.busmgmt.pojo.Users;
import com.busmgmt.repository.BusTripRepository;
import com.busmgmt.repository.ReviewRepository;
import com.busmgmt.repository.UserRepository;
import com.busmgmt.service.ReviewService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class ReviewServiceImpl implements ReviewService{
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private UserRepository userRepository; 

    @Override
    public List<Reviews> getReivewsByTripId(int tripId) {
        return this.reviewRepository.getReivewsByTripId(tripId);
    }

    @Override
    public Reviews addReview(Reviews r) {
        r.setCreatedDate(new Date());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String name = authentication.getName();
            System.out.println("username: " + authentication);
            Users u = this.userRepository.getUserByUsername(name);
            
            r.setUserId(u);
            Bustrips bt = r.getTripId();
            
            if (bt != null) {
                return this.reviewRepository.addReview(r, bt.getTripId());
            }
            return null;
        }
        return null;
    }
}
