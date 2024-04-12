package views;

import controller.MainController;
import models.ProductType;
import models.Supplier;
import util.DialogUtils;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EventListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class SupplierView extends JPanel implements ActionListener, MouseListener, KeyListener, EventListener {
    private JPanel pnMain;
    private JPanel pnHeader, pnTitle;
    private JPanel pnCener;
    private JLabel lblTitle;
    private JPanel pnMainThongTin, pnLoaiThongTin, pnChucNang;
    private JLabel lblIdLoaiSanPham;
    private JLabel lblTenLoaiSanPham;
    private JLabel lblTuKhoa;
    private JTextField txtIdLoaiSanPham;
    private JTextField txtTenLoaiSanPham;
    private JTextField txtTimKiem;
    private JButton btnThem;
    private JButton btnCapNhat;
    private JButton btnXoa;
    private JButton btnLamMoi;
    private JButton btnTimKiem;
    private JPanel pnSouth, pnSouthNorth, pnSouthBottom, pnDanhMuc;
    private JTable tableSP;
    private DefaultTableModel modelSP;
    private JLabel lblDiaChi;
    private JLabel lblSoDienThoai;
    private JTextField txtDiaChi;
    private JTextField txtSoDienThoai;
    private JButton btnXemTatCa;
    private MainController mainController;
    private Timer timer;

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                Frame frame = new Frame();
//                frame.add(new SupplierView());
//                frame.setVisible(true);
//                frame.setSize(1000, 800);
//                frame.setLocationRelativeTo(null);
//                frame.addWindowListener(new WindowAdapter() {
//                    @Override
//                    public void windowClosing(WindowEvent e) {
//                        super.windowClosing(e);
//                        System.exit(0);
//                    }
//                });
//            }
//        });
//    }

    public SupplierView() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateIdSupplier();
            }
        });
        timer.start();
        mainController = new MainController();
        setLayout(new BorderLayout());
        pnMain = new JPanel(new BorderLayout(8, 6));

        pnHeader = new JPanel();
        pnHeader.add(lblTitle = new JLabel("Quản Lý Nhà Cung Cấp"));
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblTitle.setForeground(new Color(26, 102, 227));
//		pnHeader.setBackground(new Color(208, 225, 253));

        // layout thong tin
        pnMainThongTin = new JPanel(new BorderLayout());
        pnMainThongTin.setBorder(BorderFactory.createTitledBorder("Thông tin nhà cung cấp"));

        pnLoaiThongTin = new JPanel(new GridLayout(2, 4, 10, 10));

        lblIdLoaiSanPham = new JLabel("Mã nhà cung cấp:");
        txtIdLoaiSanPham = new JTextField(20);
        txtIdLoaiSanPham.setEditable(false);
        txtIdLoaiSanPham.setPreferredSize(new Dimension(150, 30));

        lblTenLoaiSanPham = new JLabel("Tên nhà cung cấp:");
        txtTenLoaiSanPham = new JTextField(20);
        txtTenLoaiSanPham.setPreferredSize(new Dimension(150, 30));

        lblDiaChi = new JLabel("Địa chỉ:");
        txtDiaChi = new JTextField(20);
        txtDiaChi.setPreferredSize(new Dimension(150, 30));

        lblSoDienThoai = new JLabel("Số điện thoại:");
        txtSoDienThoai = new JTextField(20);
        txtSoDienThoai.setPreferredSize(new Dimension(150, 30));

        Insets labelInsets = new Insets(0, 60, 0, 10);
//        lblIdLoaiSanPham.setBorder(new EmptyBorder(labelInsets));
//        lblTenLoaiSanPham.setBorder(new EmptyBorder(labelInsets));
//        lblDiaChi.setBorder(new );
        Dimension labelSize = new Dimension(200, 30);
        lblIdLoaiSanPham.setPreferredSize(labelSize);
        lblDiaChi.setPreferredSize(labelSize);
        lblSoDienThoai.setPreferredSize(labelSize);
        lblTenLoaiSanPham.setPreferredSize(labelSize);
//		lblTenLoaiSanPham.setPreferredSize(labelSize);

        // Sử dụng FlowLayout cho từng dòng để giữ các thành phần gần nhau
        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        idPanel.add(lblIdLoaiSanPham);
        idPanel.add(txtIdLoaiSanPham);

        JPanel tenPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        tenPanel.add(lblTenLoaiSanPham);
        tenPanel.add(txtTenLoaiSanPham);

        JPanel diaChiPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        diaChiPanel.add(lblDiaChi);
        diaChiPanel.add(txtDiaChi);

        JPanel soDienThoaiPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        soDienThoaiPanel.add(lblSoDienThoai);
        soDienThoaiPanel.add(txtSoDienThoai);

        pnLoaiThongTin.add(idPanel);
        pnLoaiThongTin.add(tenPanel);
        pnLoaiThongTin.add(diaChiPanel);
        pnLoaiThongTin.add(soDienThoaiPanel);

        pnChucNang = new JPanel(new FlowLayout(5));
        btnThem = new JButton("Thêm");
        btnCapNhat = new JButton("Cập nhật");
        btnLamMoi = new JButton("Làm mới");
        btnXoa = new JButton("Xóa");
        ImageIcon iconThem = new ImageIcon(getClass().getResource("/icons/add.png"));
        ImageIcon iconCapNhat = new ImageIcon(getClass().getResource("/icons/capnhat.png"));
        ImageIcon iconLamMoi = new ImageIcon(getClass().getResource("/icons/lammoi.png"));
        ImageIcon iconXoa = new ImageIcon(getClass().getResource("/icons/xoa.png"));
        btnCapNhat.setIcon(iconCapNhat);
        btnThem.setIcon(iconThem);
        btnLamMoi.setIcon(iconLamMoi);
        btnXoa.setIcon(iconXoa);

        pnChucNang.add(btnThem);
        pnChucNang.add(btnCapNhat);
