/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.werapan.databaseproject.dao;

import com.werapan.databaseproject.helper.DatabaseHelper;
import com.werapan.databaseproject.model.RecieptDetail;
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
public class RecieptDetailDao implements Dao<RecieptDetail> {

    @Override
    public RecieptDetail get(int id) {
        RecieptDetail recieptDetail = null;
        String sql = "SELECT * FROM reciept_detail WHERE reciept_detail_id=?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                recieptDetail = RecieptDetail.fromRS(rs);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return recieptDetail;
    }


    public List<RecieptDetail> getAll() {
        ArrayList<RecieptDetail> list = new ArrayList();
        String sql = "SELECT * FROM reciept_detail";
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                RecieptDetail recieptDetail = RecieptDetail.fromRS(rs);
                list.add(recieptDetail);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    
    @Override
    public List<RecieptDetail> getAll(String where, String order) {
        ArrayList<RecieptDetail> list = new ArrayList();
        String sql = "SELECT * FROM reciept_detail where " + where + " ORDER BY" + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                RecieptDetail recieptDetail = RecieptDetail.fromRS(rs);
                list.add(recieptDetail);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    

    public List<RecieptDetail> getAll(String order) {
        ArrayList<RecieptDetail> list = new ArrayList();
        String sql = "SELECT * FROM reciept_detail  ORDER BY" + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                RecieptDetail recieptDetail = RecieptDetail.fromRS(rs);
                list.add(recieptDetail);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public RecieptDetail save(RecieptDetail obj) {

        String sql = "INSERT INTO reciept_detail (product_id, product_name, product_price, qty, total_price, reciept_id)"
                + "VALUES(?, ?, ?, ?, ?, ?)";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getProductId());
            stmt.setString(2, obj.getProductName());
            stmt.setDouble(3, obj.getProductPrice());
            stmt.setInt(4, obj.getQty());
            stmt.setDouble(5, obj.getTotalPrice());
            stmt.setInt(6, obj.getRecieptId());
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
    public RecieptDetail update(RecieptDetail obj) {
        String sql = "UPDATE reciept_detail"
                + " SET product_id = ?, product_name = ?, product_price = ?, qty = ?, total_price = ?, reciept_id = ?"
                + " WHERE reciept_detail_id = ?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getProductId());
            stmt.setString(2, obj.getProductName());
            stmt.setDouble(3, obj.getProductPrice());
            stmt.setInt(4, obj.getQty());
            stmt.setDouble(5, obj.getTotalPrice());
            stmt.setInt(6, obj.getRecieptId());
            stmt.setInt(7, obj.getId());

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
    public int delete(RecieptDetail obj) {
        String sql = "DELETE FROM reciept_detail WHERE reciept_detail_id=?";
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
