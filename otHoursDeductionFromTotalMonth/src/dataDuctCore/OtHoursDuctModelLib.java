/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataDuctCore;

import dataView.ConsolWindow;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author VSIANIK
 */
public class OtHoursDuctModelLib {

    dataView.ConsolWindow consolWindow=new ConsolWindow();
    
    public int updateAttendence(int ductHours, int year, String month, String cardno, Connection conn) {    
        
        int ductAmountOfHours = ductHours; // duction hours
        PreparedStatement statement02 = null; // create preparedStatement obj for write sql
        ResultSet rs02 = null; // result for store from database
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); // date formater
        consolWindow.setTxtConsol("\n\n======================= "+cardno+" ========================\n");
        
        try {

            try {
                // get attendence of singal cadno
                statement02 = conn.prepareStatement(""
                        + "SELECT CARDNO,PDATE,INTIME,OUTTIME,DURATION,OTMIN FROM TB_DATA_MASTER "
                        + "WHERE FINYEAR=? AND FINMONTH=? AND CARDNO=?");
                statement02.setInt(1, year);
                statement02.setString(2, month);
                statement02.setString(3, cardno);
                rs02 = statement02.executeQuery(); // store data in result shit

                // this loop control single date attendence of selected person.
                workWithDate:
                while (rs02.next()) {
                    System.out.println("==============================================");
                    consolWindow.setTxtConsol("================================================== \n");
                    // check cardno and outtime is not null
                    if ((rs02.getString(4) != null) && rs02.getString(1) != null) {

                        PreparedStatement dataUpdate = null;
                        String finDate = formatter.format(rs02.getDate(2)); // formatting date
                        System.out.println("Orginal outtime ==== " + rs02.getString(4));
                        consolWindow.setTxtConsol("Orginal OutTime: "+rs02.getString(4)+"\n");
                        
                        /*
                        There substring(begin index, end index) function help's us find out individual
                        character from string
                         */
                        int outTimeHours = Integer.parseInt(rs02.getString(4).substring(0, 2)); // get hours from string
                        int outTimeMin = Integer.parseInt(rs02.getString(4).substring(3, 5)); // get min fro string
                        int outTimeSec = Integer.parseInt(rs02.getString(4).substring(6, 8)); // get sec from string
                        String outTimeClock = rs02.getString(4).substring(9, 11); // get AM or PM
                        
                        /*
                        There .indexof(String) function help's us find out the index of given string
                         */
                        // get total duration hours from string
                        int durationHours = Integer.parseInt(rs02.getString(5).substring(0, rs02.getString(5).indexOf(":")));
                        // get duration min from string
                        int durationMin = Integer.parseInt(rs02.getString(5).substring(rs02.getString(5).indexOf(":") + 1));

                        System.out.println("Main Duration Hours: " + durationHours 
                                + " OutTime: " + outTimeHours +"  Date: "+finDate);
                        consolWindow.setTxtConsol("Main Duration Hours: " + durationHours 
                                + " OutTime: " + outTimeHours +"  Date: "+finDate+"\n");
                        System.out.println("Old Ot min: "+rs02.getInt(6));
                        consolWindow.setTxtConsol("Old Ot: "+rs02.getInt(6)+"\n");
                        
                        
                        // Check ot min and duration hours are valid
                        if ((rs02.getInt(6)) >= 60 && (durationHours > 9)) {

                            int finHours = (outTimeHours - 1); // Duct 1 hour from main out time
                            System.out.println("Date: " + finDate);
                            consolWindow.setTxtConsol("Date: "+finDate+"\n");
                            String strFinHours;
                            String strOutTimeMin;
                            String strOutTimeSec;
                            String strDurationMin;

                            
                            /*
                            formatting hours, min, sec
                            if there have any single number like '9' then we make it '09'
                             */
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

                            
                            /*
                            formatting duration number
                            if there have any single number like '9' then we make it '09'
                             */
                            if ((durationMin / 10) == 0) {
                                strDurationMin = "0" + durationMin;
                            } else {
                                strDurationMin = String.valueOf(durationMin);
                            }

                            // Make final outime string
                            String finalOutTime = strFinHours + ":"
                                    + strOutTimeMin + ":"
                                    + strOutTimeSec + " "
                                    + outTimeClock;

                            // Make final Duration string
                            String finalDuration = (durationHours - 1) + ":" + strDurationMin;

                            int otHours = ((durationHours - 1) - 9); // find ot hours

                            System.out.println("Final Hour ==== " + finHours);
                            consolWindow.setTxtConsol("Final Hour ==== " + finHours+"\n");
                            System.out.println("Ot Hour ==== " + otHours);
                            consolWindow.setTxtConsol("New Ot Hour ==== " + otHours+"\n");
                            int otMin = (otHours * 60) + durationMin; // get hot min.
                            System.out.println("New Ot Min ==== " + otMin);
                            consolWindow.setTxtConsol("New Ot Min ==== " + otMin+"\n");
                            // check this ot are valied
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
                            } else {
                                otMin = 0;
                            }

                            // update data in database
                            try {
                                dataUpdate = conn.prepareStatement(""
                                        + "UPDATE TB_DATA_MASTER SET OUTTIME=?,DURATION=?,"
                                        + "DURATION_V=?,OTMIN=? WHERE "
                                        + "PDATE = TO_DATE('" + finDate + " 00:00:00', 'MM/DD/YYYY HH24:MI:SS') AND CARDNO=?"
                                );

                                dataUpdate.setString(1, finalOutTime);
                                ductAmountOfHours -= 1; // duct 1 hours from DuctHour which hour entry by user
                                dataUpdate.setString(2, finalDuration);
                                dataUpdate.setString(3, finalDuration);
                                dataUpdate.setInt(4, otMin);
                                dataUpdate.setString(5, rs02.getString(1));

                                dataUpdate.executeUpdate();
                            } catch (NullPointerException | SQLException e) {
                                /*
                                If program can't find any attendence of this cardno
                                then continue this loop.
                                 */
                                e.printStackTrace();
                                continue;                              
                            }
                            /*
                            If program find any internal problem of this connection
                            then continue this loop.
                             */ 
                        }else{
                            continue;
                        }
                        // check wather of duct amount
                        // if work is finished then exit from loop
                        if (ductAmountOfHours == 0) {
                            break workWithDate; // exit the loop
                        }
                        dataUpdate.close();
                        
                    }
                    System.out.println("==================================================");
                    consolWindow.setTxtConsol("================================================== \n");
                }
            } finally {
                // finally close all connection
                rs02.close();
                statement02.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, " Data Process Not Successfully ",
                    ":: Class: OtHoursDuctModelLib :: ", JOptionPane.INFORMATION_MESSAGE);
        } catch (NullPointerException e) {
            return 0;
        }

        return 1;
    }

}
