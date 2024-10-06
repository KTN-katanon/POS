/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.werapan.databaseproject.service;

import com.werapan.databaseproject.dao.ProductDao;
import com.werapan.databaseproject.dao.ProductDao;
import com.werapan.databaseproject.model.Product;
import com.werapan.databaseproject.model.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author werapan
 */
public class ProductService {
    private ProductDao productDao = new ProductDao();
    public ArrayList<Product> getProductOrderByName(){
        return (ArrayList<Product>) productDao.getAll(" product_name ASC ");
    }
}
