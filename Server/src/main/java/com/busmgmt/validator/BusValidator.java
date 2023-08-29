/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.validator;

import com.busmgmt.pojo.Bus;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Admin
 */
@Component
public class BusValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Bus.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Bus b = (Bus) target;
        if (!b.getBusName().contains("Xe")) {
            errors.rejectValue("busName", "bus.busName.nameErr");
        }

    }

}
