/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.controllers;

import com.busmgmt.pojo.Bus;
import com.busmgmt.service.BusService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Admin
 */
@Controller
public class BusController {

    @Autowired
    private BusService busService;

    @GetMapping("/buses")
    public String list(Model model) {
        model.addAttribute("bus", new Bus());
        return "bus";
    }
    
    @GetMapping("/buses/{id}")
    public String update(Model model, @PathVariable (value = "id") int id ) {
        model.addAttribute("bus", this.busService.getBusById(id));
        return "bus";
    }

    @PostMapping("/buses")
    public String add(@ModelAttribute(value = "bus") @Valid Bus b, BindingResult rs) {
        if (!rs.hasErrors()) {
            if (this.busService.updateBus(b) == true) {
                return "redirect:/";
            }
        }

        return "bus";
    }
}
