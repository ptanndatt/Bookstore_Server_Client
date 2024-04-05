/*
 * @ (#) .java   1.0    05/04/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package dao;/*
 * @description:
 * @author:     Hoang Le
 * @date:       05/04/2024
 * @version:    1.0
 */

import models.Supplier;

import java.util.List;

public interface SupplierDao {
    List<Supplier> getAllSuppliers();

    boolean addSupplier(Supplier supplier);

    boolean updateSupplier(Supplier supplier);

    boolean deleteSupplier(String id);

    boolean checkSupplierId(String id);

    List<String> getLatestSupplierId();


}
