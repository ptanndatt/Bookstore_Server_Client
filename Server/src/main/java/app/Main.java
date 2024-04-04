/*
 * @ (#) .java   1.0    03/04/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package app;/*
 * @description:
 * @author:     Hoang Le
 * @date:       03/04/2024
 * @version:    1.0
 */

import jakarta.persistence.EntityManager;
import models.*;
import util.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        EntityManager em = null;
        try {
            HibernateUtil hibernateUtil = HibernateUtil.getInstance();
            em = hibernateUtil.getEntityManager();
            em.getTransaction().begin();
            Author author = new Author();
            Category category = new Category();
//            IdGenerator idGenerator = new IdGenerator();
//            idGenerator.generateId(category, "C");
            ProductType productType = new ProductType();
            Merchandise merchandise = new Merchandise();
            Supplier supplier = new Supplier();
            Book book = new Book();
            HoaDon hoaDon = new HoaDon();
            KhachHang khachHang = new KhachHang();
            NhanSu nhanSu = new NhanSu();
            em.persist(author);
            em.persist(category);
            em.persist(productType);
            em.persist(merchandise);
            em.persist(supplier);
            em.persist(book);
            em.persist(hoaDon);
            em.persist(khachHang);
            em.persist(nhanSu);
            em.getTransaction().commit();
        } catch (
                Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
