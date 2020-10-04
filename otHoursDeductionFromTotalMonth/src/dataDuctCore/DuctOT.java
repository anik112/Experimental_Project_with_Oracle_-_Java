/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataDuctCore;

import dataDuctModel.OtHoursDuctModel;
import databaseConnection.OraDbConnection;
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
 * @author VSI-ANIK
 */
public class DuctOT {

    public void _OtDuct(int finyear, String finmonth, int totalDuctOfHur, int comid) {

        List<OtHoursDuctModel> modelData = new ArrayList<>();

        try {

            ResultSet rs = null;
            Connection dataConnect = OraDbConnection.connection();
            String sqlStatement = "SELECT CARDNO,SECRETENO,EMPID FROM TB_PERSONAL_INFO WHERE OTORG='Y' AND OTCOM='Y' AND ACTIVE=0";
            PreparedStatement statement = dataConnect.prepareStatement(sqlStatement);
            rs = statement.executeQuery();

            try {
                while (rs.next()) {
                    //System.out.println(rs.getString(1));

                    OtHoursDuctModel model = new OtHoursDuctModel();
                    model.setCardno(rs.getString(1));
                    model.setSecreteno(rs.getString(2));
                    model.setEmpID(rs.getInt(3));

                    modelData.add(model);
                }

            } finally {
                statement.close();
                rs.close();
                dataConnect.close();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    ":: SQL error :: ", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(DuctOT.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Connection connection2 = OraDbConnection.connection();
            Connection connection3 = OraDbConnection.connection();
            for (OtHoursDuctModel ductModel : modelData) {
                PreparedStatement ps = connection2.prepareStatement("SELECT CARDNO, PDATE, OTMIN, OTPART, DURATION, INTIME, OUTTIME "
                        + "FROM TB_DATA_MASTER WHERE FINYEAR=" + finyear + " AND FINMONTH='" + finmonth + "' AND CARDNO='" + ductModel.getCardno() + "'"
                        + " AND OTMIN > 0 AND COMPANY=" + comid);

                ResultSet rs = ps.executeQuery();
                int count = 0;

                System.out.println("Cardno: " + ductModel.getCardno());

                int totalHr = totalDuctOfHur;
                while (rs.next()) {

                    SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
                    String date = format.format(rs.getDate("PDATE"));
                    System.out.println("-> " + date + " OT: " + (rs.getInt("OTMIN") + rs.getInt("OTPART")));

                    int otCom = rs.getInt("OTMIN");
                    int exOt = rs.getInt("OTPART");
                    int totalOt = otCom + exOt;

                    int ductHur = Math.round(totalOt / 60);

                    if (totalHr <= 0) {
                        break;
                    }

                    if (ductHur <= totalHr) {

                        String sqlOrg = "update tb_data_master set \n"
                                + "outtime='17'||substr(outtime,3), \n"
                                + "duration='9'||substr(duration,instr(duration,':')), \n"
                                + "otmin=0, \n"
                                + "otpart=0, \n"
                                + "outtime_v='17'||substr(outtime_v,3), \n"
                                + "duration_v='17'||substr(duration_v,instr(duration_v,':')), \n"
                                + "otmin_v=0 \n"
                                + "where company= " + comid + " \n"
                                + "and pdate='" + date + "' \n"
                                + "and cardno='" + rs.getString("CARDNO") + "'";

                        PreparedStatement psOrg = connection2.prepareStatement(sqlOrg);
                        psOrg.executeUpdate();

                        String sqlCom = "update tb_data_master_temp set \n"
                                + "outtime='17'||substr(outtime,3), \n"
                                + "duration='9'||substr(duration,instr(duration,':')), \n"
                                + "otmin=0, \n"
                                + "otpart=0, \n"
                                + "outtime_v='17'||substr(outtime_v,3), \n"
                                + "duration_v='17'||substr(duration_v,instr(duration_v,':')), \n"
                                + "otmin_v=0 \n"
                                + "where company= " + comid + " \n"
                                + "and pdate='" + date + "' \n"
                                + "and cardno='" + rs.getString("CARDNO") + "'";

                        PreparedStatement psCom = connection3.prepareStatement(sqlCom);
                        psCom.executeUpdate();

                        System.out.println("---> duct: " + totalHr + " Main duthr: " + ductHur);
                        totalHr -= ductHur;
                        count++;
                        psOrg.close();
                        psCom.close();
                        
                    } else if (ductHur > totalHr) {

                        int otOrg2 = 0;
                        int otEx2 = 0;
                        
                        int tempHr=ductHur-totalHr;

                        if (tempHr > 2) {
                            otOrg2 = 120;
                            otEx2 = (tempHr * 60) - 120;
                        } else {
                            otOrg2 = (tempHr * 60);
                            otEx2 = 0;
                        }
                        

                        String sqlOrg = "update tb_data_master set \n"
                                + "outtime='" + (17 + tempHr) + "'||substr(outtime,3), \n"
                                + "duration='" + (9 + tempHr) + "'||substr(duration,instr(duration,':')), \n"
                                + "otmin=" + otOrg2 + ", \n"
                                + "otpart=" + otEx2 + ", \n"
                                + "outtime_v='" + (17 + tempHr) + "'||substr(outtime_v,3), \n"
                                + "duration_v='" +  (9 + tempHr) + "'||substr(duration_v,instr(duration_v,':')), \n"
                                + "otmin_v=" + otOrg2 + " \n"
                                + "where company= " + comid + " \n"
                                + "and pdate='" + date + "' \n"
                                + "and cardno='" + rs.getString("CARDNO") + "'";

                        PreparedStatement psOrg = connection2.prepareStatement(sqlOrg);
                        psOrg.executeUpdate();

                        String sqlCom = "update tb_data_master_temp set \n"
                                + "outtime='" + (17 + (otOrg2 / 60)) + "'||substr(outtime,3), \n"
                                + "duration='" + (9 + (otOrg2 / 60)) + "'||substr(duration,instr(duration,':')), \n"
                                + "otmin=" + otOrg2 + ", \n"
                                + "otpart=0, \n"
                                + "outtime_v='" + (17 + (otOrg2 / 60)) + "'||substr(outtime_v,3), \n"
                                + "duration_v='" + (9 + (otOrg2 / 60)) + "'||substr(duration_v,instr(duration_v,':')), \n"
                                + "otmin_v=" + otOrg2 + " \n"
                                + "where company= " + comid + " \n"
                                + "and pdate='" + date + "' \n"
                                + "and cardno='" + rs.getString("CARDNO") + "'";

                        PreparedStatement psCom = connection3.prepareStatement(sqlCom);
                        psCom.executeUpdate();

                        System.out.println("ELS -> duct: " + totalHr + " Main duthr: " + ductHur+" OT: "+otOrg2);
                        totalHr -= ductHur;
                        count++;
                        psOrg.close();
                        psCom.close();

                    }

                }
                System.out.println("=================== " + count);
                ps.close();
            }
            connection2.close();
            connection3.close();
            JOptionPane.showMessageDialog(null, " Hours DUCT Successfully ",
                    ":: Successfull :: ", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    ":: Data not update :: ", JOptionPane.ERROR_MESSAGE);
        }

    }

}

//                    String sql = "update tb_data_master set \n"
//                            + "outtime=(to_char(substr(outtime,1,instr(outtime,':')-1))-" + ductHur + ")||substr(outtime,3), \n"
//                            + "duration=(to_char(substr(duration,1,instr(duration,':')-1))-" + ductHur + ")||substr(duration,instr(duration,':')), \n"
//                            + "otmin=(otmin-" + otCom + "), \n"
//                            + "otpart=(otpart-" + exOt + "), \n"
//                            + "outtime_v=(to_char(substr(outtime_v,1,instr(outtime_v,':')-1))-" + ductHur + ")||substr(outtime_v,3), \n"
//                            + "duration_v=(to_char(substr(duration_v,1,instr(duration_v,':')-1))-" + ductHur + ")||substr(duration_v,instr(duration_v,':')), \n"
//                            + "otmin_v=(otmin_v-" + otCom + ") \n"
//                            + "where company= " + comid + " \n"
//                            + "and pdate='" + date + "' \n"
//                            + "and cardno='" + rs.getString("CARDNO") + "'";
