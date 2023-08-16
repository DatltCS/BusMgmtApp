/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.controllers;

import com.busmgmt.pojo.Buscompanies;
import com.busmgmt.service.BusCompanyService;
import com.busmgmt.service.BusTripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Admin
 */
@Controller
public class HomeController {
    @Autowired
    private BusTripService busTripService;
    @Autowired
    private BusCompanyService busCompanyService;
    
    @RequestMapping("/")
    public String index(Model model){
        
        model.addAttribute("bustrips", this.busTripService.getBustrips(null));
        model.addAttribute("buscompanies", this.busCompanyService.getBuscompanies());
        
        return "index";
    }
    
}
