/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.werapan.databaseproject.dao;

import com.werapan.databaseproject.model.User;
import java.util.List;

/**
 *
 * @author werapan
 */
public interface Dao<T> {
    T get(int id);
    List<T> getAll();
    T save(T obj);
    T update(T obj);
    int delete(T obj);
    List<T> getAll(String where, String order);
}
