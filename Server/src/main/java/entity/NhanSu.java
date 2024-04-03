package entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="NhanSu")
public class NhanSu {
		@Id
	    @Column(name = "idNhanSu", nullable = false)
		private String id;
		private String ten;
		private String soDienThoai;
		private String diaChi;
		private String email;
		private Date ngaySinh;
		private boolean gioiTinh;
		private boolean trangThai;
		
		
		
		
		
		
		
		
		
}

