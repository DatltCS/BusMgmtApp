/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.controllers;

import com.busmgmt.pojo.Bus;
import com.busmgmt.pojo.Buscompanies;
import com.busmgmt.service.BusService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api")
public class APIBusController {
    @Autowired
    private BusService busSerivce;
    
    @DeleteMapping("/buses/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CrossOrigin
    public void delete(@PathVariable (value = "id") int licensePlateId) {
        this.busSerivce.deleteBus(licensePlateId);
    }
    
    @GetMapping("/buses")
    @CrossOrigin
    public ResponseEntity<List<Bus>> list(@RequestParam Map<String, String> patams) {
        return new ResponseEntity<>(this.busSerivce.getBus(patams), HttpStatus.OK);
    }
    
    @PostMapping(path = "/buses/", produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin
    public ResponseEntity<Bus> addBus(@RequestBody Bus bus) {
        Bus b = this.busSerivce.addBus(bus);
        return new ResponseEntity<>(b, HttpStatus.CREATED);
    }
    
    @PatchMapping(path = "/buses/", produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin
    public ResponseEntity<Bus> updateBus(@RequestBody Bus bus) {
        Bus b = this.busSerivce.updateBuses(bus);
        return new ResponseEntity<>(b,HttpStatus.OK);
    }
    
}
