/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test_service;

import com.werapan.databaseproject.dao.ProductDao;
import com.werapan.databaseproject.dao.RecieptDao;
import com.werapan.databaseproject.model.Product;
import com.werapan.databaseproject.model.Reciept;
import com.werapan.databaseproject.model.RecieptDetail;
import com.werapan.databaseproject.service.RecieptService;
import java.util.List;

/**
 *
 * @author nonku
 */
public class TestRecieptService {

    public static void main(String[] args) {
//        RecieptService recieptService = new RecieptService();
//        for (Reciept reciept : recieptService.getReciepts()) {
//            System.out.println(reciept);
//        }
//        System.out.println(recieptService.getById(1));
//        Reciept r1 = new Reciept(1000,10,1);
//        ProductDao pd = new ProductDao();
//        List<Product> products = pd.getAll();
//        Product product0 = products.get(0);
//        Product product1 = products.get(1);
//        
//        
//        RecieptDetail newRecieptDetail1 = new RecieptDetail(product0.getId(), product0.getName(),
//                product0.getPrice(), 1, product0.getPrice() * 1, -1);
//        
//        r1.addRecieptDetail(newRecieptDetail1);
//        
//        RecieptDetail newRecieptDetail2 = new RecieptDetail(product1.getId(), product1.getName(),
//                product1.getPrice(), 2, product1.getPrice() * 2, -1);
//        
//        r1.addRecieptDetail(newRecieptDetail2);
//        System.out.println(r1);
//        recieptService.addNew(r1);
//
//        for (Reciept reciept : recieptService.getReciepts()) {
//            System.out.println(reciept);
//        }
          RecieptDao rd = new RecieptDao();
          System.out.println(rd.get(1));
    }
}
