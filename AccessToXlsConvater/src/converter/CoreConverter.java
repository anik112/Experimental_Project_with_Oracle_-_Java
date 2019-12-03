/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import connection.DBconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author VSI-ANIK
 */
public class CoreConverter {

    Connection connection = DBconnection.getConnection();

    public void convertAccessToXls() {

        try {
            PreparedStatement statement2 = connection.prepareStatement("select * from checkinout");
            ResultSet rs2 = statement2.executeQuery();

            while (rs2.next()) {
                System.out.print(rs2.getString(1));
                //System.out.println("----- " + rs2.getString(2));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
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

    }

}
