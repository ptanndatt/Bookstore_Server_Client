package service;

import dao.ProductDao;
import dao.impl.ProductDaoImpl;
import models.Product;

import java.util.List;

public class ProductDaoImplService {
    private ProductDao productDao=new ProductDaoImpl();
    public Product getById(String id) {
        return productDao.getProductById(id);
    }
    public List<Product> getProductByText(String text) {
        return productDao.getProductByText(text);
    }
}
