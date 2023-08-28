/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.controllers;

import com.busmgmt.pojo.Bustrips;
import com.busmgmt.service.BusTripService;
import com.busmgmt.service.ReviewService;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
public class APIBusTripController {

    @Autowired
    private BusTripService busTripService;
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/bustrips")
    public ResponseEntity<List<Bustrips>> list(@RequestParam Map<String, String> patams) {
        return new ResponseEntity<>(this.busTripService.getBustrips(patams), HttpStatus.OK);
    }
    
    
    
    
//    @GetMapping("/bustrips/{id}")
//    public ResponseEntity<Optional<Bustrips>> getBustripById(@PathVariable (value = "id") int id) {
//        return new ResponseEntity<>(this.busTripService.getBusTripById(id), HttpStatus.OK );
//    }
    
//    @PostMapping("/bustrips")
//    public ResponseEntity<Bustrips> updateBustrip (@RequestBody Bustrips bustrips) {
//    busTripService.updateBusTrip(bustrips);
//    return ResponseEntity.ok(bustrips);
//    }
    
    @PostMapping("/bustrips")
    public ResponseEntity<Boolean> updateBustrip(@RequestBody Bustrips bustrips) throws Exception{
        return new ResponseEntity<>(busTripService.updateBusTrip(bustrips), HttpStatus.CREATED);
//boolean updated = busTripService.updateBusTrip(bustrips);
//    return new ResponseEntity<>(updated, HttpStatus.CREATED);
    }

}
