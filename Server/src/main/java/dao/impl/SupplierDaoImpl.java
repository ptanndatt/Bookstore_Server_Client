/*
 * @ (#) .java   1.0    05/04/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package dao.impl;/*
 * @description:
 * @author:     Hoang Le
 * @date:       05/04/2024
 * @version:    1.0
 */

import dao.SupplierDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import models.Supplier;
import util.HibernateUtil;

import java.util.List;

public class SupplierDaoImpl implements SupplierDao {
    private EntityManager em;

    public SupplierDaoImpl() {
        em = HibernateUtil.getInstance().getEntityManager();
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        try {
            String hql = "FROM Supplier";
            TypedQuery<Supplier> query = em.createQuery(hql, Supplier.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean addSupplier(Supplier supplier) {
        EntityTransaction tr = null;
        try {
            tr = em.getTransaction();
            tr.begin();
            em.persist(supplier);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateSupplier(Supplier supplier) {
        EntityTransaction tr = null;
        try {
            tr = em.getTransaction();
            tr.begin();
            em.merge(supplier);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteSupplier(String id) {
        EntityTransaction tr = null;
        try {
            tr = em.getTransaction();
            tr.begin();
            Supplier supplier = em.find(Supplier.class, id);
            em.remove(supplier);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean checkSupplierId(String id) {
        try {
            Supplier supplier = em.find(Supplier.class, id);
            return supplier != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Supplier> getLatestSupplierId() {
        try {
            String hql = "SELECT s FROM Supplier s ORDER BY s.supplierId DESC";
            TypedQuery<Supplier> query = em.createQuery(hql, Supplier.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
