package dao.impl;

import dao.PromotionDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import models.Customer;
import models.Employee;
import models.Promotion;
import models.Role;
import util.HibernateUtil;

import java.util.List;

public class PromotionDaoImpl implements PromotionDao {
    private EntityManager em;
    public PromotionDaoImpl() {
        em = HibernateUtil.getInstance().getEntityManager();
    }
    @Override
    public boolean addPromotion(Promotion promotion) {
        EntityTransaction entityTransaction=em.getTransaction();
        try {
            entityTransaction.begin();
            em.persist(promotion);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updatePromotion(Promotion promotion) {
        EntityTransaction entityTransaction =  em.getTransaction();;
        try {
            entityTransaction.begin();
            em.merge(promotion);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deletePromotion(String id) {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            Promotion promotion=em.find(Promotion.class, id);
            em.remove(promotion);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Promotion> getAllPromotion() {
        List<Promotion> promotions = null;
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            String hql = "FROM Promotion ";
            TypedQuery<Promotion> query = em.createQuery(hql, Promotion.class);
            promotions = query.getResultList();
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
        }
        return promotions;
    }

    @Override
    public List<Promotion> findPromotionByText(String text) {
        return em.createQuery("SELECT p from Promotion p where p.promotionName LIKE:text OR p.id LIKE :text", Promotion.class)
                .setParameter("text", "%" + text + "%") // %text% for similarity
                .getResultList();
    }

}
