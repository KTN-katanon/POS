/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.werapan.databaseproject.model;

import com.werapan.databaseproject.dao.CustomerDao;
import com.werapan.databaseproject.dao.UserDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nonku
 */
public class RecieptDetail {
    private int recieptDetailId;
    private int productId;
    private String productName;
    private double productPrice;
    private int qty;
    private double totalPrice;
    private int recieptId;

    public RecieptDetail(int recieptDetailId, int productId, String productName, double productPrice, int qty, double totalPrice, int recieptId) {
        this.recieptDetailId = recieptDetailId;
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.qty = qty;
        this.totalPrice = totalPrice;
        this.recieptId = recieptId;
    }
    
    public RecieptDetail(int productId, String productName, double productPrice, int qty, double totalPrice, int recieptId) {
        this.recieptDetailId = -1;
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.qty = qty;
        this.totalPrice = totalPrice;
        this.recieptId = recieptId;
    }
    public RecieptDetail() {
        this.recieptDetailId = -1;
        this.productId = 0;
        this.productName = "";
        this.productPrice = 0;
        this.qty = 0;
        this.totalPrice = 0;
        this.recieptId = 0;
    }

    public int getId() {
        return recieptDetailId;
    }

    public void setId(int recieptDetailId) {
        this.recieptDetailId = recieptDetailId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getRecieptId() {
        return recieptId;
    }

    public void setRecieptId(int recieptId) {
        this.recieptId = recieptId;
    }

    @Override
    public String toString() {
        return "RecieptDetail{" + "recieptDetailId=" + recieptDetailId + ", productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice + ", qty=" + qty + ", totalPrice=" + totalPrice + ", recieptId=" + recieptId + '}';
    }
    
    public static RecieptDetail fromRS(ResultSet rs) {
        RecieptDetail recieptDetail = new RecieptDetail();
        try {
            recieptDetail.setId(rs.getInt("reciept_detail_id"));
            recieptDetail.setProductId(rs.getInt("product_id"));
            recieptDetail.setProductName(rs.getString("product_name"));
            recieptDetail.setProductPrice(rs.getDouble("product_price"));
            recieptDetail.setQty(rs.getInt("qty"));
            recieptDetail.setTotalPrice(rs.getDouble("total_price"));
            recieptDetail.setRecieptId(rs.getInt("reciept_id"));
           
        } catch (SQLException ex) {
            Logger.getLogger(Reciept.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return recieptDetail;
    }
    
}
