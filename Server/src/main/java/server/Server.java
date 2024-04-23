package server;

import controller.MainController;
import service.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {
    private static final String URL = "rmi://ashleynguci:7881/";

    public static void main(String[] args) {
        try {
            Context context = new InitialContext();
            MainController mainController = new MainController(
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
            LocateRegistry.createRegistry(7881);
            context.rebind(URL + "mainController", mainController);
            System.out.println("Server is ready.");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
