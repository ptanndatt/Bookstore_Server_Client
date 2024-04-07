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

@Table(name = "Supplier")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {
    @Id
    @GenericGenerator(
            name = "S",
            strategy = "util.CustomIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "prefix", value = "S")
            }
    )
    @GeneratedValue(generator = "S")
    private String supplierId;
    private String supplierName;
    private String address;
    private String phoneNumber;
    @OneToMany(mappedBy = "supplierId")
    @ToString.Exclude
    private List<Product> products;

    public Supplier(String address, String phoneNumber, String supplierName) {
        this.supplierName = supplierName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}
