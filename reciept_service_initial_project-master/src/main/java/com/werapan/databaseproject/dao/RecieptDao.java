/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.werapan.databaseproject.dao;

import com.werapan.databaseproject.helper.DatabaseHelper;
import com.werapan.databaseproject.model.Reciept;
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
public class RecieptDao implements Dao<Reciept> {

    @Override
    public Reciept get(int id) {
        Reciept reciept = null;
        String sql = "SELECT * FROM reciept WHERE reciept_id=?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                reciept = Reciept.fromRS(rs);
                RecieptDetailDao rdd = new RecieptDetailDao();
                ArrayList<RecieptDetail> recieptDetails = (ArrayList<RecieptDetail>) rdd.getAll("reciept_id=" + reciept.getId(), " reciept_detail_id");              
                reciept.setRecieptDeatails(recieptDetails);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return reciept;
    }

    public List<Reciept> getAll() {
        ArrayList<Reciept> list = new ArrayList();
        String sql = "SELECT * FROM reciept";
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Reciept reciept = Reciept.fromRS(rs);
                list.add(reciept);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public List<Reciept> getAll(String where, String order) {
        ArrayList<Reciept> list = new ArrayList();
        String sql = "SELECT * FROM reciept where " + where + " ORDER BY" + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Reciept reciept = Reciept.fromRS(rs);
                list.add(reciept);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public List<Reciept> getAll(String order) {
        ArrayList<Reciept> list = new ArrayList();
        String sql = "SELECT * FROM reciept  ORDER BY" + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Reciept reciept = Reciept.fromRS(rs);
                list.add(reciept);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public Reciept save(Reciept obj) {

        String sql = "INSERT INTO reciept (total, cash, total_qty, user_id, customer_id)"
                + "VALUES(?, ?, ?, ?, ?)";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, obj.getTotal());
            stmt.setDouble(2, obj.getCash());
            stmt.setInt(3, obj.getTotalQty());
            stmt.setInt(4, obj.getUserId());
            stmt.setInt(5, obj.getCustomerId());
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
    public Reciept update(Reciept obj) {
        String sql = "UPDATE reciept"
                + " SET total = ?, cash = ?, total_qty = ?, user_id = ?, customer_id = ?"
                + " WHERE reciept_id = ?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, obj.getTotal());
            stmt.setDouble(2, obj.getCash());
            stmt.setInt(3, obj.getTotalQty());
            stmt.setInt(4, obj.getUserId());
            stmt.setInt(5, obj.getCustomerId());
            stmt.setInt(6, obj.getId());

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
    public int delete(Reciept obj) {
        String sql = "DELETE FROM reciept WHERE reciept_id=?";
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
