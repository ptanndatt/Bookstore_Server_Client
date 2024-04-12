package views;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class StatisticalView extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTable tableTopSanPhamBanChay;
    private JTable tableTopKhachHangTongTienCao;
    private JTable tableTopNhanVienCoDoanhThuCaoNhat;
    private DefaultTableModel modelTopSanPhamBanChay;
    private DefaultTableModel modelTopKhachHangTongTienCao;
    private DefaultTableModel modelTopNhanVienCoDoanhThuCaoNhat;
    private JComboBox comboBoxThang;
    private ButtonGroup btnGroup;
    private JCheckBox chckTatCa;
    private JCheckBox chckHomNay;
    private JCheckBox chckTheoThang;
    private JCheckBox chckTheoNam;
    private JComboBox comboBoxNam;

    private JLabel lblDoanhThu;
    private JLabel lblSoHoaDon;

    public StatisticalView() {
        setTitle("Statistical View");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(
                new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 85, 170), new Color(0, 85, 170)),
                "Th\u00F4\u0301ng K\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 85, 170)));
        panel.setBounds(0, 0, 1226, 656);
        add(panel);
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(0, 187, 187));
        panel_1.setBounds(322, 11, 290, 137);
        panel.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel = new JLabel("Doanh Thu");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(0, 0, 290, 73);
        String imgDT = "img/doanhthu.png";
        int setRongiconDT = 28; // Đặt chiều rộng mong muốn
        int setDaiiconDT = 22; // Đặt chiều cao mong muốn

        try {
            // Đọc hình ảnh từ tệp
            BufferedImage originalImage = ImageIO.read(new File(imgDT));

            // Thay đổi kích thước hình ảnh với giữ nguyên tỷ lệ khung hình
            int originalWidth = originalImage.getWidth();
            int originalHeight = originalImage.getHeight();
            double aspectRatio = (double) originalWidth / originalHeight;

            int scaledWidth = (int) (setDaiiconDT * aspectRatio);
            int scaledHeight = setDaiiconDT;

            if (scaledWidth > setRongiconDT) {
                scaledWidth = setRongiconDT;
                scaledHeight = (int) (setRongiconDT / aspectRatio);
            }

            Image scaledImage = originalImage.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
            lblNewLabel.setIcon(new ImageIcon(scaledImage));
        } catch (IOException e) {
            e.printStackTrace();
        }
        panel_1.add(lblNewLabel);

        lblDoanhThu = new JLabel("");
        lblDoanhThu.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lblDoanhThu.setHorizontalAlignment(SwingConstants.CENTER);
        lblDoanhThu.setBounds(0, 59, 290, 73);
        panel_1.add(lblDoanhThu);

        JPanel panel_1_1 = new JPanel();
        panel_1_1.setLayout(null);
        panel_1_1.setBackground(new Color(0, 187, 187));
        panel_1_1.setBounds(677, 11, 290, 137);
        panel.add(panel_1_1);

        JLabel lblSHoan = new JLabel("Số Hóa Đơn");
        lblSHoan.setHorizontalAlignment(SwingConstants.CENTER);
        lblSHoan.setFont(new Font("Times New Roman", Font.BOLD, 30));
        lblSHoan.setBounds(0, 0, 290, 73);
        String imgHD = "img/hoadon.png";
        int setRongiconHD = 28; // Đặt chiều rộng mong muốn
        int setDaiiconHD = 22; // Đặt chiều cao mong muốn

        try {
            // Đọc hình ảnh từ tệp
            BufferedImage originalImage = ImageIO.read(new File(imgHD));

            // Thay đổi kích thước hình ảnh với giữ nguyên tỷ lệ khung hình
            int originalWidth = originalImage.getWidth();
            int originalHeight = originalImage.getHeight();
            double aspectRatio = (double) originalWidth / originalHeight;

            int scaledWidth = (int) (setDaiiconHD * aspectRatio);
            int scaledHeight = setDaiiconHD;

            if (scaledWidth > setRongiconHD) {
                scaledWidth = setRongiconHD;
                scaledHeight = (int) (setRongiconHD / aspectRatio);
            }

            Image scaledImage = originalImage.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
            lblSHoan.setIcon(new ImageIcon(scaledImage));
        } catch (IOException e) {
            e.printStackTrace();
        }
        panel_1_1.add(lblSHoan);

        lblSoHoaDon = new JLabel("");
        lblSoHoaDon.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lblSoHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
        lblSoHoaDon.setBounds(0, 58, 290, 73);
        panel_1_1.add(lblSoHoaDon);

        JPanel pnlTopSanPham = new JPanel();
        pnlTopSanPham.setBorder(
                new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 85, 170), new Color(0, 85, 170)),
                        "Top sa\u0309n ph\u00E2\u0309m ba\u0301n cha\u0323y", TitledBorder.LEADING, TitledBorder.TOP,
                        null, new Color(0, 85, 170)));
        pnlTopSanPham.setBounds(10, 321, 396, 305);
        panel.add(pnlTopSanPham);
        pnlTopSanPham.setLayout(null);

        String header[] = {"Top", "Mã LK", "Tên LK", "Số Lượng"};
        modelTopSanPhamBanChay = new DefaultTableModel(header, 0);
        tableTopSanPhamBanChay = new JTable(modelTopSanPhamBanChay);
        JScrollPane scrollPane = new JScrollPane(tableTopSanPhamBanChay);
        scrollPane.setBounds(10, 21, 376, 273);
        pnlTopSanPham.add(scrollPane);
