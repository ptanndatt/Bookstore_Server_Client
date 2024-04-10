package models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Employee")
public class Employee {
	@Id
	@Column(name = "employeeId", nullable = false)
	protected String idEmployee;
	protected String name;
	protected String phone;
	protected String address;
	protected String email;
	protected Date birth;
	protected boolean gender;
	protected boolean status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roleId")
	protected Role role;

	public Employee(String name, String phone, String address, String email, Date birth, boolean gender, boolean status,
			Role role) {
		super();
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.birth = birth;
		this.gender = gender;
		this.status = status;
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employee [idEmployee=" + idEmployee + ", name=" + name + ", phone=" + phone + ", address=" + address
				+ ", email=" + email + ", birth=" + birth + ", gender=" + gender + ", status=" + status + ", role="
				+ role + "]";
	}

}
