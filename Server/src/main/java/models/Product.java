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
import util.ProductStatusEnum;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Product")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Product {
    @Id
    @GeneratedValue(generator = "P")
    @GenericGenerator(name = "P", strategy = "util.CustomIdGenerator", parameters = {
            @org.hibernate.annotations.Parameter(name = "prefix", value = "P")
    })
    protected String productId;
    protected String productName;
    @ManyToOne
    @JoinColumn(name = "productTypeId")
    protected ProductType productTypeId;
    @ManyToOne
    @JoinColumn(name = "supplierId")
    protected Supplier supplierId;
    protected double size;
    protected String color;
    protected ProductStatusEnum status;
    protected int quantity;
    protected double importPrice;
    protected double discountPrice;

    public abstract double tax();

    public abstract double sellingPrice();
}
