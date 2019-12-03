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
import java.net.Socket;

/**
 *
 * @author VSI-ANIK
 */
public class SocketTest01 {

    public static void main(String[] args) throws IOException {

        String ip = "localhost";
        int port = 9999;

        Socket s = new Socket(ip, port);

        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        DataInputStream dis = new DataInputStream(s.getInputStream());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        if (s.isConnected()) {
            System.out.println("Connected");
        }

        while (dis.readUTF() != "stop") {
            System.out.println("Server Msg: " + dis.readUTF());
            dos.writeUTF(br.readLine());
            dos.flush();
        }
        s.close();
        dos.close();
        dis.close();
    }
}

//       OutputStreamWriter osw=new OutputStreamWriter(s.getOutputStream());
//        PrintWriter pw=new PrintWriter(osw);
//        osw.write("I am form client");
//        osw.flush();
