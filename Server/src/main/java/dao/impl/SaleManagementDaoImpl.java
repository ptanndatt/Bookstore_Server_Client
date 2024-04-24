
package dao.impl;

import dao.SaleManagementDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import models.*;
import util.HibernateUtil;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class SaleManagementDaoImpl extends UnicastRemoteObject implements SaleManagementDao {
    private static final long serialVersionUID = -4561025631834286278L;
    private EntityManager em;

    public SaleManagementDaoImpl() throws RemoteException {
        em = HibernateUtil.getInstance().getEntityManager();
    }

    @Override
    public boolean deleteAllBillPending() throws RemoteException {
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
    public boolean deleteAllDetailBillPending() throws RemoteException {
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
    public boolean addBill(Bill bill) throws RemoteException {
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
    public boolean addDetailBill(DetailsBill detailsBill) throws RemoteException {
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
    public boolean addBillPending(BillPending billPending) throws RemoteException {
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
    public boolean addDetailsBillPending(DetailsBillPending detailsBillPending) throws RemoteException {
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
    public List<DetailsBillPending> findDetailsBillPendingById(String id) throws RemoteException {
        return em.createQuery("SELECT d FROM DetailsBillPending d WHERE d.billId=:id", DetailsBillPending.class)
                .setParameter("id", id) // %text% for similarity
                .getResultList();
    }

    @Override
    public List<DetailsBill> findDetailsBillById(String id) throws RemoteException {
        return em.createQuery("SELECT d FROM DetailsBill d WHERE d.bill.id=:id", DetailsBill.class)
                .setParameter("id", id) // %text% for similarity
                .getResultList();
    }

    @Override
    public List<BillPending> getAllBillPending() throws RemoteException {
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
    public List<DetailsBillPending> getAllDetailsBillPending() throws RemoteException {
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
    public Bill findBillById(String id) throws RemoteException {
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
    public List<Object[]> getAllBill() throws RemoteException {
        String jpql = "SELECT b.billId, b.billDate, e.name, c.name,b.amountReceived,b.amounttotal " +
                "FROM Bill b " +
                "JOIN b.employee e " +
                "JOIN b.customer c " +
                "JOIN b.detailsBills db " +
                "JOIN db.product p " +
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
    public List<Object[]> loadDataProduct(String id) throws RemoteException {
        String hql = "SELECT p.productId, p.productName, db.quantity, db.price, SUM(db.price*db.quantity) as ThanhTien " +
                "FROM Bill b " +
                "JOIN b.detailsBills db " +
                "JOIN db.product p " +
                "WHERE b.billId = :id " +
                "GROUP BY p.productId, p.productName, db.quantity, db.price";
        TypedQuery<Object[]> query = em.createQuery(hql, Object[].class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public int sumTotalBill() throws RemoteException {
        try {
            String hql = "SELECT COUNT(*) FROM Bill b";
            TypedQuery<Long> query = em.createQuery(hql, Long.class);
            Long count = query.getSingleResult();
            return count != null ? count.intValue() : 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Object[]> findBillByCustomerSDT(String sdt) throws RemoteException {
        try {
            String hql = "SELECT b.billId, b.billDate, e.name, c.name, " +
                    "MAX(ps.description) AS productDescription, b.amountReceived, b.amounttotal " +
                    "FROM Bill b " +
                    "JOIN b.employee e " +
                    "JOIN b.customer c " +
                    "JOIN b.detailsBills db " +
                    "JOIN db.product p " +
                    "LEFT JOIN p.productSale ps " +
                    "WHERE c.phone LIKE :sdt " +
                    "GROUP BY b.billId, b.billDate, e.name, c.name, " +
                    "b.amountReceived, b.amounttotal";
            TypedQuery<Object[]> query = em.createQuery(hql, Object[].class);
            query.setParameter("sdt", "%" + sdt + "%");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public List<Object[]> findProductBestSeller(Date from, Date to) throws RemoteException {
        try {
            LocalDate fromDate = from.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate toDate = to.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            String hql = "SELECT p.productId, p.productName, db.price, db.quantity as quantity, COUNT(*) * 100.0 / (SELECT COUNT(*) FROM Bill) AS percentSold " +
                    "FROM Bill b " +
                    "JOIN b.detailsBills db " +
                    "JOIN db.product p " +
                    "WHERE b.billDate BETWEEN :from AND :to " +
                    "GROUP BY p.productId, p.productName, db.price , db.quantity " +
                    "ORDER BY quantity DESC";
            TypedQuery<Object[]> query = em.createQuery(hql, Object[].class);
            query.setParameter("from", fromDate);
            query.setParameter("to", toDate);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public List<Object[]> findProductWorstSeller(Date from, Date to) throws RemoteException {
        try {
            LocalDate fromDate = from.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate toDate = to.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            String hql = "SELECT p.productId, p.productName, db.price, db.quantity AS quantity, COUNT(*) * 100.0 / (SELECT COUNT(*) FROM Bill) AS percentSold " +
                    "FROM Bill b " +
                    "JOIN b.detailsBills db " +
                    "JOIN db.product p " +
                    "WHERE b.billDate BETWEEN :from AND :to " +
                    "GROUP BY p.productId, p.productName, db.price, db.quantity " +
                    "ORDER BY quantity ASC";
            TypedQuery<Object[]> query = em.createQuery(hql, Object[].class);
            query.setParameter("from", fromDate);
            query.setParameter("to", toDate);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }


    @Override
    public double sumTotalAmount(Date from, Date to) throws RemoteException {
        try {
            LocalDate fromDate = from.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate toDate = to.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            String hql = "SELECT SUM(b.amounttotal) FROM Bill b WHERE b.billDate BETWEEN :from AND :to";
            TypedQuery<Number> query = em.createQuery(hql, Number.class);
            query.setParameter("from", fromDate);
            query.setParameter("to", toDate);
            Number count = query.getSingleResult();
            return count != null ? count.doubleValue() : 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }


    @Override
    public int sumTotalBillDate(Date from, Date to) throws RemoteException {
        try {
            LocalDate fromDate = from.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate toDate = to.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            String hql = "SELECT COUNT(*) FROM Bill b WHERE b.billDate BETWEEN :from AND :to";
            TypedQuery<Number> query = em.createQuery(hql, Number.class);
            query.setParameter("from", fromDate);
            query.setParameter("to", toDate);
            Number count = query.getSingleResult();
            return count != null ? count.intValue() : 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public double sumProfit(Date from, Date to) throws RemoteException {
        try {
            LocalDate fromDate = from.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate toDate = to.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            String hql = "SELECT SUM(b.profitTotal) FROM Bill b WHERE b.billDate BETWEEN :from AND :to";
            TypedQuery<Number> query = em.createQuery(hql, Number.class);
            query.setParameter("from", fromDate);
            query.setParameter("to", toDate);

            Number count = query.getSingleResult();
            return count != null ? count.doubleValue() : 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }


    @Override
    public double sumTotalBillValue(Date from, Date to) throws RemoteException {
        try {
            LocalDate fromDate = from.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate toDate = to.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            String hql = "SELECT SUM(db.quantity * db.price) FROM Bill b JOIN b.detailsBills db JOIN db.product p WHERE b.billDate BETWEEN :from AND :to";
            TypedQuery<Number> query = em.createQuery(hql, Number.class);
            query.setParameter("from", fromDate);
            query.setParameter("to", toDate);

            Number result = query.getSingleResult();
            return result != null ? result.doubleValue() : 0.0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }


    @Override
    public List<Object[]> sumTotalBillValueByProduct(Date from, Date to) throws RemoteException {
        try {
            LocalDate fromDate = from.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate toDate = to.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            String hql = "SELECT p.productName, SUM(db.quantity * db.price) as totalValue " +
                    "FROM Bill b " +
                    "JOIN b.detailsBills db " +
                    "JOIN db.product p " +
                    "WHERE b.billDate BETWEEN :from AND :to " +
                    "GROUP BY p.productName";

            TypedQuery<Object[]> query = em.createQuery(hql, Object[].class);
            query.setParameter("from", fromDate);
            query.setParameter("to", toDate);
            query.setMaxResults(10);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }


    @Override
    public List<Object[]> sumTotalBillValueDoanhThu(Date from, Date to) throws RemoteException {
        try {
            LocalDate fromDate = from.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate toDate = to.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            String hql = "SELECT SUM(db.quantity * db.price) FROM Bill b JOIN b.detailsBills db JOIN db.product p WHERE b.billDate BETWEEN :from AND :to";
            TypedQuery<Object[]> query = em.createQuery(hql, Object[].class);
            query.setParameter("from", fromDate);
            query.setParameter("to", toDate);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }


    @Override
    public List<Object[]> sumTotalBillValueByDate(Date from, Date to) throws RemoteException {
        try {
            LocalDate fromDate = from.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate toDate = to.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            String hql = "SELECT b.billDate, sum(b.amounttotal) as DoanhThu " +
                    "from Bill b where b.billDate BETWEEN :from AND :to " +
                    " GROUP BY b.billDate ";
            TypedQuery<Object[]> query = em.createQuery(hql, Object[].class);
            query.setParameter("from", fromDate);
            query.setParameter("to", toDate);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public List<Object[]> sumTotalBillValueByDateLoiNhuan(Date from, Date to) throws RemoteException {
        try {
            LocalDate fromDate = from.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate toDate = to.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            String hql = "SELECT b.billDate, sum(b.profitTotal) as LoiNhuan " +
                    "from Bill b where b.billDate BETWEEN :from AND :to " +
                    " GROUP BY b.billDate ";
            TypedQuery<Object[]> query = em.createQuery(hql, Object[].class);
            query.setParameter("from", fromDate);
            query.setParameter("to", toDate);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public List<Object[]> findEmployeeBestSeller(Date from, Date to) throws RemoteException {
        try {
            LocalDate fromDate = from.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate toDate = to.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            String hql = "SELECT e.name, COUNT(*) as totalBill " +
                    "FROM Bill b " +
                    "JOIN b.employee e " +
                    "WHERE b.billDate BETWEEN :from AND :to " +
                    "GROUP BY e.name ";
            TypedQuery<Object[]> query = em.createQuery(hql, Object[].class);
            query.setParameter("from", fromDate);
            query.setParameter("to", toDate);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }


    @Override
    public boolean deleteBillPendingById(String id) throws RemoteException {
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
    public boolean deleteDetailsBillPendingById(String id) throws RemoteException {
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

    @Override
    public List<BillPending> findBillPendingByText(String text) throws RemoteException {
        return em.createQuery("SELECT p from BillPending p where p.customer.name LIKE:text OR p.customer.phone LIKE :text OR p.customer.id LIKE :text", BillPending.class)
                .setParameter("text", "%" + text + "%") // %text% for similarity
                .getResultList();
    }

    @Override
    public List<Bill> findBillByEmployee(String employeeID) throws RemoteException {
        return em.createQuery("SELECT p from Bill p where p.employee.idEmployee =:employeeID", Bill.class)
                .setParameter("employeeID", employeeID) // %text% for similarity
                .getResultList();
    }

    @Override
    public List<Bill> findBillByDate(LocalDate dateFrom, LocalDate dateTo) throws RemoteException {
        return em.createQuery("SELECT p from Bill p where p.billDate between :dateFrom and  :dateTo", Bill.class)
                .setParameter("dateFrom", dateFrom)
                .setParameter("dateTo", dateTo)// %text% for similarity
                .getResultList();
    }
}
