/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketserver;

import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author VSI-ANIK
 */
public class ClientMe {

    public static void main(String args[]) {
        try {
            Socket client = new Socket("localhost", 8080);
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            out.writeUTF("Hi i am from client 2");
            out.flush();
            out.close();
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
