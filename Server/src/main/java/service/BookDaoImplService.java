package service;

import dao.impl.BookDaoImpl;
import models.Book;

import java.util.List;

public class BookDaoImplService {
    private BookDaoImpl bookDaoImpl = new BookDaoImpl();

    public List<Book> getAllBook() {
        return bookDaoImpl.getAllBook();
    }

    public boolean addBook(Book book) {
        return bookDaoImpl.addBook(book);
    }

    public boolean updateBook(Book book) {
        return bookDaoImpl.updateBook(book);
    }

    public boolean deleteBook(String idBook) {
        return bookDaoImpl.deleteBook(idBook);
    }

    public boolean checkIdBook(String idBook) {
        return bookDaoImpl.checkIdBook(idBook);
    }

    public List<String> getLatestBookID() {
        return bookDaoImpl.getLatestBookID();
    }

    public List<Book> loadComboBoxByProductType(String productTypeId) {
        return bookDaoImpl.loadComboBoxByProductType(productTypeId);
    }

    public List<Book> loadComboBoxByPublisher(String publisherId) {
        return bookDaoImpl.loadComboBoxByPublisher(publisherId);
    }

    public List<Book> loadComboBoxByAuthor(String authorId) {
        return bookDaoImpl.loadComboBoxByAuthor(authorId);
    }

    public List<Book> loadComboBoxByCategory(String categoryId) {
        return bookDaoImpl.loadComboBoxByCategory(categoryId);
    }

    public List<Book> searchBook(String search) {
        return bookDaoImpl.searchBook(search);
    }

    public List<Book> findCategoryIdByName(String name) {
        return bookDaoImpl.findCategoryIdByName(name);
    }

    public List<Book> findSupplierByName(String name) {
        return bookDaoImpl.findSupplierByName(name);
    }

    public List<Book> findBookByProductType(String name) {
        return bookDaoImpl.findBookByProductType(name);
    }

    public List<Book> findBookByAuthor(String name) {
        return bookDaoImpl.findBookByAuthor(name);
    }
}
