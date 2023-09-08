/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.controllers;

import com.busmgmt.pojo.Tickets;
import com.busmgmt.service.TicketService;
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
public class APITicketController {
    @Autowired
    private TicketService ticketService;
    
    @GetMapping("/tickets/")
    @CrossOrigin
    public ResponseEntity<List<Tickets>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.ticketService.getTicket(params), HttpStatus.OK);
    }
    
    @PostMapping(path = "/tickets/", produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin
    public ResponseEntity<Tickets> addBustrip(@RequestBody Tickets tickets) throws Exception {
        Tickets t = this.ticketService.addTicket(tickets);
        return new ResponseEntity<>(t, HttpStatus.CREATED);
    }

    @DeleteMapping("/tickets/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CrossOrigin
    public void delete(@PathVariable(value = "id") int ticketId) {
        this.ticketService.deleteTicket(ticketId);
    }
    
    @PatchMapping(path = "/tickets/", produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin
    public ResponseEntity<Tickets> updateBustrip(@RequestBody Tickets tickets) throws Exception {
        Tickets bt = this.ticketService.updateTicket(tickets);
        return new ResponseEntity<>(bt, HttpStatus.OK);
    }
    
}