/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataDuctCore;

import dataDuctModel.OtDuctParameters;
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
import javax.swing.SwingWorker;

/**
 *
 * @author VSI-ANIK
 */
public class DuctOT extends SwingWorker<Void, String> {

    private OtDuctParameters odp;

    public DuctOT() {
    }

    public DuctOT(OtDuctParameters odp) {
        this.odp = odp;
    }

    public void _OtDuct(OtDuctParameters parameters) {

        List<OtHoursDuctModel> modelData = new ArrayList<>();

        try {

            ResultSet rs = null;
            Connection dataConnect = OraDbConnection.connection();
            String sqlStatement = "SELECT CARDNO, SECRETENO, EMPID FROM TB_PERSONAL_INFO WHERE OTORG='Y' AND OTCOM='Y' AND ACTIVE=0 "
                    + "AND SECTIONNM='" + parameters.getSection() + "'";
            PreparedStatement statement = dataConnect.prepareStatement(sqlStatement);
            rs = statement.executeQuery();

            // get emp list
            try {
                while (rs.next()) {
                    //System.out.println(rs.getString(1));

                    OtHoursDuctModel model = new OtHoursDuctModel();
                    model.setCardno(rs.getString("CARDNO"));
                    model.setSecreteno(rs.getString("SECRETENO"));
                    model.setEmpID(rs.getInt("EMPID"));

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

            /// Problem in this block 
            for (OtHoursDuctModel ductModel : modelData) {
                PreparedStatement ps = connection2.prepareStatement("SELECT CARDNO, PDATE, OTMIN, OTPART, "
                        + "substr(duration,1,instr(duration,':')-1) dur_hr, substr(duration,instr(duration,':')+1) dur_min, INTIME, OUTTIME, "
                        + "substr(intime,1,2) intm_hr, substr(intime,4,2) intm_min, substr(intime,7,2) intm_sec, "
                        + "substr(outtime,1,2) outtm_hr, substr(outtime,4,2) outtm_min, substr(outtime,7,2) outtm_sec "
                        + "FROM TB_DATA_MASTER WHERE FINYEAR=? AND FINMONTH=? AND CARDNO=? "
                        + "AND OTMIN > 0 AND COMPANY=?");
                ps.setInt(1, parameters.getYear());
                ps.setString(2, parameters.getMonth());
                ps.setString(3, ductModel.getCardno());
                ps.setInt(4, parameters.getComId());

                ResultSet rsData = ps.executeQuery();
                int count = 0;

                firePropertyChange(null, null, "\nCardno: " + ductModel.getCardno() + " =======");
                System.out.println("Cardno: " + ductModel.getCardno());

                int totalDucOTHur = parameters.getDuctHours();
                while (rsData.next()) {

                    SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
                    String date = format.format(rsData.getDate("PDATE"));
                    int otCom = rsData.getInt("OTMIN");
                    int exOt = rsData.getInt("OTPART");
                    int totalOt = 0;

                    if (parameters.isOtpart()) {
                        totalOt = otCom + exOt;
                    } else {
                        totalOt = otCom;
                    }

                    int totalOTHur = Math.round(totalOt / 60);

                    if (totalDucOTHur <= 0) {
                        break;
                    }

                    if (totalOTHur <= totalDucOTHur) {

//                        String sqlOrg = "update tb_data_master set \n"
//                                + "outtime='17'||substr(outtime,3), \n"
//                                + "duration='9'||substr(duration,instr(duration,':')), \n"
//                                + "otmin=0, \n"
//                                + "otpart=0, \n"
//                                + "outtime_v='17'||substr(outtime_v,3), \n"
//                                + "duration_v='17'||substr(duration_v,instr(duration_v,':')), \n"
//                                + "otmin_v=0 \n"
//                                + "where company= " + parameters.getComId() + " \n"
//                                + "and pdate='" + date + "' \n"
//                                + "and cardno='" + rs.getString("CARDNO") + "'";
//
//                        PreparedStatement psOrg = connection2.prepareStatement(sqlOrg);
//                        psOrg.executeUpdate();
//
//                        if (parameters.isComplience()) {
//                            String sqlCom = "update tb_data_master_temp set \n"
//                                    + "outtime='17'||substr(outtime,3), \n"
//                                    + "duration='9'||substr(duration,instr(duration,':')), \n"
//                                    + "otmin=0, \n"
//                                    + "otpart=0, \n"
//                                    + "outtime_v='17'||substr(outtime_v,3), \n"
//                                    + "duration_v='17'||substr(duration_v,instr(duration_v,':')), \n"
//                                    + "otmin_v=0 \n"
//                                    + "where company= " + parameters.getComId() + " \n"
//                                    + "and pdate='" + date + "' \n"
//                                    + "and cardno='" + rs.getString("CARDNO") + "'";
//
//                            PreparedStatement psCom = connection3.prepareStatement(sqlCom);
//                            psCom.executeUpdate();
//                            psCom.close();
//                        }
                        totalDucOTHur -= totalOTHur;
                        count++;

                        firePropertyChange(null, null, "\n$ " + date + " TOT-OT: " + (rsData.getInt("OTMIN") + rsData.getInt("OTPART")));
                        System.out.println("-> " + date + " OT: " + totalOTHur + "  On hand: " + totalDucOTHur);
                        //psOrg.close();

                    } else if (totalOTHur > totalDucOTHur) {

                        int currentDurMin = rsData.getInt("dur_min");
                        int otOrg2 = 0;
                        int otEx2 = 0;

                        int tempHr = totalOTHur - totalDucOTHur;

                        int duration = (9 + tempHr) * 60;
                        duration = (duration - currentDurMin);
                        duration -= (9 * 60);
                        System.out.println("Du: " + duration);
                        tempHr = (int) Math.floor(duration / 60);

                        if (tempHr > 2) {
                            otOrg2 = 120;
                            otEx2 = duration - 120;
                        } else {
                            otOrg2 = duration;
                            otEx2 = 0;
                        }

//                        String sqlOrg = "update tb_data_master set \n"
//                                + "outtime='" + (17 + tempHr) + "'||substr(outtime,3), \n"
//                                + "duration='" + (9 + tempHr) + "'||substr(duration,instr(duration,':')), \n"
//                                + "otmin=" + otOrg2 + ", \n"
//                                + "otpart=" + otEx2 + ", \n"
//                                + "outtime_v='" + (17 + tempHr) + "'||substr(outtime_v,3), \n"
//                                + "duration_v='" + (9 + tempHr) + "'||substr(duration_v,instr(duration_v,':')), \n"
//                                + "otmin_v=" + otOrg2 + " \n"
//                                + "where company= " + parameters.getComId() + " \n"
//                                + "and pdate='" + date + "' \n"
//                                + "and cardno='" + rs.getString("CARDNO") + "'";
//
//                        PreparedStatement psOrg = connection2.prepareStatement(sqlOrg);
//                        psOrg.executeUpdate();
//
//                        if (parameters.isComplience()) {
//                            String sqlCom = "update tb_data_master_temp set \n"
//                                    + "outtime='" + (17 + (otOrg2 / 60)) + "'||substr(outtime,3), \n"
//                                    + "duration='" + (9 + (otOrg2 / 60)) + "'||substr(duration,instr(duration,':')), \n"
//                                    + "otmin=" + otOrg2 + ", \n"
//                                    + "otpart=0, \n"
//                                    + "outtime_v='" + (17 + (otOrg2 / 60)) + "'||substr(outtime_v,3), \n"
//                                    + "duration_v='" + (9 + (otOrg2 / 60)) + "'||substr(duration_v,instr(duration_v,':')), \n"
//                                    + "otmin_v=" + otOrg2 + " \n"
//                                    + "where company= " + parameters.getComId() + " \n"
//                                    + "and pdate='" + date + "' \n"
//                                    + "and cardno='" + rs.getString("CARDNO") + "'";
//
//                            PreparedStatement psCom = connection3.prepareStatement(sqlCom);
//                            psCom.executeUpdate();
//                            psCom.close();
//                        }
                        totalDucOTHur -= totalOTHur;
                        count++;
                        //psOrg.close();

                        System.out.println("Date: " + date + " Outtime: " + (17 + tempHr) + ":" + rsData.getString("outtm_min") + ":"
                                + rsData.getString("outtm_sec") + " Dur: " + (9 + tempHr) + ":" + currentDurMin + " ComOT: " + otOrg2
                                + " ExOT: " + otEx2 + " On hand: " + totalDucOTHur);

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

    @Override
    protected Void doInBackground() throws Exception {

        firePropertyChange(null, null, "\n$ Start Duction Processing ...\n");
        _OtDuct(odp);

        return null;
    }

    /**
     * This method helps us to get all section name from database and push
     * result in view class.
     *
     * @return set of section name
     */
    public ResultSet getSectionName() {

        try {
            Connection dataConnect = OraDbConnection.connection();
            PreparedStatement statement = dataConnect.prepareStatement("SELECT SECTIONNM FROM TB_SECTION_INFO");
            ResultSet rs = statement.executeQuery();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, " No Section In Database",
                    ":: Class: OtHoursDuct :: ", JOptionPane.INFORMATION_MESSAGE);
        }
        return null;
    }

    /**
     * This method helps us to get all section name from database and push
     * result in view class.
     *
     * @return set of section name
     */
    public ResultSet getLineNo() {
        try {
            Connection dataConnect = OraDbConnection.connection();
            PreparedStatement statement = dataConnect.prepareStatement(""
                    + "SELECT DISTINCT LINENO FROM TB_PERSONAL_INFO ORDER BY LINENO ASC"
                    + "");
            ResultSet rs = statement.executeQuery();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, " No Line no In Database",
                    ":: Class: OtHoursDuct :: ", JOptionPane.INFORMATION_MESSAGE);
        }
        return null;
    }

    /**
     * This method helps us to get all section name from database and push
     * result in view class.
     *
     * @return set of company name
     */
    public ResultSet getCompany() {
        try {
            Connection dataConnect = OraDbConnection.connection();
            PreparedStatement statement = dataConnect.prepareStatement(""
                    + "SELECT COMID, COMPANY FROM TB_COMPANY_INFO ORDER BY COMID ASC");
            ResultSet rs = statement.executeQuery();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, " No Line no In Database",
                    ":: Class: OtHoursDuct :: ", JOptionPane.INFORMATION_MESSAGE);
        }
        return null;
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
