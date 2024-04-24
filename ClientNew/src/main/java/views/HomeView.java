
package views;

import javax.swing.*;
import java.awt.*;



public class HomeView extends JPanel {
    private JLabel lblBackground;

    public HomeView() {
        setLayout(new BorderLayout());
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/images/homeView.jpg"));
        lblBackground = new JLabel(imageIcon);
        add(lblBackground, BorderLayout.CENTER);
    }
}
