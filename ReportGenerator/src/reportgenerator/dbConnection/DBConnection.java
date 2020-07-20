/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportgenerator.dbConnection;

import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Anik
 */
public class DBConnection {

    private final static String BasedUrl = "jdbc:oracle:thin:";
    private final static String host = "DESKTOP-KTD50PC";//"192.168.1.204"//"DESKTOP-ICON0GA";
    private final static String port = "1521";
    private final static String dbName = "payroll";
    private final static String userName = "report_generator";
    private final static String password = "report_generator";

    private final static String url = BasedUrl + "@" + host + ":" + port + ":" + dbName;
    private static java.sql.Connection connection = null;

    public static java.sql.Connection getConnection() {

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(url,userName,password);
            System.out.println("::Connected::");
            return connection;
        } catch (Exception /*| ClassNotFoundException */ e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    ":: Error- DB 01 :: ", JOptionPane.INFORMATION_MESSAGE);
        }
        return null;
    }

}
