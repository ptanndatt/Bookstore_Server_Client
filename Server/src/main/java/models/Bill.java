package models;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;


@Getter
@EqualsAndHashCode
@Setter
@NoArgsConstructor
@Entity
@Table(name="Bill")
@Inheritance(strategy = InheritanceType.JOINED)
public class Bill {
	@Id
    @Column(name = "billId", nullable = false)
	private String billId;
	@EqualsAndHashCode.Exclude
	private Date billDate;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId")
	private Customer customer;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employeeId")
	private Employee employee;
	@EqualsAndHashCode.Exclude
	private double amountReceived;
	@EqualsAndHashCode.Exclude
	private double amounttotal;
	@EqualsAndHashCode.Exclude
	private double profitTotal;
	@OneToMany(mappedBy = "bill", cascade = CascadeType.ALL)
	private Set<DetailsBill> detailsBills;

	public Bill(String billId, Date billDate, Customer customer, Employee employee, double amountReceived, double amounttotal, double profitTotal) {
		this.billId = billId;
		this.billDate = billDate;
		this.customer = customer;
		this.employee = employee;
		this.amountReceived = amountReceived;
		this.amounttotal = amounttotal;
		this.profitTotal = profitTotal;
	}

	public Bill(String billId) {
		super();
		this.billId = billId;
	}
	
	
	
	
}
