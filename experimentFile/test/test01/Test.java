/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test01;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

/**
 *
 * @author VSIANIK
 */
public class Test {

    public static void main(String[] args) {

//        String time="18:16:11 AM";
//        
//        int inTimeHours=Integer.parseInt(time.substring(0, 2));
//        int inTimeMin= Integer.parseInt(time.substring(3, 5));
//        int inTimeSec=Integer.parseInt(time.substring(6, 8));
//        String inTimeD= time.substring(9, 11);
//        
//        System.out.println(inTimeHours);
//        System.out.println(inTimeMin);
//        System.out.println(inTimeSec);
//        System.out.println(inTimeD);
//        
//        
//        String duration="11:10";
//        
//        int durationHours=Integer.parseInt(duration.substring(0,duration.indexOf(":")));
//        int durationMin=Integer.parseInt(duration.substring(duration.indexOf(":")+1));
//        System.out.println(durationHours);
//        System.out.println(durationMin);
//        
//        
//        String finOutTime=inTimeHours - 2 + ":" + inTimeMin + ":" + inTimeSec + " " + inTimeD;
//        
//        System.out.println(finOutTime);
//        
//        System.out.println(1/10);
//        
        int ductAmountOfHours = 5;
        PreparedStatement statement02;
        ResultSet rs02;
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

        try {

            statement02 = dataConnection.OraDbConnection.connection().prepareStatement(""
                    + "SELECT CARDNO,PDATE,INTIME,OUTTIME,DURATION,OTMIN FROM TB_DATA_MASTER "
                    + "WHERE FINYEAR=? AND FINMONTH=? AND CARDNO=?");
            statement02.setInt(1, 2019);
            statement02.setString(2, "May");
            statement02.setString(3, "FSQI0002");
            rs02 = statement02.executeQuery();

            // this loop control single date attendence of selected person.
            workWithDate:
            while (rs02.next()) {

                PreparedStatement dataUpdate = null;
                String finDate = formatter.format(rs02.getDate(2));

                int outTimeHours = Integer.parseInt(rs02.getString(4).substring(0, 2));
                int outTimeMin = Integer.parseInt(rs02.getString(4).substring(3, 5));
                int outTimeSec = Integer.parseInt(rs02.getString(4).substring(6, 8));
                String outTimeClock = rs02.getString(4).substring(9, 11);

                int durationHours = Integer.parseInt(rs02.getString(5).substring(0, rs02.getString(5).indexOf(":")));
                int durationMin = Integer.parseInt(rs02.getString(5).substring(rs02.getString(5).indexOf(":") + 1));

                System.out.println("Main Duration Hours: " + durationHours);

//                        System.out.println(rs02.getString(1) + " == " + rs02.getString(2) + " == " + rs02.getString(3)
//                        +" == "+rs02.getString(4)+" == "+rs02.getString(5)+" == "+rs02.getString(6));
                if ((rs02.getInt(6)) >= 60 && (durationHours > 9)) {

                    int finHours = (durationHours - 1);
                    System.out.println("Out H == " + durationHours+" == "+finDate);
                    String strFinHours;
                    String strOutTimeMin;
                    String strOutTimeSec;
                    String strDurationMin;

                    if ((finHours / 10) == 0) {
                        strFinHours = "0" + finHours;
                    } else {
                        strFinHours = String.valueOf(finHours);
                    }

                    if ((outTimeMin / 10) == 0) {
                        strOutTimeMin = "0" + outTimeMin;
                    } else {
                        strOutTimeMin = String.valueOf(outTimeMin);
                    }

                    if ((outTimeSec / 10) == 0) {
                        strOutTimeSec = "0" + outTimeSec;
                    } else {
                        strOutTimeSec = String.valueOf(outTimeSec);
                    }

                    if ((durationMin / 10) == 0) {
                        strDurationMin = "0" + durationMin;
                    } else {
                        strDurationMin = String.valueOf(durationMin);
                    }

                    String finalOutTime = strFinHours + ":"
                            + strOutTimeMin + ":"
                            + strOutTimeSec + " "
                            + outTimeClock;

                    String finalDuration = finHours + ":" + strDurationMin;

                    int otHours = (finHours - 9);

                    System.out.println("FN H ==== " + finHours);
                    System.out.println("H ==== " + otHours);
                    int otMin = (otHours * 60) + durationMin;
                    System.out.println("M ==== " + otMin);

                    if (otMin > 40) {
                        if (otMin > 40 && otMin < 100) {
                            otMin = 60;
                        } else if (otMin > 100 && otMin < 160) {
                            otMin = 120;
                        } else if (otMin > 160 && otMin < 220) {
                            otMin = 180;
                        } else if (otMin > 220 && otMin < 280) {
                            otMin = 240;
                        } else if (otMin > 280 && otMin < 340) {
                            otMin = 300;
                        } else if (otMin > 340 && otMin < 400) {
                            otMin = 360;
                        } else if (otMin > 400 && otMin < 460) {
                            otMin = 420;
                        } else if (otMin > 460 && otMin < 520) {
                            otMin = 480;
                        } else if (otMin > 520 && otMin < 580) {
                            otMin = 540;
                        }
                    }else{
                        otMin=0;
                    }

                    dataUpdate = dataConnection.OraDbConnection.connection().prepareStatement(""
                            + "UPDATE TB_DATA_MASTER SET OUTTIME=?,EXITTIME_V=?,DURATION=?,"
                            + "DURATION_V=?,OTMIN=? WHERE "
                            + "PDATE = TO_DATE('" + finDate + " 00:00:00', 'MM/DD/YYYY HH24:MI:SS') AND CARDNO=?"
                    );

                    dataUpdate.setString(1, finalOutTime);
                    ductAmountOfHours -= 1;
                    dataUpdate.setString(2, finalOutTime);
                    dataUpdate.setString(3, finalDuration);
                    dataUpdate.setString(4, finalDuration);
                    dataUpdate.setInt(5, otMin);
                    dataUpdate.setString(6, rs02.getString(1));

                    dataUpdate.executeUpdate();
                    
                }

                if (ductAmountOfHours == 0) {
                    break workWithDate;
                }
                System.out.println("==================> ");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
