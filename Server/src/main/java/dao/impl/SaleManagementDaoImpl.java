package dao.impl;

import dao.SaleManagementDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import models.*;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SaleManagementDaoImpl implements SaleManagementDao {
    private EntityManager em;
    public SaleManagementDaoImpl() {
        em = HibernateUtil.getInstance().getEntityManager();
    }
    @Override
    public boolean deleteAllBillPending() {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.createQuery("delete from BillPending").executeUpdate();
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addBill(Bill bill) {
        EntityTransaction entityTransaction=em.getTransaction();
        try {
            entityTransaction.begin();
            em.persist(bill);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addDetailBill(DetailsBill detailsBill) {
        EntityTransaction entityTransaction=em.getTransaction();
        try {
            entityTransaction.begin();
            em.persist(detailsBill);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public boolean addBillPending(BillPending billPending) {
        EntityTransaction entityTransaction=em.getTransaction();
        try {
            entityTransaction.begin();
            em.persist(billPending);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addDetailsBillPending(DetailsBillPending detailsBillPending) {
        EntityTransaction entityTransaction=em.getTransaction();
        try {
            entityTransaction.begin();
            em.persist(detailsBillPending);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<DetailsBillPending> findDetailsBillPendingById(String id) {
        return em.createQuery("SELECT d FROM DetailsBillPending d WHERE d.billId =:id", DetailsBillPending.class)
                .setParameter("id", "%" + id + "%") // %text% for similarity
                .getResultList();
    }

    @Override
    public boolean deleteDetailsBillPendingById(String id) {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.createQuery("delete FROM DetailsBillPending d WHERE d.billId =:id", DetailsBillPending.class)
                .setParameter("id", "%" + id + "%"); // %text% for similarity
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<BillPending> getAllBillPending() {
        try {
            String hql = "FROM BillPending ";
            TypedQuery<BillPending> query = em.createQuery(hql, BillPending.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public boolean deleteBillPendingById(String id) {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.createQuery("delete FROM BillPending d WHERE d.billID =:id", DetailsBillPending.class)
                    .setParameter("id", "%" + id + "%"); // %text% for similarity
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
            return false;
        }
    }


}
