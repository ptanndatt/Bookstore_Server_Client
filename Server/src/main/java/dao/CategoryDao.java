/*
 * @ (#) .java   1.0    03/04/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package dao;/*
 * @description:
 * @author:     Hoang Le
 * @date:       03/04/2024
 * @version:    1.0
 */

import models.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> getAllCategory();

    boolean addCategory(Category category);

    boolean updateCategory(Category category);

    boolean deleteCategory(String idCategory);

    boolean checkIdCategory(String idCategory);

    List<String> getLatestCategoryID();

    boolean decreaseNumberOfCategory(String idCategory);

    boolean increaseNumberOfCategory(String idCategory);
    

}
