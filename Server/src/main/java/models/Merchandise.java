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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Merchandise")
public class Merchandise extends Product{
    private int quantitySold;
    private double revenue;
    private double profit;

    @Override
    public double tax() {
        return 0;
    }

    @Override
    public double sellingPrice() {
        return super.importPrice + (super.importPrice * 0.55) + tax();
    }
}
