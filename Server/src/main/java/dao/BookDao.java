package dao;

import models.Book;

import java.util.List;

public interface BookDao {
    List<Book> getAllBook();

    boolean addBook(Book book);

    boolean updateBook(Book book);

    boolean deleteBook(String idBook);

    boolean checkIdBook(String idBook);

    List<String> getLatestBookID();

    List<Book> loadComboBoxByProductType(String productTypeId);

    List<Book> loadComboBoxByPublisher(String publisherId);

    List<Book> loadComboBoxByAuthor(String authorId);

    List<Book> loadComboBoxByCategory(String categoryId);

    List<Book> searchBook(String search);


    List<Book> findCategoryIdByName(String name);

    List<Book> findSupplierByName(String name);

    List<Book> findBookByProductType(String name);

    List<Book> findBookByAuthor(String name);
}