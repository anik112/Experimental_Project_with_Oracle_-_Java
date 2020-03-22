/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author VSI-ANIK
 */
public class ZktCheck {
    
    public static void main(String[] args) {
        
        try {
            Socket s=new Socket("192.168.1.209",4370);
            
            if(s.isConnected()){
                System.out.println("Connected");
                
                System.out.println(s.getReceiveBufferSize());
                System.out.println(s.getChannel());
                System.out.println(s.getOutputStream());
                System.out.println(s.getKeepAlive());
                
                
//                
//                DataOutputStream dos=new DataOutputStream(s.getOutputStream());
//                String cmd="CMD_ATTLOG_RRQ";
//                dos.writeUTF(cmd);
//                dos.flush();
//                
//                DataInputStream dis=new DataInputStream(s.getInputStream());
//                System.out.println(dis.readUTF());
                
            }else{
                System.out.println("Not- Connected");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }  
    }
    
}
