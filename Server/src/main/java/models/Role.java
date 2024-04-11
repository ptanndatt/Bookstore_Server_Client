package models;

import java.util.HashSet;

import org.hibernate.mapping.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="Role")
public class Role {
	@Id
    @Column(name = "roleId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRole;
	@Column(name = "roleName",unique=true,columnDefinition = "NVARCHAR(255)")
	private String roleName;

	public Role(String roleName) {
		this.roleName = roleName;
	}

	public Role(int idRole) {
		this.idRole = idRole;
	}
}
