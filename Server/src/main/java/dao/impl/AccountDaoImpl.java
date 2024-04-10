package dao.impl;

import dao.AccountDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import models.Account;
import models.Customer;
import util.HibernateUtil;

public class AccountDaoImpl implements AccountDao {
    private EntityManager em;
    public AccountDaoImpl() {
        em = HibernateUtil.getInstance().getEntityManager();
    }
    @Override
    public boolean addAccount(Account account) {
        EntityTransaction entityTransaction=em.getTransaction();
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
            Account account=em.find(Account.class, acountDelete);
            em.remove(account);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
            return false;
        }
    }
}
