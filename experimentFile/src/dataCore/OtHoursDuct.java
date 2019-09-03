/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataCore;

import dataConnection.OraDbConnection;
import dataModel.OtHoursDuctModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author VSIANIK
 */
public class OtHoursDuct {

    private Connection dataConnect = OraDbConnection.connection();
    private String sectionNM = "Sewing";
    private String finMonth = "March";
    private int finYear = 2019;
    private SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    private List<OtHoursDuctModel> modelData = new ArrayList<>();
    private int str = 0;
    private int end = 0;
    private int ductAmountOfHours = 0;

    public void dataProcess() throws SQLException {
        
        int temp = 1;
        str = 0;
        end = 200;
        dataConnect=dataConnection.OraDbConnection.connection();
        
        System.out.println("data ==========>" + modelData.size());
        // this loop control data limit
        outerLoop:
        while (temp != 0) {
            OtHoursDuctModelLib otLib=new OtHoursDuctModelLib();
            
            //  this loop control single person data
            for (int i = str; i < end; i++) {
                
                ductAmountOfHours = 4; // total ot duct hours.
                otLib.updateAttendence(ductAmountOfHours, finYear, finMonth, modelData.get(i).getCardno(),dataConnect);
                
                if (i == (modelData.size() - 1)) {
                    break outerLoop;
                }
                
                System.out.println("========================================== "+i+" cardno: "+modelData.get(i).getCardno());

            }
            str = end;
            end += 200;
        }
    }

    public void setData() throws SQLException {

        ResultSet rs = null;

        PreparedStatement statement = dataConnect.prepareStatement(""
                + "SELECT CARDNO,SECRETENO,EMPID FROM TB_PERSONAL_INFO "
                + "WHERE OTORG='Y' AND ACTIVE=0 AND SECTIONNM=?");
        statement.setString(1, sectionNM);

        rs = statement.executeQuery();
        //int count = 0;
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
            //System.out.println("rs ==============>" + rs.getRow());
            statement.close();
            rs.close();
            dataConnect.close();
        }

//        for (int i = 0; i < modelData.size(); i++) {
//            System.out.println(modelData.get(i).getEmpID() + " == " + modelData.get(i).getCardno() 
//                    +" == " + modelData.get(i).getSecreteno());
//        }
    }

    public static void main(String[] args) throws Throwable {
        OtHoursDuct otHoursDuct = new OtHoursDuct();
        otHoursDuct.setData();
        otHoursDuct.dataProcess();
        //Application.launch(args);
    }

}





//                try {
//
//                    statement02 = dataConnect.prepareStatement(""
//                            + "SELECT CARDNO,PDATE,INTIME,OUTTIME,DURATION,OTMIN FROM TB_DATA_MASTER "
//                            + "WHERE FINYEAR=? AND FINMONTH=? AND CARDNO=?");
//                    statement02.setInt(1, finYear);
//                    statement02.setString(2, finMonth);
//                    statement02.setString(3, modelData.get(i).getCardno());
//                    rs02 = statement02.executeQuery();
//
//                    // this loop control single date attendence of selected person.
//                    workWithDate:
//                    while (rs02.next()) {
//
//                        PreparedStatement dataUpdate = null;
//                        String finDate = formatter.format(rs02.getDate(2));
//
//                        int outTimeHours = Integer.parseInt(rs02.getString(4).substring(0, 2));
//                        int outTimeMin = Integer.parseInt(rs02.getString(4).substring(3, 5));
//                        int outTimeSec = Integer.parseInt(rs02.getString(4).substring(6, 8));
//                        String outTimeClock = rs02.getString(4).substring(9, 11);
//
//                        int durationHours = Integer.parseInt(rs02.getString(5).substring(0, rs02.getString(5).indexOf(":")));
//                        int durationMin = Integer.parseInt(rs02.getString(5).substring(rs02.getString(5).indexOf(":") + 1));
//
////                        System.out.println(rs02.getString(1) + " == " + rs02.getString(2) + " == " + rs02.getString(3)
////                        +" == "+rs02.getString(4)+" == "+rs02.getString(5)+" == "+rs02.getString(6));
//                        if ((rs02.getInt(6)) >= 60 && (durationHours > 9)) {
//
//                            int finHours = (outTimeHours - 1);
//                            
//                            String strFinHours;
//                            String strOutTimeMin;
//                            String strOutTimeSec;
//                            String strDurationMin;
//
//                            String finalOutTime = ((finHours / 10) == 0) ? "0" + finHours : finHours + ":"
//                                    + outTimeMin + ":" + outTimeSec + " " + outTimeClock;
//
//                            String finalDuration = (durationHours - 2) + ":" + durationMin;
//
//                            int otMin = ((finHours - 9) * 60) + outTimeMin;
//
//                            if (otMin > 40 && otMin < 100) {
//                                otMin = 60;
//                            } else if (otMin > 100 && otMin < 160) {
//                                otMin = 120;
//                            } else if (otMin > 160 && otMin < 220) {
//                                otMin = 180;
//                            } else if (otMin > 220 && otMin < 280) {
//                                otMin = 240;
//                            } else if (otMin > 280 && otMin < 340) {
//                                otMin = 300;
//                            } else if (otMin > 340 && otMin < 400) {
//                                otMin = 360;
//                            } else if (otMin > 400 && otMin < 460) {
//                                otMin = 420;
//                            } else if (otMin > 460 && otMin < 520) {
//                                otMin = 480;
//                            }
//
//                            dataUpdate = dataConnect.prepareStatement(""
//                                    + "UPDATE FROM TB_DATA_MASTER SET OUTTIME=?,OUTTIME_V=?,DURATION=?,"
//                                    + "DURATION_V=?,OTMIN=?,OTMIN_V=? WHERE "
//                                    + "PDATE = TO_DATE('" + finDate + " 00:00:00', 'MM/DD/YYYY HH24:MI:SS') AND CARDNO=?"
//                            );
//
//                            dataUpdate.setString(1, finalOutTime);
//                            ductAmountOfHours -= 2;
//                            dataUpdate.setString(2, finalOutTime);
//                            dataUpdate.setString(3, finalDuration);
//                            dataUpdate.setString(4, finalDuration);
//                            dataUpdate.setInt(5, otMin);
//                            dataUpdate.setInt(6, otMin);
//
//                            dataUpdate.executeUpdate();
//                        }
//
//                        if (ductAmountOfHours == 0) {
//                            break workWithDate;
//                        }
//
//                    }
//                    System.out.println("rs02 ==========>" + rs02.getRow() + " i ==========>" + i);
//                } finally {
//                    statement02.close();
//                    rs02.close();
//                }