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
    public boolean deleteProductSaleByPromotionId(String promotionId) {
        return productSaleDao.deleteProductSaleByPromotionId(promotionId);
    }
    public ProductSale getProductSale(String productSaleId) {
        return productSaleDao.getProductSaleById(productSaleId);
    }
    public List<ProductSale> getProductSaleByPromotionId(String productSaleId) {
        return productSaleDao.getProductSaleByPromotionId(productSaleId);
    }
    public List<ProductSale> findProductSaleByText(String text) {
        return productSaleDao.findProductSaleByText(text);
    }
}
