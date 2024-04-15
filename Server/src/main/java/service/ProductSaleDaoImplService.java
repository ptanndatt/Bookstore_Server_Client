package service;

import dao.ProductSaleDao;
import dao.impl.ProductSaleDaoImpl;
import models.Account;
import models.ProductSale;

import java.util.List;

public class ProductSaleDaoImplService {
    private ProductSaleDao productSaleDao=new ProductSaleDaoImpl();
    public List<ProductSale> getAllAProductSale() {
        return productSaleDao.getProductSale();
    }

    public boolean addProductSale(ProductSale productSale) {
        return productSaleDao.addProductSale(productSale);
    }



    public boolean deleteProductSale(String productSale) {
        return productSaleDao.deleteProductSale(productSale);
    }
    public ProductSale getProductSale(String productSaleId) {
        return productSaleDao.getProductSaleById(productSaleId);
    }
}
