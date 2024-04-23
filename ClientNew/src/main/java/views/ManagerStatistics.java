package views;

import com.toedter.calendar.JDateChooser;
import controller.MainController;
import lombok.SneakyThrows;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ManagerStatistics extends JPanel implements ItemListener, ActionListener {
    private JPanel pnTop, pnTop_1, pnTop_2;
    private JPanel pnCenter;
    private JPanel pnBottom;
    private JLabel lblFilter;
    private JLabel lblOverview;
    private JDateChooser dcFrom;
    private JDateChooser dcTo;
    private JComboBox cbFilter;

    private MainController mainController;
    private JButton btnRefresh;
    private JTable table, table1;
    private DefaultTableModel model, model1;
    private JPanel pnCenter_2;
    private JPanel pnCenter_3;
    private JLabel lblDonHangValue;
    private JLabel lblDoanhThu, lblDoanhThuValue, lblGiaTriDonHangValue, lblThucThuValue;
    private JButton btntimKiem;
    private DefaultCategoryDataset barDataset;
    private ChartPanel pieDataset;
    private JPanel pnCenter_4;
    private JPanel pnCenter_5;

    public ManagerStatistics() {
        initComponents();
    }

    @SneakyThrows
    private void initComponents() {
        this.barDataset = new DefaultCategoryDataset();
        mainController = new MainController();
        table = new JTable();
        model = new DefaultTableModel();
        setLayout(null);
        pnTop = new JPanel(null);
        pnCenter_3 = new JPanel();
        pnCenter_4 = new JPanel();
        pnCenter_5 = new JPanel();
        pnTop.setBounds(10, 50, 1650, 100);
        btntimKiem = new JButton("Tìm kiếm");
        btntimKiem.setBounds(550, 10, 100, 30);
        btnRefresh = new JButton("Làm mới");
        btnRefresh.setBounds(660, 10, 100, 30);
        lblOverview = new JLabel("Tổng quan");
        lblFilter = new JLabel("Lọc theo:");
        cbFilter = new JComboBox();
        cbFilter.addItem("Hôm nay");
        cbFilter.addItem("1 tuần");
        cbFilter.addItem("1 tháng");
        cbFilter.addItem("3 tháng");
        cbFilter.addItem("Tuỳ chọn");
        dcFrom = new JDateChooser();
        dcFrom.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        dcFrom.setBounds(100, 310, 200, 40);
        dcFrom.setDateFormatString("dd/MM/yyyy");
        dcFrom.setBorder(new LineBorder(new Color(114, 23, 153), 1, true));
        dcFrom.setFont(new Font("SansSerif", Font.PLAIN, 15));
        dcFrom.getCalendarButton().setPreferredSize(new Dimension(30, 24));
        dcFrom.getCalendarButton().setBackground(new Color(102, 0, 153));
        dcTo = new JDateChooser();
        dcTo.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        dcTo.setBounds(310, 310, 200, 40);
        dcTo.setDateFormatString("dd/MM/yyyy");
        dcTo.setBorder(new LineBorder(new Color(114, 23, 153), 1, true));
        dcTo.setFont(new Font("SansSerif", Font.PLAIN, 15));
        dcTo.getCalendarButton().setPreferredSize(new Dimension(30, 24));
        dcTo.getCalendarButton().setBackground(new Color(102, 0, 153));

        dcFrom.setDate(Calendar.getInstance().getTime());
        dcTo.setDate(Calendar.getInstance().getTime());
        pnTop_1 = new JPanel(null);
        pnTop_1.setBounds(10, 0, 1650, 50);
        lblFilter.setBounds(10, 10, 100, 30);
        cbFilter.setBounds(120, 10, 100, 30);
        dcFrom.setBounds(230, 10, 150, 30);
        dcTo.setBounds(390, 10, 150, 30);
        pnTop_1.add(lblOverview);
        pnTop_1.add(lblFilter);
        pnTop_1.add(cbFilter);
        pnTop_1.add(dcFrom);
        pnTop_1.add(dcTo);
        pnTop_1.add(btntimKiem);
        pnTop_1.add(btnRefresh);

        JPanel pn_1, pn_2, pn_3, pn_4;
        pn_1 = new JPanel(null);
        pn_2 = new JPanel(null);
        pn_3 = new JPanel(null);
        pn_4 = new JPanel(null);

        JLabel lblDonHang = new JLabel("Số lượng đơn hàng");
        lblDonHang.setBounds(10, 10, 200, 30);
        lblDonHang.setForeground(Color.WHITE);
        lblDonHangValue = new JLabel();
//        lblDonHangValue.setText(String.valueOf(mainController.sumTotalBill()));
        lblDonHangValue.setBounds(10, 40, 200, 30);
        lblDonHangValue.setForeground(Color.WHITE);
        lblDonHangValue.setFont(new Font("SansSerif", Font.BOLD, 30));
        JLabel lblGiaTriDonHang = new JLabel("Giá trị đơn hàng");
        lblGiaTriDonHangValue = new JLabel("1000000");
        lblGiaTriDonHang.setBounds(10, 10, 200, 30);
        lblGiaTriDonHang.setForeground(Color.WHITE);
        lblGiaTriDonHangValue.setFont(new Font("SansSerif", Font.BOLD, 30));
        lblGiaTriDonHangValue.setBounds(10, 40, 200, 30);
        lblGiaTriDonHangValue.setForeground(Color.WHITE);
        JLabel lblThucThu = new JLabel("Thực thu");
        lblThucThu.setBounds(10, 10, 200, 30);
        lblThucThu.setForeground(Color.WHITE);
        lblThucThuValue = new JLabel("1000000");
        lblThucThuValue.setBounds(10, 40, 200, 30);
        lblThucThuValue.setForeground(Color.WHITE);
        lblThucThuValue.setFont(new Font("SansSerif", Font.BOLD, 30));
        lblDoanhThu = new JLabel("Doanh thu");
        lblDoanhThu.setBounds(10, 10, 200, 30);
        lblDoanhThu.setForeground(Color.WHITE);
        lblDoanhThuValue = new JLabel("1000000");
        lblDoanhThuValue.setBounds(10, 40, 200, 30);
        lblDoanhThuValue.setForeground(Color.WHITE);
        lblDoanhThuValue.setFont(new Font("SansSerif", Font.BOLD, 30));

        pn_1.setBounds(10, 10, 400, 80);
        pn_1.setBackground(new Color(66, 109, 189));
        pn_1.add(lblDonHang);
        pn_1.add(lblDonHangValue);

        pn_2.setBounds(420, 10, 400, 80);
        pn_2.setBackground(new Color(66, 109, 189));
        pn_2.add(lblGiaTriDonHang);
        pn_2.add(lblGiaTriDonHangValue);

        pn_3.setBounds(830, 10, 400, 80);
        pn_3.setBackground(new Color(66, 109, 189));
        pn_3.add(lblThucThu);
        pn_3.add(lblThucThuValue);

        pn_4.setBounds(1240, 10, 400, 80);
        pn_4.setBackground(new Color(66, 109, 189));
        pn_4.add(lblDoanhThu);
        pn_4.add(lblDoanhThuValue);

        pnCenter = new JPanel();
        pnCenter.setLayout(null);
        pnCenter.setBorder(BorderFactory.createTitledBorder("Sản phẩm bán chạy"));
        pnCenter.setBounds(50, 160, 500, 350);

        model.addColumn("Mã sản phẩm");
        model.addColumn("Tên sản phẩm");
        model.addColumn("Giá bán");
        model.addColumn("So luong");
        model.addColumn("Tỷ lệ bán ra");
        table.setModel(model);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 20, 500, 320);
        pnCenter.add(sp);

        pnCenter_2 = new JPanel();
        pnCenter_2.setLayout(null);
        pnCenter_2.setBorder(BorderFactory.createTitledBorder("Doanh số theo hàng hoá"));
        pnCenter_2.setBounds(600, 160, 500, 350);
        Date today = Calendar.getInstance().getTime();
        dcFrom.setDate(today);
        dcTo.setDate(today);
        JFreeChart pieChart = createChart(createDataset(today, today));
        ChartPanel chartPanel = new ChartPanel(pieChart);
        chartPanel.setBounds(0, 20, 500, 320);
        pnCenter_2.add(chartPanel);


        pnCenter_3 = new JPanel();
        pnCenter_3.setLayout(null);
        pnCenter_3.setBorder(BorderFactory.createTitledBorder("Doanh thu và lợi nhuận theo thời gian"));
        pnCenter_3.setBounds(1150, 160, 500, 350);
        JFreeChart chart = createChartBar(createBarChartDataset(today, today));
        ChartPanel panel = new ChartPanel(chart);
        panel.setBounds(0, 20, 500, 320);
        pnCenter_3.add(panel);

        pnCenter_4 = new JPanel();
        pnCenter_4.setLayout(null);
        pnCenter_4.setBorder(BorderFactory.createTitledBorder("Sản phẩm bán chậm"));
        pnCenter_4.setBounds(50, 560, 500, 350);
        model1 = new DefaultTableModel();
        model1.addColumn("Mã sản phẩm");
        model1.addColumn("Tên sản phẩm");
        model1.addColumn("Giá bán");
        model1.addColumn("Tỷ lệ bán ra");
        table1 = new JTable();
        table1.setModel(model1);
        JScrollPane sp1 = new JScrollPane(table1);
        sp1.setBounds(0, 20, 500, 320);
        pnCenter_4.add(sp1);

        pnCenter_5 = new JPanel();
        pnCenter_5.setLayout(null);
        pnCenter_5.setBorder(BorderFactory.createTitledBorder("Doanh số theo nhân viên"));
        pnCenter_5.setBounds(600, 560, 1020, 350);
        JFreeChart chart1 = createChartBar1(createBarChartDataset1(today, today));
        ChartPanel panel1 = new ChartPanel(chart1);
        panel1.setBounds(0, 20, 1020, 320);
        pnCenter_5.add(panel1);


        pnTop.add(pn_1);
        pnTop.add(pn_2);
        pnTop.add(pn_3);
        pnTop.add(pn_4);

        add(pnCenter_2);
        add(pnCenter_3);
        add(pnCenter_4);
        add(pnCenter_5);
        add(pnCenter);
        add(pnTop_1);
        add(pnTop);


        dcFrom.setDate(Calendar.getInstance().getTime());
        dcTo.setDate(Calendar.getInstance().getTime());
        dcTo.setEnabled(false);
        dcFrom.setEnabled(false);
        btntimKiem.setEnabled(false);
        btntimKiem.addActionListener(this);
        btnRefresh.addActionListener(this);

        loadDataProductSales(dcFrom.getDate(), dcTo.getDate());
        loadDataProductWorstSeller(dcFrom.getDate(), dcTo.getDate());
        lblDonHangValue.setText(String.valueOf(mainController.sumTotalBillDate(dcFrom.getDate(), dcTo.getDate())));
        lblDoanhThuValue.setText(String.valueOf(mainController.sumTotalAmount(dcFrom.getDate(), dcTo.getDate())));
        lblThucThuValue.setText(String.valueOf(mainController.sumProfit(dcFrom.getDate(), dcTo.getDate())));
        lblGiaTriDonHangValue.setText(String.valueOf(mainController.sumTotalBillValue(dcFrom.getDate(), dcTo.getDate())));

        cbFilter.addItemListener(this);
    }

    @SneakyThrows
    public void loadDataProductWorstSeller(Date from, Date to) {
        List<Object[]> list = mainController.findProductWorstSeller(from, to);
        model1.setRowCount(0);
        for (Object[] obj : list) {
            model1.addRow(obj);
        }
    }

    @SneakyThrows
    public void loadDataProductSales(Date from, Date to) {
        List<Object[]> list = mainController.findProductBestSeller(from, to);
        model.setRowCount(0);
        for (Object[] obj : list) {
            model.addRow(obj);
        }
    }

    @SneakyThrows
    private PieDataset createDataset(Date startDate, Date endDate) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        mainController.sumTotalBillValueByProduct(startDate, endDate).forEach(objects -> {
            dataset.setValue(objects[0].toString(), Double.parseDouble(objects[1].toString()));
        });
        return dataset;
    }

    private static JFreeChart createChart(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart(
                "", dataset, true, true, true);
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} = {1}({2})"));
        return chart;
    }

    @SneakyThrows
    private DefaultCategoryDataset createBarChartDataset(Date startDate, Date endDate) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        mainController.sumTotalBillValueByDate(startDate, endDate).forEach(objects -> {
            if (objects[0] != null && objects[1] != null) {
                String time = new SimpleDateFormat("yyyy-MM-dd").format((Date) objects[0]);
                double value = Double.parseDouble(objects[1].toString());
                dataset.addValue(value, "Doanh Thu", time);
            }
        });

        mainController.sumTotalBillValueByDateLoiNhuan(startDate, endDate).forEach(objects -> {
            if (objects[0] != null && objects[1] != null) {
                String time = new SimpleDateFormat("yyyy-MM-dd").format((Date) objects[0]);
                double value = Double.parseDouble(objects[1].toString());
                dataset.addValue(value, "Lợi Nhuận", time);
            }
        });

        return dataset;
    }


    private static JFreeChart createChartBar(DefaultCategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(
                "",
                "Thời Gian",
                "Số Tiền",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
        chart.setBackgroundPaint(Color.WHITE);
        return chart;
    }

    private static JFreeChart createChartBar1(DefaultCategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(
                "",
                "Nhân viên",
                "Số Lượng",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
        chart.setBackgroundPaint(Color.WHITE);
        return chart;
    }

    @SneakyThrows
    private DefaultCategoryDataset createBarChartDataset1(Date startDate, Date endDate) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        mainController.findEmployeeBestSeller(startDate, endDate).forEach(objects -> {
            if (objects[0] != null && objects[1] != null) {
                String name = objects[0].toString();
                double value = Double.parseDouble(objects[1].toString());
                dataset.addValue(value, "Số lượng", name);
            }
        });

        return dataset;
    }

    @SneakyThrows
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == cbFilter && e.getStateChange() == ItemEvent.SELECTED) {
            String selectedOption = (String) cbFilter.getSelectedItem();
            if ("Hôm nay".equals(selectedOption)) {
                dcTo.setEnabled(false);
                dcFrom.setEnabled(false);
                Date today = Calendar.getInstance().getTime();
                dcFrom.setDate(today);
                dcTo.setDate(today);
                loadDataProductSales(today, today);
                updateUI(today, today);
                updateChartWithNewData(today, today);
                updateBarChart(today, today);
                loadDataProductWorstSeller(today, today);
                updateBarChart1(today, today);
            } else if ("1 tuần".equals(selectedOption)) {
                dcTo.setEnabled(false);
                dcFrom.setEnabled(false);
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.DAY_OF_MONTH, -7);
                Date startDate = calendar.getTime();
                Date endDate = Calendar.getInstance().getTime();
                dcFrom.setDate(startDate);
                dcTo.setDate(endDate);
                loadDataProductSales(startDate, endDate);
                updateUI(startDate, endDate);
                updateChartWithNewData(startDate, endDate);
                updateBarChart(startDate, endDate);
                loadDataProductWorstSeller(startDate, endDate);
                updateBarChart1(startDate, endDate);
            } else if ("1 tháng".equals(selectedOption)) {
                dcTo.setEnabled(false);
                dcFrom.setEnabled(false);
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.MONTH, -1);
                dcFrom.setDate(calendar.getTime());
                dcTo.setDate(Calendar.getInstance().getTime());
                loadDataProductWorstSeller(dcFrom.getDate(), dcTo.getDate());
                lblDonHangValue.setText(String.valueOf(mainController.sumTotalBillDate(dcTo.getDate(), dcFrom.getDate())));
                lblDoanhThuValue.setText(String.valueOf(mainController.sumTotalAmount(dcTo.getDate(), dcFrom.getDate())));
                lblThucThuValue.setText(String.valueOf(mainController.sumProfit(dcTo.getDate(), dcFrom.getDate())));
                lblGiaTriDonHangValue.setText(String.valueOf(mainController.sumTotalBillValue(dcTo.getDate(), dcFrom.getDate())));
            } else if ("3 tháng".equals(selectedOption)) {
                dcTo.setEnabled(false);
                dcFrom.setEnabled(false);
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.MONTH, -3);
                dcFrom.setDate(calendar.getTime());
                dcTo.setDate(Calendar.getInstance().getTime());
                loadDataProductSales(dcFrom.getDate(), dcTo.getDate());
                lblDonHangValue.setText(String.valueOf(mainController.sumTotalBillDate(dcFrom.getDate(), dcTo.getDate())));
                lblDoanhThuValue.setText(String.valueOf(mainController.sumTotalAmount(dcFrom.getDate(), dcTo.getDate())));
                lblThucThuValue.setText(String.valueOf(mainController.sumProfit(dcFrom.getDate(), dcTo.getDate())));
                lblGiaTriDonHangValue.setText(String.valueOf(mainController.sumTotalBillValue(dcFrom.getDate(), dcTo.getDate())));
            } else if ("Tuỳ chọn".equals(selectedOption)) {
                btntimKiem.setEnabled(true);
                dcTo.setEnabled(true);
                dcFrom.setEnabled(true);
                dcFrom.setDate(Calendar.getInstance().getTime());
                dcTo.setDate(Calendar.getInstance().getTime());
                loadDataProductSales(dcFrom.getDate(), dcTo.getDate());
                lblDonHangValue.setText(String.valueOf(mainController.sumTotalBillDate(dcFrom.getDate(), dcTo.getDate())));
                lblDoanhThuValue.setText(String.valueOf(mainController.sumTotalAmount(dcFrom.getDate(), dcTo.getDate())));
                lblThucThuValue.setText(String.valueOf(mainController.sumProfit(dcFrom.getDate(), dcTo.getDate())));
                lblGiaTriDonHangValue.setText(String.valueOf(mainController.sumTotalBillValue(dcFrom.getDate(), dcTo.getDate())));
            }
        }
    }

    @SneakyThrows
    public void updateUI(Date startDate, Date endDate) {
        lblDonHangValue.setText(String.valueOf(mainController.sumTotalBillDate(startDate, endDate)));
        lblDoanhThuValue.setText(String.valueOf(mainController.sumTotalAmount(startDate, endDate)));
        lblThucThuValue.setText(String.valueOf(mainController.sumProfit(startDate, endDate)));
        lblGiaTriDonHangValue.setText(String.valueOf(mainController.sumTotalBillValue(startDate, endDate)));
    }


    public void updateChartWithNewData(Date startDate, Date endDate) {
        PieDataset dataset = createDataset(startDate, endDate);
        Component[] component = pnCenter_2.getComponents();
        for (Component component1 : component) {
            if (component1 instanceof ChartPanel) {
                ChartPanel chartPanel = (ChartPanel) component1;
                JFreeChart chart = chartPanel.getChart();
                PiePlot plot = (PiePlot) chart.getPlot();
                plot.setDataset(dataset);
                chartPanel.repaint();
            }
        }
    }

    private void updateBarChart(Date startDate, Date endDate) {
        DefaultCategoryDataset updatedDataset = createBarChartDataset(startDate, endDate);
        Component[] components = pnCenter_3.getComponents();
        for (Component component : components) {
            if (component instanceof ChartPanel) {
                ChartPanel chartPanel = (ChartPanel) component;
                JFreeChart chart = createChartBar(updatedDataset);
                chartPanel.setChart(chart);
                chartPanel.repaint();
            }
        }
    }


    private void updateBarChart1(Date startDate, Date endDate) {
        DefaultCategoryDataset updatedDataset = createBarChartDataset1(startDate, endDate);
        Component[] components = pnCenter_5.getComponents();
        for (Component component : components) {
            if (component instanceof ChartPanel) {
                ChartPanel chartPanel = (ChartPanel) component;
                JFreeChart chart = createChartBar1(updatedDataset);
                chartPanel.setChart(chart);
                chartPanel.repaint();
            }
        }
    }

    @SneakyThrows
    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(btntimKiem)) {
            loadDataProductSales(dcFrom.getDate(), dcTo.getDate());
            lblDonHangValue.setText(String.valueOf(mainController.sumTotalBillDate(dcFrom.getDate(), dcTo.getDate())));
            lblDoanhThuValue.setText(String.valueOf(mainController.sumTotalAmount(dcFrom.getDate(), dcTo.getDate())));
            lblThucThuValue.setText(String.valueOf(mainController.sumProfit(dcFrom.getDate(), dcTo.getDate())));
            lblGiaTriDonHangValue.setText(String.valueOf(mainController.sumTotalBillValue(dcFrom.getDate(), dcTo.getDate())));
        } else if (o.equals(btnRefresh)) {
            cbFilter.setSelectedIndex(0);
            dcFrom.setDate(Calendar.getInstance().getTime());
            dcTo.setDate(Calendar.getInstance().getTime());
            loadDataProductSales(dcFrom.getDate(), dcTo.getDate());
            lblDonHangValue.setText(String.valueOf(mainController.sumTotalBillDate(dcFrom.getDate(), dcTo.getDate())));
            lblDoanhThuValue.setText(String.valueOf(mainController.sumTotalAmount(dcFrom.getDate(), dcTo.getDate())));
            lblThucThuValue.setText(String.valueOf(mainController.sumProfit(dcFrom.getDate(), dcTo.getDate())));
            lblGiaTriDonHangValue.setText(String.valueOf(mainController.sumTotalBillValue(dcFrom.getDate(), dcTo.getDate())));
            table.clearSelection();
        }
    }
}
