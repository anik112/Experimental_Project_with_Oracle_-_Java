/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_transmittion_access_to_oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author VSI-ANIK
 */
public class MoveDataAccessToOra {

    public void moveDataAccessToOracle(String fromDate, String toDate) {
        Connection connAccess = null, connOra = null;
        PreparedStatement statementAccess = null;
        ResultSet rsAccess = null;

        try {

            Class.forName(
                    "net.ucanaccess.jdbc.UcanaccessDriver");
            connAccess = DriverManager.getConnection("jdbc:ucanaccess://C:\\Program Files (x86)\\ZKTeco\\att2000.mdb");

            Class.forName(
                    "oracle.jdbc.driver.OracleDriver");
            connOra = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:payroll", "payroll", "payroll");

            String sql02 = "SELECT CHECKINOUT.CHECKTIME,CHECKINOUT.SENSORID,CHECKINOUT.USERID,USERINFO.Badgenumber "
                    + "FROM CHECKINOUT,USERINFO WHERE "
                    + "(CHECKINOUT.CHECKTIME) between (#" + fromDate + " 9:00:00 AM#) and (#" + toDate + " 9:00:00 AM#)"
                    + "AND USERINFO.USERID=CHECKINOUT.USERID";
            statementAccess = connAccess.prepareStatement(sql02);
            rsAccess = statementAccess.executeQuery();

//            try (PreparedStatement oldData = connOra.prepareStatement("DELETE TB_ATTENDENCE_DATA WHERE PDATE >= TO_DATE('" + fromDate + " 09:00:00', 'MM/DD/YYYY HH24:MI:SS') OR PDATE <= TO_DATE('" + toDate + " 09:00:00', 'MM/DD/YYYY HH24:MI:SS')")) {
//                oldData.executeUpdate();
//                oldData.close();
//            }
//SELECT CHECKINOUT.CHECKTIME,CHECKINOUT.SENSORID,CHECKINOUT.USERID,USERINFO.Badgenumber FROM CHECKINOUT,USERINFO WHERE 
//(CHECKINOUT.CHECKTIME) between (#10/1/2019 9:00:00 AM#) and (#10/2/2019 5:00:00 PM#)
//AND USERINFO.USERID=CHECKINOUT.USERID
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss a");
            int i = 0;

            while (rsAccess.next()) {
                Date date = rsAccess.getTimestamp(1);
                String strDate = formatter.format(date);
                System.out.println(strDate);
                String onlyDate = strDate.substring(0, 10);
                System.out.println(onlyDate);
                String onlyTime = strDate.substring(11, 22);
                System.out.println(onlyTime + "--" + onlyTime.substring(9, 11));
                i++;

                try (PreparedStatement statementOra = connOra.prepareStatement("INSERT INTO TB_ATTENDENCE_DATA (MACNO,SECRETENO,PDATE,PTIME,COMPANY) VALUES (?,?,TO_DATE('" + onlyDate + " 00:00:00', 'MM/DD/YYYY HH24:MI:SS'),?,?)")) {
                    statementOra.setString(1, rsAccess.getString(2));
                    System.out.println("---------->>");
                    statementOra.setString(2, rsAccess.getString(4));
                    System.out.println("---------->>");
                    statementOra.setString(3, onlyTime);
                    System.out.println("---------->>");
                    statementOra.setInt(4, 2);

                    statementOra.executeUpdate();
                    statementOra.close();
                }
            }

            JOptionPane.showMessageDialog(
                    null, i + " => Data Sucessfully Moved :) ",
                    ":: Date Move Success :: ", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(
                    "Total: " + i);

            statementAccess.close();
            rsAccess.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Please Check > MoveDataAccessToOra < Class",
                    ":: SQL Error :: ", JOptionPane.INFORMATION_MESSAGE);
        }

    }

}
