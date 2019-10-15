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
import java.sql.Statement;
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

        Connection getConn = AccessConnection.dbConnection();
        Random random = new Random();
        String filePath = "D:\\DATA\\";
        String dateForFileName = toDate.replace("/", "");
        String fileName = dateForFileName + random.nextInt(9) + ".txt";
        int rowCount = 0;

        try {
            String sql02 = "SELECT CHECKINOUT.CHECKTIME,CHECKINOUT.SENSORID,CHECKINOUT.USERID,USERINFO.Badgenumber "
                    + "FROM CHECKINOUT,USERINFO WHERE "
                    + "(CHECKINOUT.CHECKTIME) between (#" + fromDate + " 9:00:00 AM#) and (#" + toDate + " 9:00:00 AM#)"
                    + "AND USERINFO.USERID=CHECKINOUT.USERID";
            PreparedStatement statement = getConn.prepareStatement(sql02);
            ResultSet rs = statement.executeQuery();

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss a");

            try {

                FileWriter fileWriter = new FileWriter(filePath + fileName);
                PrintWriter printWriter = new PrintWriter(fileWriter);

                while (rs.next()) {
                    Date date = rs.getTimestamp(1);
                    String strDate = formatter.format(date);
                    System.out.println(strDate);
                    String onlyDate = strDate.substring(0, 10);
                    onlyDate = onlyDate.replace("/", "");
                    System.out.println(onlyDate);
                    String onlyTime = strDate.substring(11, 22);
                    onlyTime = onlyTime.substring(0, 8);
                    onlyTime = onlyTime.replace(":", "");
                    System.out.println(onlyTime);

                    String finalText = (rs.getString(2) + ":" + rs.getString(3) + ":" + onlyDate + ":" + onlyTime + ":" + "BLANK !!:11");
                    printWriter.println(finalText);

                    System.out.println(rs.getString(2) + ":" + rs.getString(3) + ":" + onlyDate + ":" + onlyTime + ":" + "BLANK !!:11");
                    rowCount++;
                }
                printWriter.close();
                fileWriter.close();

                JOptionPane.showMessageDialog(
                        null, rowCount + " => Data Sucessfully Generate :) ",
                        ":: Date Converting Success :: ", JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "File System Error, Check FileWriter.PrintWriter",
                        ":: File Error :: ", JOptionPane.INFORMATION_MESSAGE);
            }
            statement.close();
            rs.close();
            getConn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Check SQL Syntex or Data",
                    ":: SQL Error :: ", JOptionPane.INFORMATION_MESSAGE);
        } 
    }


}
