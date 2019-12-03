/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author VSIANIK
 */
public class OraDbConnection {
    
    public static Connection connection() {
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //"jdbc:oracle:thin:@localhost:1521:zktbiotime","zktadmin","Admin007
            Connection connOra = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:payroll", "payroll", "payroll");
            //System.out.println("::: It's Works ---> Oracle :::");
            return connOra;
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null," Please Check Database and User Name/Password",
//                    ":: Connection Error :: ", JOptionPane.INFORMATION_MESSAGE);
            e.printStackTrace();
        }
        
        return null;
    }
    
    public static Connection accessConnection(){
        
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn=DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\VSIANIK\\Desktop\\att2000.mdb");
            System.out.println("Connected");
            return conn;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
}
