/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesstotextconvert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author VSI-ANIK
 */
public class DataDelete {

    public void deleteAttendenceDataInAccessDb(String date) {
        Connection connAccess = AccessConnection.dbConnection();

        try {

//            CHECKINOUT.USERID,CHECKINOUT.CHECKTIME,CHECKINOUT.CHECKTYPE,"
//                    + "CHECKINOUT.VERIFYCODE,CHECKINOUT.SENSORID,CHECKINOUT.Memoinfo,CHECKINOUT.WorkCode,"
//                    + "CHECKINOUT.sn,CHECKINOUT.UserExtFmt,CHECKINOUT.DDate,CHECKINOUT.DTime,CHECKINOUT.Mrk"
//"DELETE FROM CHECKINOUT WHERE (CHECKINOUT.CHECKTIME) BETWEEN (#07/21/2019 1:00:00 AM#) AND (#07/21/2019 23:00:00 PM#);"

            PreparedStatement statement = connAccess.prepareStatement("DELETE FROM CHECKINOUT WHERE (CHECKINOUT.CHECKTIME) BETWEEN (#"+date+" 1:00:00 AM#) AND (#"+date+" 23:00:00 PM#)");
            statement.executeUpdate();

            System.out.println("Data Delete");
            connAccess.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(
                    null, " => Check Date Format and Date SQL :) ",
                    ":: Date Error :: ", JOptionPane.INFORMATION_MESSAGE);
        }

    }
}
