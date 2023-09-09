/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.controllers;

import com.busmgmt.pojo.Buscompanies;
import com.busmgmt.service.BusCompanyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api")
public class APIBusCompanyController {
    @Autowired
    private BusCompanyService busCompanyService;
    
    @GetMapping("buscompanies")
    public ResponseEntity<List<Buscompanies>> list() {
        return new ResponseEntity<>(this.busCompanyService.getBuscompanies(), HttpStatus.OK);
    }
    
//    @PatchMapping(path = "/buscompanies/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
//    @CrossOrigin
//    @ResponseStatus(HttpStatus.OK)
//    public void active(@RequestBody Buscompanies buscompanies) {
//        this.busCompanyService.activeBuscompanies(buscompanies);
//    }
}
