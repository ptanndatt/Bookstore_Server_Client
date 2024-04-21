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
import java.util.ArrayList;
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


        List<BillPending> promotions = mainController.findBillPendingByText("03");
        System.out.println(promotions);
    }

    @AfterAll
    void tearDown() {
        mainController = null;

    }


}
