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
import reportgenerator.dao.EntrySubmitedBillDao;
import reportgenerator.dbConnection.DBConnection;

/**
 *
 * @author Anik
 */
public class EntrySubmitedBillService {
    
    public void saveData(EntrySubmitedBillDao billDao){
        
         Connection connection=DBConnection.getConnection();
        
        try{
            PreparedStatement statement=connection.prepareStatement("INSERT INTO TB_SUBMITED_BILL "
                    + "(BILL_DATE,BILL_NUMBER,COM_NAME,AMOUNT,BILL_TYPE) VALUES (?,?,?,?,?)");
            statement.setString(1, billDao.getBillDate());
            statement.setString(2, billDao.getBillNumber());
            statement.setString(3, billDao.getCompanyName());
            statement.setFloat(4, billDao.getAmount());
            statement.setString(5,billDao.getBillType());
            
            statement.executeUpdate();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
             JOptionPane.showMessageDialog(null, e.getMessage(),
                    ":: ERROR- SERVICE SUBMITE BILL [SAVE DATA] :: ", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    
    public void updateData(EntrySubmitedBillDao billDao){
        Connection connection=DBConnection.getConnection();
        
        try{
            PreparedStatement statement=connection.prepareStatement("UPDATE TB_SUBMITED_BILL "
                    + "SET BILL_DATE='"+billDao.getBillDate()+"',"
                    + "BILL_NUMBER='"+billDao.getBillNumber()+"',"
                    + "COM_NAME='"+billDao.getCompanyName()+"',"
                    + "AMOUNT="+billDao.getAmount()+","
                    + "BILL_TYPE='"+billDao.getBillType()+"',"
                    + "COLLECTED='"+billDao.getCollected()+"'"
                    + "WHERE ID="+billDao.getId());
            statement.executeUpdate();
            connection.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    ":: ERROR- SERVICE SUBMITE BILL [UPDATE DATA] :: ", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    
    public List<EntrySubmitedBillDao> getBillSearchByCompany(String comName){
        Connection connection=DBConnection.getConnection();
        List<EntrySubmitedBillDao> listOfBill=new ArrayList<>();
        try{
            int i=0;
            PreparedStatement statement=connection.prepareStatement("SELECT * FROM TB_SUBMITED_BILL "
                    + "WHERE COM_NAME='"+comName+"'");
            ResultSet rs=statement.executeQuery();
            
            while(rs.next()){
                i++;
                EntrySubmitedBillDao billDao=new EntrySubmitedBillDao();
                
                billDao.setId(rs.getInt(1));
                billDao.setBillDate(rs.getString(2));
                billDao.setBillNumber(rs.getString(3));
                billDao.setCompanyName(rs.getString(4));
                billDao.setAmount(rs.getFloat(5));
                billDao.setBillType(rs.getString(6));
                billDao.setCollected(rs.getString(7));
                
                listOfBill.add(billDao);
            }
            //System.out.println("=> "+i);
            connection.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    ":: ERROR- SERVICE SUBMITE BILL [SELECT DATA] :: ", JOptionPane.INFORMATION_MESSAGE);
        }
        return listOfBill;
    }
    
    public boolean checkBillNumberAllreadyEntry(String billNumber, String comName){
        Connection connection=DBConnection.getConnection();
        boolean check=true;
        
        try{
            PreparedStatement statement=connection.prepareStatement("SELECT * FROM TB_SUBMITED_BILL "
                    + "WHERE BILL_NUMBER='"+billNumber+"'"
                    + "AND COM_NAME='"+comName+"'");
            ResultSet rs=statement.executeQuery();
            
            if(rs.next()){
                check=false;
            }else{
                check=true;
            }
            connection.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    ":: ERROR- SERVICE SUBMITE BILL [UPDATE DATA] :: ", JOptionPane.INFORMATION_MESSAGE);
        }
        return check;
    }
    
    
}
