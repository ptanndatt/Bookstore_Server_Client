package view;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;

public class EmployeeManagementView extends JPanel implements KeyListener, MouseListener, ActionListener {



    private JDateChooser chooserNgaySinh;
    private JTextField txtTenNV;
    private JTextField txtsdt;
    private JTextField txtEmail;
    private JTextField txtDiaChi;
    private JTextField txtTimKiem;
    private JTextField txtID;
    private JLabel lbTenNV;
    private JLabel lbsdt;
    private JLabel lbEmail;
    private JLabel lbDiaChi;
    private JLabel lbNgaySinh;
    private JLabel lbGioiTinh;
    private JLabel lbID;

    private JLabel lbTimKiem;
    private JRadioButton rbNam;
    private JRadioButton rbNu;
    private JComboBox<Object> cbTrangThai,cbChucVu;
    private JLabel lbChucVu;
    private JLabel lbTrangThai;
    private JTable tableNhanVien;
    private DefaultTableModel modelNhanVien;
    private JButton btnThemNV;
    private JButton btnCapNhatNV;
    private JButton btnXoaNV;
    private JButton btnLamMoi;
    private JButton btnXemTatCa;
    private JButton btnXuatExecl;
    private SimpleDateFormat dfNgaySinh;
    private JTabbedPane tabbedPane;
    private
    public EmployeeManagementView() {
        dfNgaySinh = new SimpleDateFormat("dd/MM/yyyy");


        setLayout(new BorderLayout());

        JPanel pnNouth = new JPanel(new BorderLayout());
        JPanel pnSounth = new JPanel(new BorderLayout());
        JPanel pnTitle = new JPanel();
        JPanel pnInfo = new JPanel(new GridLayout(5, 1, 5, 5));
        JPanel pnChucNang = new JPanel(new GridLayout(1, 4, 10, 10));
        JPanel pnTimKiem = new JPanel(new GridLayout(1, 3, 10, 10));
        JPanel pntbNV = new JPanel();
//		Tiêu đề
        JLabel lblTieuDe = new JLabel("QUẢN LÝ NHÂN VIÊN");
        lblTieuDe.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblTieuDe.setForeground(new Color(26, 102, 227));
        pnTitle.add(lblTieuDe);
        pnNouth.add(pnTitle, BorderLayout.NORTH);
        add(pnNouth, BorderLayout.NORTH);

        lbID = new JLabel("ID nhân viên:");
        lbTenNV = new JLabel("Tên nhân viên:");
        txtTenNV = new JTextField();
        lbsdt = new JLabel("Số điện thoại:");
        txtsdt = new JTextField();
        lbEmail = new JLabel("Email:");
        txtEmail = new JTextField();
        lbDiaChi = new JLabel("Địa chỉ:");
        txtDiaChi = new JTextField();
        lbChucVu = new JLabel("Chức vụ:");
        lbTrangThai = new JLabel("Trạng thái:");
        lbGioiTinh = new JLabel("Giới tính:");
        lbNgaySinh = new JLabel("Ngày sinh:");
        txtID = new JTextField();
        txtID.setEditable(false);
        cbChucVu = new JComboBox<Object>(new Object[]{"Nhân viên"});
        cbTrangThai = new JComboBox<Object>(new Object[]{"Đang làm việc", "Đã nghỉ việc"});

        chooserNgaySinh = new JDateChooser();
        chooserNgaySinh.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        chooserNgaySinh.setBounds(100, 310, 200, 40);
        chooserNgaySinh.setDateFormatString("dd/MM/yyyy");
        chooserNgaySinh.setBorder(new LineBorder(new Color(114, 23, 153), 1, true));
        chooserNgaySinh.setFont(new Font("SansSerif", Font.PLAIN, 15));
        chooserNgaySinh.getCalendarButton().setPreferredSize(new Dimension(30, 24));
        chooserNgaySinh.getCalendarButton().setBackground(new Color(102, 0, 153));
        chooserNgaySinh.getCalendarButton().setToolTipText("Chọn ngày sinh");
        rbNam = new JRadioButton("Nam");
        rbNu = new JRadioButton("Nữ");
        //Tạo button groud giới tính
        ButtonGroup groupGT = new ButtonGroup();
        groupGT.add(rbNam);
        groupGT.add(rbNu);
        pnInfo.add(lbID);
        pnInfo.add(txtID);
        pnInfo.add(lbTenNV);
        pnInfo.add(txtTenNV);
        pnInfo.add(lbsdt);
        pnInfo.add(txtsdt);
        pnInfo.add(lbEmail);
        pnInfo.add(txtEmail);
        pnInfo.add(lbDiaChi);
        pnInfo.add(txtDiaChi);
        pnInfo.add(lbChucVu);
        pnInfo.add(cbChucVu);
        pnInfo.add(lbTrangThai);
        pnInfo.add(cbTrangThai);
        pnInfo.add(lbNgaySinh);
        pnInfo.add(chooserNgaySinh);
        pnInfo.add(lbGioiTinh);
        pnInfo.setBorder(BorderFactory.createTitledBorder("Thông tin nhân viên"));

        pnInfo.add(rbNam);
        pnInfo.add(rbNu);

        pnNouth.add(pnInfo, BorderLayout.CENTER);

        lbTimKiem = new JLabel("Tìm kiếm nhân viên:");
        txtTimKiem = new JTextField();
        pnTimKiem.add(lbTimKiem);
        pnTimKiem.add(txtTimKiem);
        ImageIcon iconThem = new ImageIcon(getClass().getResource("/icons/add.png"));
        ImageIcon iconCapNhat = new ImageIcon(getClass().getResource("/icons/capnhat.png"));
        ImageIcon iconLamMoi = new ImageIcon(getClass().getResource("/icons/lammoi.png"));
        ImageIcon iconXoa = new ImageIcon(getClass().getResource("/icons/xoa.png"));
        btnThemNV = new JButton("THÊM NHÂN VIÊN");
        btnThemNV.setIcon(iconThem);
        btnCapNhatNV = new JButton("CẬP NHẬT THÔNG TIN NHÂN VIÊN");
        btnCapNhatNV.setIcon(iconCapNhat);
        btnXoaNV = new JButton("XÓA NHÂN VIÊN");
        btnXuatExecl = new JButton("XUẤT EXCEL");
        btnXoaNV.setIcon(iconXoa);
        btnLamMoi = new JButton("LÀM MỚI");
        btnLamMoi.setIcon(iconLamMoi);
        btnXemTatCa = new JButton("XEM TẤT CẢ");
        pnChucNang.add(btnThemNV);
        pnChucNang.add(btnCapNhatNV);
        pnChucNang.add(btnXoaNV);
        pnChucNang.add(btnLamMoi);
        pnChucNang.add(btnXuatExecl);
        pnChucNang.setBorder(BorderFactory.createTitledBorder("Chức năng"));
        pnNouth.add(pnChucNang, BorderLayout.SOUTH);
        add(pnSounth, BorderLayout.CENTER);
        pnSounth.add(pnTimKiem, BorderLayout.NORTH);
        pnTimKiem.add(btnXemTatCa);

        modelNhanVien = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép chỉnh sửa các ô trong bảng
            }
        };
        tableNhanVien = new JTable();
        modelNhanVien.addColumn("ID nhân viên");
        modelNhanVien.addColumn("Tên nhân viên");
        modelNhanVien.addColumn("Số điện thoại");
        modelNhanVien.addColumn("Email");
        modelNhanVien.addColumn("Địa chỉ");
        modelNhanVien.addColumn("Ngày sinh");
        modelNhanVien.addColumn("Giới tính");
        modelNhanVien.addColumn("Chức vụ");
        modelNhanVien.addColumn("Trạng thái");
        tableNhanVien.setModel(modelNhanVien);
        JScrollPane scrollPane = new JScrollPane(tableNhanVien);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Danh sách nhân viên"));
        pnSounth.add(scrollPane, BorderLayout.CENTER);


        txtID.setToolTipText("ID + Date + XXXX");
        txtTenNV.setToolTipText("Chỉ nhận chữ");
        txtEmail.setToolTipText("Điền mail hợp lệ");
        txtsdt.setToolTipText("10 số bắt đầu bằng 0 hoặc +84");
        txtDiaChi.setToolTipText("Nhận số và chữ");
        rbNam.setToolTipText("Chọn 1 trong 2");
        rbNu.setToolTipText("Chọn 1 trong 2");
        chooserNgaySinh.setToolTipText("Trước ngày hiện tại");


        chooserNgaySinh.setDate(new java.util.Date());
        btnLamMoi.addActionListener(this);
        btnThemNV.addActionListener(this);
        btnCapNhatNV.addActionListener(this);
        btnXoaNV.addActionListener(this);
        btnXemTatCa.addActionListener(this);
        btnXuatExecl.addActionListener(this);
        tableNhanVien.addMouseListener(this);
        tableNhanVien.addKeyListener(this);
        txtTimKiem.addKeyListener(this);
        txtTenNV.addKeyListener(this);
        txtDiaChi.addKeyListener(this);
        txtEmail.addKeyListener(this);
        txtsdt.addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}