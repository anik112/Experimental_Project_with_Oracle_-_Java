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

/**
 *
 * @author VSI-ANIK
 */
public class ClientMe1 {

    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    
    private String getDataFromServer(Socket s) {
        try {
            dataInputStream = new DataInputStream(s.getInputStream());
            return dataInputStream.readUTF();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }

    private void sendDataToServer(String data, Socket s) {
        try {
            dataOutputStream = new DataOutputStream(s.getOutputStream());
            dataOutputStream.writeUTF(data);
            dataOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public static void main(String args[]) {
        try {
            ClientMe1 me=new ClientMe1();
            Socket socket = new Socket("localhost", 8080);
            me.sendDataToServer("Client 182056", socket);
            while(true){
                System.out.println(me.getDataFromServer(socket));
                System.out.print("Rep: ");
                Scanner scanner=new Scanner(System.in);
                String str=scanner.nextLine();
                me.sendDataToServer(str, socket);
                if(str.equals("exit")){
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
