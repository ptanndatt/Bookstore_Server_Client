package dao.impl;

import dao.SaleManagementDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import models.*;
import util.HibernateUtil;

import java.util.*;

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
            em.createQuery("delete from BillPending ").executeUpdate();
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteAllDetailBillPending() {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.createQuery("delete from DetailsBillPending ").executeUpdate();
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
        EntityTransaction entityTransaction = em.getTransaction();
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
        EntityTransaction entityTransaction = em.getTransaction();
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
        EntityTransaction entityTransaction = em.getTransaction();
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
        EntityTransaction entityTransaction = em.getTransaction();
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
        return em.createQuery("SELECT d FROM DetailsBillPending d WHERE d.billId=:id", DetailsBillPending.class)
                .setParameter("id", id) // %text% for similarity
                .getResultList();
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
    public List<DetailsBillPending> getAllDetailsBillPending() {
        try {
            String hql = "FROM DetailsBillPending ";
            TypedQuery<DetailsBillPending> query = em.createQuery(hql, DetailsBillPending.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public Bill findBillById(String id) {
        return em.find(Bill.class, id);
    }


    /*
    *     /*
    * select b.billId, b.billDate,e.employeeName, c.customerName, b.amountReceived, b.amounttotal
    from Bill b  join Employee e
on b.employeeId = e.employeeId
 join Customer c
on b.customerId = c.customerId
    * */
    @Override
    public List<Object[]> getAllBill() {
        String jpql = "SELECT b.billId, b.billDate, e.name, c.name, " +
                "MAX(ps.description) AS productDescription, b.amountReceived, b.amounttotal " +
                "FROM Bill b " +
                "JOIN b.employee e " +
                "JOIN b.customer c " +
                "JOIN b.detailsBills db " +
                "JOIN db.product p " +
                "LEFT JOIN p.productSale ps " +
                "GROUP BY b.billId, b.billDate, e.name, c.name, " +
                "b.amountReceived, b.amounttotal";

        TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
        return query.getResultList();
    }

    /*
    * select p.productId, p.productName, db.quantity, db.price, SUM(db.price*db.quantity) as ThanhTien
    from Bill b
join DetailsBill db on db.billId = b.billId
join Product p on db.productId = p.productId
group by p.productId, p.productName, db.quantity, db.price
    * */
    @Override
    public List<Object[]> loadDataProduct() {
        String hql = "SELECT p.productId, p.productName, db.quantity, db.price, SUM(db.price*db.quantity) as ThanhTien " +
                "FROM Bill b " +
                "JOIN b.detailsBills db " +
                "JOIN db.product p " +
                "GROUP BY p.productId, p.productName, db.quantity, db.price";
        TypedQuery<Object[]> query = em.createQuery(hql, Object[].class);
        return query.getResultList();
    }


    @Override
    public boolean deleteBillPendingById(String id) {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.createQuery("delete FROM BillPending d WHERE d.billId =:id")
                    .setParameter("id", id).executeUpdate(); // %text% for similarity
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteDetailsBillPendingById(String id) {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.createQuery("delete from DetailsBillPending d where d.billId=:id").setParameter("id", id).executeUpdate();
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
            return false;
        }
    }

}
