package models;

import java.awt.Color;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Test extends JFrame {

    public Test() {
        super("Biểu Đồ Đường");

        XYSeries series1 = new XYSeries("Doanh Thu");
        series1.add(1, 100);
        series1.add(2, 200);
        series1.add(3, 300);

        XYSeries series2 = new XYSeries("Lợi Nhuận");
        series2.add(1, 50);
        series2.add(2, 150);
        series2.add(3, 250);

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Biểu Đồ Doanh Thu và Lợi Nhuận",
                "Thời Gian",
                "Số Tiền",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    public static void main(String[] args) {
        Test example = new Test();
        example.setSize(800, 400);
        example.setLocationRelativeTo(null);
        example.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        example.setVisible(true);
    }
}
