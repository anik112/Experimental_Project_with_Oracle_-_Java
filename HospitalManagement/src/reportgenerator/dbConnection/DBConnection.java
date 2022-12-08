/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportgenerator.dbConnection;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author Anik
 */
public class DBConnection {

    private static String basedUrl = "jdbc:mysql:";
    private static String host = "localhost";//"DESKTOP-ICON0GA"//DESKTOP-KTD50PC;
    private static String port = "8080";
    private static String dbName = "hospital";//payroll
    private static String userName = "root";//report_generator
    private static String password = "";//report_generator
    private final static ConfigKeyList KEY_LIST = new ConfigKeyList();

    private static String url = "";
    private static java.sql.Connection connection = null;

    public static void setupUtility() {

        // check file is exists
        try (InputStream input = new FileInputStream("setup\\ConnectionSetup.properties")) {
            Properties properties = new Properties();
            properties.load(input);
            basedUrl = properties.getProperty(KEY_LIST.KEY_ORACLE_BASE_URL);
            host = properties.getProperty(KEY_LIST.KEY_SERVER_NAME);
            port = properties.getProperty(KEY_LIST.KEY_PORT_NUMBER);
            dbName = properties.getProperty(KEY_LIST.KEY_DATABSE_NAME);
            userName = properties.getProperty(KEY_LIST.KEY_USER_NAME);
            password = properties.getProperty(KEY_LIST.KEY_USER_PASSWORD);

            properties.clear();

            url = basedUrl + "//" + host + ":" + port + ":" + dbName;

        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    null, "Check File Exists? " + e.getMessage(),
                    ":: File Not Found :: ", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public static java.sql.Connection getConnection() {

        //setupUtility();
        
        //url = basedUrl + "//" + host + ":" + port + "/" + dbName;
        
        url = "jdbc:mysql://localhost:3306/hospital";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("::Connected::");
            return connection;
        } catch (Exception /*| ClassNotFoundException */ e) {
            e.printStackTrace();
            System.out.println("::Not Connected::");
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    ":: Error- DB 01 :: ", JOptionPane.INFORMATION_MESSAGE);
        }
        return null;
    }

}