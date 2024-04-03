/*
 * @ (#) .java   1.0    03/04/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package models;/*
 * @description:
 * @author:     Hoang Le
 * @date:       03/04/2024
 * @version:    1.0
 */

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Table(name = "Author")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    @Id
    private String authorId;
    private String authorName;
    private LocalDate date;
    private int numberOfWorks;
    @OneToMany(mappedBy = "authorId")
    private List<Book> books;
}
