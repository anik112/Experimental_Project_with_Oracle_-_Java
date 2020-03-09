/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author VSI-ANIK
 */
public class DBConnection {
    
    public static Connection connection() {
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //"jdbc:oracle:thin:@localhost:1521:zktbiotime","zktadmin","Admin007
            Connection connOra = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:payroll","tagGenerator", "tagGenerator");
            //System.out.println("::: It's Works ---> Oracle :::");
            return connOra;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null," Please Check Database and User Name/Password",
                    ":: Connection Error :: ", JOptionPane.INFORMATION_MESSAGE);
        }
        
        return null;
    }
    
}
