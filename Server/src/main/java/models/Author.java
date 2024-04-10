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

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.List;

@Table(name = "Author")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(generator = "A")
    private String authorId;
    private String authorName;
    private LocalDate date;
    private int numberOfWorks;
    @OneToMany(mappedBy = "authorId")
    @ToString.Exclude
    private List<Book> books;

    public Author(String authorName, LocalDate date, int numberOfWorks) {
        this.authorName = authorName;
        this.date = date;
        this.numberOfWorks = numberOfWorks;
    }
}
