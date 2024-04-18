package dao;

import models.Product;

import java.util.List;

public interface ProductDao {
    Product getProductById(String id);
    List<Product> getProductByText(String text);
    boolean updateProduct(String id, int quantity);
}
