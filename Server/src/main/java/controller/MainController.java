package controller;

import models.Author;
import models.Category;
import models.ProductType;
import models.Supplier;
import service.AuthorDaoImplService;
import service.CategoryDaoImplService;
import service.ProductTypeDaoImplService;
import service.SupplierDaoImplService;

import java.util.List;

public class MainController {
    private AuthorDaoImplService authorDaoImplService = new AuthorDaoImplService();
    private CategoryDaoImplService categoryDaoImplService = new CategoryDaoImplService();
    private ProductTypeDaoImplService productTypeDaoImplService = new ProductTypeDaoImplService();
    private SupplierDaoImplService supplierDaoImplService = new SupplierDaoImplService();

    // author
    public List<Author> getAllAuthor() {
        return authorDaoImplService.getAllAuthor();
    }

    public boolean addAuthor(Author author) {
        return authorDaoImplService.addAuthor(author);
    }

    public boolean updateAuthor(Author author) {
        return authorDaoImplService.updateAuthor(author);
    }

    public boolean deleteAuthor(String idAuthor) {
        return authorDaoImplService.deleteAuthor(idAuthor);
    }

    public boolean checkIdAuthor(String idAuthor) {
        return authorDaoImplService.checkIdAuthor(idAuthor);
    }

    public List<Author> getLatestAuthorID() {
        return authorDaoImplService.getLatestAuthorID();
    }

    // category
    public List<Category> getAllCategory() {
        return categoryDaoImplService.getAllCategory();
    }

    public boolean addCategory(Category category) {
        return categoryDaoImplService.addCategory(category);
    }

    public boolean updateCategory(Category category) {
        return categoryDaoImplService.updateCategory(category);
    }

    public boolean deleteCategory(String idCategory) {
        return categoryDaoImplService.deleteCategory(idCategory);
    }

    public boolean checkIdCategory(String idCategory) {
        return categoryDaoImplService.checkIdCategory(idCategory);
    }

    public List<String> getLatestCategoryID() {
        return categoryDaoImplService.getLatestCategoryID();
    }

    // product type
    public List<ProductType> getAllProductType() {
        return productTypeDaoImplService.getAllProductType();
    }

    public ProductType getProductTypeById(String id) {
        return productTypeDaoImplService.getProductTypeById(id);
    }

    public boolean addProductType(ProductType productType) {
        return productTypeDaoImplService.addProductType(productType);
    }

    public boolean updateProductType(ProductType productType) {
        return productTypeDaoImplService.updateProductType(productType);
    }

    public boolean deleteProductType(String id) {
        return productTypeDaoImplService.deleteProductType(id);
    }

    public List<String> getLastestProductType() {
        return productTypeDaoImplService.getLastestProductType();
    }

    public boolean checkProductTypeExist(String id) {
        return productTypeDaoImplService.checkProductTypeExist(id);
    }

    // supplier
    public List<Supplier> getAllSuppliers() {
        return supplierDaoImplService.getAllSuppliers();
    }

    public boolean addSupplier(Supplier supplier) {
        return supplierDaoImplService.addSupplier(supplier);
    }

    public boolean updateSupplier(Supplier supplier) {
        return supplierDaoImplService.updateSupplier(supplier);
    }

    public boolean deleteSupplier(String id) {
        return supplierDaoImplService.deleteSupplier(id);
    }

    public boolean checkSupplierId(String id) {
        return supplierDaoImplService.checkSupplierId(id);
    }

    public List<Supplier> getLatestSupplierId() {
        return supplierDaoImplService.getLatestSupplierId();
    }

}
