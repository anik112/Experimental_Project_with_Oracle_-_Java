/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 *
 * @author Anik
 */
public class ClientHandelar implements Runnable {

    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private Socket socket;

    public ClientHandelar(Socket s) {
        socket = s;
    }

    private String getDataFromClient(Socket s) {
        try {
            dataInputStream = new DataInputStream(s.getInputStream());
            return dataInputStream.readUTF();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }

    private void sendDataToClient(String data, Socket s) {
        try {
            dataOutputStream = new DataOutputStream(s.getOutputStream());
            dataOutputStream.writeUTF(data);
            dataOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println(socket);
        System.out.println(getDataFromClient(socket));
        sendDataToClient("Hi i am Server. What you want? ", socket);
        while (true) {
            System.out.println(getDataFromClient(socket));
            System.out.print("Rep: ");
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            sendDataToClient(str, socket);
            if (str.equals("exit")) {
                break;
            }
        }
    }
}
