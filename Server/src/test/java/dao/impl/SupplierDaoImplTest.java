///*
// * @ (#) .java   1.0    05/04/2024
// *
// * Copyright (c) 2024 IUH. All rights reserved.
// */
//
//package dao.impl;/*
// * @description:
// * @author:     Hoang Le
// * @date:       05/04/2024
// * @version:    1.0
// */
//
//import dao.SupplierDao;
//import models.Supplier;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestInstance;
//import util.log.Log;
//
//import java.util.List;
//
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//public class SupplierDaoImplTest {
//    private SupplierDao supplierDao;
//
//    @BeforeAll
//    void setUp() {
//        supplierDao = new SupplierDaoImpl();
//    }
//
//    @Test
//    void testAddSupplier() {
//        Supplier supplier = new Supplier("23213213dsadsa", "123456", "Hoangle");
//        boolean check = supplierDao.addSupplier(supplier);
//        if (check) {
//            Log.info("Add supplier successfully");
//        } else {
//            Log.error("Add supplier failed");
//        }
//    }
//
//    @Test
//    void testGetAllSuppliers() {
//        supplierDao.getAllSuppliers().forEach(supplier -> Log.info(supplier));
//    }
//
//    @Test
//    void testUpdateSupplier() {
//        Supplier supplier = new Supplier("Long thanh", "123456", "leHoang");
//        supplier.setSupplierId("null20240405170427");
//        boolean check = supplierDao.updateSupplier(supplier);
//        if (check) {
//            Log.info("Update supplier successfully");
//        } else {
//            Log.error("Update supplier failed");
//        }
//    }
//
//    @Test
//    void testDeleteSupplier() {
//        boolean check = supplierDao.deleteSupplier("null20240405170427");
//        if (check) {
//            Log.info("Delete supplier successfully");
//        } else {
//            Log.error("Delete supplier failed");
//        }
//    }
//
//    @Test
//    void testCheckSupplierId() {
//        boolean check = supplierDao.checkSupplierId("null20240405173301");
//        if (check) {
//            Log.info("SupplierId is exist");
//        } else {
//            Log.error("SupplierId is not exist");
//        }
//    }
//
//    @Test
//    void testGetLatestSupplierId() {
//        List<Supplier> suppliers = supplierDao.getLatestSupplierId();
//        suppliers.forEach(s -> Log.info(s.toString()));
//    }
//
//    @AfterAll
//    void tearDown() {
//        supplierDao = null;
//    }
//}
