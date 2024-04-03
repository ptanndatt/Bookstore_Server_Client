/*
 * @ (#) .java   1.0    03/04/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package dao.impl;/*
 * @description:
 * @author:     Hoang Le
 * @date:       03/04/2024
 * @version:    1.0
 */

import dao.CategoryDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import lombok.extern.log4j.Log4j2;
import models.Category;

import util.HibernateUtil;
import util.log.Log;

import java.util.List;


public class CategoryDaoImpl implements CategoryDao {
    private EntityManager em;

    public CategoryDaoImpl() {
        em = HibernateUtil.getInstance().getEntityManager();
    }

    @Override
    public List<Category> getAllCategory() {
        List<Category> categories = null;
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            String hql = "FROM Category";
            TypedQuery<Category> query = em.createQuery(hql, Category.class);
            categories = query.getResultList();
            tr.commit();
            Log.info("Retrieved all categories successfully");
        } catch (Exception e) {
            tr.rollback();
            Log.error("Error retrieving all categories");
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public boolean addCategory(Category category) {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.persist(category);
            tr.commit();
//            Log.info("Added category successfully");
            return true;
        } catch (Exception e) {
            tr.rollback();
//            Log.error("Error adding category");
            e.printStackTrace();
            return false;
        }
    }
}
