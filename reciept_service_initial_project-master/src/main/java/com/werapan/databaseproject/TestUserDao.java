/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.werapan.databaseproject;

import com.werapan.databaseproject.dao.UserDao;
import com.werapan.databaseproject.helper.DatabaseHelper;
import com.werapan.databaseproject.model.User;

/**
 *
 * @author werapan
 */
public class TestUserDao {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        for(User u: userDao.getAll()) {
            System.out.println(u);
        }
//        User user1 = userDao.get(2);
//        System.out.println(user1);
        
//        User newUser = new User("user3", "password", 2, "F");
//        User insertedUser = userDao.save(newUser);
//        System.out.println(insertedUser);
//        insertedUser.setGender("M");
//        user1.setGender("F");
//        userDao.update(user1);
//        User updateUser = userDao.get(user1.getId());
//        System.out.println(updateUser);
        
//        userDao.delete(user1);
//        for(User u: userDao.getAll()) {
//            System.out.println(u);
//        }
        
        
        for(User u: userDao.getAll(" user_name like 'u%' ", " user_name asc, user_gender desc ")) {
            System.out.println(u);
        }
        
        DatabaseHelper.close();
    }
}
