USE [QLHieuSach]
GO
/****** Object:  Table [dbo].[ApDungKhuyenMai]    Script Date: 12/14/2023 12:09:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ApDungKhuyenMai](
	[idSP] [nvarchar](14) NOT NULL,
	[idKM] [nvarchar](14) NULL,
	[tenSP] [nvarchar](30) NULL,
	[giaBan] [float] NULL,
	[giaKM] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[idSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ApDungKhuyenMaiSach]    Script Date: 12/14/2023 12:09:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ApDungKhuyenMaiSach](
	[idS] [nvarchar](13) NOT NULL,
	[idKM] [nvarchar](14) NULL,
	[tenSP] [nvarchar](30) NULL,
	[giaBan] [float] NULL,
	[giaKM] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[idS] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietHoaDonChoSach]    Script Date: 12/14/2023 12:09:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDonChoSach](
	[idDonHangCho] [nvarchar](15) NOT NULL,
	[idDonHang] [nvarchar](14) NOT NULL,
	[tenSanPham] [nvarchar](50) NOT NULL,
	[idSanPham] [nvarchar](13) NOT NULL,
	[giaBan] [float] NULL,
	[khuyenMai] [float] NULL,
	[soLuong] [int] NULL,
	[giaCuoi] [float] NULL,
	[thanhTien] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[idDonHangCho] ASC,
	[idSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietHoaDonChoSanPham]    Script Date: 12/14/2023 12:09:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDonChoSanPham](
	[idDonHangCho] [nvarchar](15) NOT NULL,
	[idDonHang] [nvarchar](14) NOT NULL,
	[tenSanPham] [nvarchar](50) NOT NULL,
	[idSanPham] [nvarchar](14) NOT NULL,
	[giaBan] [float] NULL,
	[khuyenMai] [float] NULL,
	[soLuong] [int] NULL,
	[giaCuoi] [float] NULL,
	[thanhTien] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[idDonHangCho] ASC,
	[idSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietHoaDonSach]    Script Date: 12/14/2023 12:09:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDonSach](
	[soLuong] [int] NULL,
	[idDonHang] [nvarchar](14) NOT NULL,
	[idSanPham] [nvarchar](13) NOT NULL,
	[thanhTien] [float] NULL,
	[loiNhuan] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[idDonHang] ASC,
	[idSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietHoaDonSanPham]    Script Date: 12/14/2023 12:09:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDonSanPham](
	[soLuong] [int] NULL,
	[idDonHang] [nvarchar](14) NOT NULL,
	[idSanPham] [nvarchar](14) NOT NULL,
	[thanhTien] [float] NULL,
	[loiNhuan] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[idDonHang] ASC,
	[idSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 12/14/2023 12:09:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[idDonHang] [nvarchar](14) NOT NULL,
	[ngayLap] [date] NOT NULL,
	[nhanVien] [nvarchar](14) NOT NULL,
	[khachHang] [nvarchar](14) NOT NULL,
	[tienKhachDua] [float] NULL,
	[tongTien] [float] NULL,
	[tongLoiNhuan] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[idDonHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDonCho]    Script Date: 12/14/2023 12:09:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonCho](
	[idDonHangCho] [nvarchar](15) NOT NULL,
	[idDonHang] [nvarchar](14) NOT NULL,
	[idKhachHang] [nvarchar](14) NOT NULL,
	[tenKhachHang] [nvarchar](30) NOT NULL,
	[soDienThoai] [nvarchar](14) NOT NULL,
	[ngayLap] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idDonHangCho] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 12/14/2023 12:09:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[idKhachHang] [nvarchar](14) NOT NULL,
	[tenKhachHang] [nvarchar](50) NOT NULL,
	[soDienThoai] [nvarchar](10) NULL,
	[email] [nvarchar](50) NULL,
	[diaChi] [nvarchar](50) NULL,
	[ngaySinh] [date] NULL,
	[gioiTinh] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[idKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhuyenMai]    Script Date: 12/14/2023 12:09:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhuyenMai](
	[idKM] [nvarchar](14) NOT NULL,
	[tenKM] [nvarchar](20) NOT NULL,
	[ngayBatDau] [date] NULL,
	[trangThai] [bit] NULL,
	[loaiKM] [nvarchar](8) NULL,
PRIMARY KEY CLUSTERED 
(
	[idKM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiSanPham]    Script Date: 12/14/2023 12:09:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiSanPham](
	[idLoaiSanPham] [nvarchar](15) NOT NULL,
	[tenLoaiSanPham] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idLoaiSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 12/14/2023 12:09:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaCungCap](
	[idNhaCungCap] [nvarchar](15) NOT NULL,
	[tenNhaCungCap] [nvarchar](50) NOT NULL,
	[diaChi] [nvarchar](100) NULL,
	[soDienThoai] [nvarchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[idNhaCungCap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 12/14/2023 12:09:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[idNhanVien] [nvarchar](14) NOT NULL,
	[tenNhanVien] [nvarchar](50) NOT NULL,
	[soDienThoai] [nvarchar](10) NULL,
	[diaChi] [nvarchar](50) NULL,
	[email] [nvarchar](50) NULL,
	[ngaySinh] [date] NULL,
	[gioiTinh] [bit] NULL,
	[chucVu] [nvarchar](50) NULL,
	[trangThai] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[idNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[QuanLy]    Script Date: 12/14/2023 12:09:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[QuanLy](
	[idQuanLy] [nvarchar](14) NOT NULL,
	[tenNhanVien] [nvarchar](50) NOT NULL,
	[soDienThoai] [nvarchar](10) NULL,
	[diaChi] [nvarchar](50) NULL,
	[email] [nvarchar](50) NULL,
	[ngaySinh] [date] NULL,
	[gioiTinh] [bit] NULL,
	[chucVu] [nvarchar](50) NULL,
	[trangThai] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[idQuanLy] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Sach]    Script Date: 12/14/2023 12:09:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Sach](
	[idSanPham] [nvarchar](13) NOT NULL,
	[tenSanPham] [nvarchar](100) NOT NULL,
	[tacGia] [nvarchar](14) NOT NULL,
	[theLoai] [nvarchar](14) NOT NULL,
	[namXuatBan] [date] NOT NULL,
	[ISBN] [nvarchar](255) NOT NULL,
	[soTrang] [int] NULL,
	[loaiSanPham] [nvarchar](15) NOT NULL,
	[nhaCungCap] [nvarchar](15) NOT NULL,
	[kichThuoc] [float] NOT NULL,
	[mauSac] [nvarchar](255) NOT NULL,
	[trangThai] [bit] NOT NULL,
	[thue] [float] NULL,
	[soLuong] [int] NULL,
	[giaNhap] [float] NULL,
	[giaBan] [float] NULL,
	[giaKhuyenMai] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[idSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 12/14/2023 12:09:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[idSanPham] [nvarchar](14) NOT NULL,
	[tenSanPham] [nvarchar](30) NOT NULL,
	[loaiSanPham] [nvarchar](15) NOT NULL,
	[nhaCungCap] [nvarchar](15) NOT NULL,
	[kichThuoc] [float] NOT NULL,
	[mauSac] [nvarchar](255) NOT NULL,
	[trangThai] [bit] NOT NULL,
	[thue] [float] NULL,
	[giaNhap] [float] NULL,
	[soLuong] [int] NULL,
	[giaBan] [float] NULL,
	[giaKhuyenMai] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[idSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TacGia]    Script Date: 12/14/2023 12:09:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TacGia](
	[idTacGia] [nvarchar](14) NOT NULL,
	[tenTacGia] [nvarchar](30) NOT NULL,
	[ngaySinh] [date] NULL,
	[soLuongTacPham] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[idTacGia] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 12/14/2023 12:09:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[idTaiKhoan] [nvarchar](14) NOT NULL,
	[matKhau] [nvarchar](255) NOT NULL,
	[ngayLap] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[idTaiKhoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TheLoai]    Script Date: 12/14/2023 12:09:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TheLoai](
	[idTheLoai] [nvarchar](14) NOT NULL,
	[tenTheLoai] [nvarchar](100) NOT NULL,
	[soLuongSach] [int] NULL,
	[moTa] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idTheLoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[KhuyenMai] ADD  DEFAULT (getdate()) FOR [ngayBatDau]
GO
ALTER TABLE [dbo].[NhanVien] ADD  DEFAULT ((1)) FOR [trangThai]
GO
ALTER TABLE [dbo].[QuanLy] ADD  DEFAULT ((1)) FOR [trangThai]
GO
ALTER TABLE [dbo].[TaiKhoan] ADD  DEFAULT (getdate()) FOR [ngayLap]
GO
ALTER TABLE [dbo].[ApDungKhuyenMai]  WITH CHECK ADD FOREIGN KEY([idKM])
REFERENCES [dbo].[KhuyenMai] ([idKM])
GO
ALTER TABLE [dbo].[ApDungKhuyenMai]  WITH CHECK ADD FOREIGN KEY([idSP])
REFERENCES [dbo].[SanPham] ([idSanPham])
GO
ALTER TABLE [dbo].[ApDungKhuyenMaiSach]  WITH CHECK ADD FOREIGN KEY([idKM])
REFERENCES [dbo].[KhuyenMai] ([idKM])
GO
ALTER TABLE [dbo].[ApDungKhuyenMaiSach]  WITH CHECK ADD FOREIGN KEY([idS])
REFERENCES [dbo].[Sach] ([idSanPham])
GO
ALTER TABLE [dbo].[ChiTietHoaDonChoSach]  WITH CHECK ADD FOREIGN KEY([idDonHangCho])
REFERENCES [dbo].[HoaDonCho] ([idDonHangCho])
GO
ALTER TABLE [dbo].[ChiTietHoaDonChoSach]  WITH CHECK ADD FOREIGN KEY([idSanPham])
REFERENCES [dbo].[Sach] ([idSanPham])
GO
ALTER TABLE [dbo].[ChiTietHoaDonChoSanPham]  WITH CHECK ADD FOREIGN KEY([idDonHangCho])
REFERENCES [dbo].[HoaDonCho] ([idDonHangCho])
GO
ALTER TABLE [dbo].[ChiTietHoaDonChoSanPham]  WITH CHECK ADD FOREIGN KEY([idSanPham])
REFERENCES [dbo].[SanPham] ([idSanPham])
GO
ALTER TABLE [dbo].[ChiTietHoaDonSach]  WITH CHECK ADD FOREIGN KEY([idDonHang])
REFERENCES [dbo].[HoaDon] ([idDonHang])
GO
ALTER TABLE [dbo].[ChiTietHoaDonSach]  WITH CHECK ADD FOREIGN KEY([idSanPham])
REFERENCES [dbo].[Sach] ([idSanPham])
GO
ALTER TABLE [dbo].[ChiTietHoaDonSanPham]  WITH CHECK ADD FOREIGN KEY([idDonHang])
REFERENCES [dbo].[HoaDon] ([idDonHang])
GO
ALTER TABLE [dbo].[ChiTietHoaDonSanPham]  WITH CHECK ADD FOREIGN KEY([idSanPham])
REFERENCES [dbo].[SanPham] ([idSanPham])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([khachHang])
REFERENCES [dbo].[KhachHang] ([idKhachHang])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([nhanVien])
REFERENCES [dbo].[NhanVien] ([idNhanVien])
GO
ALTER TABLE [dbo].[HoaDonCho]  WITH CHECK ADD FOREIGN KEY([idKhachHang])
REFERENCES [dbo].[KhachHang] ([idKhachHang])
GO
ALTER TABLE [dbo].[Sach]  WITH CHECK ADD FOREIGN KEY([loaiSanPham])
REFERENCES [dbo].[LoaiSanPham] ([idLoaiSanPham])
GO
ALTER TABLE [dbo].[Sach]  WITH CHECK ADD FOREIGN KEY([nhaCungCap])
REFERENCES [dbo].[NhaCungCap] ([idNhaCungCap])
GO
ALTER TABLE [dbo].[Sach]  WITH CHECK ADD FOREIGN KEY([tacGia])
REFERENCES [dbo].[TacGia] ([idTacGia])
GO
ALTER TABLE [dbo].[Sach]  WITH CHECK ADD FOREIGN KEY([theLoai])
REFERENCES [dbo].[TheLoai] ([idTheLoai])
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD FOREIGN KEY([loaiSanPham])
REFERENCES [dbo].[LoaiSanPham] ([idLoaiSanPham])
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD FOREIGN KEY([nhaCungCap])
REFERENCES [dbo].[NhaCungCap] ([idNhaCungCap])
GO
ALTER TABLE [dbo].[ChiTietHoaDonChoSach]  WITH CHECK ADD CHECK  (([soLuong]>(0)))
GO
ALTER TABLE [dbo].[ChiTietHoaDonChoSanPham]  WITH CHECK ADD CHECK  (([soLuong]>(0)))
GO
ALTER TABLE [dbo].[ChiTietHoaDonSach]  WITH CHECK ADD CHECK  (([soLuong]>(0)))
GO
ALTER TABLE [dbo].[ChiTietHoaDonSanPham]  WITH CHECK ADD CHECK  (([soLuong]>(0)))
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD CHECK  (([tienKhachDua]>=(0)))
GO
ALTER TABLE [dbo].[KhachHang]  WITH CHECK ADD CHECK  (([ngaySinh]<getdate()))
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD CHECK  (([ngaySinh]<getdate()))
GO
ALTER TABLE [dbo].[QuanLy]  WITH CHECK ADD CHECK  (([ngaySinh]<getdate()))
GO
ALTER TABLE [dbo].[Sach]  WITH CHECK ADD CHECK  (([giaNhap]>=(0)))
GO
ALTER TABLE [dbo].[Sach]  WITH CHECK ADD CHECK  ((datepart(year,[namXuatBan])<=datepart(year,getdate())))
GO
ALTER TABLE [dbo].[Sach]  WITH CHECK ADD CHECK  (([thue]>=(0)))
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD CHECK  (([giaNhap]>=(0)))
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD CHECK  (([thue]>=(0)))
GO
ALTER TABLE [dbo].[TacGia]  WITH CHECK ADD CHECK  (([ngaySinh]<getdate()))
GO
ALTER TABLE [dbo].[TacGia]  WITH CHECK ADD CHECK  (([soLuongTacPham]>=(0)))
GO
ALTER TABLE [dbo].[TheLoai]  WITH CHECK ADD CHECK  (([soLuongSach]>=(0)))
GO
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312010001', N'Hữu Vinh', N'0918255167', N'vinhpham123@gmail.com', N'320D phường 7, TP.Bến Tre', CAST(N'2003-01-09' AS Date), 1)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312010002', N'Vũ Duy', N'0918288167', N'duy123@gmail.com', N'Phan Rang', CAST(N'2003-06-27' AS Date), 1)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312010003', N'Tấn Đạt', N'0929255167', N'datpham@gmail.com', N'Tiền Giang', CAST(N'2003-04-13' AS Date), 1)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312010004', N'Văn Hoàng', N'0918255167', N'hoangle@gmail.com', N'Long Thành,Đồng Nai', CAST(N'2003-01-09' AS Date), 1)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312010005', N'Bảo Trinh', N'0379121672', N'trinhxinhdep@gmail.com', N'Bình Định', CAST(N'2003-11-17' AS Date), 0)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312010006', N'Hồng Luyên', N'0976321697', N'luyenxinh@gmail.com', N'Bình Định', CAST(N'2003-09-29' AS Date), 0)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312010007', N'Hồng Lưu', N'0783126567', N'luuxinh@gmail.com', N'Bình Định', CAST(N'2003-09-29' AS Date), 0)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312010008', N'Phước Hậu', N'0783454367', N'haungo@gmail.com', N'Bến Tre', CAST(N'2003-11-21' AS Date), 1)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312010009', N'Đức Minh', N'0776754367', N'minhcute@gmail.com', N'Bến Tre', CAST(N'2003-01-21' AS Date), 1)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312010010', N'Thái Công', N'0989891437', N'congthai@gmail.com', N'Bến Tre', CAST(N'2003-07-23' AS Date), 1)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312010011', N'Lan Anh', N'0778884367', N'lananh25@gmail.com', N'Bến Tre', CAST(N'2003-11-25' AS Date), 0)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312010012', N'Mỹ Dung', N'0765754367', N'dungxd@gmail.com', N'Bến Tre', CAST(N'2003-02-06' AS Date), 0)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312010013', N'Thanh Thảo', N'0744454367', N'thaodep@gmail.com', N'Kon Tum', CAST(N'2002-02-05' AS Date), 0)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312010014', N'Duy Thống', N'0917755167', N'thongtruong123@gmail.com', N'329 phường 8, TP.Bến Tre', CAST(N'2003-08-17' AS Date), 1)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312010015', N'Thành Đạt', N'0918987867', N'datcool@gmail.com', N'Bến Tre', CAST(N'2003-06-27' AS Date), 1)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312010016', N'Tường Vy', N'0989255167', N'vynguyen@gmail.com', N'Bến Tre', CAST(N'2003-11-13' AS Date), 0)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312010017', N'Mỹ Hạnh', N'0918257767', N'myhanh@gmail.com', N'222 phương 7, Bến Tre', CAST(N'2003-01-18' AS Date), 0)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312010018', N'Cát Tường', N'0879121672', N'cattuong@gmail.com', N'Bến Tre', CAST(N'2003-05-28' AS Date), 0)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312010019', N'Tuyết Nhung', N'0976321688', N'tuyenxinh@gmail.com', N'Hà Nội', CAST(N'2003-09-29' AS Date), 0)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312010020', N'Yến Vân', N'0783776567', N'yenvan@gmail.com', N'250 phương 7, TP.Bến Tre', CAST(N'2003-09-19' AS Date), 0)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312010021', N'Tuấn Duy', N'0783455367', N'duy23@gmail.com', N'Bến Tre', CAST(N'2003-11-20' AS Date), 1)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312010022', N'Minh Khang', N'0746754367', N'minhkhang@gmail.com', N'Bến Tre', CAST(N'2003-01-16' AS Date), 1)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312010023', N'Duy Thuận', N'0989891777', N'dt@gmail.com', N'Bến Tre', CAST(N'2003-01-16' AS Date), 1)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312010024', N'Mỹ Vy', N'0778810367', N'vydep@gmail.com', N'Bến Tre', CAST(N'2003-11-25' AS Date), 0)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312010025', N'Tường Vân', N'0765754797', N'tv@gmail.com', N'Bến Tre', CAST(N'2003-02-06' AS Date), 0)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312010026', N'Quốc Tuấn', N'0744454355', N'tuan@gmail.com', N'Kon Tum', CAST(N'2002-02-05' AS Date), 1)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312010027', N'Minh Nhựt', N'0744554367', N'minhnhutg@gmail.com', N'Bến Tre', CAST(N'2003-01-26' AS Date), 1)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312010028', N'Thanh Nhiên', N'0989891789', N'tn@gmail.com', N'Bến Tre', CAST(N'2003-01-16' AS Date), 1)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312010029', N'Phương Quyên', N'0773303675', N'quyen@gmail.com', N'Bến Tre', CAST(N'2003-01-01' AS Date), 0)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312010030', N'Ngọc Châu', N'0765754740', N'chau@gmail.com', N'Cần Thơ', CAST(N'2003-05-06' AS Date), 0)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312010031', N'Chí Khang', N'0744454355', N'khang@gmail.com', N'Kon Tum', CAST(N'2002-08-20' AS Date), 1)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312010032', N'Quang Vinh', N'0355430475', N'vinh@mail', N'125 Bùi Đình Túy, TP.HCM', CAST(N'2023-01-09' AS Date), 1)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312010033', N'Hoàng Anh', N'0355430754', N'hoang123@mail', N'Bình Qu?i, B?n Tre', CAST(N'2023-01-04' AS Date), 1)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312090034', N'Văn A', N'0918995167', N'vinhpham123@gmail.com', N'320D phường 7, TP.Bến Tre', CAST(N'2003-01-09' AS Date), 1)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312090035', N'Văn B', N'0918284167', N'duy123@gmail.com', N'Phan Rang', CAST(N'2003-06-27' AS Date), 1)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312090036', N'Thị C', N'0929252167', N'datpham@gmail.com', N'Tiền Giang', CAST(N'2003-04-13' AS Date), 1)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312090037', N'Văn Tú', N'0918233167', N'hoangle@gmail.com', N'Long Thành,Đồng Nai', CAST(N'2003-01-09' AS Date), 1)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312090038', N'Minh An', N'0379971672', N'trinhxinhdep@gmail.com', N'Bình Định', CAST(N'2003-11-17' AS Date), 0)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312090039', N'Minh Hải', N'0976321688', N'luyenxinh@gmail.com', N'Bình Định', CAST(N'2003-09-29' AS Date), 0)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312090040', N'Hồng Hải', N'0783126534', N'luuxinh@gmail.com', N'Bình Định', CAST(N'2003-09-29' AS Date), 0)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312090041', N'Văn Ý', N'0783454313', N'haungo@gmail.com', N'Bến Tre', CAST(N'2003-11-21' AS Date), 1)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312090042', N'Yến Mỹ', N'0776754377', N'minhcute@gmail.com', N'Bến Tre', CAST(N'2003-01-21' AS Date), 1)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312090043', N'Yến Dung', N'0988814378', N'congthai@gmail.com', N'Bến Tre', CAST(N'2003-07-23' AS Date), 1)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312090044', N'Công Hữu', N'0778889977', N'lananh25@gmail.com', N'Bến Tre', CAST(N'2003-11-25' AS Date), 0)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312090045', N'Mỹ Duyên', N'0765454367', N'dungxd@gmail.com', N'Bến Tre', CAST(N'2003-02-06' AS Date), 0)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312090046', N'Thanh Hăng', N'0743354367', N'thaodep@gmail.com', N'Kon Tum', CAST(N'2002-02-05' AS Date), 0)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312090047', N'Duy Thành', N'0914555167', N'thongtruong123@gmail.com', N'329 phường 8, TP.Bến Tre', CAST(N'2003-08-17' AS Date), 1)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312090048', N'Thành Công', N'0916687867', N'datcool@gmail.com', N'Bến Tre', CAST(N'2003-06-27' AS Date), 1)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312090049', N'Tường Yến', N'0922255167', N'vynguyen@gmail.com', N'Bến Tre', CAST(N'2003-11-13' AS Date), 0)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312090050', N'Mỹ Cúc', N'0918211767', N'myhanh@gmail.com', N'222 phương 7, Bến Tre', CAST(N'2003-01-18' AS Date), 0)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312090051', N'Cát Tường', N'0822221672', N'cattuong@gmail.com', N'Bến Tre', CAST(N'2003-05-28' AS Date), 0)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312090052', N'Tuyết Vân', N'0976321657', N'tuyenxinh@gmail.com', N'Hà Nội', CAST(N'2003-09-29' AS Date), 0)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312090053', N'Yến Như', N'0783776598', N'yenvan@gmail.com', N'250 phương 7, TP.Bến Tre', CAST(N'2003-09-19' AS Date), 0)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312090054', N'Tuấn Bệu', N'0783455333', N'duy23@gmail.com', N'Bến Tre', CAST(N'2003-11-20' AS Date), 1)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312090055', N'Minh Cò', N'0746754310', N'minhkhang@gmail.com', N'Bến Tre', CAST(N'2003-01-16' AS Date), 1)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312090056', N'Duy Thẩm', N'0989891774', N'dt@gmail.com', N'Bến Tre', CAST(N'2003-01-16' AS Date), 1)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312090057', N'Mỹ Phương', N'0778810787', N'vydep@gmail.com', N'Bến Tre', CAST(N'2003-11-25' AS Date), 0)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312090058', N'Tường Cúc', N'0765754927', N'tv@gmail.com', N'Bến Tre', CAST(N'2003-02-06' AS Date), 0)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312090059', N'Quốc Nghiệp', N'0742254355', N'tuan@gmail.com', N'Kon Tum', CAST(N'2002-02-05' AS Date), 1)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312090060', N'Minh Nhựa', N'0744511367', N'minhnhutg@gmail.com', N'Bến Tre', CAST(N'2003-01-26' AS Date), 1)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312090061', N'Thanh Nhân', N'0900891789', N'tn@gmail.com', N'Bến Tre', CAST(N'2003-01-16' AS Date), 1)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312090062', N'Phương Uyên', N'0747303675', N'quyen@gmail.com', N'Bến Tre', CAST(N'2003-01-01' AS Date), 0)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312090063', N'Ngọc Mỹ', N'0765752540', N'chau@gmail.com', N'Cần Thơ', CAST(N'2003-05-06' AS Date), 0)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312090064', N'Chí Tài', N'0744452355', N'khang@gmail.com', N'Kon Tum', CAST(N'2002-08-20' AS Date), 1)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312090065', N'Quang Tài', N'0355410475', N'vinh@mail', N'125 Bùi Đình Túy, TP.HCM', CAST(N'2023-01-09' AS Date), 1)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312090066', N'Hoàng Ánh', N'0358730754', N'hoang123@mail', N'Bình Qu?i, B?n Tre', CAST(N'2023-01-04' AS Date), 1)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312140067', N'Nguyễn Văn B', N'0355420478', N'van@gmail.com', N'Bến Tre', CAST(N'2003-12-10' AS Date), 1)
INSERT [dbo].[KhachHang] ([idKhachHang], [tenKhachHang], [soDienThoai], [email], [diaChi], [ngaySinh], [gioiTinh]) VALUES (N'KH202312140068', N'Văn C', N'0355784342', N'van@gmail.com', N'Bến Tre', CAST(N'2003-12-09' AS Date), 1)