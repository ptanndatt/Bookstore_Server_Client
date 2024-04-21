package dao;

import models.ProductSale;

import java.util.List;

public interface ProductSaleDao {
    List<ProductSale> getProductSale();
    boolean addProductSale(ProductSale productSale);
    boolean deleteProductSale(String id);
    boolean deleteProductSaleByPromotionId(String id);
    ProductSale getProductSaleById(String id);
    List<ProductSale> getProductSaleByPromotionId(String id);

    List<ProductSale> findProductSaleByText(String text);
}
