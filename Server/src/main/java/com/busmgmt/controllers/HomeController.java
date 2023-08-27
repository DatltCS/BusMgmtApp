/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.controllers;

import com.busmgmt.pojo.Bus;
import com.busmgmt.pojo.Buscompanies;
import com.busmgmt.service.BusCompanyService;
import com.busmgmt.service.BusService;
import com.busmgmt.service.BusTripService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
@ControllerAdvice
@PropertySource("classpath:configs.properties")
public class HomeController {

    @Autowired
    private BusTripService busTripService;
    @Autowired
    private BusService busService;
    @Autowired
    private BusCompanyService busCompanyService;
    @Autowired
    private Environment env;

    @ModelAttribute
    public void commonAttribute(Model model) {
        model.addAttribute("buscompanies", this.busCompanyService.getBuscompanies());
    }

//    @RequestMapping("/")
//    public String index(Model model, @RequestParam Map<String, String> params) {
//
//        model.addAttribute("bustrips", this.busTripService.getBustrips(params));
//
//        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
//        long count = this.busTripService.countBusTrip();
//        model.addAttribute("count", Math.ceil(count * 1.0 / pageSize));
//
//        return "index";
//    }
    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String, String> params) {

        model.addAttribute("bus", this.busService.getBus(params));

        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        long count = this.busService.countBus();
        model.addAttribute("count", Math.ceil(count * 1.0 / pageSize));

        return "index";
    }

 

}
