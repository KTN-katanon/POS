/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.werapan.databaseproject.dao;

import com.werapan.databaseproject.helper.DatabaseHelper;
import com.werapan.databaseproject.model.User;
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
public class UserDao implements Dao<User> {

    @Override
    public User get(int id) {
        User user = null;
        String sql = "SELECT * FROM user WHERE user_id=?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                user = User.fromRS(rs);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return user;
    }

    public User getByLogin(String name) {
        User user = null;
        String sql = "SELECT * FROM user WHERE user_login=?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                user = User.fromRS(rs);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return user;
    }

    public List<User> getAll() {
        ArrayList<User> list = new ArrayList();
        String sql = "SELECT * FROM user";
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                User user = User.fromRS(rs);
                list.add(user);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    
    @Override
    public List<User> getAll(String where, String order) {
        ArrayList<User> list = new ArrayList();
        String sql = "SELECT * FROM user where " + where + " ORDER BY" + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                User user = User.fromRS(rs);
                list.add(user);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    

    public List<User> getAll(String order) {
        ArrayList<User> list = new ArrayList();
        String sql = "SELECT * FROM user  ORDER BY" + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                User user = User.fromRS(rs);
                list.add(user);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public User save(User obj) {

        String sql = "INSERT INTO user (user_login, user_name, user_gender, user_password, user_role)"
                + "VALUES(?, ?, ?, ?, ?)";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getLogin());
            stmt.setString(2, obj.getName());
            stmt.setString(3, obj.getGender());
            stmt.setString(4, obj.getPassword());
            stmt.setInt(5, obj.getRole());
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
    public User update(User obj) {
        String sql = "UPDATE user"
                + " SET user_login = ?, user_name = ?, user_gender = ?, user_password = ?, user_role = ?"
                + " WHERE user_id = ?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getLogin());
            stmt.setString(2, obj.getName());
            stmt.setString(3, obj.getGender());
            stmt.setString(4, obj.getPassword());
            stmt.setInt(5, obj.getRole());
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
    public int delete(User obj) {
        String sql = "DELETE FROM user WHERE user_id=?";
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
