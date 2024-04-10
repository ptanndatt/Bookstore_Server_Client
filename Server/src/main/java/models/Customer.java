package models;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import util.GenderEnum;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name="Customer")
@NamedQueries({
		@NamedQuery(name = "Customer.findByText",query = "SELECT c FROM Customer c WHERE c.name LIKE :text OR c.phone LIKE :text "
				                  + "OR c.email LIKE :text OR c.address LIKE :text OR c.idCustomer LIKE :text")
})
public class Customer {
	@Id
    @Column(name = "customerId", nullable = false,columnDefinition = "NVARCHAR(255)",unique = true)
	private String idCustomer;
	@Column(name = "customerName",columnDefinition = "NVARCHAR(255)")
	private String name;
	@Column(name="phone")
	private String phone;
	private String email;
	@Column(name = "address",columnDefinition = "NVARCHAR(255)")
	private String address;
	@Column(name = "gender",columnDefinition = "NVARCHAR(5)")
	private String gender;
	private Date birth;
	public Customer(String name, String phone, String email, String address, String gender, Date birth) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.gender = gender;
		this.birth = birth;
	}



	@Override
	public String toString() {
		return "Customer [idCustomer=" + idCustomer + ", name=" + name + ", phone=" + phone + ", email=" + email
				+ ", address=" + address + ", gender=" + gender + ", birth=" + birth + "]";
	}
	public Customer(String idCustomer) {
		super();
		this.idCustomer = idCustomer;
	}
	

	

	
	
}