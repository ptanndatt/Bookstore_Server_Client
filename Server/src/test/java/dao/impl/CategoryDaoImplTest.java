package dao.impl;


import controller.MainController;
import dao.CategoryDao;
import dao.ProductSaleDao;
import models.BillPending;
import models.Category;
import models.ProductSale;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import util.log.Log;

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
        List<BillPending> billPending = mainController.getAllBillPending();
        System.out.println(billPending);
    }

    @AfterAll
    void tearDown() {
        mainController = null;

    }


}
