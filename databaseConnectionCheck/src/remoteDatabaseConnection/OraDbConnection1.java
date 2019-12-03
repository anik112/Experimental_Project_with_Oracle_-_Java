/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remoteDatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author VSIANIK
 */
public class OraDbConnection1 {

    public static Connection connection() {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //"jdbc:oracle:thin:@localhost:1521:zktbiotime","zktadmin","Admin007
            Connection connOra
                    = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-A1SEADB:1521:payroll", "payroll", "payroll");
            System.out.println("::: It's Works ---> Oracle :::");
            return connOra;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Please Check Database and User Name/Password",
                    ":: Connection Error :: ", JOptionPane.INFORMATION_MESSAGE);
            e.printStackTrace();
            System.exit(0);
        }

        return null;
    }

}
