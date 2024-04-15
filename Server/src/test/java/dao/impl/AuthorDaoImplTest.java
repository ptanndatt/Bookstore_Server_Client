/*
 * @ (#) .java   1.0    04/04/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package dao.impl;/*
 * @description:
 * @author:     Hoang Le
 * @date:       04/04/2024
 * @version:    1.0
 */

import models.Author;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import util.log.Log;

import java.time.LocalDate;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AuthorDaoImplTest {
    private AuthorDaoImpl authorDaoImpl;

    @BeforeAll
    void setUp() {
        authorDaoImpl = new AuthorDaoImpl();
    }

//    @Test
//    void testAddAuthor() {
//        Author author = new Author("Hoangle", LocalDate.now(), 6);
//        boolean resulft = authorDaoImpl.addAuthor(author);
//        if (resulft) {
//            Log.info("Add author successfully");
//        } else {
//            Log.error("Add author failed");
//        }
//    }

    @Test
    void testGetAllAuthor() {
        authorDaoImpl.getAllAuthor().forEach(author -> Log.info(author.toString()));
    }

//    @Test
//    void testUpdateAuthor() {
//        Author author = new Author("AnhHong", LocalDate.now(), 6);
//        author.setAuthorId("null20240404152912");
//        boolean resulft = authorDaoImpl.updateAuthor(author);
//        if (resulft) {
//            Log.info("Update author successfully");
//        } else {
//            Log.error("Update author failed");
//        }
//    }

    @Test
    void testDeleteAuthor() {
        boolean resulft = authorDaoImpl.deleteAuthor("null20240404152912");
        if (resulft) {
            Log.info("Delete author successfully");
        } else {
            Log.error("Delete author failed");
        }
    }

    @Test
    void testCheckIdAuthor() {
        boolean resulft = authorDaoImpl.checkIdAuthor("null20240404153916");
        if (resulft) {
            Log.info("Author is exist");
        } else {
            Log.error("Author is not exist");
        }
    }

    @Test
    void testGetLatestAuthorID() {
        authorDaoImpl.getLatestAuthorID().forEach(author -> Log.info(author.toString()));
    }
    @AfterAll
    void tearDown() {
        authorDaoImpl = null;
    }
}
