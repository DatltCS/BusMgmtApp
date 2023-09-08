/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.controllers;

import com.busmgmt.pojo.Reviews;
import com.busmgmt.service.ReviewService;
import java.util.List;
import java.util.Map;
import javax.print.attribute.standard.Media;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
@Validated
@RequestMapping("/api")
public class APIReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/bustrips/{tripId}/reviews/")
    @CrossOrigin
    public ResponseEntity<List<Reviews>> list(@PathVariable(value = "tripId") int id) {
        return new ResponseEntity<>(this.reviewService.getReivewsByTripId(id), HttpStatus.OK);
    }
    
//    @PostMapping(path = "/bustrips/{tripId}/reviews/", produces = MediaType.APPLICATION_JSON_VALUE)
//    @CrossOrigin
//    public ResponseEntity<Reviews> addReview(@RequestBody Reviews review) {
//        Reviews r = this.reviewService.addReview(review);
//        return new ResponseEntity<>(r, HttpStatus.CREATED);
//    }
}
