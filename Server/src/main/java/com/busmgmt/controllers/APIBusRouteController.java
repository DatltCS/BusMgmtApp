/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.controllers;

import com.busmgmt.pojo.Busroutes;
import com.busmgmt.pojo.Bustrips;
import com.busmgmt.service.BusRouteService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
@Validated
@RequestMapping("/api")
public class APIBusRouteController {

    @Autowired
    private BusRouteService busRouteService;

    @GetMapping("/busroutes/")
    @CrossOrigin
    public ResponseEntity<List<Busroutes>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.busRouteService.getBusroute(params), HttpStatus.OK);
    }

    @PostMapping(path = "/busroutes/", produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin
    public ResponseEntity<Busroutes> addBustrip(@RequestBody Busroutes busroutes) throws Exception {
        Busroutes br = this.busRouteService.addBusroute(busroutes);
        return new ResponseEntity<>(br, HttpStatus.CREATED);
    }

    @PatchMapping(path = "/busroutes/", produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin
    public ResponseEntity<Busroutes> updateBusroute(@RequestBody Busroutes busroutes) throws Exception {
        Busroutes br = this.busRouteService.updateBusroute(busroutes);
        return new ResponseEntity<>(br, HttpStatus.OK);
    }

    @DeleteMapping("/busroutes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CrossOrigin
    public void delete(@PathVariable(value = "id") int routeId) {
        this.busRouteService.deleteBusroute(routeId);
    }
}