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
 * @author Anik
 */
public class ClientHandelar implements Runnable {

    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private Socket socket;
    private int id;

    public ClientHandelar(Socket s, int id) {
        socket = s;
        this.id=id;
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
        Consol c=new Consol("Handeler-"+id,socket);
        c.setVisible(true);
        System.out.println(socket);
        sendDataToClient("Hi i am Server. What you want? ", socket);
        String str2=getDataFromClient(socket);
        System.out.println(str2);
        c.txtAreaConsol.setText(c.txtAreaConsol.getText()+"\n"
                +str2+"\n=====================\n");
        
        while (true) {
            str2=getDataFromClient(socket);
            System.out.println(str2);
            Date d=new Date(System.currentTimeMillis());
            SimpleDateFormat dateFormat=new SimpleDateFormat("dd/mm/yyy hh:mm");
            String currentTime=dateFormat.format(d);
            c.txtAreaConsol.setText(c.txtAreaConsol.getText()+"\n"+currentTime+"  "+str2);
            //System.out.print("Rep: ");
            //Scanner scanner = new Scanner(System.in);
            //String str = scanner.nextLine();
//            String str=c.returnSeverData();
//            sendDataToClient(str, socket);
            if (str2.equals("close")) {
                break;
            }
        }
    }
}
