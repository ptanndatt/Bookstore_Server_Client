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
        categories.forEach(category -> Log.info(category.toString()));
    }

    @Test
    void testAddCategory() {
        Category category = new Category("Books", 11, "This category contains books");
        boolean result = categoryDao.addCategory(category);
        if (result == true) {
            Log.info("Add category successfully");
        } else {
            Log.error("Add category failed");
        }
    }

    @Test
    void testUpdateCategory() {
        Category category = new Category("Hoangle", 11, "This category contains books");
        category.setIdCategory("null20240404140937");
        boolean result = categoryDao.updateCategory(category);
        if (result == true) {
            Log.info("Update category successfully");
        } else {
            Log.error("Update category failed");
        }
    }

    @Test
    void testDeleteCategory() {
        boolean result = categoryDao.deleteCategory("null20240404140937");
        if (result == true) {
            Log.info("Delete category successfully");
        } else {
            Log.error("Delete category failed");
        }
    }

    @Test
    void testCheckIdCategory() {
        boolean result = categoryDao.checkIdCategory("null20240404012003");
        if (result == true) {
            Log.info("Check id category successfully");
        } else {
            Log.error("Check id category failed");
        }
    }

    @Test
    void testGetLatestCategoryID() {
        List<String> categoryIDs = categoryDao.getLatestCategoryID();
        categoryIDs.forEach(categoryID -> Log.info(categoryID));
    }

    @AfterAll
    void tearDown() {
        categoryDao = null;
        System.out.println("After all test");
    }


}
