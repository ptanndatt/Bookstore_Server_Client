package dao;

import models.ProductSale;

import java.util.List;

public interface ProductSaleDao {
    List<ProductSale> getProductSale();
    boolean addProductSale(ProductSale productSale);
//    boolean deleteProductSale(String id);

//    boolean deleteProductSale(ProductSale productSale);

    boolean deleteProductSale(String id);
    ProductSale getProductSaleById(String id);
}
