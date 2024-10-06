/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.werapan.databaseproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author werapan
 */
public class SelectDatabase {
    
    public static void main(String[] args) {
        Connection conn = null;
        String url = "jdbc:sqlite:dcoffee.db";
        // Connection database
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been establish.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        // Selection
        String sql = "SELECT * FROM category";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                System.out.println(rs.getInt("category_id") + " " 
                        + rs.getString("category_name"));
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        // Close Database
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
}
