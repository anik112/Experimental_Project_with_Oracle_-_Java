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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VSI-ANIK
 */
public class ProcessHelper {

    public List<String> getCompanyList() {

        List<String> comapny = new ArrayList<>();
        try {
            Connection connection = OraDbConnection.connection();
            PreparedStatement statement = connection.prepareCall("SELECT COMPANY FROM TB_COMPANY_INFO");

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                comapny.add(rs.getString(1));
            }
            connection.close();
            statement.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comapny;
    }
    
    public List<String> getDepartment(){
        
        List<String> department=new ArrayList<>();
        
        try{
            Connection connection=OraDbConnection.connection();
            PreparedStatement statement=connection.prepareCall("SELECT DEPT_NAME FROM TB_DEPARTMENT_INFO");
            ResultSet rs=statement.executeQuery();
            
            while(rs.next()){
                department.add(rs.getString(1));
            }
            connection.close();
            statement.close();
            rs.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return department;
    }
    
    
    public List<String> getSectionNm(){
        
        List<String> section=new ArrayList<>();
        
        try{
            Connection connection=OraDbConnection.connection();
            PreparedStatement statement=connection.prepareCall("SELECT SECTIONNM FROM TB_SECTION_INFO");
            ResultSet rs=statement.executeQuery();
            
            while(rs.next()){
                section.add(rs.getString(1));
            }
            connection.close();
            statement.close();
            rs.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return section;
    }
    
    
    public List<String> getCardNo(){
        
        List<String> cardList=new ArrayList<>();
        
        try{
            Connection connection=OraDbConnection.connection();
            PreparedStatement statement=connection.prepareCall("SELECT CARDNO,EMPNAME FROM TB_PERSONAL_INFO WHERE ACTIVE=0");
            ResultSet rs=statement.executeQuery();
            
            while(rs.next()){
                cardList.add(rs.getString(1)+","+rs.getString(2));
            }
            connection.close();
            statement.close();
            rs.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return cardList;
    }
    
}
