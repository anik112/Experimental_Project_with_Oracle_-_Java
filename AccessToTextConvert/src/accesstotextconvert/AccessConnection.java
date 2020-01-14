/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesstotextconvert;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;
import utility.KeyList;
import utility.PWS;
import utility.PasswordEnqDnq;

/**
 *
 * @author VSI-ANIK
 */
public class AccessConnection {

    //String serverName = "DESKTOP-NSLL7T5\\SQLEXPRESS";
    //String database = "NitgenAccessManager";
    //String userName = "admin";
    //String password = "admin";
    //C:\\Users\\carev\\Desktop 
    //C:\\Users\\carev\\Documents 
    private static String serverNameTrim = "";
    private static String userNameTrim = "";
    private static String passwordTrim = "";
    private static String dbNameTrim = "";
    private static String zktFileName = "";
    private static String rtaFileName = "";
    private static KeyList keyList = new KeyList();

    // setup class for setup all data
    public static void setupUtility() {

        // check file is exists
        try (InputStream input = new FileInputStream("config.properties")) {
            Properties properties = new Properties();
            properties.load(input);

            serverNameTrim = properties.getProperty(keyList.KEY_SERVER_NAME); // get server name from txt file
            userNameTrim = properties.getProperty(keyList.KEY_USER_NAME); // get user name from txt file
            passwordTrim = properties.getProperty(keyList.KEY_USER_PASSWORD); // get password from txt file
            dbNameTrim = properties.getProperty(keyList.KEY_DATABSE_NAME); // get db name from txt file
            zktFileName = properties.getProperty(keyList.KEY_ZKT_LINK); // get zkt file path
            rtaFileName = properties.getProperty(keyList.KEY_RTA_LINK); // get rta file path
            properties.clear();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    null, "Check File Exists? " + e.getMessage(),
                    ":: File Not Found :: ", JOptionPane.INFORMATION_MESSAGE);
        }
        PasswordEnqDnq ped = new PWS(); // call boj for password deque
        passwordTrim = ped.passwordDnq(passwordTrim); // call deque method

    }

    // ZKT database connection
    public static Connection dbConnection() {

        setupUtility();
        Connection connAccess;

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            connAccess = DriverManager.getConnection("jdbc:ucanaccess://" + zktFileName);
            System.out.println("== Connected with ZKT server ==");
            return connAccess;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(
                    null, e.getMessage(),
                    ":: Connection Error ZKT server :: ", JOptionPane.INFORMATION_MESSAGE);
        }
        return null;
    }

    // RTA database connection
    public static Connection dbRTAConnection() {
        setupUtility();
        Connection connAccess;

        try {
            //C:\\Users\\carev\\Desktop 
            //C:\\Users\\carev\\Documents 
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            connAccess = DriverManager.getConnection("jdbc:ucanaccess://" + rtaFileName);
            System.out.println("== Connected with RMS server ==");
            return connAccess;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(
                    null, e.getMessage(),
                    ":: Connection Error RMS server :: ", JOptionPane.INFORMATION_MESSAGE);
        }

        return null;
    }

    // NITGEN database connection
    public static Connection dbNITGENconnection() {
        setupUtility();
        Connection connNitgen;
        try {
            // ==========================================================
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            int portNumber = 1433;

            // jdbc:sqlserver://DESKTOP-NSLL7T5\\SQLEXPRESS:1433;databaseName=NitgenAccessManager;user=admin;password=admin
            String conntectionURL = "jdbc:sqlserver://" + serverNameTrim + ":" + portNumber + ";databaseName=" + dbNameTrim + ";user=" + userNameTrim + ";password=" + passwordTrim;
            connNitgen = DriverManager.getConnection(conntectionURL);
            // connNitgen=DriverManager.getConnection(url, userName, password);
            System.out.println("== Connected with NITGEN server ==");
            return connNitgen;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(
                    null, e.getMessage(),
                    ":: Connection Error NITGEN server :: ", JOptionPane.INFORMATION_MESSAGE);
        }

        return null;
    }

}
