
import databaseConnection.OraDbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author VSI-ANIK
 */
public class Test {

    public static void main(String arg[]) {
        try {
            Connection connection2 = OraDbConnection.connection();

            PreparedStatement ps = connection2.prepareStatement("SELECT CARDNO, PDATE, OTMIN, OTPART, "
                    + "substr(duration,1,instr(duration,':')-1) dur_hr, substr(duration,instr(duration,':')+1) dur_min, INTIME, OUTTIME, "
                    + "substr(intime,1,2) intm_hr, substr(intime,4,2) intm_min, substr(intime,7,2) intm_sec, "
                    + "substr(outtime,1,2) outtm_hr, substr(outtime,4,2) outtm_min, substr(outtime,7,2) outtm_sec "
                    + "FROM TB_DATA_MASTER WHERE FINYEAR=? AND FINMONTH=? AND CARDNO=? "
                    + "AND OTMIN > 0 AND COMPANY=?");

            ps.setInt(1, 2020);
            ps.setString(2, "February");
            ps.setString(3, "I-7003");
            ps.setInt(4, 2);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("Cardno: " + rs.getString("CARDNO"));
                System.out.println("-> " + rs.getInt("dur_hr"));
                System.out.println("-> " + rs.getInt("dur_min"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
