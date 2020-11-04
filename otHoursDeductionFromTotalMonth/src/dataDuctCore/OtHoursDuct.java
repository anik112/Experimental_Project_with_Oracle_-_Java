/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataDuctCore;

import databaseConnection.OraDbConnection;
import dataDuctModel.OtHoursDuctModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author VSIANIK
 */
public class OtHoursDuct {

    private Connection dataConnect;
    private SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    private List<OtHoursDuctModel> modelData = new ArrayList<>();
    private int str = 0;
    private int end = 0;
    private int companyId = 0;

    /**
     * Data process method.this method push card no to another lib method
     *
     * @param ductAmountOfHours
     * @param finYear
     * @param finMonth
     */
    public void dataProcess(int ductAmountOfHours, int finYear, String finMonth, boolean complience, String companyName) {

        try {
            System.out.println("data ==========>" + modelData.size());
            if (ductAmountOfHours > 0) {

                Connection con = OraDbConnection.connection();
                PreparedStatement stmt = con.prepareCall("select comid from tb_company_info where company='" + companyName + "'");
                ResultSet set = stmt.executeQuery();

                while (set.next()) {
                    companyId = set.getInt("comid");
                }

                for (OtHoursDuctModel otHoursDuctModel : modelData) {

                    Connection connection = OraDbConnection.connection();

                    PreparedStatement ps = connection.prepareCall("SELECT CARDNO, PDATE, OTMIN, OTPART, DURATION, INTIME, OUTTIME\n"
                            + "FROM TB_DATA_MASTER \n"
                            + "WHERE COMPANY=" + companyId + "\n"
                            + "AND	  FINYEAR=" + finYear + "\n"
                            + "AND	  FINMONTH='" + finMonth + "'\n"
                            + "AND	  CARDNO='" + otHoursDuctModel.getCardno() + "'");

                    ResultSet rs = ps.executeQuery();

                    int otHrsCount = 0;
                    while (rs.next()) {
                        if (rs.getInt("OTMIN") > 0 && otHrsCount < ductAmountOfHours) {
                            Connection c = OraDbConnection.connection();
                            PreparedStatement statement
                                    = c.prepareCall("update tb_data_master set\n"
                                            + "outtime=(to_char(substr(outtime,1,instr(outtime,':')-1))-1)||substr(outtime,3), \n"
                                            + "duration=(to_char(substr(duration,1,instr(duration,':')-1))-1)||substr(duration,instr(duration,':')),\n"
                                            + "otmin=(otmin-60),\n"
                                            + "outtime_v=(to_char(substr(outtime_v,1,instr(outtime_v,':')-1))-1)||substr(outtime_v,3),\n"
                                            + "duration_v=(to_char(substr(duration_v,1,instr(duration_v,':')-1))-1||substr(duration_v,instr(duration_v,':')),\n"
                                            + "otmin_v=(otmin_v-60)\n"
                                            + "from tb_data_master \n"
                                            + "where company=" + companyId + "\n"
                                            + "and pdate=" + rs.getDate("PDATE") + "\n"
                                            + "and cardno='" + rs.getString("CARDNO") + "'");
                            statement.executeUpdate();
                            c.close();
                            otHrsCount++;
                        }
                    }

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(OtHoursDuct.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, " Ot " + ductAmountOfHours + " Hours Dusuction Successfully ",
                ":: Successfull :: ", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * This method store card no from database using section name filter
     *
     * @param sectionNm
     * @param lineNo
     * @exception sql exception
     */
    public void setData(String sectionNm, String lineNo) {
        try {

            ResultSet rs = null;
            dataConnect = OraDbConnection.connection();
            String sqlStatement = "SELECT CARDNO,SECRETENO,EMPID FROM TB_PERSONAL_INFO WHERE OTORG='Y' OTCOM='Y' AND ACTIVE=0 "
                    + "AND SECTIONNM=? ";
            if (!"Nil".equals(lineNo)) {
                sqlStatement += "AND LINENO=?";
            }
            PreparedStatement statement = dataConnect.prepareStatement(sqlStatement);
            statement.setString(1, sectionNm);
            if (!"Nil".equals(lineNo)) {
                statement.setString(2, lineNo);
            }
            rs = statement.executeQuery();

            int count = 0;
            try {
                while (rs.next()) {
                    System.out.println(rs.getString(1));

                    OtHoursDuctModel model = new OtHoursDuctModel();
                    model.setCardno(rs.getString(1));
                    model.setSecreteno(rs.getString(2));
                    model.setEmpID(rs.getInt(3));

                    modelData.add(model);
                    count++;
                }

            } finally {
                System.out.println("rs ==============>" + count);
                statement.close();
                rs.close();
                dataConnect.close();
            }

            JOptionPane.showMessageDialog(null, " Data Initialize Successfully ",
                    ":: Successfull :: ", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, " Data Initialize Not Successfully ",
                    "Class: OtHoursDuct ", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    

}

//            OtHoursDuctModelLib otLib = new OtHoursDuctModelLib();
// this loop control data limit
//            outerLoop:
//            while (temp != 0) {
//                try {
//                    dataConnect = databaseConnection.OraDbConnection.connection();
//                    //  this loop control single person data
//                    for (int i = str; i < end; i++) {
//                        System.out.println("==================================================== " + i + " cardno: "
//                                + modelData.get(i).getCardno());
//
//                        otLib.updateAttendence(ductAmountOfHours, finYear, finMonth, 
//                                modelData.get(i).getCardno(), dataConnect,complience);
//
//                        if (i == (modelData.size() - 1)) {
//                            break outerLoop;
//                        }
//                    }
//                    str = end;
//                    end += 200;
//                    dataConnect.close();
//
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//                try {
//                    PreparedStatement statement=.prepareCall("select (to_char(substr(outtime,1,instr(outtime,':')-1))-1)||substr(outtime,3) mod_outtime, outtime,\n" +
//                            "(to_char(substr(duration,1,instr(duration,':')-1))-1)||substr(duration,instr(duration,':')) mod_duration, duration,\n" +
//                            "(otmin-60) mod_otmin, otmin,\n" +
//                            "(to_char(substr(outtime_v,1,instr(outtime_v,':')-1))-1)||substr(outtime_v,3) mod_outtime_v, outtime_v,\n" +
//                            "(to_char(substr(duration_v,1,instr(duration_v,':')-1))-1)||substr(duration_v,instr(duration_v,':')) mod_duration_v, duration_v,\n" +
//                            "(otmin_v-60) mod_otmin_v, otmin_v\n" +
//                            "from tb_data_master \n" +
//                            "where company=2\n" +
//                            "and finyear=2020\n" +
//                            "and finmonth='May'\n" +
//                            "and pdate='"++"' \n" +
//                            "and cardno="+);
//                } catch (SQLException ex) {
//                    Logger.getLogger(OtHoursDuct.class.getName()).log(Level.SEVERE, null, ex);
//                }
