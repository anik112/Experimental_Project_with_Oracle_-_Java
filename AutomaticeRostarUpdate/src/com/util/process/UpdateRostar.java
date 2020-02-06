/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util.process;

import com.db.databaseConnection.OraDbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VSI-ANIK
 */
public class UpdateRostar {

    public UpdateRostar() {
    }

    public void updateEmpHolidayWiseRostar() {

        String wDay=formatedDayName(2020, 01, 01);
        
        try {
            Connection connection=OraDbConnection.connection();
            PreparedStatement ps=connection.prepareStatement("SELECT CARDNO,WDAY FROM TB_PERSONAL_INFO WHERE WDAY=?");
            ps.setString(1,wDay);
            ResultSet rs=ps.executeQuery();
                        
            while(rs.next()){
                PreparedStatement statement=connection.prepareStatement("");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UpdateRostar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {

    }

    public String formatedDayName(int year, int month, int day) {

        LocalDate ld = LocalDate.of(year, month, day);
        DayOfWeek dow = ld.getDayOfWeek();
        System.out.println(dow);
        String tempStr = (dow.toString()).toLowerCase();
        System.out.println(tempStr);
        String finalStr=(tempStr.substring(0, 1)).toUpperCase() + tempStr.substring(1, tempStr.length());
        System.out.println(finalStr);
        
        return finalStr;
    }
    
    
    
}
