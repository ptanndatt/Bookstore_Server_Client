package dao.impl;

import dao.MerchandiseDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import models.Book;
import models.Merchandise;
import util.HibernateUtil;

import java.util.List;

public class MerchandiseDaoImpl implements MerchandiseDao {
    private EntityManager em;
    public MerchandiseDaoImpl() {
        em = HibernateUtil.getInstance().getEntityManager();
    }
    @Override
    public boolean addMerchandise(Merchandise merchandise) {
        EntityTransaction tr = null;
        try {
            tr = em.getTransaction();
            if (!tr.isActive()) tr.begin();
            if (em.contains(merchandise)) em.merge(merchandise);
            else em.persist(merchandise);
            tr.commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateMerchandise(Merchandise merchandise) {
        EntityTransaction tr = null;
        try {
            tr = em.getTransaction();
            if (!tr.isActive()) tr.begin();
            em.merge(merchandise);
            tr.commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteMerchandise(String id) {
        EntityTransaction tr = null;
        try {
            tr = em.getTransaction();
            if (!tr.isActive()) tr.begin();
            Merchandise merchandise = em.find(Merchandise.class, id);
            if (merchandise != null) {
                em.remove(merchandise);
                tr.commit();
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkIdExist(String id) {
        try {
            Merchandise merchandise = em.find(Merchandise.class, id);
            if (merchandise != null) return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Merchandise> getAllMerchandise() {
        try {
            String hql = "FROM Merchandise";
            List<Merchandise> list = em.createQuery(hql).getResultList();
            return list;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Merchandise> findSupplierByNameMerchandise(String name) {
        try {
            if (!em.isOpen()) {
                throw new IllegalStateException("EntityManager is closed");
            }
            String hql = "SELECT m FROM Merchandise m WHERE m.supplierId.supplierName = :name";
            List<Merchandise> merchandiseList = em.createQuery(hql, Merchandise.class)
                    .setParameter("name", name)
                    .getResultList();
            return merchandiseList;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Merchandise> findProductTypeMerchandise(String name) {
        try {
            if (!em.isOpen()) {
                throw new IllegalStateException("EntityManager is closed");
            }
            String hql = "SELECT m FROM Merchandise m WHERE m.productTypeId.productTypeName = :name";
            List<Merchandise> merchandiseList = em.createQuery(hql, Merchandise.class)
                    .setParameter("name", name)
                    .getResultList();
            return merchandiseList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
