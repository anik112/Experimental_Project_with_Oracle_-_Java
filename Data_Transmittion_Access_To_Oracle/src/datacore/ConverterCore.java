/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datacore;

import connection.DBconnection;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author VSI-ANIK
 */
public class ConverterCore {

    private int rowCount = 0;
    private int maxSize = 0;

    //005:0001090025:20190918:074957:BLANK !!:11
    //"00"+STRING(NODE_NO)+":"+CARD_NO+":"+D_CARD+":"+T_CARD+":"+"BLANK !!"+":"+"11"
    public void txtConverter(String fromDate, String toDate, String rtaFromDate, String rtaToDate) throws IOException {

        System.out.println(rtaFromDate + "  ==  " + rtaToDate);

        // get data from access database
        try {
            Connection getConn = DBconnection.getConnection("ZKT"); // get connection from access database
            // write SQL for pull data from database
            String sql02 = "SELECT CHECKINOUT.CHECKTIME,CHECKINOUT.SENSORID,CHECKINOUT.USERID,USERINFO.Badgenumber "
                    + "FROM CHECKINOUT,USERINFO WHERE "
                    + "DateValue(checktime) BETWEEN  #" + fromDate + "#  AND  #" + toDate + "# "
                    + "AND USERINFO.USERID=CHECKINOUT.USERID";

            PreparedStatement statement = getConn.prepareStatement(sql02); // statement create
            ResultSet rs = statement.executeQuery(); // statement execute
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss a"); // get formatter for format date

            // ========== RMS ============
            Connection getRtaConn = DBconnection.getConnection("RTA"); // get RMS server connection
            String sql03 = "SELECT NODE_NO,CARD_NO,D_CARD,T_CARD FROM DATA_CARD WHERE (((data_card.d_card)='" + rtaFromDate + "')) OR (((data_card.d_card)='" + rtaToDate + "'));";
            PreparedStatement rtaStatement = getRtaConn.prepareStatement(sql03); // statement create
            ResultSet rtaSet = rtaStatement.executeQuery(); // statement execute           
            //System.exit(0);

            // ========== ORACLE ===========
            Connection getOraConnection = DBconnection.getConnection("ORA");
            String sqlOra = "INSERT INTO TB_DATA_LOAD (MACHINENO,SECRETENO,DATADATE,DATATIME,STATUS)VALUES (?,?,?,?,'BLANK !!:11')";

            // wite data in Oracle table
            try {
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

                    // INSERT data in TB_DATA_LOAD table
                    PreparedStatement oraStatement = getOraConnection.prepareStatement(sqlOra);
                    oraStatement.setString(1, rs.getString(2));
                    oraStatement.setString(2, "00" + rs.getString(4));
                    oraStatement.setString(3, onlyDate);
                    oraStatement.setString(4, onlyTime);
                    oraStatement.executeUpdate();
                    oraStatement.close();

                    System.out.println(rs.getString(2) + ":" + rs.getString(4) + ":" + onlyDate + ":" + onlyTime + ":" + "BLANK !!:11");
                    rowCount++; // row count
                }

                // "00"+STRING(NODE_NO)+":"+CARD_NO+":"+D_CARD+":"+T_CARD+":"+"BLANK !!"+":"+"11"
                while (rtaSet.next()) {
                    System.out.println("----------- in ");

                    // INSERT data in TB_DATA_LOAD table
                    PreparedStatement oraStatement = getOraConnection.prepareStatement(sqlOra);
                    oraStatement.setString(1, "0" + rtaSet.getString(1));
                    oraStatement.setString(2, rtaSet.getString(2));
                    oraStatement.setString(3, rtaSet.getString(3));
                    oraStatement.setString(4, rtaSet.getString(4));
                    oraStatement.executeUpdate();
                    oraStatement.close();

                    // Make string format
                    System.out.println("0" + rtaSet.getString(1) + ":" + rtaSet.getString(2) + ":" + rtaSet.getString(3) + ":" + rtaSet.getString(4) + ":" + "BLANK !!:11");
                    rowCount++; // row count
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ConverterCore.java | " + e.getMessage(),
                        ":: File Error ZKT server :: ", JOptionPane.INFORMATION_MESSAGE);
            }

            statement.close();
            rs.close();
            getConn.close();
            rtaStatement.close(); // close
            rtaSet.close(); // close
            getRtaConn.close(); // close
            getOraConnection.close();

            JOptionPane.showMessageDialog(
                    null, rowCount + " Data Sucessfully Generate ",
                    ":: Date Converting Success :: ", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Check SQL Syntex or Data | " + e.getMessage(),
                    ":: SQL Error :: ", JOptionPane.INFORMATION_MESSAGE);
        }
        System.gc();
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

}


/* SQL Document MS Access*/
//"SELECT CHECKINOUT.CHECKTIME,CHECKINOUT.SENSORID,CHECKINOUT.USERID,USERINFO.Badgenumber "
//                    + "FROM CHECKINOUT,USERINFO WHERE "
//                    + "(CHECKINOUT.CHECKTIME) between (#" + fromDate + " 7:00:00 AM#) and (#" + toDate + " 7:00:00 AM#)"
//                    + "AND USERINFO.USERID=CHECKINOUT.USERID";
//SELECT NODE_NO,CARD_NO,D_CARD,T_CARD FROM DATA_CARD WHERE D_CARD BETWEEN '20191126' AND '20191127';
// delete from data_card where d_card between '20190101' and '20190530'
// delete from checkinout where DateValue(checktime) BETWEEN  #01/01/2018#  AND  #12/30/2018#
