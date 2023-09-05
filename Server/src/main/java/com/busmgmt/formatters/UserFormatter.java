/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.formatters;

import com.busmgmt.pojo.Users;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Admin
 */
public class UserFormatter implements Formatter<Users> {

    @Override
    public String print(Users u, Locale locale) {
        return String.valueOf(u.getUserId());
    }

    @Override
    public Users parse(String uId, Locale locale) throws ParseException {
        int id = Integer.parseInt(uId);
        return new Users(id);
    }

}
