/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.busmgmt.repository;

import com.busmgmt.pojo.Cart;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface ReceiptRepository {
    boolean addReceipt(Map<String, Cart> carts);
}
