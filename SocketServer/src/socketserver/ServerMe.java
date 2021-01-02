/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VSI-ANIK
 */
public class ServerMe {

    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    public ServerMe() {

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

    public static void main(String arg[]) {
        try {
            ServerMe me = new ServerMe();
            ServerSocket serverSocket = new ServerSocket(8080);
            Socket socket = serverSocket.accept();
            System.out.println(me.getDataFromClient(socket));
            socket.close();
            serverSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerMe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
