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
import java.sql.Date;
import java.text.SimpleDateFormat;

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
            ClientMe1 me = new ClientMe1();
            Socket socket = new Socket("localhost", 8080);
            ConsolForClient cfc = new ConsolForClient("Client 182056-2", socket);
            cfc.setVisible(true);
            me.sendDataToServer("Client 182056-2", socket);
            String str2 = me.getDataFromServer(socket);
            cfc.txtAreaConsol.setText(cfc.txtAreaConsol.getText() + "\n"
                    + str2 + "\n=====================\n");

            while (true) {
                //System.out.println(me.getDataFromServer(socket));
                //System.out.print("Rep: ");
                str2 = me.getDataFromServer(socket);
                Date d = new Date(System.currentTimeMillis());
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyy hh:mm");
                String currentTime = dateFormat.format(d);
                cfc.txtAreaConsol.setText(cfc.txtAreaConsol.getText() + "\n" + currentTime + "  " + str2);
//                Scanner scanner=new Scanner(System.in);
//                String str=scanner.nextLine();
//                me.sendDataToServer(str, socket);
                if(str2.equals("close")){
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
