package reportgenerator.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import reportgenerator.dao.RoomInfoBooking;
import reportgenerator.dbConnection.DBConnection;

/**
 *
 * @author Administrator
 */
public class RoombookingService {
 
    
    public void saveData(RoomInfoBooking info){
        
        Connection connection=DBConnection.getConnection();
        //PatientInfo patientInfo = new PatientInfo();
        
        try{
            System.out.println("from Patient service");

            PreparedStatement statement=connection.prepareStatement("INSERT INTO `room_booking` ( "
                    + "`patient_id`,"
                    + "`room_id`, "
                    + "`description` )"
                    + "VALUES (?,?,?)");
            statement.setInt(1, info.getPatientId());
            statement.setInt(2, info.getDoctorId());
            statement.setString(3, info.getDescription());
            
            statement.executeUpdate();
            connection.close();
            
            System.out.println("Pass the Save function.");
            
            JOptionPane.showMessageDialog(null, "Data Save !!",
                    ":: Sys Says :: ", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            e.printStackTrace();
             JOptionPane.showMessageDialog(null, e.getMessage(),
                    ":: ERROR- SERVICE ADVANCE AMOUNT [SAVE DATA] :: ", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    
    public List<RoomInfoBooking> getDataFromPatientTable(){
        
        List<RoomInfoBooking> listOfData=new ArrayList<>();
        
        Connection connection=DBConnection.getConnection();
        
        try{
            PreparedStatement statement=connection.prepareStatement("SELECT `patient_id`,"
                    + "`room_id`, "
                    + "`description` "
                    + "FROM `room_booking` ORDER BY patient_id DESC");
            
            ResultSet rs=statement.executeQuery();
            
            while (rs.next()) {
                RoomInfoBooking di=new RoomInfoBooking();
                
                di.setId(rs.getInt(1));
                di.setPatientId(rs.getInt(1));
                di.setDoctorId(rs.getInt(2));
                di.setDescription(rs.getString(3));
                
                listOfData.add(di);
            }
            
            connection.close();
        }catch(Exception e){
             e.printStackTrace();
             JOptionPane.showMessageDialog(null, e.getMessage(),
                    ":: ERROR- SERVICE ADVANCE AMOUNT [SELECT DATA] :: ", JOptionPane.INFORMATION_MESSAGE);
        }
        return listOfData;
    }
    
    
    public void updateData(RoomInfoBooking amount){
        
        Connection connection=DBConnection.getConnection();
        /*
        try{
            PreparedStatement statement=connection.prepareStatement("UPDATE TB_ADVANCE_AMOUNT "
                    + "SET SUB_DATE='"+amount.getGivenDate()+"',"
                    + "EMP_NAME='"+amount.getAdvanceHolderName()+"',"
                    + "AMOUNT="+amount.getAmountOfAdvance()+","
                    + "COST="+amount.getAmountOfCost()+","
                    + "CASH_IN_HAND="+amount.getAmountCashOnHand()+","
                    + "AUTHORIZED='"+amount.getAuthorized()+"' "
                    + "WHERE ID="+amount.getId());
            
            statement.executeUpdate();
            connection.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    ":: ERROR- SERVICE ADVANCE AMOUNT [UPDATE DATA] :: ", JOptionPane.INFORMATION_MESSAGE);
        }
*/
    }
    
    
    public List<RoomInfoBooking> searchByDateAndEmpName(String date, String name){
        Connection connection=DBConnection.getConnection();
        List<RoomInfoBooking> listOfData=new ArrayList<>();
        
        try{
            
            PreparedStatement statement=connection.prepareStatement("SELECT * FROM TB_ADVANCE_AMOUNT "
                    + "WHERE SUB_DATE='"+date+"'"
                    + "AND EMP_NAME='"+name+"' "
                    + "ORDER BY ID DESC");
            
            ResultSet rs=statement.executeQuery();
            /*
            while (rs.next()) {
                AdvanceAmount amount=new AdvanceAmount();
                amount.setId(rs.getInt(1));
                amount.setGivenDate(rs.getString(2));
                amount.setAdvanceHolderName(rs.getString(3));
                amount.setAmountOfAdvance(rs.getFloat(4));
                amount.setAmountOfCost(rs.getFloat(5));
                amount.setAmountCashOnHand(rs.getFloat(6));
                amount.setAuthorized(rs.getString(7));
                
                listOfData.add(amount);
            }
            */
            connection.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    ":: ERROR- SERVICE ADVANCE AMOUNT [SELECT DATA] :: ", JOptionPane.INFORMATION_MESSAGE);
        }
        
        return listOfData;
    }
    
    
}