//		pnChucNang.add(btnXoa);
        pnChucNang.add(btnLamMoi);

        Insets btnInsert = new Insets(50, 110, 0, 0);
        pnChucNang.setBorder(new EmptyBorder(btnInsert));

        // phan top
        pnSouth = new JPanel(new BorderLayout());
        pnSouthNorth = new JPanel(new FlowLayout(5));
        lblTuKhoa = new JLabel("Từ khóa:");
        txtTimKiem = new JTextField(20);
        btnXemTatCa = new JButton("Xem tất cả");
        pnSouthNorth.add(lblTuKhoa);
        pnSouthNorth.add(txtTimKiem);
        pnSouthNorth.add(btnXemTatCa);

        // phan bottom
        pnSouthBottom = new JPanel(new BorderLayout());
        pnSouthBottom = new JPanel(new BorderLayout());
        pnSouthBottom.setBorder(BorderFactory.createTitledBorder("Danh mục"));
        modelSP = new DefaultTableModel();
        tableSP = new JTable();
        modelSP.addColumn("Mã Nhà Cung Cấp");
        modelSP.addColumn("Tên Nhà Cung Cấp");
        modelSP.addColumn("Địa Chỉ");
        modelSP.addColumn("Số Điện Thoại");
        tableSP.setModel(modelSP);
        JScrollPane scrollPane = new JScrollPane(tableSP);
        pnSouthBottom.add(scrollPane);

        pnSouth.add(pnSouthNorth, BorderLayout.NORTH);
        pnSouth.add(pnSouthBottom, BorderLayout.CENTER);

        pnMainThongTin.add(pnLoaiThongTin, BorderLayout.NORTH);
        pnMainThongTin.add(pnChucNang, BorderLayout.CENTER);

        pnMain.add(pnHeader, BorderLayout.NORTH);
        pnMain.add(pnMainThongTin, BorderLayout.CENTER);
        pnMain.add(pnSouth, BorderLayout.SOUTH);
        this.add(pnMain);

        btnThem.addActionListener(this);
        btnLamMoi.addActionListener(this);
        btnCapNhat.addActionListener(this);
