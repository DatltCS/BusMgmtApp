/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.formatters;

import com.busmgmt.pojo.Buscompanies;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Admin
 */
public class BusCompanyFormatter implements Formatter<Buscompanies>{

    @Override
    public String print(Buscompanies bc, Locale locale) {
      return String.valueOf(bc.getCompanyId());
    }

    @Override
    public Buscompanies parse(String bcId, Locale locale) throws ParseException {
        int id = Integer.parseInt(bcId);
        return new Buscompanies(id);
    }
    
}
