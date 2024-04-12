package dao.impl;

import dao.AccountDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import models.Account;
import models.Customer;
import util.HibernateUtil;

import java.util.List;

public class AccountDaoImpl implements AccountDao {
    private EntityManager em;

    public AccountDaoImpl() {
        em = HibernateUtil.getInstance().getEntityManager();
    }

    @Override
    public boolean addAccount(Account account) {
        EntityTransaction entityTransaction = em.getTransaction();
        try {
            entityTransaction.begin();
            em.persist(account);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteAccount(String acountDelete) {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            Account account = em.find(Account.class, acountDelete);
            em.remove(account);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateAccount(Account account) {
        EntityTransaction entityTransaction = em.getTransaction();
        ;
        try {
            entityTransaction.begin();
            em.merge(account);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Account> getAccounts() {
        List<Account> accounts = null;
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            String hql = "FROM Account ";
            TypedQuery<Account> query = em.createQuery(hql, Account.class);
            accounts = query.getResultList();
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
        }
        return accounts;
    }

    @Override
    public Account getAccountById(String id) {
        Account account = null;
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            String hql = "SELECT a " +
                    "FROM Account a " +
                    "JOIN FETCH a.employee e " +
                    "JOIN FETCH e.role r " +
                    "WHERE a.employee.idEmployee = :id";
            TypedQuery<Account> query = em.createQuery(hql, Account.class);
            query.setParameter("id", id);
            account = query.getSingleResult();
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public String findPasswordByEmployeeId(String employeeId) {
        String password = null;
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            String hql = "SELECT a.password " +
                    "FROM Account a " +
                    "WHERE a.employee.idEmployee = :id";
            TypedQuery<String> query = em.createQuery(hql, String.class);
            query.setParameter("id", employeeId);
            password = query.getSingleResult();
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
        }
        return password;
    }


}
