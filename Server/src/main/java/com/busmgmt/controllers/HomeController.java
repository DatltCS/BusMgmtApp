/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.controllers;

import com.busmgmt.pojo.Buscompanies;
import com.busmgmt.service.BusCompanyService;
import com.busmgmt.service.BusTripService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
@PropertySource("classpath:configs.properties")
public class HomeController {
    @Autowired
    private BusTripService busTripService;
    @Autowired
    private BusCompanyService busCompanyService;
    @Autowired
    private Environment env;
    
    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String, String> params){
        
        model.addAttribute("bustrips", this.busTripService.getBustrips(params));
        model.addAttribute("buscompanies", this.busCompanyService.getBuscompanies());
        
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        long count = this.busTripService.countBusTrip();
        model.addAttribute("count", Math.ceil(count*1.0/pageSize));
        
        return "index";
    }
    
}
