package models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "Promotion")
public class Promotion {
    @Id
    @Column(name = "promotionId", nullable = false)
    private String promotionId;
    private String promotionName;
    private String promotionDiscount;

    public Promotion(String promotionId) {
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