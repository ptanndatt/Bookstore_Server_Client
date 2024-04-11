package views;

import controller.MainController;
import models.Category;
import models.ProductType;
import util.DialogUtils;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class ProductTypeView extends JPanel implements ActionListener, KeyListener, MouseListener {
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
    private JButton btnXemTatCa;
    private Timer timer;
    private MainController mainController;

    public ProductTypeView() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateIdProductType();
            }
        });
        timer.start();
        setLayout(new BorderLayout());
        mainController = new MainController();
        pnMain = new JPanel(new BorderLayout(8, 6));

        pnHeader = new JPanel();
        pnHeader.add(lblTitle = new JLabel("Quản Lý Loại Sản Phẩm"));
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblTitle.setForeground(new Color(26, 102, 227));

        // layout thong tin
        pnMainThongTin = new JPanel(new BorderLayout());
        pnMainThongTin.setBorder(BorderFactory.createTitledBorder("Thông tin sản phẩm"));

        pnLoaiThongTin = new JPanel(new GridLayout(2, 2, 10, 10));

        lblIdLoaiSanPham = new JLabel("Mã loại sản phẩm:");
        txtIdLoaiSanPham = new JTextField(20);
        txtIdLoaiSanPham.setEditable(false);
        txtIdLoaiSanPham.setPreferredSize(new Dimension(150, 30));

        lblTenLoaiSanPham = new JLabel("Tên loại sản phẩm:");
        txtTenLoaiSanPham = new JTextField(20);
        txtTenLoaiSanPham.setPreferredSize(new Dimension(150, 30));

        Insets labelInsets = new Insets(0, 60, 0, 10);
        lblIdLoaiSanPham.setBorder(new EmptyBorder(labelInsets));
        lblTenLoaiSanPham.setBorder(new EmptyBorder(labelInsets));
        Dimension labelSize = new Dimension(200, 30);
        lblIdLoaiSanPham.setPreferredSize(labelSize);
        lblTenLoaiSanPham.setPreferredSize(labelSize);

        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idPanel.add(lblIdLoaiSanPham);
        idPanel.add(txtIdLoaiSanPham);

        JPanel tenPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        tenPanel.add(lblTenLoaiSanPham);
        tenPanel.add(txtTenLoaiSanPham);

        pnLoaiThongTin.add(idPanel);
        pnLoaiThongTin.add(tenPanel);

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

        Insets btnInsert = new Insets(50, 60, 0, 0);
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
        modelSP.addColumn("Mã Loại Sản Phẩm");
        modelSP.addColumn("Tên Loại Sản Phẩm");
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
        btnXoa.addActionListener(this);
        btnXemTatCa.addActionListener(this);
        tableSP.addMouseListener(this);
        txtTimKiem.addKeyListener(this);
        loadData();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(btnThem)) {
            addProductType();
        } else if (o.equals(btnLamMoi)) {
            refreshForm();
        } else if (o.equals(btnCapNhat)) {
            updateProductType();
        } else if (o.equals(btnXoa)) {
            deleteProductType();
        } else if (o.equals(btnXemTatCa)) {
            refreshForm();
            loadData();
        }
    }

    private void loadData() {
        modelSP.setRowCount(0);
        java.util.List<ProductType> productTypes = mainController.getAllProductType();

        if (productTypes != null) {
            for (ProductType productType : productTypes) {
                Object[] rowData = {productType.getProductTypeId(), productType.getProductTypeName()};
                modelSP.addRow(rowData);
            }
        } else {
            DialogUtils.showErrorMessage(this, "Error loading data");
        }
    }

    private void updateIdProductType() {
        if (tableSP.getSelectedRow() == -1) {
            Date currentTime = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String formattedTime = "PT" + sdf.format(currentTime);
            txtIdLoaiSanPham.setText(formattedTime);
        }
    }

    private void deleteProductType() {
        int row = tableSP.getSelectedRow();
        if (row == -1) {
            DialogUtils.showErrorMessage(this, "Please select a row to delete");
        } else {
            int confirmDialogResult = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this item?", "Warning",
                    JOptionPane.YES_NO_OPTION);
            if (confirmDialogResult == JOptionPane.YES_OPTION) {
                String idProductType = txtIdLoaiSanPham.getText();
                if (mainController.deleteProductType(idProductType)) {
                    DialogUtils.showSuccessMessage(this, "Item deleted successfully");
                    loadData();
                    refreshForm();
                } else {
                    DialogUtils.showErrorMessage(this, "Failed to delete item");
                }
            }
        }
    }

    private void updateProductType() {
        int row = tableSP.getSelectedRow();
        if (row >= 0) {
            int update = JOptionPane.showConfirmDialog(this, "Are you sure you want to update this information?", "Warning",
                    JOptionPane.YES_NO_OPTION);
            if (update == JOptionPane.YES_OPTION) {
//                if (validateFields()) {
                String idProductType = txtIdLoaiSanPham.getText().trim();
                String productName = txtTenLoaiSanPham.getText().trim();
                ProductType productType = new ProductType(idProductType, productName);
                if (mainController.updateProductType(productType)) {
                    DialogUtils.showSuccessMessage(this, "Update successful");
                    refreshForm();
                    loadData();
                } else {
                    DialogUtils.showErrorMessage(this, "Update failed");
                }
//                }
            } else {
                DialogUtils.showErrorMessage(this, "Update failed");
            }
        } else {
            DialogUtils.showErrorMessage(this, "Please select a row");
        }
    }

    private void refreshForm() {
        txtTenLoaiSanPham.setText("");
        txtTimKiem.setText("");
        txtTenLoaiSanPham.selectAll();
        txtTenLoaiSanPham.requestFocus();
        tableSP.clearSelection();
        updateIdProductType();
    }

    private boolean validataField(JTextField textField, String regex, String errorMessage) {
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
        return true;
    }


    private boolean validataFields() {
        return validataField(txtTenLoaiSanPham, "^[\\p{L}\\s]+$",
                "Tên Loại Sản Phẩm không hợp lệ. Phải bắt đầu bằng chữ cái, không chấp nhận ký tự đặc biệt.");
    }

    private void addProductType() {
        String idProductType = txtIdLoaiSanPham.getText();
        String productName = txtTenLoaiSanPham.getText();
        ProductType productType = new ProductType(idProductType, productName);

        if (mainController.checkProductTypeExist(idProductType)) {
            DialogUtils.showErrorMessage(this, "Duplicate product type ID. Please choose a different ID.");
        } else {
//            if (validateFields()) {
            if (mainController.addProductType(productType)) {
                modelSP.addRow(new Object[]{idProductType, productName});
                DialogUtils.showSuccessMessage(this, "Product type added successfully");
                loadData();
                refreshForm();
            } else {
                DialogUtils.showErrorMessage(this, "Error adding product type");
            }
        }
//        }
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
                tr.setRowFilter(RowFilter.regexFilter("(?i)" + txtTimKiem.getText().trim(), 1));
            }
        });

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = tableSP.getSelectedRow();
        if (row >= 0) {
            txtIdLoaiSanPham.setText(modelSP.getValueAt(row, 0).toString());
            txtTenLoaiSanPham.setText(modelSP.getValueAt(row, 1).toString());
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

}