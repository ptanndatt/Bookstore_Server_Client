package service;

import dao.impl.CategoryDaoImpl;
import models.Category;

import java.util.List;

public class CategoryDaoImplService {
    private CategoryDaoImpl categoryDaoImpl = new CategoryDaoImpl();

    public List<Category> getAllCategory() {
        return categoryDaoImpl.getAllCategory();
    }

    public boolean addCategory(Category category) {
        return categoryDaoImpl.addCategory(category);
    }

    public boolean updateCategory(Category category) {
        return categoryDaoImpl.updateCategory(category);
    }

    public boolean deleteCategory(String idCategory) {
        return categoryDaoImpl.deleteCategory(idCategory);
    }

    public boolean checkIdCategory(String idCategory) {
        return categoryDaoImpl.checkIdCategory(idCategory);
    }

    public List<String> getLatestCategoryID() {
        return categoryDaoImpl.getLatestCategoryID();
    }
}
