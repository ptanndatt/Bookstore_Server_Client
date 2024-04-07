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

import java.util.List;

@Table(name = "ProductType")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductType {
    @Id
    @GenericGenerator(
            name = "P",
            strategy = "util.CustomIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "prefix", value = "P")
            }
    )
    @GeneratedValue(generator = "P")
    private String productTypeId;
    private String productTypeName;
    @OneToMany(mappedBy = "productTypeId")
    @ToString.Exclude
    private List<Product> products;

    public ProductType(String productTypeName) {
        this.productTypeName = productTypeName;
    }

}
