package models;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

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
	@Column(name = "employeeName",columnDefinition = "NVARCHAR(255)")
	protected String name;
	protected String phone;
	@Column(name = "address",columnDefinition = "NVARCHAR(255)")
	protected String address;
	protected String email;
	protected Date birth;

	@Column(name = "gender",columnDefinition = "NVARCHAR(5)")
	protected String gender;
	@Column(name = "status",columnDefinition = "NVARCHAR(20)")
	protected String status;


	public Employee(String name, String phone, String address, String email, Date birth, String gender, String status) {
		this.idEmployee = idEmployee;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.birth = birth;
		this.gender = gender;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"idEmployee='" + idEmployee + '\'' +
				", name='" + name + '\'' +
				", phone='" + phone + '\'' +
				", address='" + address + '\'' +
				", email='" + email + '\'' +
				", birth=" + birth +
				", gender='" + gender + '\'' +
				", status=" + status +
				'}';
	}
}
