/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.controllers;

import com.busmgmt.pojo.Bus;
import com.busmgmt.service.BusService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
    public void delete(@PathVariable (value = "id") int licensePlateId) {
        this.busSerivce.deleteBus(licensePlateId);
    }
    
    @CrossOrigin
    @GetMapping("/buses")
    public ResponseEntity<List<Bus>> list(@RequestParam Map<String, String> patams) {
        return new ResponseEntity<>(this.busSerivce.getBus(patams), HttpStatus.OK);
    }
}
