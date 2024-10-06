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
public class User {
    private int id;
    private String login;
    private String name;
    private String password;
    private int role;
    private String gender;

    public User(int id, String login, String name, String password, int role, String gender) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.password = password;
        this.role = role;
        this.gender = gender;
    }

    public User(String login,String name, String password, int role, String gender) {
        this.id = -1;
        this.login = login;
        this.name = name;
        this.password = password;
        this.role = role;
        this.gender = gender;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public User() {
        this.id = -1;
        this.gender = "M";
        this.role = 0;
        this.name = "";
        this.login = "";
        this.password = "";
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", login=" + login + ", name=" + name + ", password=" + password + ", role=" + role + ", gender=" + gender + '}';
    }

    
    public static User fromRS(ResultSet rs) {
        User user = new User();
        try {
            user.setId(rs.getInt("user_id"));
            user.setLogin(rs.getString("user_login"));
            user.setName(rs.getString("user_name"));
            user.setRole(rs.getInt("user_role"));
            user.setGender(rs.getString("user_gender"));
            user.setPassword(rs.getString("user_password"));
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return user;
    }
}
