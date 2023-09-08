/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.service.impl;

import com.busmgmt.pojo.Customers;
import com.busmgmt.validator.*;
import com.busmgmt.pojo.Reviews;
import com.busmgmt.pojo.Users;
import com.busmgmt.repository.ReviewRepository;
import com.busmgmt.repository.UserRepository;
import com.busmgmt.service.ReviewService;
import java.nio.file.attribute.UserPrincipal;
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
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private UserRepository userRepo;

    @Override
    public List<Reviews> getReivewsByTripId(int tripId) {
        return this.reviewRepository.getReivewsByTripId(tripId);
    }

    @Override
    public Reviews addComment(Reviews c) {
        c.setCreatedDate(new Date());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Customers cus = this.userRepo.getCustomerByName(authentication.getName());
        c.setCustomerId(cus);
        return this.reviewRepository.addComment(c);
    }
}
