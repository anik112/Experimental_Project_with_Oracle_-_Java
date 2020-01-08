/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesstotextconvert;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import javax.swing.JOptionPane;
import utility.PWS;
import utility.PasswordEnqDnq;
import utility.SetupDatabase;

/**
 *
 * @author VSI-ANIK
 */
public class AccessConnection {

    public static Connection dbConnection() {

        Connection connAccess;

        try {
            //String serverName = "DESKTOP-NSLL7T5\\SQLEXPRESS";
            //String database = "NitgenAccessManager";
            //String userName = "admin";
            //String password = "admin";
            //C:\\Users\\carev\\Desktop 
            //C:\\Users\\carev\\Documents 
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            connAccess = DriverManager.getConnection("jdbc:ucanaccess://D:\\ZKT\\att2000.mdb");

            System.out.println("== Connected with ZKT server==");
            return connAccess;

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(
                    null, e.getMessage(),
                    ":: Connection Error ZKT server :: ", JOptionPane.INFORMATION_MESSAGE);
        }

        return null;
    }

    public static Connection dbRTAConnection() {

        Connection connAccess;

        try {
            //C:\\Users\\carev\\Desktop 
            //C:\\Users\\carev\\Documents 
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            connAccess = DriverManager.getConnection("jdbc:ucanaccess://C:\\RMS\\RMS_A.mdb");

            System.out.println("== Connected with RMS server ==");
            return connAccess;

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(
                    null, e.getMessage(),
                    ":: Connection Error RMS server :: ", JOptionPane.INFORMATION_MESSAGE);
        }

        return null;
    }

    public static Connection dbNITGENconnection() {

        Connection connNitgen;
        try {
            // call file
            File file = new File("D:\\AccessToTextConvert\\config.txt");
            Scanner scan = new Scanner(file); // call scanner class

            String serverNameTrim = ""; // call server name
            String userNameTrim = ""; // call user name
            String passwordTrim = ""; // call password
            String dbNameTrim = ""; // call db name

            // check file is exists
            if (file.exists()) {
                String serverFile = scan.nextLine(); // get server name from txt file
                String userNameFile = scan.nextLine(); // get user name from txt file
                String passwordFile = scan.nextLine(); // get password from txt file
                String dbName = scan.nextLine(); // get db name from txt file

                serverNameTrim = serverFile.substring(4, serverFile.length()); // trim server name from string
                userNameTrim = userNameFile.substring(4, userNameFile.length()); // trim user name from string
                passwordTrim = passwordFile.substring(4, passwordFile.length()); // trim password from string
                dbNameTrim = dbName.substring(4, dbName.length()); // trim db name from string

                PasswordEnqDnq ped = new PWS(); // call boj for password deque
                passwordTrim = ped.passwordDnq(passwordTrim); // call deque method

            } else {
                JOptionPane.showMessageDialog(
                        null, "Setup Server,Username,Password,DBname",
                        ":: Connection Error NITGEN server :: ", JOptionPane.INFORMATION_MESSAGE);
            }

            // ===========================================
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            int portNumber = 1433;

            // jdbc:sqlserver://DESKTOP-NSLL7T5\\SQLEXPRESS:1433;databaseName=NitgenAccessManager;user=admin;password=admin
            String conntectionURL = "jdbc:sqlserver://" + serverNameTrim + ":" + portNumber + ";databaseName=" + dbNameTrim + ";user=" + userNameTrim + ";password=" + passwordTrim;
            connNitgen = DriverManager.getConnection(conntectionURL);

            // connNitgen=DriverManager.getConnection(url, userName, password);
            System.out.println("== Connected with NITGEN server ==");
            return connNitgen;

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(
                    null, e.getMessage(),
                    ":: Connection Error NITGEN server :: ", JOptionPane.INFORMATION_MESSAGE);
        }

        return null;
    }

}
