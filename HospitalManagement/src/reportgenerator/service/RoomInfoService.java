package reportgenerator.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import reportgenerator.dao.PatientInfo;
import reportgenerator.dao.RoomInfo;
import reportgenerator.dbConnection.DBConnection;

/**
 *
 * @author Administrator
 */
public class RoomInfoService {
 
    
    public void saveData(RoomInfo info){
        
        Connection connection=DBConnection.getConnection();
        //PatientInfo patientInfo = new PatientInfo();
        
        try{
            System.out.println("from Patient service");

            PreparedStatement statement=connection.prepareStatement("INSERT INTO `room_details` ( "
                    + "`room_id`,"
                    + "`room_type`, "
                    + "`room_description` )"
                    + "VALUES (?,?,?)");
            statement.setInt(1, info.getId());
            statement.setString(2, info.getRoom_type());
            statement.setString(3,info.getRoom_description());
            
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
    
    
    public List<RoomInfo> getDataFromPatientTable(){
        
        List<RoomInfo> listOfData=new ArrayList<>();
        
        Connection connection=DBConnection.getConnection();
        
        try{
            PreparedStatement statement=connection.prepareStatement("SELECT `room_id`,"
                    + "`room_type`, "
                    + "`room_description` "
                    + "FROM `room_details` ORDER BY room_id DESC");
            
            ResultSet rs=statement.executeQuery();
            
            while (rs.next()) {
                RoomInfo di=new RoomInfo();
                
                di.setId(rs.getInt(1));
                di.setRoom_id(String.valueOf(rs.getInt(1)));
                di.setRoom_type(rs.getString(2));
                di.setRoom_description(rs.getString(3));
                
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
    
    
    public void updateData(RoomInfo amount){
        
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
    
    
    public List<RoomInfo> searchByDateAndEmpName(String date, String name){
        Connection connection=DBConnection.getConnection();
        List<RoomInfo> listOfData=new ArrayList<>();
        
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
