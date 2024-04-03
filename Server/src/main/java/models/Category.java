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
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Table(name = "Category")
@Entity
@Data
//@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(generator = "C")
    @GenericGenerator(name = "C", strategy = "util.CustomIdGenerator", parameters = {
            @org.hibernate.annotations.Parameter(name = "prefix", value = "C")
    })
    private String idCategory;
    private String categoryName;
    private int bookQuantity;
    private String description;
    @OneToMany(mappedBy = "categoryId")
    private List<Book> books;

    public Category() {
    }

    public Category(String categoryName, int bookQuantity, String description) {
        this.categoryName = categoryName;
        this.bookQuantity = bookQuantity;
        this.description = description;
    }
}
