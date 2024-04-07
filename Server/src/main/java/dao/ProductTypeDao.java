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

import models.ProductType;

import java.util.List;

public interface ProductTypeDao {
    List<ProductType> getAllProductType();

    ProductType getProductTypeById(String id);

    boolean addProductType(ProductType productType);

    boolean updateProductType(ProductType productType);

    boolean deleteProductType(String id);

    List<String> getLastestProductType();

    boolean checkProductTypeExist(String name);
}
