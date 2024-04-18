package client;

import javax.swing.SwingUtilities;

//import controller.MainController;
import views.LoginView;

public class ClientView {
		public static void main(String[] args) {
			SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
//					MainController controller = new MainController();
					LoginView view = new LoginView();
					view.setVisible(true);
				}
			});
		}
}
