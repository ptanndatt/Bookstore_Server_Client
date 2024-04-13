package models;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="roleId")
	protected Role role;

	public Employee(String idEmployee) {
		this.idEmployee = idEmployee;
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
