package service;

import dao.impl.ProductTypeDaoImpl;
import models.ProductType;

import java.util.List;

public class ProductTypeDaoImplService {
    private ProductTypeDaoImpl productTypeDaoImpl = new ProductTypeDaoImpl();

    public List<ProductType> getAllProductType() {
        return productTypeDaoImpl.getAllProductType();
    }

    public ProductType getProductTypeById(String id) {
        return productTypeDaoImpl.getProductTypeById(id);
    }

    public boolean addProductType(ProductType productType) {
        return productTypeDaoImpl.addProductType(productType);
    }

    public boolean updateProductType(ProductType productType) {
        return productTypeDaoImpl.updateProductType(productType);
    }

    public boolean deleteProductType(String id) {
        return productTypeDaoImpl.deleteProductType(id);
    }

    public List<String> getLastestProductType() {
        return productTypeDaoImpl.getLastestProductType();
    }

    public boolean checkProductTypeExist(String id) {
        return productTypeDaoImpl.checkProductTypeExist(id);
    }
}
