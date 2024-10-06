/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.werapan.databaseproject.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author werapan
 */
public class Customer {
    private int id;
    private String name;
    private String tel;


    public Customer(int id, String tel, String name) {
        this.id = id;
        this.name = name;
        this.tel = tel;
    }
    public Customer(String name, String tel) {
        this.id = -1;
        this.name = name;
        this.tel = tel;
    }


    public Customer() {
        this.id = -1;
        this.name = "";
        this.tel = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", tel=" + tel + '}';
    }



    
    public static Customer fromRS(ResultSet rs) {
        Customer customer = new Customer();
        try {
            customer.setId(rs.getInt("customer_id"));
            customer.setName(rs.getString("customer_name"));
            customer.setTel(rs.getString("customer_tel"));
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return customer;
    }
}
