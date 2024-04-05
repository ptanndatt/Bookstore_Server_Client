package models;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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
	private List<DetailsBill> invoiceDetails;


	public Bill(Date billDate, Customer customer, Employee employee, double amountReceived, double amounttotal,
			double profitTotal) {
		super();
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
