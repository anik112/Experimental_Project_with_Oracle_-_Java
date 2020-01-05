/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesstotextconvert;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author VSI-ANIK
 */
public class AccessConnection {

    public static Connection dbConnection() {

        Connection connAccess;

        try {
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
    
    
    public static Connection dbNITGENconnection(){
        
        Connection connNitgen;
        try{
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String serverName="DESKTOP-NSLL7T5\\SQLEXPRESS";
            int portNumber=1433;
            String database="NitgenAccessManager";
            String userName="admin";
            String password="admin";
            
            // jdbc:sqlserver://DESKTOP-NSLL7T5\\SQLEXPRESS:1433;databaseName=NitgenAccessManager;user=admin;password=admin
            String conntectionURL="jdbc:sqlserver://"+serverName+":"+portNumber+";databaseName="+database+";user="+userName+";password="+password;
            connNitgen=DriverManager.getConnection(conntectionURL);
            
            // connNitgen=DriverManager.getConnection(url, userName, password);
            System.out.println("== Connected with NITGEN server ==");
            return connNitgen;
            
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(
                    null, e.getMessage(),
                    ":: Connection Error NITGEN server :: ", JOptionPane.INFORMATION_MESSAGE);
        }
        
        
        return null;
    }
    

}
