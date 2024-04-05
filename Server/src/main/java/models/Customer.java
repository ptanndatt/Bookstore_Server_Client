package models;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import util.GenderEnum;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name="Customer")
public class Customer {
	@Id
    @Column(name = "customerId", nullable = false)

	@GenericGenerator(

            name = "KH", strategy = "util.CustomIdGenerator", parameters = {
			@org.hibernate.annotations.Parameter(name = "prefix", value = "KH")
    })
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "KH")
	private String idCustomer;
	@Column(name = "customerName")
	private String name;
	private String phone;
	private String email;
	private String address;
	private String gender;
	private LocalDate birth;
	public Customer(String name, String phone, String email, String address, String gender, LocalDate birth) {
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