package server;

import controller.MainController;
import controller.MainControllerInterface;
import service.*;
import views.LoginView;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.awt.*;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {
    private static final String SERVER_IP = "192.168.1.95";
    private static final int PORT = 7881;
    private static final String URL = "rmi://" + SERVER_IP + ":" + PORT + "/";

    public static void main(String[] args) {
        try {
            Context context = new InitialContext();
            MainControllerInterface mainController = new MainController(
                    new AuthorDaoImplService(),
                    new CategoryDaoImplService(),
                    new ProductTypeDaoImplService(),
                    new SupplierDaoImplService(),
                    new BookDaoImplService(),
                    new MerchandiseDaoImplService(),
                    new CustomerDaoImplService(),
                    new EmployeeDaoImplService(),
                    new AccountDaoImplService(),
                    new RoleDaoImplService(),
                    new PromotionDaoImplService(),
                    new ProductSaleDaoImplService(),
                    new ProductDaoImplService(),
                    new SaleManagementDaoService()
            );
            LocateRegistry.createRegistry(PORT);
            context.rebind(URL + "mainController", mainController);
            System.out.println("Server is ready.");
            System.out.println("Waiting for clients...");
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    LoginView view = new LoginView(mainController);
                    view.setVisible(true);
                }
            });

        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
