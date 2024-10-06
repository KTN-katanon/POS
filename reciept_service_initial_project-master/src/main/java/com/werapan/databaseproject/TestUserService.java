/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.werapan.databaseproject;

import com.werapan.databaseproject.model.User;
import com.werapan.databaseproject.service.UserService;

/**
 *
 * @author werapan
 */
public class TestUserService {
    public static void main(String[] args) {
        UserService userSevice = new UserService();
        User user = userSevice.login("user2", "password");
        if(user!=null) {
            System.out.println("Welcome user : " + user.getName());
        } else {
            System.out.println("Error");
        }
        
    }
}
