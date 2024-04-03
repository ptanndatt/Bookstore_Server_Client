package entity;

import java.sql.Date;
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

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name="KhachHang")
public class KhachHang {
	@Id
    @Column(name = "idKhachHang", nullable = false)
	private String idKhachHang;
	private String tenKhachHang;
	private String sdt;
	private String email;
	private String diaChi;
	private boolean gioiTinh;
	private Date ngaySinh;
	public KhachHang(String tenKhachHang, String sdt, String email, String diaChi, boolean gioiTinh,
			Date ngaySinh) {
		super();
		
		this.tenKhachHang = tenKhachHang;
		this.sdt = sdt;
		this.email = email;
		this.diaChi = diaChi;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
	}
	public KhachHang(String idKhachHang) {
		super();
		this.idKhachHang = idKhachHang;
	}
	@Override
	public String toString() {
		return "KhachHang [idKhachHang=" + idKhachHang + ", tenKhachHang=" + tenKhachHang + ", sdt=" + sdt + ", email="
				+ email + ", diaChi=" + diaChi + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + "]";
	}

	

	
	
}