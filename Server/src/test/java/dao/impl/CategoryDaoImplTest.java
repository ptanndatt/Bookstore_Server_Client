package dao.impl;


import controller.MainController;
import dao.CategoryDao;
import dao.ProductSaleDao;
import models.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import util.log.Log;

import java.sql.Date;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CategoryDaoImplTest {

    private MainController mainController;

    @BeforeAll
    void setUp() {
        mainController = new MainController();

    }
    @Test
    void getProductSales() {
//        Customer customer=mainController.findCustomerById("C20240414195510");
//        Employee employee=mainController.findEmployeeById("E20240415161112");
//        Bill bill = new Bill("B123", Date.valueOf("2023-05-06"),customer,employee,10000,20000,1000);
//        Bill bill = mainController.getBillById("B123");
        Product product = mainController.getProductById("SP20240415212327");

        boolean result= mainController.updateProductQuantity("SP20240415212327",15);
        System.out.println(product);
        System.out.println(result);
    }

    @AfterAll
    void tearDown() {
        mainController = null;

    }


}
