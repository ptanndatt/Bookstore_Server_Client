package dao.impl;

import dao.CustomerDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import models.Author;
import models.Customer;
import util.HibernateUtil;

public class CustomerDaoImpl implements CustomerDao {
    private EntityManager em;
    public CustomerDaoImpl() {
        em = HibernateUtil.getInstance().getEntityManager();
    }
    @Override
    public boolean addCustomer(Customer customer) {
        EntityTransaction entityTransaction=em.getTransaction();
        try {
            entityTransaction.begin();
            em.persist(customer);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        EntityTransaction entityTransaction =  em.getTransaction();;
        try {

            entityTransaction.begin();
            em.merge(customer);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCustomer(String customerID) {
        {
            EntityTransaction tr = em.getTransaction();
            try {
                tr.begin();
                Customer customer=em.find(Customer.class, customerID);
                em.remove(customer);
                tr.commit();
                return true;
            } catch (Exception e) {
                tr.rollback();
                e.printStackTrace();
                return false;
            }
        }

    }
}