//        dao = new ThongKe_Dao();
//        docDuLieuVaoTableLinhKien();

        JPanel pnlTopKhachHang = new JPanel();
        pnlTopKhachHang.setBorder(
                new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 85, 170), new Color(0, 85, 170)),
                        "Top kha\u0301ch ha\u0300ng co\u0301 t\u00F4\u0309ng ti\u00EA\u0300n cao", TitledBorder.LEADING,
                        TitledBorder.TOP, null, new Color(0, 85, 170)));
        pnlTopKhachHang.setBounds(416, 321, 396, 305);
        panel.add(pnlTopKhachHang);
        pnlTopKhachHang.setLayout(null);

        String header1[] = {"Top", "Mã KH", "Tên KH", "Tổng Tiền"};
        modelTopKhachHangTongTienCao = new DefaultTableModel(header1, 0);
        tableTopKhachHangTongTienCao = new JTable(modelTopKhachHangTongTienCao);
        JScrollPane scrollPane_1 = new JScrollPane(tableTopKhachHangTongTienCao);
        scrollPane_1.setBounds(10, 22, 376, 272);
        pnlTopKhachHang.add(scrollPane_1);
//        docDuLieuVaoTableKhachHang();

        JPanel pnlTopNhanVien = new JPanel();
        pnlTopNhanVien.setBorder(
                new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 85, 170), new Color(0, 85, 170)),
                        "Top nh\u00E2n vi\u00EAn co\u0301 doanh thu cao nh\u00E2\u0301t", TitledBorder.LEADING,
                        TitledBorder.TOP, null, new Color(0, 85, 170)));
        pnlTopNhanVien.setBounds(820, 321, 396, 305);
        panel.add(pnlTopNhanVien);
        pnlTopNhanVien.setLayout(null);

        String header2[] = {"Top", "Mã NV", "Tên NV", "Doanh Thu"};
        modelTopNhanVienCoDoanhThuCaoNhat = new DefaultTableModel(header2, 0);
        tableTopNhanVienCoDoanhThuCaoNhat = new JTable(modelTopNhanVienCoDoanhThuCaoNhat);
        JScrollPane scrollPane_2 = new JScrollPane(tableTopNhanVienCoDoanhThuCaoNhat);
        scrollPane_2.setBounds(10, 22, 376, 272);
        pnlTopNhanVien.add(scrollPane_2);
//        docDuLieuVaoTableNhanVien();

        btnGroup = new ButtonGroup();
        chckTatCa = new JCheckBox("Tất cả");
        chckTatCa.setSelected(true);
