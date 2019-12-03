/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author VSI-ANIK
 */
public class DBconnection {

    public static Connection getConnection() {
        try {
            
            Connection connAccess;
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            connAccess = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\carev\\Desktop\\att2000.mdb");
            System.out.println("Connected---");
            return connAccess;
            
            //"jdbc:oracle:thin:@localhost:1521:zktbiotime","zktadmin","Admin007
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
