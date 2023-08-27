/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.validator;

import com.busmgmt.pojo.Buscompanies;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Admin
 */
@Component
public class BusCompanyNameValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return Buscompanies.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Buscompanies bc = (Buscompanies) target;
        if (bc.getNameCompany().contains("Buslines"))
            errors.rejectValue("nameCompany", "buscompanies.nameCompany.nameErr");
        if (bc.getEmail().contains("@"))
            errors.rejectValue("nameCompany", "buscompanies.nameCompany.emailErr");
    }
    
}
