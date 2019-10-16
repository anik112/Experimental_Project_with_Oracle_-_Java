/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesstotextconvert;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author VSI-ANIK
 */
public class ConverterCore {

    //005:0001090025:20190918:074957:BLANK !!:11
    //"00"+STRING(NODE_NO)+":"+CARD_NO+":"+D_CARD+":"+T_CARD+":"+"BLANK !!"+":"+"11"
    public void txtConverter(String fromDate, String toDate) {

        Connection getConn = AccessConnection.dbConnection(); // get connection from access database
        Random random = new Random(); // generat random number
        String filePath = "D:\\DATA\\"; // file location
        String dateForFileName = toDate.replace("/", ""); // resize date
        String fileName = dateForFileName + random.nextInt(9) + ".txt"; // file name
        int rowCount = 0; // count row
        
        // get data from access database
        try {
            // write SQL for pull data from database
            String sql02 = "SELECT CHECKINOUT.CHECKTIME,CHECKINOUT.SENSORID,CHECKINOUT.USERID,USERINFO.Badgenumber "
                    + "FROM CHECKINOUT,USERINFO WHERE "
                    + "(CHECKINOUT.CHECKTIME) between (#" + fromDate + " 9:00:00 AM#) and (#" + toDate + " 9:00:00 AM#)"
                    + "AND USERINFO.USERID=CHECKINOUT.USERID";
            PreparedStatement statement = getConn.prepareStatement(sql02); // statement create
            ResultSet rs = statement.executeQuery(); // statement execute

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss a"); // get formatter for format date
            
            // wite data in txt file
            try {
                FileWriter fileWriter = new FileWriter(filePath + fileName); // call fileWriter for get file or create file in system
                PrintWriter printWriter = new PrintWriter(fileWriter); // call printWriter for write text in file
                // loop for push data in txt file
                while (rs.next()) {
                    Date date = rs.getTimestamp(1); // get date/time form result sheet
                    String strDate = formatter.format(date); // format date using date formatter
                    System.out.println(strDate);
                    String onlyDate = strDate.substring(0, 10); // get only date from (date/time)
                    onlyDate = onlyDate.replace("/", ""); // remove '/' from date
                    System.out.println(onlyDate);
                    String onlyTime = strDate.substring(11, 22); // get only time form (date/time)
                    onlyTime = onlyTime.substring(0, 8); // resize time
                    onlyTime = onlyTime.replace(":", ""); // remove ':' from time
                    System.out.println(onlyTime);
                    
                    // Make string format
                    String finalText = (rs.getString(2) + ":" + rs.getString(3) + ":" + onlyDate + ":" + onlyTime + ":" + "BLANK !!:11");
                    printWriter.println(finalText); // write text in file

                    System.out.println(rs.getString(2) + ":" + rs.getString(3) + ":" + onlyDate + ":" + onlyTime + ":" + "BLANK !!:11");
                    rowCount++; // row count
                }
                printWriter.close(); // close
                fileWriter.close(); // close

                JOptionPane.showMessageDialog(
                        null, rowCount + " Data Sucessfully Generate ",
                        ":: Date Converting Success :: ", JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "ConverterCore.java | "+e.getMessage(),
                        ":: File Error :: ", JOptionPane.INFORMATION_MESSAGE);
            }
            statement.close();
            rs.close();
            getConn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Check SQL Syntex or Data | "+e.getMessage(),
                    ":: SQL Error :: ", JOptionPane.INFORMATION_MESSAGE);
        } 
    }


}