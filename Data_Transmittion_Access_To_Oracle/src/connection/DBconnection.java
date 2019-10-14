/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author VSI-ANIK
 */
public class DBconnection {

    public static Connection getConnection(String connectionName) {
        try {
            Connection connAccess=null, connOra=null;

            if (connectionName == "access") {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                connAccess = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\carev\\Desktop\\att2000.mdb");
                System.out.println("Connected---");
                return connAccess;
            } else if (connectionName == "oracle") {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                connOra = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:payroll", "payroll", "payroll");
                return connOra;
            } 

            //"jdbc:oracle:thin:@localhost:1521:zktbiotime","zktadmin","Admin007
            
//            PreparedStatement statement = connOra.prepareStatement("select * from INOUT");
//            ResultSet rs1 = statement.executeQuery();

//            PreparedStatement statement2 = connAccess.prepareStatement("select * from checkinout");
//            ResultSet rs2 = statement2.executeQuery();
//
//            while (rs2.next()) {
//                System.out.print(rs2.getString(1));
//                //System.out.println("----- " + rs2.getString(2));
//            }

//            String insertOraDataBaseIntime = "insert into (in_time) values (";
//            String insertOraDataBaseOuttime = "insert into (out_time) values (";
//            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss a");
//
//            while (rs2.next()) {
//                Date date = rs2.getTimestamp(2);
//                String strDate = formatter.format(date);
//                System.out.println(strDate);
//                String onlyDate = strDate.substring(0, 10);
//                System.out.println(onlyDate);
//                String onlyTime = strDate.substring(11, 22);
//                System.out.println(onlyTime + "--" + onlyTime.substring(9, 11))
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
