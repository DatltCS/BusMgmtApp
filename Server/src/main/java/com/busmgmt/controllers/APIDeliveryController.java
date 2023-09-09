/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.controllers;

import com.busmgmt.pojo.Deliveries;
import com.busmgmt.service.DeliveryService;
import java.util.List;
import java.util.Map;
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
public class APIDeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @GetMapping("/deliveries/")
    @CrossOrigin
    public ResponseEntity<List<Deliveries>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.deliveryService.getDelivery(params), HttpStatus.OK);
    }

    @GetMapping(path = "/deliveries/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin
    public ResponseEntity<Deliveries> deliveryById(@PathVariable (value = "id") int id) {
        return new ResponseEntity<>(this.deliveryService.getDeliveryById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/deliveries/", produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin
    public ResponseEntity<Deliveries> addBustrip(@RequestBody Deliveries deliveries) throws Exception {
        Deliveries d = this.deliveryService.addDelivery(deliveries);
        return new ResponseEntity<>(d, HttpStatus.CREATED);
    }
}
