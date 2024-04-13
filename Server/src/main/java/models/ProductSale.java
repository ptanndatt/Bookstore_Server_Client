package models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "ProductSale")
public class ProductSale {
    @Id
    @OneToOne
    @JoinColumn(name = "productId")
    private Product product;
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="promotionId")
    private Promotion promotion;
    private String description;
    private double giaBan;

}
