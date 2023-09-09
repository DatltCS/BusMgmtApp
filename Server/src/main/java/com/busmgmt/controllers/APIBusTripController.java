/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.controllers;

import com.busmgmt.pojo.Bustrips;
import com.busmgmt.service.BusTripService;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
public class APIBusTripController {

    @Autowired
    private BusTripService busTripService;

    @GetMapping("/bustrips")
    @CrossOrigin
    public ResponseEntity<List<Bustrips>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.busTripService.getBustrips(params), HttpStatus.OK);
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
    @PostMapping(path = "/bustrips/", produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin
    public ResponseEntity<Bustrips> addBustrip(@RequestBody Bustrips bustrips) throws Exception {
        Bustrips bt = this.busTripService.addBustrip(bustrips);
        return new ResponseEntity<>(bt, HttpStatus.CREATED);
    }

    @GetMapping(path = "/bustrips/{id}", produces = {MediaType.APPLICATION_JSON_VALUE} )
    @CrossOrigin
    public ResponseEntity<Bustrips> getBustripById(@PathVariable (value = "id") int id) {
        return new ResponseEntity<>(this.busTripService.getBusTripById(id), HttpStatus.OK);
    }

    @DeleteMapping("/bustrips/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CrossOrigin
    public void delete(@PathVariable(value = "id") int tripId) {
        this.busTripService.deleteBustrip(tripId);
    }

    @PatchMapping(path = "/bustrips/", produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin
    public ResponseEntity<Bustrips> updateBustrip(@RequestBody Bustrips bustrips) throws Exception {
        Bustrips bt = this.busTripService.updateBustrips(bustrips);
        return new ResponseEntity<>(bt, HttpStatus.OK);
    }

}
