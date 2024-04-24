package client;

import controller.MainControllerInterface;
import views.LoginView;

import java.rmi.Naming;

public class Client {
    private static final String SERVER_IP = "192.168.89.111";
    private static final int PORT = 7881;
    private static final String URL = "rmi://" + SERVER_IP + ":" + PORT + "/";

    public static void main(String[] args) {
        try {
            MainControllerInterface mainController = (MainControllerInterface) Naming.lookup(URL + "mainController");
            LoginView loginView = new LoginView(mainController);
            loginView.setVisible(true);
            System.out.println("Client connected successfully.");
            // notify the server that the client has connected

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
