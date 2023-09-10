/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.controllers;

import com.busmgmt.pojo.Buscompanies;
import com.busmgmt.service.BusCompanyService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Admin
 */
@Controller
public class BusCompanyController {
    @Autowired
    private BusCompanyService busCompanyService;
//    @Autowired
//    private WebApplicationValidator busValidator;
//    
//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        binder.setValidator(busValidator);
//    }

    @GetMapping("/buscompanies")
    public String list(Model model) {
        model.addAttribute("buscompany", new Buscompanies());
        return "buscompany";
    }
    
//    @GetMapping("/buscompanies/{id}")
//    public String update(Model model, @PathVariable (value = "id") int id ) {
//        model.addAttribute("buscompany", this.busCompanyService.getBusById(id));
//        return "bus";
//    }

    @PostMapping("/buscompanies")
    public String add(@ModelAttribute(value = "buscompany") @Valid Buscompanies bc, BindingResult rs) {
        if (!rs.hasErrors()) {
            if (this.busCompanyService.addBuscompanies(bc) == true) {
                return "redirect:/";
            }
        }

        return "buscompany";
    }
    
    
    @GetMapping("/buscompanies/active")
    public String listForActive(Model model) {
        model.addAttribute("activeBusCompany", new Buscompanies());
        return "activeBusCompany";
    }
    
    @GetMapping("/buscompanies/active/{id}")
    public String active(Model model, @ModelAttribute(value = "buscompanies")
                                            @PathVariable (value = "id") int id,
                                            @Valid Buscompanies bc, BindingResult rs) {
//        bc = this.busCompanyService.getBusCompanyById(id);
//        model.addAttribute("activeBusCompany", this.busCompanyService.getBusCompanyById(id));
//        if (bc.getStatus()) {
//            model.addAttribute("activeBusCompany", this.busCompanyService.lockBuscompanies(bc));
            if(this.busCompanyService.activeBuscompanies(this.busCompanyService.getBusCompanyById(id)) == true) {
                return "redirect:/";
            }
            else {
                this.busCompanyService.activeBuscompanies(bc);
            }
//        }
//        this.busCompanyService.lockBuscompanies(bc);
        return "activeBusCompany";
    }
    
    @GetMapping("/buscompanies/lock/{id}")
    public String lock(Model model, @ModelAttribute(value = "buscompanies")
                                            @PathVariable (value = "id") int id,
                                            @Valid Buscompanies bc, BindingResult rs) {
//        bc = this.busCompanyService.getBusCompanyById(id);
//        model.addAttribute("activeBusCompany", this.busCompanyService.getBusCompanyById(id));
//        if (bc.getStatus()) {
//            model.addAttribute("activeBusCompany", this.busCompanyService.lockBuscompanies(bc));
            if(this.busCompanyService.lockBuscompanies(this.busCompanyService.getBusCompanyById(id)) == true) {
                return "redirect:/";
            }
            else {
                this.busCompanyService.lockBuscompanies(bc);
            }
//        }
//        this.busCompanyService.lockBuscompanies(bc);
        return "activeBusCompany";
    }
}