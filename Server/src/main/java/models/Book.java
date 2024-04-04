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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "Book")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Book extends Product {
    @ManyToOne
    @JoinColumn(name = "authorId")
    private Author authorId;
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category categoryId;
    private LocalDate publicationYear;
    private String ISBN;
    private int numberOfPages;
    private int quantitySold;
    private double revenue;
    private double profit;

    @Override
    public double tax() {
        return super.importPrice * 0.05;
    }

    @Override
    public double sellingPrice() {
        return super.importPrice + (super.importPrice * 0.55) + tax();
    }
}


