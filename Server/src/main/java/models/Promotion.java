package models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Promotion")
public class Promotion {
    @Id
    @Column(name = "promotionId", nullable = false)
    private String promotionId;
    @Column(name = "promotionName",nullable = false,columnDefinition = "NVARCHAR(255)")
    private String promotionName;
    @Column(name = "promotionDiscount",columnDefinition = "NVARCHAR(10)")
    private String promotionDiscount;
    private Date promotionStartDate;
    private Date promotionEndDate;
    @OneToMany(mappedBy = "promotion", cascade = CascadeType.ALL)
    private List<ProductSale> productSales;
    public Promotion(String promotionId) {
        this.promotionId = promotionId;
    }

    public Promotion(String promotionId,String promotionName,Date promotionStartDate,Date promotionEndDate, String promotionDiscount ) {
        this.promotionEndDate = promotionEndDate;
        this.promotionStartDate = promotionStartDate;
        this.promotionDiscount = promotionDiscount;
        this.promotionName = promotionName;
        this.promotionId = promotionId;
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "promotionId='" + promotionId + '\'' +
                ", promotionName='" + promotionName + '\'' +
                ", promotionDiscount='" + promotionDiscount + '\'' +
                '}';
    }
}