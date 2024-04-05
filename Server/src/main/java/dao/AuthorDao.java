/*
 * @ (#) .java   1.0    04/04/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package dao;/*
 * @description:
 * @author:     Hoang Le
 * @date:       04/04/2024
 * @version:    1.0
 */

import models.Author;

import java.util.List;

public interface AuthorDao {
    List<Author> getAllAuthor();

    boolean addAuthor(Author author);

    boolean updateAuthor(Author author);

    boolean deleteAuthor(String idAuthor);

    boolean checkIdAuthor(String idAuthor);

    List<Author> getLatestAuthorID();
}
