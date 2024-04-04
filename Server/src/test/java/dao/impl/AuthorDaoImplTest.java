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

    @Test
    void testAddAuthor() {
        Author author = new Author("Hoangle", LocalDate.now(), 6);
        boolean resulft = authorDaoImpl.addAuthor(author);
        if (resulft) {
            Log.info("Add author successfully");
        } else {
            Log.error("Add author failed");
        }
    }

    @Test
    void testGetAllAuthor() {
        authorDaoImpl.getAllAuthor().forEach(author -> Log.info(author.toString()));
    }

    @AfterAll
    void tearDown() {
        authorDaoImpl = null;
    }
}
