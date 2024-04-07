/*
 * @ (#) .java   1.0    05/04/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package dao.impl;/*
 * @description:
 * @author:     Hoang Le
 * @date:       05/04/2024
 * @version:    1.0
 */

import dao.ProductTypeDao;
import junit.framework.TestCase;
import models.ProductType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import util.log.Log;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductTypeDaoImplTest {
    private ProductTypeDao productTypeDao;

    @BeforeAll
    void setUp() {
        productTypeDao = new ProductTypeDaoImpl();
    }

    @Test
    void testAddProductType() {
        ProductType productType = new ProductType("Kieu hoc tap");
        boolean result = productTypeDao.addProductType(productType);
        if (result) {
            Log.info("Add product type successfully");
        } else {
            Log.error("Add product type failed");
        }
    }

    @Test
    void testGetAllProductType() {
        Log.info("List of product types: ");
        productTypeDao.getAllProductType().forEach(productType -> Log.info(productType.toString()));
    }

    @Test
    void testUpdateProductType() {
        ProductType productType = new ProductType("Le Van Hoang");
        productType.setProductTypeId("null20240405153116");
        boolean result = productTypeDao.updateProductType(productType);
        if (result) {
            Log.info("Update product type successfully");
        } else {
            Log.error("Update product type failed");
        }
    }

    @Test
    void testGetProductTypeById() {
        ProductType productType = productTypeDao.getProductTypeById("null20240405153116");
        if (productType != null) {
            Log.info("Product type: " + productType.toString());
        } else {
            Log.error("Product type not found");
        }
    }

    @Test
    void testDeleteProductType() {
        boolean result = productTypeDao.deleteProductType("null20240405153116");
        if (result) {
            Log.info("Delete product type successfully");
        } else {
            Log.error("Delete product type failed");
        }
    }

    @Test
    void testGetLastestProductType() {
        List<String> productType = productTypeDao.getLastestProductType();
        if (productType != null) {
            Log.info("Product type: " + productType.toString());
        } else {
            Log.error("Product type not found");
        }
    }

    @Test
    void testCheckProductTypeExist() {
        boolean result = productTypeDao.checkProductTypeExist("null20240405160527");
        if (result) {
            Log.info("Product type exist");
        } else {
            Log.error("Product type not exist");
        }
    }

    @AfterAll
    void tearDown() {
        productTypeDao = null;
    }
}
