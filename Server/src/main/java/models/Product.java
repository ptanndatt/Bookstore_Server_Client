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
    @Column(name = "productId")
    protected String productId;
    @Column(name = "productName",columnDefinition = "NVARCHAR(255)")
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
    @OneToOne(mappedBy = "product")
    private ProductSale productSale;

    public Product(String productId) {
        this.productId = productId;
    }

    public abstract double tax();

    public abstract double sellingPrice();
}
