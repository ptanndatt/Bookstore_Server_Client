package models;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="Account")
public class Account {

	@Id
	@OneToOne
	@JoinColumn(name = "employeeId")
	private Employee employee;

	private String password;
	private Date starDate;
	@Override
	public String toString() {
		return "Account [password=" + password + ", starDate=" + starDate + "]";
	}
	
	
	
	
	
	
	
}
