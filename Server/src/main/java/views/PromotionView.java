package views;

import com.toedter.calendar.JDateChooser;
import controller.MainController;
import models.Book;
import models.Product;
import models.Promotion;
import util.GeneratorIDAuto;
import util.SaleTypeEnum;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PromotionView extends JPanel implements ActionListener, MouseListener, KeyListener {
    private JLabel lbID;
    private JLabel lbTenKM;
    private JLabel lbLoai;
    private JLabel lbNgayBatDauKM;
    private JLabel lbNgayKetThucKM;
    private JLabel lbTimKiemKM;
    private JTextField txtTimKiemKM;
    private JLabel lbTimKiemSPKM;
    private JTextField txtTimKiemSPKM;
    private JLabel lbTimKiemSKM;
    private JTextField txtTimKiemSKM;
    private JLabel lbTimKiemSP;
    private JLabel lbTimKiemSach;
    private JTextField txtTimKiemSP;
    private JTextField txtTimKiemSach;
    private JTextField txtID;
    private JTextField txtTen;
    private JButton btnChonSP;
    private JButton btnChonSach;
    private JDateChooser chooserngayBatDau;
    private JDateChooser chooserngayKetThuc;
    private JComboBox<SaleTypeEnum> cbLoai;
    private JButton btnThem;
    private JButton btnCapNhat;
    private JButton btnXoaKM;
    private JButton btnLamMoi;
    private JTable tblSP;
    private DefaultTableModel modelSP2;
    private JTable tblSach;
    private DefaultTableModel modelSach;

    private DefaultTableModel modelKM;
    private JTable tableKM;
    private DefaultTableModel modelSP;
    private JTable tableSP;
    private DefaultTableModel modelSPKM;
    private JTable tableSPKM;
    private SimpleDateFormat dfNgay;
    private JButton btnMoTbSP;
    private JButton btnMoTbSach;
    private JButton btnDongSP;
    private JButton btnDongSach;
    private JButton btnXoaSPKM;
    private JButton btnXoaSKM;
    private JPanel pnSP;
    private JFrame FrameSP;
    private JDialog dlogSP;
    private JFrame FrameSach;
    private JDialog dlogSach;
    private NumberFormat vietnameseFormat;
    private GeneratorIDAuto autoID;
    private MainController mainController;


    public PromotionView() {
        setLayout(new GridBagLayout());
        mainController=new MainController();
        vietnameseFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        autoID = new GeneratorIDAuto();
        dfNgay = new SimpleDateFormat("dd/MM/yyyy");
        JLabel lbTieuDe = new JLabel("CHƯƠNG TRÌNH KHUYẾN MÃI");
        lbTieuDe.setFont(new Font("Tahoma", Font.BOLD, 25));
        lbTieuDe.setForeground(new Color(26, 102, 227));

        cbLoai = new JComboBox<>();
        cbLoai.addItem(SaleTypeEnum.Giam_10);
        cbLoai.addItem(SaleTypeEnum.Giam_20);
        cbLoai.addItem(SaleTypeEnum.Giam_30);

        chooserngayBatDau = new JDateChooser();
        chooserngayBatDau.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        chooserngayBatDau.setBounds(100, 310, 200, 40);
        chooserngayBatDau.setDateFormatString("dd/MM/yyyy");
        chooserngayBatDau.setBorder(new LineBorder(new Color(114, 23, 153), 1, true));
        chooserngayBatDau.setFont(new Font("SansSerif", Font.PLAIN, 15));
        chooserngayBatDau.getCalendarButton().setPreferredSize(new Dimension(20, 24));
        chooserngayBatDau.getCalendarButton().setBackground(new Color(102, 0, 153));
        chooserngayBatDau.getCalendarButton().setToolTipText("Chọn ngày bắt đầu");

        chooserngayKetThuc = new JDateChooser();
        chooserngayKetThuc.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        chooserngayKetThuc.setBounds(100, 310, 200, 40);
        chooserngayKetThuc.setDateFormatString("dd/MM/yyyy");
        chooserngayKetThuc.setBorder(new LineBorder(new Color(114, 23, 153), 1, true));
        chooserngayKetThuc.setFont(new Font("SansSerif", Font.PLAIN, 15));
        chooserngayKetThuc.getCalendarButton().setPreferredSize(new Dimension(20, 24));
        chooserngayKetThuc.getCalendarButton().setBackground(new Color(102, 0, 153));
        chooserngayKetThuc.getCalendarButton().setToolTipText("Chọn ngày kết thúc");
        lbID = new JLabel("ID khuyến mãi:");
        txtID = new JTextField();
        lbTenKM = new JLabel("Tên khuyến mãi:");
        txtTen = new JTextField();
        lbLoai = new JLabel("Loại khuyến mãi:");
        lbNgayBatDauKM = new JLabel("Ngày bắt đầu:");
        lbNgayKetThucKM = new JLabel("Ngày kết thúc:");
        lbTimKiemSP = new JLabel("Tìm kiếm sản phẩm");
        lbTimKiemSach = new JLabel("Tìm kiếm sách");
        txtTimKiemSP = new JTextField();

        ImageIcon iconThem = new ImageIcon(getClass().getResource("/icons/add.png"));
        ImageIcon iconCapNhat = new ImageIcon(getClass().getResource("/icons/capnhat.png"));
        ImageIcon iconLamMoi = new ImageIcon(getClass().getResource("/icons/lammoi.png"));
        ImageIcon iconMoTBSP = new ImageIcon(getClass().getResource("/icons/product.png"));
        ImageIcon iconMoTBSach = new ImageIcon(getClass().getResource("/icons/book.png"));
        ImageIcon iconDong = new ImageIcon(getClass().getResource("/icons/close.png"));
        ImageIcon iconXoa = new ImageIcon(getClass().getResource("/icons/xoa.png"));

        btnCapNhat = new JButton("CẬP NHẬT");
        btnCapNhat.setIcon(iconCapNhat);
        btnThem = new JButton("THÊM KHUYẾN MÃI");
        btnThem.setIcon(iconThem);
        btnLamMoi = new JButton("LÀM MỚI");
        btnLamMoi.setIcon(iconLamMoi);
        btnXoaKM = new JButton("XÓA KHUYẾN MÃI");
        btnXoaKM.setIcon(iconXoa);
        lbTimKiemSPKM = new JLabel("Tìm kiếm sản phẩm khuyến mãi:");
        txtTimKiemSPKM = new JTextField();
        lbTimKiemSKM = new JLabel("Tìm kiếm sách khuyến mãi");
        txtTimKiemSKM = new JTextField();
        lbTimKiemKM = new JLabel("Tìm kiếm khuyến mãi:");
        txtTimKiemKM = new JTextField();

        txtTimKiemSach = new JTextField();
        btnMoTbSP = new JButton("CHỌN SẢN PHẨM");
        btnMoTbSP.setIcon(iconMoTBSP);
        btnMoTbSach = new JButton("CHỌN SÁCH");
        btnMoTbSach.setIcon(iconMoTBSach);
        btnDongSP = new JButton("ĐÓNG");
        btnDongSP.setIcon(iconDong);
        btnDongSach = new JButton("ĐÓNG");
        btnDongSach.setIcon(iconDong);
        btnXoaSPKM = new JButton("XÓA");
        btnXoaSKM = new JButton("XÓA");
        JPanel pnKM = new JPanel(new GridLayout(5, 1, 10, 10));
        JPanel pnHeaderLeft = new JPanel(new BorderLayout());

        JPanel pnTitleLeft = new JPanel();

        JPanel pnChucNang = new JPanel();
        pnTitleLeft.add(lbTieuDe);

        pnKM.add(lbID);
        pnKM.add(txtID);
        txtID.setEditable(false);
        pnKM.add(lbTenKM);
        pnKM.add(txtTen);
        pnKM.add(lbLoai);
        pnKM.add(cbLoai);
        pnKM.add(lbNgayBatDauKM);
        pnKM.add(chooserngayBatDau);
        pnKM.add(lbNgayKetThucKM);
        pnKM.add(chooserngayKetThuc);
        pnHeaderLeft.add(pnTitleLeft, BorderLayout.NORTH);
        pnHeaderLeft.add(pnKM, BorderLayout.CENTER);

        pnKM.setBorder(BorderFactory.createTitledBorder("Thông tin khuyến mãi"));

        pnChucNang.add(btnThem);
        pnChucNang.add(btnCapNhat);
        pnChucNang.add(btnXoaKM);
        pnChucNang.add(btnLamMoi);

        pnHeaderLeft.add(pnChucNang, BorderLayout.SOUTH);

        JPanel pnTimKiemSP = new JPanel(new GridLayout(1, 4, 10, 10));
        pnTimKiemSP.add(lbTimKiemSPKM);
        pnTimKiemSP.add(txtTimKiemSPKM);
        pnTimKiemSP.add(btnXoaSPKM);


        JPanel pnTimKiemKM = new JPanel(new GridLayout(1, 4, 10, 10));
        pnTimKiemKM.add(btnMoTbSP);
        pnTimKiemKM.add(btnMoTbSach);
        pnTimKiemKM.add(lbTimKiemKM);
        pnTimKiemKM.add(txtTimKiemKM);

    //Bảng khuyến mãi
        modelKM = new DefaultTableModel();
        tableKM = new JTable();
        modelKM.addColumn("ID khuyến mãi");
        modelKM.addColumn("Tên KM");
        modelKM.addColumn("Loại");
        modelKM.addColumn("Ngày bắt đầu");
        modelKM.addColumn("Ngày kết thúc");
        tableKM.setModel(modelKM);
        JScrollPane scrollPane1 = new JScrollPane(tableKM);

        JPanel pntbKM = new JPanel(new BorderLayout());
        pntbKM.setBorder(BorderFactory.createTitledBorder("Khuyến mãi"));
        pntbKM.add(pnTimKiemKM, BorderLayout.NORTH);
        pntbKM.add(scrollPane1, BorderLayout.CENTER);
//Bảng sản phẩm khuyến mãi
        modelSPKM = new DefaultTableModel();
        tableSPKM = new JTable();
        modelSPKM.addColumn("Chương trình KM");
        modelSPKM.addColumn("ID sản phẩm");
        modelSPKM.addColumn("Tên sản phẩm");
        modelSPKM.addColumn("Giá bán");
        modelSPKM.addColumn("Giá KM");
        tableSPKM.setModel(modelSPKM);
        JScrollPane scrollPane2 = new JScrollPane(tableSP);
        JPanel pntbSP = new JPanel(new BorderLayout());
        pntbSP.add(pnTimKiemSP, BorderLayout.NORTH);
        pntbSP.add(scrollPane2, BorderLayout.CENTER);
        pntbSP.setBorder(BorderFactory.createTitledBorder("Sản phẩm khuyến mãi"));

//Tạo bảng chọn sản phẩm
        tblSP = new JTable();
        modelSP = new DefaultTableModel();
        modelSP.addColumn("ID sản phẩm");
        modelSP.addColumn("Tên sản phẩm");
        modelSP.addColumn("Giá bán");
        tblSP.setModel(modelSP);
        JScrollPane scrollTblKH = new JScrollPane(tblSP);
        btnChonSP = new JButton("ÁP DỤNG");
        JPanel TimKiemSP = new JPanel(new GridLayout(1, 2, 5, 5));
        JPanel FooterSP = new JPanel(new GridLayout(1, 4, 5, 5));
        FooterSP.add(btnChonSP);
        TimKiemSP.add(lbTimKiemSP);
        TimKiemSP.add(txtTimKiemSP);
        pnSP = new JPanel(new BorderLayout());
        pnSP.add(scrollTblKH, BorderLayout.CENTER);
        pnSP.add(TimKiemSP, BorderLayout.NORTH);
        pnSP.add(FooterSP, BorderLayout.SOUTH);
        FrameSP = new JFrame();
        dlogSP = new JDialog(dlogSP, "SẢN PHẨM", null);
        dlogSP.add(pnSP);
//Tảo bảng chọn sách
        tblSach = new JTable();
        modelSach = new DefaultTableModel();
        modelSach.addColumn("ID sách");
        modelSach.addColumn("Tên sách");
        modelSach.addColumn("Giá bán");
        tblSach.setModel(modelSach);
        JScrollPane scrollTblSach = new JScrollPane(tblSach);
        btnChonSach = new JButton("ÁP DỤNG");
        JPanel TimKiemSach = new JPanel(new GridLayout(1,2,5,5));
        JPanel FooterSach = new JPanel(new GridLayout(1,4,5,5));
        FooterSach.add(btnChonSach);

        TimKiemSach.add(lbTimKiemSach);
        TimKiemSach.add(txtTimKiemSach);
        JPanel pnSach = new JPanel(new BorderLayout());
        pnSach.add(scrollTblSach, BorderLayout.CENTER);
        pnSach.add(TimKiemSach, BorderLayout.NORTH);
        pnSach.add(FooterSach,BorderLayout.SOUTH);
        FrameSach=new JFrame();
        dlogSach= new JDialog( FrameSach, "SÁCH", null);
        dlogSach.add(pnSach);


        JPanel pnRigth = new JPanel();
        pnRigth.setLayout(new BorderLayout());
        JPanel pnLeft = new JPanel(new BorderLayout());
        pnRigth.add(pntbSP, BorderLayout.CENTER);
        pnLeft.add(pnHeaderLeft, BorderLayout.NORTH);
        pnLeft.add(pntbKM, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.4;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        add(pnLeft, gbc);


        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.6;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        add(pnRigth, gbc);

        txtID.setToolTipText("ID + Date + XXXX");
        txtTen.setToolTipText("Tên hợp lệ");
        chooserngayBatDau.setToolTipText("Trước ngày kết thúc");
        chooserngayBatDau.setDate(new java.util.Date());
        chooserngayKetThuc.setToolTipText("Sau ngày bắt đầu");
        chooserngayKetThuc.setDate(new java.util.Date());


        btnLamMoi.addActionListener(this);
        btnXoaKM.addActionListener(this);
        btnCapNhat.addActionListener(this);
        btnChonSP.addActionListener(this);
        btnThem.addActionListener(this);
        tableKM.addMouseListener(this);
        txtTimKiemKM.addKeyListener(this);
        txtTimKiemSPKM.addKeyListener(this);
        txtTimKiemSKM.addKeyListener(this);
        txtTimKiemSP.addKeyListener(this);
        txtTimKiemSach.addKeyListener(this);
        btnMoTbSP.addActionListener(this);
        btnMoTbSach.addActionListener(this);
        btnDongSP.addActionListener(this);
        btnDongSach.addActionListener(this);
        btnXoaSKM.addActionListener(this);
        btnXoaSPKM.addActionListener(this);
        txtTen.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                txtID.setText(autoID.autoID("S"));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
//        loadSPKM();
        loadData();
        LoadDataBook();
        LoadDataProduct();
//        loadSKM();
    }
    private void LoadDataProduct() {
        modelSP.setRowCount(0);
        for (Product product :mainController.getAllMerchandise()) {

            modelSP.addRow(new Object[] {product.getProductId(),product.getProductName(),vietnameseFormat.format(product.sellingPrice())});
        }
    }
    private void LoadDataBook() {
        modelSP.setRowCount(0);
        for (Book book :mainController.getAllBook()) {

            modelSP.addRow(new Object[] {book.getProductId(),book.getProductName(),vietnameseFormat.format(book.sellingPrice())});
        }
    }
    private void addBooktoPromotion() throws SQLException {
        // Lấy thông tin chương trình khuyến mãi đang được chọn
        int chonKM = tableKM.getSelectedRow();
        int chonSach = tblSach.getSelectedRow();

        if(chonKM<0 || chonSach<0) {
            JOptionPane.showMessageDialog(null,"Vui lòng chọn chương trình khuyến mãi và sách");
        }
        else {

                String idKM=(String)tableKM.getValueAt(chonKM,0);
                SaleTypeEnum loaiKM= (SaleTypeEnum) tableKM.getValueAt(chonKM, 2);
                // Lấy thông tin sản phẩm
                String id = (String) tblSach.getValueAt(chonSach, 0);
                NumberFormat format = NumberFormat.getCurrencyInstance(new java.util.Locale("vi", "VN"));
                String getGiaBan=tblSach.getValueAt(chonSach, 2).toString();
                Number number = null;
                try {
                    number = format.parse(getGiaBan);
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                double giaBan=number.doubleValue();

                String tenSP=(String) tblSach.getValueAt(chonSach, 1);
                // Tính giá bán mới sau khuyến mãi
                double giaKM = giaBan * (loaiKM.getValue() / 100.0);
                // Cập nhật giá bán mới trong bảng và cơ sở dữ liệu
                if(KiemTraSKM(idSP)) {
                    daoKM.ThemSachKM(idSP, idKM, tenSP, giaBan, giaKM);
                    daoKM.updateGiaKMSach(idSP, giaKM);
                    modelSKM.addRow(new Object[] {idKM,idSP,tenSP,vietnameseFormat.format(giaBan),"-"+vietnameseFormat.format(giaKM)});
                    dlogSach.setVisible(false);
                    JOptionPane.showMessageDialog(this,"Áp dụng khuyến mãi thành công");
                }

            }


        }
    }
    private void updatePromotion() {
        String id=modelKM.getValueAt(tableKM.getSelectedRow(), 0).toString();
        String ten = txtTen.getText();
        java.util.Date dateBatDau = chooserngayBatDau.getDate();
        Date ngayBD = new Date(dateBatDau.getYear(), dateBatDau.getMonth(), dateBatDau.getDate());
        java.util.Date dateKetThuc = chooserngayKetThuc.getDate();
        Date ngayKT = new Date(dateKetThuc.getYear(), dateKetThuc.getMonth(), dateKetThuc.getDate());
        SaleTypeEnum selectedValue = (SaleTypeEnum) cbLoai.getSelectedItem();
        String LoaiDescription=selectedValue.getDescription();
        Promotion promotion = new Promotion(id,ten,ngayBD,ngayKT,LoaiDescription);
        if(valiDate()){
            try {
                mainController.updatePromotion(promotion);
                loadData();
                JOptionPane.showMessageDialog(this, "Cập nhật thành công");
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
            }
        }

    }
    private void addPromotion() {
        String id = txtID.getText();
        String tenKM = txtTen.getText();
        java.util.Date dateBatDau = chooserngayBatDau.getDate();
        Date ngayBD = new Date(dateBatDau.getYear(), dateBatDau.getMonth(), dateBatDau.getDate());
        java.util.Date dateKetThuc = chooserngayKetThuc.getDate();
        Date ngayKT = new Date(dateKetThuc.getYear(), dateKetThuc.getMonth(), dateKetThuc.getDate());
        SaleTypeEnum selectedValue = (SaleTypeEnum) cbLoai.getSelectedItem();
        String LoaiDescription=selectedValue.getDescription();
        if(valiDate()){
            Promotion promotion = new Promotion(id,tenKM,ngayBD,ngayKT,LoaiDescription);
            mainController.addPromotion(promotion);
            modelKM.addRow(new Object[] {promotion.getPromotionId(),promotion.getPromotionName(),promotion.getPromotionDiscount(),dfNgay.format(promotion.getPromotionStartDate()),dfNgay.format(promotion.getPromotionEndDate())});
            reload();
        }


    }
    private void deletePromotion() {
        int row = tableKM.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Phải chọn dòng cần xoá");
        } else {
            try {
                int HopThoai = JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá dòng này không?", "Cảnh báo",
                        JOptionPane.YES_NO_OPTION);
                if (HopThoai == JOptionPane.YES_OPTION) {
                    String id = modelKM.getValueAt(row, 0).toString();
                    mainController.deletePromotion(id);
                    modelKM.removeRow(row);
                    reload();
                    JOptionPane.showMessageDialog(this, "Xoá chương trình khuyến mãi thành công");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                JOptionPane.showMessageDialog(this, "Xoá chương trình khuyến mãi thất bại");
            }
        }
    }
    private void reload() {
        loadData();
        txtID.setText("");
        txtTen.setText("");
        txtTen.requestFocus();
        chooserngayBatDau.setDate(new java.util.Date());
        chooserngayKetThuc.setDate(new java.util.Date());
        cbLoai.setSelectedItem(SaleTypeEnum.Giam_10);
    }
    public boolean valiDate() {

        String ten = txtTen.getText().trim();
        java.util.Date ngayBD = chooserngayBatDau.getDate();
        java.util.Date ngayKT = chooserngayKetThuc.getDate();
        if(ten.equals("") ) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin đầy đủ!", "Thông báo",
                    JOptionPane.WARNING_MESSAGE);
            txtTen.requestFocus();

            return false;
        }

        if (!(ngayBD!=null  && (ngayBD.before(ngayKT)))) {
            JOptionPane.showMessageDialog(this, "Ngày bắt đầu phải trước ngày ket thúc", "Thông báo",
                    JOptionPane.WARNING_MESSAGE);
            chooserngayBatDau.requestFocus();

            return false;
        }
        if (!(ngayKT!=null  && (ngayKT.after(ngayBD)))) {
            JOptionPane.showMessageDialog(this, "Ngày kết thúc phải sau ngày bắt đầu", "Thông báo",
                    JOptionPane.WARNING_MESSAGE);
            chooserngayKetThuc.requestFocus();

            return false;
        }
        return true;
    }
    private void loadData() {
        modelKM.setRowCount(0);
        for (Promotion promotion : mainController.getAllPromotion() ) {
            modelKM.addRow(new Object[] { promotion.getPromotionId(), promotion.getPromotionName(),promotion.getPromotionDiscount(),dfNgay.format(promotion.getPromotionStartDate()),dfNgay.format(promotion.getPromotionEndDate())
            });

        }
    }
    private void showDialog(JFrame FrameParent,JDialog dialog) {

        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(btnThem)) {
            addPromotion();
        }
        if (o.equals(btnXoaKM)) {
            deletePromotion();
        }
        if (o.equals(btnCapNhat)) {
            updatePromotion();
        }
        if (o.equals(btnLamMoi)) {
            reload();
        }
        if (o.equals(btnMoTbSP)) {
            showDialog(FrameSP,dlogSP);
        }
        if (o.equals(btnMoTbSach)) {
            showDialog(FrameSach,dlogSach);
        }
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
        int row = tableKM.getSelectedRow();
        txtID.setText(modelKM.getValueAt(row, 0).toString());
        txtTen.setText(modelKM.getValueAt(row, 1).toString());
        SaleTypeEnum loaiSelectd=(SaleTypeEnum) modelKM.getValueAt(row,2);

        cbLoai.setSelectedItem(loaiSelectd);
        String ngayBatDau=modelKM.getValueAt(row, 3).toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date valueNgayBD=null;
        try {
            valueNgayBD = dateFormat.parse(ngayBatDau);
        } catch (ParseException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        chooserngayBatDau.setDate(valueNgayBD);
        String ngayKetThuc=modelKM.getValueAt(row, 4).toString();
        java.util.Date valueNgayKT=null;
        try {
            valueNgayKT = dateFormat.parse(ngayKetThuc);
        } catch (ParseException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        chooserngayKetThuc.setDate(valueNgayKT);


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