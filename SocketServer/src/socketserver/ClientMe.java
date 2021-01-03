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
public class ClientMe {

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
            
            ClientMe me=new ClientMe();
            Socket socket = new Socket("localhost", 8080);
            me.sendDataToServer("Client 182056-1", socket);
            Consol c=new Consol("Client1",socket);
            c.setVisible(true);
            c.txtAreaConsol.setText(me.getDataFromServer(socket));
            while(true){
                String str2=me.getDataFromServer(socket);
                c.txtAreaConsol.setText(c.txtAreaConsol.getText()+"\n"
                +str2+"\n=====================\n");
                System.out.println(str2);
                
                System.out.print("Rep: ");
                //Scanner scanner=new Scanner(System.in);
                //String str=scanner.nextLine();
                String str=c.returnSeverData();
                me.sendDataToServer(c.msg.getText(), socket);
                if(str.equals("exit")){
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DataInputStream getDataInputStream() {
        return dataInputStream;
    }

    public void setDataInputStream(DataInputStream dataInputStream) {
        this.dataInputStream = dataInputStream;
    }

    public DataOutputStream getDataOutputStream() {
        return dataOutputStream;
    }

    public void setDataOutputStream(DataOutputStream dataOutputStream) {
        this.dataOutputStream = dataOutputStream;
    }
}
