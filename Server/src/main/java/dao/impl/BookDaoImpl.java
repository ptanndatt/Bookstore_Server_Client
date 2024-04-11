package dao.impl;

import dao.BookDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import models.Book;
import util.HibernateUtil;

import java.util.List;

public class BookDaoImpl implements BookDao {
    private EntityManager em;

    public BookDaoImpl() {
        em = HibernateUtil.getInstance().getEntityManager();
    }

    @Override
    public List<Book> getAllBook() {
        EntityTransaction tr = null;
        try {
            tr = em.getTransaction();
            tr.begin();
            List<Book> books = em.createQuery("FROM Book", Book.class).getResultList();
            tr.commit();
            return books;
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean addBook(Book book) {
        EntityTransaction tr = null;
        try {
            tr = em.getTransaction();
            if (!tr.isActive()) {
                tr.begin();
            }
            if (!em.contains(book)) {
                book = em.merge(book);
            }
            em.persist(book);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateBook(Book book) {
        EntityTransaction tr = null;
        try {
            tr = em.getTransaction();
            tr.begin();
            em.merge(book);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteBook(String idBook) {
        EntityTransaction tr = null;
        try {
            tr = em.getTransaction();
            tr.begin();
            Book book = em.find(Book.class, idBook);
            em.remove(book);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean checkIdBook(String idBook) {
        try {
            Book book = em.find(Book.class, idBook);
            if (book == null) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<String> getLatestBookID() {
        return null;
    }

    @Override
    public List<Book> loadComboBoxByProductType(String productTypeId) {
        return null;
    }

    @Override
    public List<Book> loadComboBoxByPublisher(String publisherId) {
        return null;
    }

    @Override
    public List<Book> loadComboBoxByAuthor(String authorId) {
        return null;
    }

    @Override
    public List<Book> loadComboBoxByCategory(String categoryId) {
        return null;
    }

    @Override
    public List<Book> searchBook(String search) {
        return null;
    }


    @Override
    public List<Book> findCategoryIdByName(String categoryName) {
        try {
            if (!em.isOpen()) {
                throw new IllegalStateException("EntityManager is closed");
            }
            List<Book> books = em.createQuery("SELECT b FROM Book b WHERE b.categoryId.categoryName = :categoryName", Book.class)
                    .setParameter("categoryName", categoryName)
                    .getResultList();
            return books;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> findSupplierByName(String name) {
        try {
            if (!em.isOpen()) {
                throw new IllegalStateException("EntityManager is closed");
            }
            String hql = "SELECT b FROM Book b WHERE b.supplierId.supplierName = :name";
            List<Book> books = em.createQuery(hql, Book.class)
                    .setParameter("name", name)
                    .getResultList();
            return books;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> findBookByProductType(String name) {
        try {
            if (!em.isOpen()) {
                throw new IllegalStateException("EntityManager is closed");
            }
            String hql = "SELECT b FROM Book b WHERE b.productTypeId.productTypeName = :name";
            List<Book> books = em.createQuery(hql, Book.class)
                    .setParameter("name", name)
                    .getResultList();
            return books;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> findBookByAuthor(String name) {
        try {
            if (!em.isOpen()) {
                throw new IllegalStateException("EntityManager is closed");
            }
            String hql = "SELECT b FROM Book b WHERE b.authorId.authorName = :name";
            List<Book> books = em.createQuery(hql, Book.class)
                    .setParameter("name", name)
                    .getResultList();
            return books;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
