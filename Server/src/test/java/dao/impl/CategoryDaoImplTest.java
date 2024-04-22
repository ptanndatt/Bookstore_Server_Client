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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CategoryDaoImplTest {

    private MainController mainController;
    private ProductSaleDao productSaleDao;
    @BeforeAll
    void setUp() {
        mainController = new MainController();
//        productSaleDao = new ProductSaleDaoImpl();
    }
    @Test
    void getProductSales() {

        LocalDate datefrom= LocalDate.now();
        LocalDate dateto=LocalDate.of(2024,5,1);
        List<Bill> merchandises = mainController.findBillByDate(datefrom,dateto);
        System.out.println(merchandises);
    }

    @AfterAll
    void tearDown() {
        mainController = null;

    }


}
