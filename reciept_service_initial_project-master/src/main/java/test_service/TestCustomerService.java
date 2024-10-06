/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test_service;

import com.werapan.databaseproject.model.Customer;
import com.werapan.databaseproject.service.CustomerService;

/**
 *
 * @author nonku
 */
public class TestCustomerService {
    public static void main(String[] args) {
        CustomerService cs = new CustomerService();
        for(Customer customer : cs.getCustomers()){
            System.out.println(customer);
        }
        System.out.println(cs.getByTel("0888868888"));
        Customer cus1 = new Customer("kob", "0863398888");
        cs.addNew(cus1);
        for(Customer customer : cs.getCustomers()){
            System.out.println(customer);
        }
        Customer delCus = cs.getByTel("0863398888");
        delCus.setTel("0863398881");
        cs.update(delCus);
        System.out.println("After Updated");
        for(Customer customer : cs.getCustomers()){
            System.out.println(customer);
        }
        cs.delete(delCus);
        for(Customer customer : cs.getCustomers()){
            System.out.println(customer);
        }
    }
}
