/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vsi.anik.main;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author VSI-ANIK
 */
public class SocketTestServer {

    public static void main(String[] args) throws IOException {

        ServerSocket socket = new ServerSocket(9999);
        Socket s = socket.accept();
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        System.out.println("Server Runing");
          dos.writeUTF("Hello i am server .....");
          dos.flush();
    }
}
