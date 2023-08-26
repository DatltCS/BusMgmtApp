/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.formatters;

import com.busmgmt.pojo.Bustrips;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Admin
 */
public class BusTripFormatter implements Formatter<Bustrips>{

    @Override
    public String print(Bustrips bt, Locale locale) {
        return String.valueOf(bt.getTripId());
    }

    @Override
    public Bustrips parse(String btId, Locale locale) throws ParseException {
        int id = Integer.parseInt(btId);
        return new Bustrips(id);
    }
    
}
