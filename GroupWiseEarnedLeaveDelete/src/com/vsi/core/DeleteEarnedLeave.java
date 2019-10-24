/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vsi.core;

import com.vsi.db.OraDbConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author VSI-ANIK
 */
public class DeleteEarnedLeave {

    private Connection connection = OraDbConnection.connection(); // create database connection
    
    /**
     * This function delete earn leave from database
     * @param finyear
     * @param finMonth
     * @param date
     * @param dptName
     * @param secName
     * @param leaveType 
     * @return 
     */
    public int deleteData(int finyear, String finMonth, Date date, String dptName, String secName, String leaveType) {

        try {
            // write sql for run in database
            String sqlSelect = ("SELECT * FROM TB_LEAVE_DETAILINFO WHERE FINYEAR=" + finyear + " AND FINMONTH='" + finMonth + "' AND CARDNO IN "
                    + "(SELECT CARDNO FROM TB_PERSONAL_INFO WHERE DEPARTMENTNM LIKE DECODE(NVL('" + dptName + "','all'),'all','%','" + dptName + "') "
                    + "AND SECTIONNM LIKE DECODE(NVL('" + secName + "','all'),'all','%','" + secName + "') AND ACTIVE=0)");

            //String sqlDelete=("DELETE FROM TB_LEAVE_DETAILINFO WHERE FINYEAR="+finyear+" AND FINMONTH='"+finMonth+"' AND CARDNO='"+cardno+"'");
            PreparedStatement statement = connection.prepareStatement(sqlSelect);
            ResultSet rs = statement.executeQuery();
            int count = 0,countDelete=0;
            while (rs.next()) {
                System.out.println(rs.getString(2));
                Date rsStrDate = rs.getDate(6);
                System.out.println("==> Str Date: " + rsStrDate);
                Date rsEndDate = rs.getDate(7);
                System.out.println("==> End Date: " + rsEndDate);

                if ((date.equals(rsStrDate) || date.after(rsStrDate))
                        && (date.equals(rsEndDate) || date.before(rsEndDate))
                        && rs.getString(5).equals(leaveType)) {
                    System.out.println("Delete-----------");
                    String sqlDelete = "DELETE FROM TB_LEAVE_DETAILINFO WHERE SLNO=? AND FINYEAR=? AND FINMONTH=? AND LEAVE_TYPE=?";
                    PreparedStatement statementDelete = connection.prepareStatement(sqlDelete);
                    statementDelete.setInt(1, rs.getInt(1));
                    statementDelete.setInt(2, rs.getInt(3));
                    statementDelete.setString(3, rs.getString(4));
                    statementDelete.setString(4, leaveType);
                    statementDelete.executeUpdate();
                    statementDelete.close();
                    countDelete++;
                }
                count++;
            }
            System.out.println(count);
            rs.close();
            statement.close();
            return countDelete;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
