package dao.impl;

import dao.MerchandiseDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import models.Book;
import models.Merchandise;
import models.ProductType;
import models.Supplier;
import util.HibernateUtil;
import util.ProductStatusEnum;

import java.util.ArrayList;
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
        } catch (Exception e) {
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
        } catch (Exception e) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkIdExist(String id) {
        try {
            Merchandise merchandise = em.find(Merchandise.class, id);
            if (merchandise != null) return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //    @Override
//    public List<Merchandise> getAllMerchandise() {
//        try {
//            String hql = "SELECT m, p.productTypeName, s.supplierName  " +
//                    "FROM Merchandise m " +
//                    "JOIN m.productTypeId p " +
//                    "JOIN m.supplierId s";
//
//            List<Object[]> resultList = em.createQuery(hql).getResultList();
//            List<Merchandise> merchandiseList = new ArrayList<>();
//
//            for (Object[] result : resultList) {
//                Merchandise merchandise = (Merchandise) result[0];
//                String productTypeName = (String) result[1];
//                String supplierName = (String) result[2];
//                merchandise.getProductTypeId().setProductTypeName(productTypeName);
//                merchandise.getSupplierId().setSupplierName(supplierName);
//                merchandiseList.add(merchandise);
//            }
//            return merchandiseList;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
    @Override
    public List<Merchandise> getAllMerchandise() {
        try {
            String hql = "SELECT m, p.productTypeName AS productTypeName, s.supplierName AS supplierName " +
                    "FROM Merchandise m " +
                    "JOIN FETCH m.productTypeId p " +
                    "JOIN FETCH m.supplierId s";

            TypedQuery<Object[]> query = em.createQuery(hql, Object[].class);
            List<Object[]> resultList = query.getResultList();
            List<Merchandise> merchandiseList = new ArrayList<>();

            for (Object[] result : resultList) {
                Merchandise merchandise = (Merchandise) result[0];
                String productTypeName = (String) result[1];
                String supplierName = (String) result[2];
                merchandise.getProductTypeId().setProductTypeName(productTypeName);
                merchandise.getSupplierId().setSupplierName(supplierName);
                merchandiseList.add(merchandise);
            }
            return merchandiseList;
        } catch (Exception e) {
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
        } catch (Exception e) {
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
