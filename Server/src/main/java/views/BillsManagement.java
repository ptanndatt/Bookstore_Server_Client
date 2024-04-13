package views;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class BillsManagement extends JFrame {
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

    private JTextField txtGetSearchBill;
    private JTextField getTxtGetSearchProduct;
    private JCheckBox chkFullTime;
    private JCheckBox chkAnotherChoice;

    private ButtonGroup checkBoxGroup;

    private JComboBox<Object> cboSearchBillDate;
    private JDateChooser dateChooser;

    public BillsManagement() {
        setLayout(null);
        setTitle("Bills Management");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        init();
    }

    public void init() {
        pnLeft = new JPanel();
        chkFullTime = new JCheckBox();
        chkAnotherChoice = new JCheckBox();
        cboSearchBillDate = new JComboBox<>();
        dateChooser = new JDateChooser();
        pnMain = new JPanel();
        pnLeft.setBorder(BorderFactory.createTitledBorder("Tim kiem"));
        pnLeft.setBounds(10, 10, 300, 150);
        lblGetSearchBill = new JLabel("Ma hoa don");
        lblGetSearchBill.setBounds(10, 30, 100, 30);
        txtGetSearchBill = new JTextField(20);
        txtGetSearchBill.setBounds(120, 30, 200, 30);
        lblGetSearchProduct = new JLabel("Ma san pham");
        lblGetSearchProduct.setBounds(10, 70, 200, 30);
        getTxtGetSearchProduct = new JTextField(20);
        getTxtGetSearchProduct.setBounds(120, 70, 200, 30);
        pnLeft.add(lblGetSearchBill);
        pnLeft.add(txtGetSearchBill);
        pnLeft.add(lblGetSearchProduct);
        pnLeft.add(getTxtGetSearchProduct);

        pnLeft_Bottom = new JPanel();
        pnLeft_Bottom.setBounds(10, 175, 300, 150);
        pnLeft_Bottom.setBorder(BorderFactory.createTitledBorder("Tim kiem theo ngay"));
        chkFullTime = new JCheckBox("Toàn thời gian");
        cboSearchBillDate = new JComboBox<>();
        cboSearchBillDate.addItem("Tất cả");
        cboSearchBillDate.addItem("Hôm nay");
        cboSearchBillDate.addItem("Hôm qua");
        cboSearchBillDate.addItem("Tuần nay");
        cboSearchBillDate.addItem("Tháng nay");
        cboSearchBillDate.addItem("Năm nay");
        cboSearchBillDate.setBounds(0, 30, 200, 30);

        chkFullTime.setBounds(10, 30, 200, 30);
        chkAnotherChoice = new JCheckBox("Lựa chọn khác");
        chkAnotherChoice.setBounds(10, 30, 200, 30);
        dateChooser.setBounds(0, 30, 200, 30);
        dateChooser.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        dateChooser.setDateFormatString("dd/MM/yyyy");
        dateChooser.setBorder(new LineBorder(new Color(114, 23, 153), 1, true));
        dateChooser.setFont(new Font("SansSerif", Font.PLAIN, 15));
        dateChooser.getCalendarButton().setPreferredSize(new Dimension(30, 24));
        dateChooser.getCalendarButton().setBackground(new Color(102, 0, 153));


        pnMain = new JPanel(null);
        pnMain.setBounds(320, 10, 1200, 700);
        pnMain.setBorder(BorderFactory.createTitledBorder("Danh sách hóa đơn"));
        lblManagerBill = new JLabel("Hóa đơn");
        lblManagerBill.setFont(new Font("Arial", Font.BOLD, 35));
        lblManagerBill.setBounds(40, 70, 200, 30);
        btnExportExcel = new JButton("Luư trữ");
        btnExportExcel.setBounds(1000, 70, 130, 30);
        pnMain.add(lblManagerBill);
        pnMain.add(btnExportExcel);


        checkBoxGroup = new ButtonGroup();
        checkBoxGroup.add(chkFullTime);
        checkBoxGroup.add(chkAnotherChoice);

        pnLeft_Bottom.add(chkFullTime);
        pnLeft_Bottom.add(cboSearchBillDate);
        pnLeft_Bottom.add(chkAnotherChoice);
        pnLeft_Bottom.add(dateChooser);

        add(pnLeft_Bottom);
        add(pnLeft);
        add(pnMain);


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BillsManagement view = new BillsManagement();
            view.setVisible(true);
        });
    }
}
