/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workerEnd.EntryCore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import workerEnd.EntryModel.LeaveEntryModel;

/**
 *
 * @author VSIANIK
 */
public class LeaveEntryCore {

    public void inseartInDatabase(LeaveEntryModel entryModel) {

        Connection connection = dbConnection.OraDbConnection.connection();
        PreparedStatement statement = null;

        try {

            try {
                String sql = "INSERT INTO TB_LEAVE_NOTIFICATION ( "
                        + "	FINYEAR,"
                        + "	FINMONTH,"
                        + "	COMPANY,"
                        + "	CARDNO,"
                        + "	SUPERVISOR_CARDNO,"
                        + "	START_DATE,"
                        + "	END_DATE,"
                        + "	LEAVE_TYPE,"
                        + "	LEAVEDAY,"
                        + "	SALDAY,"
                        + "	REASON,"
                        + "	REQUEST_DATE )"
                        + " VALUES "
                        + "(?,?,?,?,?,TO_DATE('" + entryModel.getStrDate() + " 00:00:00', 'MM/DD/YYYY HH24:MI:SS'),"
                        + " TO_DATE('" + entryModel.getEndDate() + " 00:00:00', 'MM/DD/YYYY HH24:MI:SS'),"
                        + "?,?,?,?"
                        + " TO_DATE('" + entryModel.getProcessDate() + " 00:00:00', 'MM/DD/YYYY HH24:MI:SS'))";

                statement = connection.prepareStatement(sql);
                statement.setInt(1, entryModel.getYear());
                statement.setString(2, entryModel.getMonth());
                statement.setString(3, entryModel.getCompanyName());
                statement.setString(4, entryModel.getCardno());
                statement.setString(5, entryModel.getSupervisorCardno());
                statement.setString(6, entryModel.getLeaveType());
                statement.setInt(7, entryModel.getLeaveDay());
                statement.setInt(8, entryModel.getLeaveDay());
                
                
            } finally {
                connection.close();
                statement.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    
    
    public List<String> getCompany(){
        
        Connection conn=dbConnection.OraDbConnection.connection();
        PreparedStatement stmt;
        ResultSet rs;
        List<String> list=new ArrayList<>();
        try {
            stmt=conn.prepareStatement("SELECT COMPANY FROM TB_COMPANY_INFO");
            rs=stmt.executeQuery();
            
            while(rs.next()){
                list.add(rs.getString(1));
            }
            
            conn.close();
            stmt.close();
            rs.close();
            
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    
    public ResultSet getSuperVisor(String woorkerCardno,String companyName){
        
        Connection conn=dbConnection.OraDbConnection.connection();
        PreparedStatement stmt;
        ResultSet rs;
        try {
            stmt=conn.prepareStatement("SELECT SUPERVISOR_CARDNO,SUPERVISOR_NAME FROM TB_CONN_BTW_WORKR_SUPRVISOR "
                    + "WHERE CARDNO=? AND COMPANY=? ");
            stmt.setString(1, woorkerCardno);
            stmt.setString(2, companyName);
            rs=stmt.executeQuery();
            
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    

}
