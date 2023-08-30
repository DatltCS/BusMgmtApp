/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.controllers;




import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;


/**
 *
 * @author Admin
 */
@Controller
public class UserController {
    
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
//    @GetMapping("/register")
//    public String registerView(Model model){
//        model.addAttribute("users", new Users());
//        return "register";
//    }
//    
//    @PostMapping("/register")
//    public String register(Model model, @ModelAttribute(value = "users") Users user){
//        String msg = "";
//        if (user.getPassword().equals(user.getConfirmPassword())) {
//            if (this.userDetailsService.addUser(user) == true)
//                return "redirect:/login";
//            else
//                System.out.println("Sometings went wrong!!!");
//        } else
//            System.out.println("Password not match!!!");
//        
//        return "register";
//    }
    
    
//    public void sendEmail(String from, String to, String subject, String content) {
//        SimpleMailMessage mailMessage = new SimpleMailMessage();
//        
//        mailMessage.setFrom(from);
//        mailMessage.setTo(to);
//        mailMessage.setSubject(subject);
//        mailMessage.setText(content);
//        
//        mailSender.send(mailMessage);
//    }
}