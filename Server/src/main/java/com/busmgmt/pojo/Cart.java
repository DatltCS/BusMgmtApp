/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.pojo;

import lombok.Data;

/**
 *
 * @author Admin
 */
@Data
public class Cart {
    private int id;
    private String name;
    private Long price;
    private int quantity;
}