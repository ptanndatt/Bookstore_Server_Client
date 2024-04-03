package dao.impl;


import dao.CategoryDao;
import models.Category;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import util.log.Log;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CategoryDaoImplTest {

    private CategoryDao categoryDao;

    @BeforeAll
    void setUp() {
        categoryDao = new CategoryDaoImpl();
        System.out.println("Before all test");
    }

    @Test
    void testGetAllCategory() {
        List<Category> categories = categoryDao.getAllCategory();
        categories.forEach(category -> Log.info(category));
    }

    @Test
    void testAddCategory() {
        Category category = new Category("Books", 10, "This category contains books");
        boolean result = categoryDao.addCategory(category);
        
//        if (result == true) {
//            Log.info("Add category successfully");
//        } else {
//            Log.error("Add category failed");
//        }
    }

    @AfterAll
    void tearDown() {
        categoryDao = null;
        System.out.println("After all test");
    }


}
