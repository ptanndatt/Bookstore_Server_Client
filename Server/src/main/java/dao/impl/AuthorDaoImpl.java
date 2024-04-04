/*
 * @ (#) .java   1.0    04/04/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package dao.impl;/*
 * @description:
 * @author:     Hoang Le
 * @date:       04/04/2024
 * @version:    1.0
 */

import dao.AuthorDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import models.Author;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class AuthorDaoImpl implements AuthorDao {
    private EntityManager em;

    public AuthorDaoImpl() {
        em = HibernateUtil.getInstance().getEntityManager();
    }

    @Override
    public List<Author> getAllAuthor() {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            List<Author> authors = em.createQuery("FROM Author", Author.class).getResultList();
            tr.commit();
            return authors;
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean addAuthor(Author author) {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.persist(author);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateAuthor(Author author) {
        return false;
    }

    @Override
    public boolean deleteAuthor(String idAuthor) {
        return false;
    }

    @Override
    public boolean checkIdAuthor(String idAuthor) {
        return false;
    }

    @Override
    public List<Author> getLatestAuthorID() {
        return null;
    }
}
