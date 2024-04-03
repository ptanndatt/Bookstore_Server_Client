package models;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@EqualsAndHashCode
@Setter
@NoArgsConstructor
@Entity
@Table(name = "HoaDon")
@AllArgsConstructor
public class HoaDon {
    @Id
    @Column(name = "idDonHang", nullable = false)
    private String idDonHang;
    @EqualsAndHashCode.Exclude
    private Date ngayLap;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idKhachHang")
    private KhachHang khachHang;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idNhanSu")
    private NhanSu nhanSu;
    @EqualsAndHashCode.Exclude
    private double tienKhachDua;
    @EqualsAndHashCode.Exclude
    private double tongTien;
    @EqualsAndHashCode.Exclude
    private double tongLoiNhuan;

    public HoaDon(Date ngayLap, KhachHang khachHang, NhanSu nhanSu, double tienKhachDua,
                  double tongTien, double tongLoiNhuan) {
        super();

        this.ngayLap = ngayLap;
        this.khachHang = khachHang;
        this.nhanSu = nhanSu;
        this.tienKhachDua = tienKhachDua;
        this.tongTien = tongTien;
        this.tongLoiNhuan = tongLoiNhuan;
    }

    public HoaDon(String idDonHang) {
        super();
        this.idDonHang = idDonHang;
    }

    public HoaDon() {
    }

    @Override
    public String toString() {
        return "HoaDon [idDonHang=" + idDonHang + ", ngayLap=" + ngayLap + ", khachHang=" + khachHang + ", nhanSu="
                + nhanSu + ", tienKhachDua=" + tienKhachDua + ", tongTien=" + tongTien + ", tongLoiNhuan="
                + tongLoiNhuan + "]";
    }


}
