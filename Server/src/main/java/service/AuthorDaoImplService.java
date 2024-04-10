package service;

import dao.impl.AuthorDaoImpl;
import models.Author;

import java.util.List;

public class AuthorDaoImplService {
    private AuthorDaoImpl authorDaoImpl = new AuthorDaoImpl();

    public List<Author> getAllAuthor() {
        return authorDaoImpl.getAllAuthor();
    }

    public boolean addAuthor(Author author) {
        return authorDaoImpl.addAuthor(author);
    }

    public boolean updateAuthor(Author author) {
        return authorDaoImpl.updateAuthor(author);
    }

    public boolean deleteAuthor(String idAuthor) {
        return authorDaoImpl.deleteAuthor(idAuthor);
    }

    public boolean checkIdAuthor(String idAuthor) {
        return authorDaoImpl.checkIdAuthor(idAuthor);
    }

    public List<Author> getLatestAuthorID() {
        return authorDaoImpl.getLatestAuthorID();
    }

    public boolean decreaseNumberOfBooks(String idAuthor) {
        return authorDaoImpl.decreaseNumberOfBooks(idAuthor);
    }

    public boolean increaseNumberOfBooks(String idAuthor) {
        return authorDaoImpl.increaseNumberOfBooks(idAuthor);
    }
}