//		btnXoa.addActionListener(this);
        tableSP.addMouseListener(this);
        txtTimKiem.addKeyListener(this);
        btnXemTatCa.addActionListener(this);
        loadData();
        this.setFocusable(true);
        this.requestFocusInWindow();
        tableSP.requestFocus();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(btnThem)) {
            addSupplier();
        } else if (o.equals(btnLamMoi)) {
            refreshForm();
        } else if (o.equals(btnCapNhat)) {
            updateSupplier();
        } else if (o.equals(btnXoa)) {
            deleteSupplier();
        } else if (o.equals(btnXemTatCa)) {
            refreshForm();
            loadData();
        }

    }

    private void loadData() {
        modelSP.setRowCount(0);
        java.util.List<Supplier> suppliers = mainController.getAllSuppliers();

        if (suppliers != null) {
            for (Supplier supplier : suppliers) {
                Object[] rowData = {supplier.getSupplierId(), supplier.getSupplierName(), supplier.getAddress(), supplier.getPhoneNumber()};
                modelSP.addRow(rowData);
            }
        } else {
            DialogUtils.showErrorMessage(this, "Error loading data");
        }
    }

    private void updateIdSupplier() {
        if (tableSP.getSelectedRow() == -1) {
            Date currentTime = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String formattedTime = "SL" + sdf.format(currentTime);
            txtIdLoaiSanPham.setText(formattedTime);
        }
    }

    private void deleteSupplier() {
        int row = tableSP.getSelectedRow();
        if (row == -1) {
            DialogUtils.showErrorMessage(this, "Please select a row to delete");
        } else {
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this supplier's information?", "Warning",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                String idSupplier = txtIdLoaiSanPham.getText();
                boolean isSuccess = mainController.deleteSupplier(idSupplier);
                if (isSuccess) {
                    JOptionPane.showMessageDialog(this, "Supplier information deleted successfully");
                    loadData();
                    refreshForm();
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to delete supplier information");
                }
            }
        }
    }


    private void updateSupplier() {
        int row = tableSP.getSelectedRow();
        if (row >= 0) {
            int update = JOptionPane.showConfirmDialog(this, "Are you sure you want to update this supplier's information?", "Warning",
                    JOptionPane.YES_NO_OPTION);
            if (update == JOptionPane.YES_OPTION) {
                String idSupplier = txtIdLoaiSanPham.getText().trim();
                String supplierName = txtTenLoaiSanPham.getText().trim();
                String address = txtDiaChi.getText().trim();
                String phoneNumber = txtSoDienThoai.getText().trim();
                Supplier supplier = new Supplier(idSupplier, address, phoneNumber, supplierName);
                boolean isSuccess = mainController.updateSupplier(supplier);
                if (isSuccess) {
                    JOptionPane.showMessageDialog(this, "Supplier information updated successfully");
                    loadData();
                    refreshForm();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Update failed");
            }
        } else {
            DialogUtils.showErrorMessage(this, "Please select a row to update");
        }
    }

    private void refreshForm() {
        txtTenLoaiSanPham.setText("");
        txtSoDienThoai.setText("");
        txtTimKiem.setText("");
        txtDiaChi.setText("");
        txtTenLoaiSanPham.selectAll();
        txtTenLoaiSanPham.requestFocus();
        tableSP.clearSelection();
        updateIdSupplier();

    }

    private void addSupplier() {
        String supplierId = txtIdLoaiSanPham.getText().trim();
        String supplierName = txtTenLoaiSanPham.getText().trim();
        String address = txtDiaChi.getText().trim();
        String phoneNumber = txtSoDienThoai.getText().trim();

        if (mainController.checkSupplierId(supplierId)) {
            DialogUtils.showErrorMessage(this, "Supplier ID already exists");
            return;
        }

//        if (validateFields()) {
        try {
            Supplier supplier = new Supplier(supplierId, address, phoneNumber, supplierName);
            boolean isSuccess = mainController.addSupplier(supplier);
            if (isSuccess) {
                modelSP.addRow(new Object[]{supplierId, address, phoneNumber, supplierName});
                loadData();
                refreshForm();
                DialogUtils.showSuccessMessage(this, "Supplier added successfully");
            } else {
                DialogUtils.showErrorMessage(this, "Error adding supplier");
            }
        } catch (Exception e) {
            DialogUtils.showErrorMessage(this, "Error adding supplier");
            e.printStackTrace();
        }
//        }
    }

//    private boolean validataField(JTextField textField, String regex, String errorMessage) {
//        String fieldValue = textField.getText().trim();
//        if (fieldValue.isEmpty()) {
//            showErrorDialog("Vui lòng nhập giá trị cho " + textField.getName() + "!");
//            textField.requestFocus();
//            return false;
//        }
//
//        if (!fieldValue.matches(regex)) {
//            showErrorDialog(errorMessage);
//            textField.requestFocus();
//            textField.selectAll();
//            return false;
//        }
//        return true;
//    }


//    private boolean validataFields() {
//        return validataField(txtTenLoaiSanPham, "^[\\p{L}\\s]+$",
//                "Tên nhà cung cấp không hợp lệ. Phải bắt đầu bằng chữ cái, không chấp nhận ký tự đặc biệt.")
//                && validataField(txtSoDienThoai, "^(03|04|05|06|07|08|09)\\d{8}$",
//                "Số điện thoại không hợp lệ. Phải bắt đầu bằng 03, 04, 05, 06 , 07, 08 hoặc 09 và có 10 chữ số.")
//                && validataField(txtDiaChi, "^[^,\\p{P} ]+[\\p{L}\\p{M}0-9,.]*(\\s[^,\\p{P} ]+[\\p{L}\\p{M}0-9,.]*)*[^,\\p{P} ]$",
//                "Địa chỉ không được chứa kí tự đặc biệt trừ dấu phẩy và không bắt đầu hoặc kết thúc bằng dấu phẩy, kí tự đặc biệt.");
//    }


    @Override
    public void mouseClicked(MouseEvent e) {
        int row = tableSP.getSelectedRow();
        if (row >= 0) {
            txtIdLoaiSanPham.setText(modelSP.getValueAt(row, 0).toString());
            txtTenLoaiSanPham.setText(modelSP.getValueAt(row, 1).toString());
            txtDiaChi.setText(modelSP.getValueAt(row, 2).toString());
            txtSoDienThoai.setText(modelSP.getValueAt(row, 3).toString());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyReleased(KeyEvent e) {
        SwingUtilities.invokeLater(() -> {
            Object o = e.getSource();
            if (o.equals(txtTimKiem)) {
                DefaultTableModel model = (DefaultTableModel) tableSP.getModel();
                TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model);
                tableSP.setRowSorter(tr);
                tr.setRowFilter(RowFilter.regexFilter("(?i)" + txtTimKiem.getText().trim(), 1, 3));
            }
        });
    }
}
