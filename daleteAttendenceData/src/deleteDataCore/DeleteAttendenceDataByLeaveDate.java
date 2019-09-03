/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deleteDataCore;

import dataConnection.OraDbConnection;
import dataModel.LeaveUserInfo;
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
public class DeleteAttendenceDataByLeaveDate {

    public DeleteAttendenceDataByLeaveDate() {

    }

    private Connection dataConn = OraDbConnection.connection();
    private List<LeaveUserInfo> userInfo = new ArrayList<>();

    public void getAllLeaveEmployee(int finYear, String finMonth) {

        try {
            PreparedStatement statement = dataConn.prepareStatement(""
                    + "SELECT CARDNO,START_DATE,END_DATE,LEAVE_TYPE FROM TB_LEAVE_DETAILINFO "
                    + "WHERE FINYEAR=? AND FINMONTH=?");
            statement.setInt(1, finYear);
            statement.setString(2, finMonth);

            ResultSet rs = statement.executeQuery();
            //int count = 0;
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

            while (rs.next()) {

                LeaveUserInfo user = new LeaveUserInfo();

                //count = rs.getRow();
                String strDate = formatter.format(rs.getDate(2));
                String endDate = formatter.format(rs.getDate(3));

                // System.out.println(rs.getString(1) + " " + strDate + "  " + endDate);
                user.setCardno(rs.getString(1));
                user.setStartDate(strDate);
                user.setEndDate(endDate);

                userInfo.add(user);
            }
            
            JOptionPane.showMessageDialog(null, "Data Initialize Successful" ,
                    ":: Successful Init :: ", JOptionPane.INFORMATION_MESSAGE);
            
            //System.out.println("=== Length: " + count + " ===");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Not Initialize, DeleteAttendenceDataByLeaveDate.getAllLeaveEmployee()",
                    ":: SQL Error :: ", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void deleteAttendeceOfLeaveEmployee() {

        try {
            int str = 0, end = 289, check = 0;

            // Max work with 4335 item data
            brackOuterLoop:
            for (int j = 0; j < 15; j++) {

                PreparedStatement dataMasterStatement = null;

                for (int i = str; i <= end; i++) {

                    if (i == userInfo.size()) {
                        break brackOuterLoop;
                    }

                    try {

                        dataMasterStatement = dataConn.prepareStatement("delete FROM TB_DATA_MASTER "
                                + "WHERE PDATE >= "
                                + "TO_DATE('" + userInfo.get(i).getStartDate() + " 00:00:00', 'MM/DD/YYYY HH24:MI:SS') "
                                + "AND PDATE <= "
                                + "TO_DATE('" + userInfo.get(i).getEndDate() + " 00:00:00', 'MM/DD/YYYY HH24:MI:SS') "
                                + "AND CARDNO = ?");
                        dataMasterStatement.setString(1, userInfo.get(i).getCardno());
                        dataMasterStatement.executeUpdate();
                    } finally {
                        dataMasterStatement.close();
                    }

                    try {
                        // delete data from tb_data_master_temp
                        dataMasterStatement = dataConn.prepareStatement("delete FROM TB_DATA_MASTER_TEMP "
                                + "WHERE PDATE >= "
                                + "TO_DATE('" + userInfo.get(i).getStartDate() + " 00:00:00', 'MM/DD/YYYY HH24:MI:SS') "
                                + "AND PDATE <= "
                                + "TO_DATE('" + userInfo.get(i).getEndDate() + " 00:00:00', 'MM/DD/YYYY HH24:MI:SS') "
                                + "AND CARDNO = ?");
                        dataMasterStatement.setString(1, userInfo.get(i).getCardno());
                        dataMasterStatement.executeUpdate();

                    } finally {
                        dataMasterStatement.close();
                    }

                }

                str = end;
                end += 289;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Data Not Delete, "
                    + "DeleteAttendenceDataByLeaveDate.deleteAttendenceOfLeaveEmployee()",
                    ":: SQL Error :: ", JOptionPane.INFORMATION_MESSAGE);
        }
        
        JOptionPane.showMessageDialog(null, "Data Delete == Successful" ,
                    ":: Successful Delete :: ", JOptionPane.INFORMATION_MESSAGE);
    }

    
    
    
    
    
    public void showAttendenceOfAllLeaveEmpolyee() {

//        int str = 0, end = 289, check = 0;
//
//        // Max work with 4335 item data
//        brackOuterLoop:
//        for (int j = 0; j < 15; j++) {
//
//            PreparedStatement dataMasterStatement = null;
//            ResultSet rs2 = null;
//
//            for (int i = str; i <= end; i++) {
//
//                if (i == userInfo.size()) {
//                    break brackOuterLoop;
//                }
//
//                try {
//
//                        System.out.println(userInfo.get(i).getCardno() + " "
//                                + userInfo.get(i).getStartDate() + " " + userInfo.get(i).getEndDate());
//
//                        System.out.println("======================================");
//                     Show data from tb_data_master
//                        dataMasterStatement = dataConn.prepareStatement("SELECT * FROM TB_DATA_MASTER "
//                                + "WHERE PDATE >= "
//                                + "TO_DATE('" + userInfo.get(i).getStartDate() + " 00:00:00', 'MM/DD/YYYY HH24:MI:SS') "
//                                + "AND PDATE <= "
//                                + "TO_DATE('" + userInfo.get(i).getEndDate() + " 00:00:00', 'MM/DD/YYYY HH24:MI:SS') "
//                                + "AND CARDNO = ?");
//                     delete data from tb_data_master
//                    dataMasterStatement = dataConn.prepareStatement("delete FROM TB_DATA_MASTER "
//                            + "WHERE PDATE >= "
//                            + "TO_DATE('" + userInfo.get(i).getStartDate() + " 00:00:00', 'MM/DD/YYYY HH24:MI:SS') "
//                            + "AND PDATE <= "
//                            + "TO_DATE('" + userInfo.get(i).getEndDate() + " 00:00:00', 'MM/DD/YYYY HH24:MI:SS') "
//                            + "AND CARDNO = ?");
//
//                        dataMasterStatement = dataConn.prepareStatement("SELECT * FROM TB_DATA_MASTER "
//                                + "WHERE FINYEAR=2019  AND CARDNO = ? ");
//                    dataMasterStatement.setString(1, userInfo.get(i).getCardno());
//                    dataMasterStatement.executeUpdate();
//                        rs2 = dataMasterStatement.executeQuery();
//                        while (rs2.next()) {
//                            System.out.println(rs2.getString(1) + " <-------------------> " + rs2.getDate(3));
//                            check++;
//                        }
//
//                        System.out.println("======================================");
//                        System.out.println("=== Count: " + userInfo.size() + " ===");
//                        System.out.println("==============================================> " + i);
//
//                } finally {
//                        rs2.close();
//                    dataMasterStatement.close();
//                }
//
//            }
//
//            str = end;
//            end += 289;
//
//            System.err.println("===================================================================== >" + j);
//
//        }
//
//        System.out.println("-------- Total: " + check + " ----------");
//    }
//    catch (SQLException e
//
//    
//        ) {
//            e.printStackTrace();
//        JOptionPane.showMessageDialog(null, e.getClass() + " :: Massage: Data not Delete",
//                ":: Application Error :: ", JOptionPane.INFORMATION_MESSAGE);
//    }
    }

}
