/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesstotextconvert;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author VSI-ANIK
 */
public class AccessConnection {

    public static Connection dbConnection() {

        Connection connAccess;

        try {
            //C:\\Users\\carev\\Desktop 
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            connAccess = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\carev\\Documents\\att20000.mdb");

            System.out.println("== Connected ==");
            return connAccess;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
