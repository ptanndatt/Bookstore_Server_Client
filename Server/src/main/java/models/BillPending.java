package models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name="BillPending")
public class BillPending {
    @Id
    @Column(name = "billPendingId", nullable = false,unique = true)
    private String billPendingId;
    private String billID;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="customerId")
    private Customer customer;
    @Column(name = "ngayLap")
    private Date ngayLap;
    @OneToMany(mappedBy = "billPending", cascade = CascadeType.ALL)
    private List<DetailsBillPending> detailsBillPendings;

    public BillPending(String billPendingId, String billID, Customer customer, Date ngayLap) {
        this.billPendingId = billPendingId;
        this.billID = billID;
        this.customer = customer;
        this.ngayLap = ngayLap;
    }
}