//        chckTatCa.addItemListener(new ItemListener() {
//            @Override
//            public void itemStateChanged(ItemEvent e) {
//                if (e.getStateChange() == ItemEvent.SELECTED) {
//                    xoaDuLieutablesanpham();
//                    xoaDuLieutablekhachhang();
//                    xoaDuLieutablenhanvien();
//                    docDuLieuVaoTableNhanVien();
//                    docDuLieuVaoTableKhachHang();
//                    docDuLieuVaoTableLinhKien();
//                    tinhDoanhThu();
//                }
//            }
//        });
//        tinhDoanhThu();
        chckTatCa.setFont(new Font("Times New Roman", Font.BOLD, 15));
        chckTatCa.setBounds(10, 181, 138, 23);
        btnGroup.add(chckTatCa);
        panel.add(chckTatCa);

        chckHomNay = new JCheckBox("Hôm nay");
        chckHomNay.setFont(new Font("Times New Roman", Font.BOLD, 15));
        chckHomNay.setBounds(10, 209, 138, 23);
//        chckHomNay.addItemListener(new ItemListener() {
//            @Override
//            public void itemStateChanged(ItemEvent e) {
//                if (e.getStateChange() == ItemEvent.SELECTED) {
//                    // Nếu được chọn, tính và hiển thị doanh thu hôm nay
//                    xoaDuLieutablesanpham();
//                    xoaDuLieutablekhachhang();
//                    xoaDuLieutablenhanvien();
//                    hienThiSanPhamBanChayVaDoanhThuHomNay();
//                    hienThiKhachHangvaDoanhThuHomNay();
//                    hienThiNhanVienvaDoanhThuHomNay();
//                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
//                    // Nếu không được chọn, có thể xử lý một cách khác nếu cần thiết
//                }
//            }
//        });

        btnGroup.add(chckHomNay);
        panel.add(chckHomNay);


        chckTheoThang = new JCheckBox("Theo tháng");
//        chckTheoThang.addItemListener(new ItemListener() {
//            @Override
//            public void itemStateChanged(ItemEvent e) {
//                if (e.getStateChange() == ItemEvent.SELECTED) {
//                    // Nếu được chọn, tính và hiển thị doanh thu hôm nay
//                    xoaDuLieutablesanpham();
//                    xoaDuLieutablekhachhang();
//                    xoaDuLieutablenhanvien();
//                    hienThiDoanhThuTheoThangCuaNhanVien();
//                    hienThiDoanhThuTheoThangChoKhachHang();
//                    hienThiSanPhamBanChayTheoThang();
//                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
//                    // Nếu không được chọn, có thể xử lý một cách khác nếu cần thiết
//                }
//            }
//        });
        chckTheoThang.setFont(new Font("Times New Roman", Font.BOLD, 15));
        chckTheoThang.setBounds(10, 241, 138, 23);
        btnGroup.add(chckTheoThang);
        panel.add(chckTheoThang);

        chckTheoNam = new JCheckBox("Theo năm");
//        chckTheoNam.addItemListener(new ItemListener() {
//            @Override
//            public void itemStateChanged(ItemEvent e) {
//                if (e.getStateChange() == ItemEvent.SELECTED) {
//                    // Nếu được chọn, tính và hiển thị doanh thu hôm nay
//                    xoaDuLieutablesanpham();
//                    xoaDuLieutablekhachhang();
//                    xoaDuLieutablenhanvien();
//                    hienThiTopSanPhamVaDoanhThuTheoNam();
//                    hienThiThongTinKhachHangVaDoanhThuTheoNam();
//                    hienThiThongTinNhanVienVaDoanhThuTheoNam();
//                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
//                    // Nếu không được chọn, có thể xử lý một cách khác nếu cần thiết
//                }
//            }
//        });
        chckTheoNam.setFont(new Font("Times New Roman", Font.BOLD, 15));
        chckTheoNam.setBounds(10, 272, 138, 23);
        btnGroup.add(chckTheoNam);
        panel.add(chckTheoNam);

        String thang[] = {"Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7",
                "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12"};
        comboBoxThang = new JComboBox(thang);
        comboBoxThang.setBounds(170, 242, 132, 22);
        panel.add(comboBoxThang);

        String nam[] = {"2020", "2021", "2022", "2023"};
        comboBoxNam = new JComboBox(nam);
        comboBoxNam.setBounds(170, 273, 132, 22);
        panel.add(comboBoxNam);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StatisticalView();
        });
    }
}
