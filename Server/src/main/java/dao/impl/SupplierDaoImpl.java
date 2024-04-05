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

import dao.SupplierDao;
import models.Supplier;

import java.util.List;

public class SupplierDaoImpl implements SupplierDao {
    @Override
    public List<Supplier> getAllSuppliers() {
        return null;
    }

    @Override
    public boolean addSupplier(Supplier supplier) {
        return false;
    }

    @Override
    public boolean updateSupplier(Supplier supplier) {
        return false;
    }

    @Override
    public boolean deleteSupplier(String id) {
        return false;
    }

    @Override
    public boolean checkSupplierId(String id) {
        return false;
    }

    @Override
    public List<String> getLatestSupplierId() {
        return null;
    }
}
