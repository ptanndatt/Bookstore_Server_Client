package dao.impl;

import dao.ProductDao;
import jakarta.persistence.EntityManager;
import models.Employee;
import models.Product;
import util.HibernateUtil;

import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private EntityManager em;
    public ProductDaoImpl() {
        em = HibernateUtil.getInstance().getEntityManager();
    }

    @Override
    public Product getProductById(String id) {
        return em.find(Product.class, id);
    }

    @Override
    public List<Product> getProductByText(String text) {
        return em.createQuery("SELECT p FROM Product p WHERE p.productId LIKE :text OR p.productName LIKE :text ", Product.class)
                .setParameter("text", "%" + text + "%") // %text% for similarity
                .getResultList();
    }
}
