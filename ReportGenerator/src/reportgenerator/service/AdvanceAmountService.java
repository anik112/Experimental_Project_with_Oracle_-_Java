/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportgenerator.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
            
            PreparedStatement statement=connection.prepareStatement("INSERT INTO TB_ADVANCE_AMOUNT "
                    + "(SUB_DATE,EMP_NAME,AMOUNT,COST,CASH_IN_HAND,AUTHORIZED) VALUES "
                    + "('"+amount.getGivenDate()+"',"
                    + "'"+amount.getAdvanceHolderName()+"',"
                    + amount.getAmountOfAdvance()+","
                    + amount.getAmountOfCost()+","
                    + amount.getAmountCashOnHand()+","
                    + "'NO');");
//            statement.setString(1, amount.getGivenDate());
//            statement.setString(2, amount.getAdvanceHolderName());
//            statement.setFloat(3, amount.getAmountOfAdvance());
//            statement.setFloat(4, amount.getAmountOfCost());
//            statement.setFloat(5, amount.getAmountCashOnHand());
//            statement.setString(6, "NO");
            
            statement.executeUpdate();
                        
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, e.getMessage(),
                    ":: ERROR- SERVICE ADVANCE AMOUNT:: ", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
}
