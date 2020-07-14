/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportgenerator.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import reportgenerator.dao.AdvanceAmount;
import reportgenerator.dbConnection.DBConnection;

/**
 *
 * @author Anik
 */
public class AdvanceAmountService {
    
    
    public void saveData(AdvanceAmount amount){
        
        Connection connection=DBConnection.getConnection();
        
        try{
            System.out.println("from service");
//            PreparedStatement statement=connection.prepareStatement("INSERT INTO TB_ADVANCE_AMOUNT "
//                    + "(SUB_DATE,EMP_NAME,AMOUNT,COST,CASH_IN_HAND,AUTHORIZED) VALUES "
//                    + "('"+amount.getGivenDate()+"',"
//                    + "'"+amount.getAdvanceHolderName()+"',"
//                    + amount.getAmountOfAdvance()+","
//                    + amount.getAmountOfCost()+","
//                    + amount.getAmountCashOnHand()+","
//                    + "'NO')");

            PreparedStatement statement=connection.prepareStatement("INSERT INTO TB_ADVANCE_AMOUNT "
                    + "(SUB_DATE,EMP_NAME,AMOUNT,COST,CASH_IN_HAND,AUTHORIZED) VALUES (?,?,?,?,?,?)");
            statement.setString(1, amount.getGivenDate());
            statement.setString(2, amount.getAdvanceHolderName());
            statement.setFloat(3, amount.getAmountOfAdvance());
            statement.setFloat(4, amount.getAmountOfCost());
            statement.setFloat(5, amount.getAmountCashOnHand());
            statement.setString(6, "NO");
            
            statement.executeUpdate();
            System.out.println("Pass the Save function.");
            
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
             JOptionPane.showMessageDialog(null, e.getMessage(),
                    ":: ERROR- SERVICE ADVANCE AMOUNT [SAVE DATA] :: ", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    
    public List<AdvanceAmount> getDataFromAdvanceTable(){
        
        List<AdvanceAmount> listOfData=new ArrayList<>();
        
        Connection connection=DBConnection.getConnection();
        
        try{
            PreparedStatement statement=connection.prepareStatement("SELECT * FROM TB_ADVANCE_AMOUNT ORDER BY ID DESC");
            
            ResultSet rs=statement.executeQuery();
            
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
            
            connection.close();
        }catch(Exception e){
             e.printStackTrace();
             JOptionPane.showMessageDialog(null, e.getMessage(),
                    ":: ERROR- SERVICE ADVANCE AMOUNT [SELECT DATA] :: ", JOptionPane.INFORMATION_MESSAGE);
        }
        return listOfData;
    }
    
    
    public void updateData(AdvanceAmount amount){
        
        Connection connection=DBConnection.getConnection();
        
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
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    ":: ERROR- SERVICE ADVANCE AMOUNT [UPDATE DATA] :: ", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
}
