/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.controllers;

import com.busmgmt.pojo.Buscompanies;
import com.busmgmt.pojo.Users;
import com.busmgmt.service.BusCompanyService;
import com.busmgmt.service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Admin
 */
@Controller
public class CompanyRegisterController {

    @Autowired
    private BusCompanyService busCompanyService;
    @Autowired
    private UserService userService;

    @GetMapping("/buscompanies/register")
    public String list(Model model) {
        model.addAttribute("companyRegister", new Users());
        return "companyRegister";
    }

    @GetMapping("/buscompanies/register/{id}")
    public String active(Model model, @ModelAttribute(value = "companyRegister")
                                            @PathVariable (value = "id") int id,
                                            @Valid Buscompanies bc, BindingResult rs) {
//        bc = this.busCompanyService.getBusCompanyById(id);
//        model.addAttribute("activeBusCompany", this.busCompanyService.getBusCompanyById(id));
//        if (bc.getStatus()) {
//            model.addAttribute("activeBusCompany", this.busCompanyService.lockBuscompanies(bc));
            if(this.userService.registerBuscompanies(this.userService.geUserById(id)) == true) {
                return "redirect:/";
            }
            else {
                this.busCompanyService.activeBuscompanies(bc);
            }
//        }
//        this.busCompanyService.lockBuscompanies(bc);
        return "companyRegister";
    }
}
