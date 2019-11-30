/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesstotextconvert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author VSI-ANIK
 */
public class DataDelete {

    public void deleteAttendenceDataInAccessDb(String fromDate, String toDate) {
        Connection connAccess = AccessConnection.dbConnection();

        try {

            // Write SQL statement for delete data in access database 
            PreparedStatement statement = connAccess.prepareStatement("DELETE FROM CHECKINOUT WHERE DateValue(checktime) BETWEEN  #" + fromDate + "#  AND  #" + toDate + "#;");
            statement.executeUpdate(); // statement run

            System.out.println("Data Delete");
            JOptionPane.showMessageDialog(
                    null, " Date wise Attendence Delete Successfully :) ",
                    ":: Date Delete :: ", JOptionPane.INFORMATION_MESSAGE);
            connAccess.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(
                    null, " => Check Date Format and Date SQL :) ",
                    ":: Date Error :: ", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void deleteAttendenceFromRmsServer(String fromDate, String toDate) {
        Connection connAccessRms = AccessConnection.dbRTAConnection();

        try {
            PreparedStatement statementRms = connAccessRms.prepareCall("delete from data_card where d_card between '" + fromDate + "' and '" + toDate + "';");
            statementRms.execute();

            System.out.println("Data Delete");
            connAccessRms.close();
            statementRms.close();

            JOptionPane.showMessageDialog(
                    null, " Date wise Attendence Delete Successfully :) ",
                    ":: Date Delete :: ", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(DataDelete.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

// unused sql statement
//            CHECKINOUT.USERID,CHECKINOUT.CHECKTIME,CHECKINOUT.CHECKTYPE,"
//                    + "CHECKINOUT.VERIFYCODE,CHECKINOUT.SENSORID,CHECKINOUT.Memoinfo,CHECKINOUT.WorkCode,"
//                    + "CHECKINOUT.sn,CHECKINOUT.UserExtFmt,CHECKINOUT.DDate,CHECKINOUT.DTime,CHECKINOUT.Mrk"
//"DELETE FROM CHECKINOUT WHERE (CHECKINOUT.CHECKTIME) BETWEEN (#07/21/2019 1:00:00 AM#) AND (#07/21/2019 23:00:00 PM#);"
}
