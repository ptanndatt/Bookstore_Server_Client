package client;

import java.io.IOException;
import java.net.Socket;

public class Client {
    private static final int PORT = 7881;
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", PORT);
            System.out.println("Connected to the server");
            new ClientThread(socket).start();
        } catch (IOException e) {
            System.out.println("Client exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
