package views;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import controller.MainController;
import models.ProductSale;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class BillsManagement extends JFrame implements ListSelectionListener, ItemListener, PropertyChangeListener, ActionListener {
    private JPanel pnController;
    private JPanel pnMain;
    private JPanel pnLeft;
    private JPanel pnRight;
    private JPanel pnLeft_Top;
    private JPanel pnLeft_Bottom;
    private JLabel lblGetSearchBill;
    private JLabel lblGetSearchProduct;
    private JLabel lblManagerBill;
    private JLabel lblSumBill;
    private JLabel lblSumBillValue;
    private JButton btnExportExcel;
    private JButton btnRefresh;

    private JTextField txtGetSearchBill;
    private JTextField getTxtGetSearchProduct;
    private JCheckBox chkFullTime;
    private JCheckBox chkAnotherChoice;

    private ButtonGroup checkBoxGroup;

    private JComboBox<Object> cboSearchBillDate;
    private JDateChooser dateChooser;

    private JTextArea txtAreaBillDetail;

    private JTable table;
    private DefaultTableModel tableModel, tableModel1;

    private JLabel lblTxtMaHoaDon;
    private JLabel lblTxtThoiGian;
    private JLabel lblTxtNhanVien;
    private JLabel lblTxtKhachHang;
    private JLabel lblTxtGiamGia;
    private JLabel lblTxtKhachDaDua;
    private JLabel lblTxtKhachDaTra;
    private JLabel lblTxtTongTien;

    private JButton btnExportBillExcel;
    private MainController controller;

    public BillsManagement() {
        setLayout(null);
        setTitle("Bills Management");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        init();
    }

    public void init() {
        controller = new MainController();
        pnLeft = new JPanel();
        pnLeft.setLayout(null);
        chkFullTime = new JCheckBox();
        chkAnotherChoice = new JCheckBox();
        cboSearchBillDate = new JComboBox<>();
        dateChooser = new JDateChooser();
        table = new JTable();
        tableModel = new DefaultTableModel();
        pnMain = new JPanel();
        btnRefresh = new JButton();
        txtAreaBillDetail = new JTextArea();
        pnRight = new JPanel();
        btnExportBillExcel = new JButton();
        lblSumBill = new JLabel();
        lblSumBillValue = new JLabel();
        pnLeft.setBorder(BorderFactory.createTitledBorder("Tim kiem"));
        pnLeft.setBounds(10, 10, 300, 200);
        lblGetSearchBill = new JLabel("Mã hóa đơn");
        lblGetSearchBill.setBounds(10, 30, 100, 30);
        txtGetSearchBill = new JTextField();
        txtGetSearchBill.setBounds(10, 60, 260, 30);
        lblGetSearchProduct = new JLabel("Mã khách hàng/Tên khách hàng/SDT");
        lblGetSearchProduct.setBounds(10, 100, 300, 30);
        getTxtGetSearchProduct = new JTextField(20);
        getTxtGetSearchProduct.setBounds(10, 130, 260, 30);
        pnLeft.add(lblGetSearchBill);
        pnLeft.add(txtGetSearchBill);
        pnLeft.add(lblGetSearchProduct);
        pnLeft.add(getTxtGetSearchProduct);

        pnLeft_Bottom = new JPanel();
        pnLeft_Bottom.setLayout(null);
        pnLeft_Bottom.setBounds(10, 220, 300, 150);
        pnLeft_Bottom.setBorder(BorderFactory.createTitledBorder("Tim kiem theo ngay"));
        chkFullTime = new JCheckBox();
        cboSearchBillDate = new JComboBox<>();
        cboSearchBillDate.addItem("Tất cả");
        cboSearchBillDate.addItem("Hôm nay");
        cboSearchBillDate.addItem("Hôm qua");
        cboSearchBillDate.addItem("Tuần nay");
        cboSearchBillDate.addItem("Tháng nay");
        cboSearchBillDate.addItem("Năm nay");
        cboSearchBillDate.setBounds(70, 100, 200, 30);

        chkFullTime.setBounds(10, 100, 20, 30);
        chkAnotherChoice = new JCheckBox();
        chkAnotherChoice.setBounds(10, 50, 20, 30);
        dateChooser.setBounds(70, 50, 200, 30);
        dateChooser.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        dateChooser.setDateFormatString("dd/MM/yyyy");
        dateChooser.setBorder(new LineBorder(new Color(114, 23, 153), 1, true));
        dateChooser.setFont(new Font("SansSerif", Font.PLAIN, 15));
        dateChooser.getCalendarButton().setPreferredSize(new Dimension(30, 24));
        dateChooser.getCalendarButton().setBackground(new Color(102, 0, 153));
        dateChooser.setDate(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));


        chkFullTime.setSelected(dateChooser.getDate() == null);
        chkAnotherChoice.setSelected(dateChooser.getDate() != null);
        cboSearchBillDate.setEnabled(false);

        pnMain = new JPanel(null);
        pnMain.setBounds(320, 10, 1000, 900);
        pnMain.setBorder(BorderFactory.createTitledBorder("Danh sách hóa đơn"));
        lblManagerBill = new JLabel("Hóa đơn");
        lblManagerBill.setFont(new Font("Arial", Font.BOLD, 35));
        lblManagerBill.setBounds(40, 70, 200, 30);
        btnExportExcel = new JButton("Luư trữ");
        btnExportExcel.setBounds(850, 70, 130, 30);
        btnRefresh = new JButton("Làm mới");
        btnRefresh.setBounds(700, 70, 130, 30);
        lblSumBill = new JLabel("Tổng số hóa đơn:");
        lblSumBill.setBounds(800, 865, 150, 30);
        lblSumBillValue = new JLabel("100");
        lblSumBillValue.setBounds(950, 865, 50, 30);
        pnMain.add(lblManagerBill);
        pnMain.add(btnRefresh);
        pnMain.add(btnExportExcel);
        pnMain.add(lblSumBill);
        pnMain.add(lblSumBillValue);


        tableModel.addColumn("Mã hóa đơn");
        tableModel.addColumn("Thời gian");
        tableModel.addColumn("Nhân viên");
        tableModel.addColumn("Khách hàng");
        tableModel.addColumn("Giảm giá (VNĐ)");
        tableModel.addColumn("Khách đã đưa (VNĐ)");
        tableModel.addColumn("Tổng tiền hàng (VNĐ)");

        table.setModel(tableModel);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(10, 110, 970, 760);
        pnMain.add(sp);
        calculateTotalPayment();


        checkBoxGroup = new ButtonGroup();
        checkBoxGroup.add(chkFullTime);
        checkBoxGroup.add(chkAnotherChoice);

        pnLeft_Bottom.add(chkFullTime);
        pnLeft_Bottom.add(cboSearchBillDate);
        pnLeft_Bottom.add(chkAnotherChoice);
        pnLeft_Bottom.add(dateChooser);


        pnRight = new JPanel();
        pnRight.setBounds(1330, 10, 570, 900);
        pnRight.setBorder(BorderFactory.createTitledBorder("Chi tiết hóa đơn"));
        pnRight.setLayout(null);

        JLabel lblMaHoaDon = new JLabel("Mã hóa đơn:");
        JLabel lblThoiGian = new JLabel("Thời gian:");
        JLabel lblNhanVien = new JLabel("Nhân viên:");
        JLabel lblKhachHang = new JLabel("Khách hàng:");
        JLabel lblGiamGia = new JLabel("Giảm giá (VNĐ):");
        JLabel lblKhachDaDua = new JLabel("Khách đã đưa (VNĐ):");
        JLabel lblTongTien = new JLabel("Tổng tiền hàng (VNĐ):");

        lblTxtMaHoaDon = new JLabel();
        lblTxtThoiGian = new JLabel();
        lblTxtNhanVien = new JLabel();
        lblTxtKhachHang = new JLabel();
        lblTxtGiamGia = new JLabel();
        lblTxtKhachDaDua = new JLabel();
        lblTxtTongTien = new JLabel();

        JTable table1 = new JTable();
        tableModel1 = new DefaultTableModel();

        tableModel1.addColumn("Mã sản phẩm");
        tableModel1.addColumn("Tên sản phẩm");
        tableModel1.addColumn("Số lượng");
        tableModel1.addColumn("Đơn giá (VNĐ)");
        tableModel1.addColumn("Thành tiền (VNĐ)");
        table1.setModel(tableModel1);
        JScrollPane cthd = new JScrollPane(table1);
        cthd.setBounds(10, 300, 540, 500);

        btnExportBillExcel = new JButton("In hóa đơn");
        btnExportBillExcel.setBounds(397, 820, 150, 30);
        loadDataProduct();
        int y = 30;
        int verticalGap = 10;
//        txtAreaBillDetail.setBounds(10, y, 369, 160); // Đ?ặt vị trí và kích thước cho JTextArea

        lblMaHoaDon.setBounds(10, y, 369, 20);
        lblTxtMaHoaDon.setBounds(190, y, 369, 20);
        y += 20 + verticalGap;
        lblThoiGian.setBounds(10, y, 369, 20);
        lblTxtThoiGian.setBounds(190, y, 369, 20);
        y += 20 + verticalGap;
        lblNhanVien.setBounds(10, y, 369, 20);
        lblTxtNhanVien.setBounds(190, y, 369, 20);
        y += 20 + verticalGap;
        lblKhachHang.setBounds(10, y, 369, 20);
        lblTxtKhachHang.setBounds(190, y, 369, 20);
        y += 20 + verticalGap;
        lblGiamGia.setBounds(10, y, 369, 20);
        lblTxtGiamGia.setBounds(190, y, 369, 20);
        y += 20 + verticalGap;
        lblKhachDaDua.setBounds(10, y, 369, 20);
        lblTxtKhachDaDua.setBounds(190, y, 369, 20);
        y += 20 + verticalGap;

        lblTongTien.setBounds(10, y, 369, 20);
        lblTxtTongTien.setBounds(190, y, 369, 20);

        pnRight.add(lblTongTien);
        pnRight.add(lblMaHoaDon);
        pnRight.add(lblThoiGian);
        pnRight.add(lblNhanVien);
        pnRight.add(lblKhachHang);
        pnRight.add(lblGiamGia);
        pnRight.add(lblKhachDaDua);

        pnRight.add(lblTxtMaHoaDon);
        pnRight.add(lblTxtThoiGian);
        pnRight.add(lblTxtNhanVien);
        pnRight.add(lblTxtKhachHang);
        pnRight.add(lblTxtGiamGia);
        pnRight.add(lblTxtKhachDaDua);
        pnRight.add(lblTxtTongTien);

        pnRight.add(btnExportBillExcel);

        pnRight.add(txtAreaBillDetail);
        pnRight.add(cthd);

        add(pnLeft_Bottom);
        add(pnLeft);
        add(pnMain);
        add(pnRight);

        loadData();

        table.getSelectionModel().addListSelectionListener(this);
        chkFullTime.addItemListener(this);
        chkAnotherChoice.addItemListener(this);
        dateChooser.addPropertyChangeListener(this);
        btnRefresh.addActionListener(this);
    }

    public void loadDataProduct() {
        tableModel1.setRowCount(0);
        controller.loadDataProduct().forEach(product -> {
            Object[] rowData = new Object[]{
                    product[0],
                    product[1],
                    product[2],
                    product[3],
                    product[4]
            };
            tableModel1.addRow(rowData);
        });
    }

    public void calculateTotalPayment() {
        int totalPayment = 0;
        int totalPaymentCustomer = 0;

        for (int i = 0; i < tableModel.getRowCount(); i++) {
            double totalForRow = Double.parseDouble(tableModel.getValueAt(i, 6).toString());
            double paymentCustomer = Double.parseDouble(tableModel.getValueAt(i, 5).toString());

            totalPayment += totalForRow;
            totalPaymentCustomer += paymentCustomer;
        }
        Object[] totalRow = new Object[]{
                "",
                "",
                "",
                "",
                "",
                "<html><b>" + totalPaymentCustomer + "</b></html>",
                "<html><b>" + totalPayment + "</b></html>"
        };
        tableModel.insertRow(0, totalRow);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BillsManagement view = new BillsManagement();
            view.setVisible(true);
        });
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                Object maHoaDonObj = table.getValueAt(selectedRow, 0);
                Object thoiGianObj = table.getValueAt(selectedRow, 1);
                Object nhanVienObj = table.getValueAt(selectedRow, 2);
                Object khachHangObj = table.getValueAt(selectedRow, 3);
                Object giamGiaObj = table.getValueAt(selectedRow, 4);
                Object khachDaDuaObj = table.getValueAt(selectedRow, 5);
                Object tongTienObj = table.getValueAt(selectedRow, 6);


                String maHoaDon = maHoaDonObj != null ? maHoaDonObj.toString() : "";
                String thoiGian = thoiGianObj != null ? thoiGianObj.toString() : "";
                String nhanVien = nhanVienObj != null ? nhanVienObj.toString() : "";
                String khachHang = khachHangObj != null ? khachHangObj.toString() : "";
                String giamGia = giamGiaObj != null ? giamGiaObj.toString() : "";
                String khachDaDua = khachDaDuaObj != null ? khachDaDuaObj.toString() : "";
                String tongTien = tongTienObj != null ? tongTienObj.toString() : "";

                lblTxtMaHoaDon.setText(maHoaDon);
                lblTxtThoiGian.setText(thoiGian);
                lblTxtNhanVien.setText(nhanVien);
                lblTxtKhachHang.setText(khachHang);
                lblTxtGiamGia.setText(giamGia);
                lblTxtKhachDaDua.setText(khachDaDua);
                lblTxtTongTien.setText(tongTien);


            }
        }
    }


    public void loadData() {
        // Load data from database
        tableModel.setRowCount(0);
        controller.getAllBill().forEach(bill -> {
            Object[] rowData = new Object[]{
                    bill[0],
                    bill[1],
                    bill[2],
                    bill[3],
                    bill[4],
                    bill[5],
                    bill[6]
            };
            tableModel.addRow(rowData);
        });
        calculateTotalPayment();
    }


    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == chkFullTime) {
            if (chkFullTime.isSelected()) {
                chkAnotherChoice.setSelected(false);
                dateChooser.setEnabled(false);
//                System.out.println("Full time");
            } else {
                dateChooser.setEnabled(true);
            }
        } else if (e.getSource() == chkAnotherChoice) {
            if (chkAnotherChoice.isSelected()) {
                cboSearchBillDate.setSelectedIndex(0);
                chkFullTime.setSelected(false);
                dateChooser.setEnabled(true);
                cboSearchBillDate.setEnabled(false);
//                System.out.println("Another choice");
            } else {
                cboSearchBillDate.setEnabled(true);
            }
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("date".equals(evt.getPropertyName())) {
            chkFullTime.setSelected(false);
            chkAnotherChoice.setSelected(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnExportExcel) {
            // Export excel
        } else if (e.getSource() == btnRefresh) {
            refreshForm();
            // Refresh
        } else if (e.getSource() == btnExportBillExcel) {
            // Export bill excel
        } else if (e.getSource() == cboSearchBillDate) {
            // Search bill by date
        }
    }

    private void refreshForm() {
        cboSearchBillDate.setSelectedIndex(0);
        chkFullTime.setSelected(false);
        chkAnotherChoice.setSelected(true);
        dateChooser.setDate(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        txtGetSearchBill.setText("");
        getTxtGetSearchProduct.setText("");
        txtGetSearchBill.requestFocus();

    }
}
