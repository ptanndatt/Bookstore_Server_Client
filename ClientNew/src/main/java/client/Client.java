package client;

import controller.MainControllerInterface;
import views.LoginView;

import java.rmi.Naming;

public class Client {
    private static final String URL = "rmi://ashleynguci:7881/";

    public static void main(String[] args) {
        try {
            MainControllerInterface mainController = (MainControllerInterface) Naming.lookup(URL + "mainController");
            LoginView loginView = new LoginView(mainController);
            loginView.setVisible(true);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
