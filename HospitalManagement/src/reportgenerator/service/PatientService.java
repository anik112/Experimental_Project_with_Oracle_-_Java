package reportgenerator.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import reportgenerator.dao.PatientInfo;
import reportgenerator.dbConnection.DBConnection;

/**
 *
 * @author Administrator
 */
public class PatientService {
 
    
    public void saveData(PatientInfo patient){
        
        Connection connection=DBConnection.getConnection();
        //PatientInfo patientInfo = new PatientInfo();
        
        try{
            System.out.println("from Patient service");
//            PreparedStatement statement=connection.prepareStatement("INSERT INTO TB_ADVANCE_AMOUNT "
//                    + "(SUB_DATE,EMP_NAME,AMOUNT,COST,CASH_IN_HAND,AUTHORIZED) VALUES "
//                    + "('"+amount.getGivenDate()+"',"
//                    + "'"+amount.getAdvanceHolderName()+"',"
//                    + amount.getAmountOfAdvance()+","
//                    + amount.getAmountOfCost()+","
//                    + amount.getAmountCashOnHand()+","
//                    + "'NO')");

            PreparedStatement statement=connection.prepareStatement("INSERT INTO `in_patient_details` ( "
                    + "`patient_fname`, "
                    //+ "`patient_dob`, "
                    + "`patient_sex`, "
                    + "`patient_nid`, "
                    + "`patient_mphone`, "
                    + "`patient_address`,"
                    + "`patient_hight`, "
                    + "`patient_weight`, "
                    + "`patient_blood_group`, "
                    + "`status`)"
                    + "VALUES (?,?,?,?,?,?,?,?,?)");
            statement.setString(1, patient.getName());
            //statement.setDate(2, patient.getSqlDate(patient.getPatient_dob()));
            statement.setString(2, patient.getPatient_sex());
            statement.setString(3, patient.getPatient_nid());
            statement.setString(4, patient.getPatient_hphone());
            statement.setString(5, patient.getAddress());
            statement.setInt(6, patient.getPatient_hight());
            statement.setInt(7, patient.getPatient_weight());
            statement.setString(8, patient.getPatient_blood_group());
            statement.setString(9, patient.getStatus());
            
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
    
    
    public List<PatientInfo> getDataFromPatientTable(){
        
        List<PatientInfo> listOfData=new ArrayList<>();
        
        Connection connection=DBConnection.getConnection();
        
        try{
            PreparedStatement statement=connection.prepareStatement("SELECT `patient_id`,"
                    + "`patient_fname`, "
                    //+ "`patient_dob`, "
                    + "`patient_sex`, "
                    + "`patient_nid`, "
                    + "`patient_mphone`, "
                    + "`patient_address`,"
                    + "`patient_hight`, "
                    + "`patient_weight`, "
                    + "`patient_blood_group`, "
                    + "`status`"
                    + "FROM `in_patient_details` ORDER BY patient_id DESC");
            
            ResultSet rs=statement.executeQuery();
            
            while (rs.next()) {
                PatientInfo di=new PatientInfo();
                
                di.setId(rs.getInt(1));
                di.setName(rs.getString(2));
                //di.setPatient_dob(di.getUtilDate(rs.getDate(3)));
                di.setPatient_sex(rs.getString(3));
                di.setPatient_nid(rs.getString(4));
                di.setPatient_hphone(rs.getString(5));
                di.setAddress(rs.getString(6));
                di.setPatient_hight(rs.getInt(7));
                di.setPatient_weight(rs.getInt(8));
                di.setPatient_blood_group(rs.getString(9));
                di.setStatus(rs.getString(10));
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
    
    
    public void updateData(PatientInfo amount){
        
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
        }*/
    }
    
    
    public List<PatientInfo> searchByDateAndEmpName(String date, String name){
        Connection connection=DBConnection.getConnection();
        List<PatientInfo> listOfData=new ArrayList<>();
        
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
