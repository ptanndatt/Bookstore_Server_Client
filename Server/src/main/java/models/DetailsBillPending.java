package models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DetailsBillPending")
public class DetailsBillPending {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="billPendingId")
    private BillPending billPending;
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="productId")
    private Product product;
    private String billId;
    private int quantity;
    private double price;
    private double total;

    @Override
    public String toString() {
        return "DetailsBillPending{" +
                "product=" + product +
                ", billId='" + billId + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", total=" + total +
                '}';
    }
}
