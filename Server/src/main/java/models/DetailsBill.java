package models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.ui.Model;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "DetailsBill")
public class DetailsBill {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="billId")
    private Bill bill;
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="productId")
    private Product product;

    private int quantity;
    private double price;
    private double total;


}