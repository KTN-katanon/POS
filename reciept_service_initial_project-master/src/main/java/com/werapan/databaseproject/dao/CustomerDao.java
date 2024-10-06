/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.werapan.databaseproject.dao;

import com.werapan.databaseproject.helper.DatabaseHelper;
import com.werapan.databaseproject.model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author werapan
 */
public class CustomerDao implements Dao<Customer> {

    @Override
    public Customer get(int id) {
        Customer customer = null;
        String sql = "SELECT * FROM customer WHERE customer_id=?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                customer = Customer.fromRS(rs);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return customer;
    }

    public Customer getByTel(String tel) {
        Customer customer = null;
        String sql = "SELECT * FROM customer WHERE customer_tel=?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, tel);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                customer = Customer.fromRS(rs);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return customer;
    }

    public List<Customer> getAll() {
        ArrayList<Customer> list = new ArrayList();
        String sql = "SELECT * FROM customer";
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Customer customer = Customer.fromRS(rs);
                list.add(customer);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    
    @Override
    public List<Customer> getAll(String where, String order) {
        ArrayList<Customer> list = new ArrayList();
        String sql = "SELECT * FROM customer where " + where + " ORDER BY" + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Customer customer = Customer.fromRS(rs);
                list.add(customer);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    

    public List<Customer> getAll(String order) {
        ArrayList<Customer> list = new ArrayList();
        String sql = "SELECT * FROM customer  ORDER BY" + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Customer customer = Customer.fromRS(rs);
                list.add(customer);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public Customer save(Customer obj) {

        String sql = "INSERT INTO customer (customer_name, customer_tel)"
                + "VALUES(?, ?)";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getName());
            stmt.setString(2, obj.getTel());
//            System.out.println(stmt);
            stmt.executeUpdate();
            int id = DatabaseHelper.getInsertedId(stmt);
            obj.setId(id);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return obj;
    }

    @Override
    public Customer update(Customer obj) {
        String sql = "UPDATE customer"
                + " SET customer_name = ?, customer_tel = ?"
                + " WHERE customer_id = ?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getName());
            stmt.setString(2, obj.getTel());
            stmt.setInt(3, obj.getId());

//            System.out.println(stmt);
            int ret = stmt.executeUpdate();
            System.out.println(ret);
            return obj;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public int delete(Customer obj) {
        String sql = "DELETE FROM customer WHERE customer_id=?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getId());
            int ret = stmt.executeUpdate();
            return ret;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return -1;        
    }

}
