/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vsi.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VSI-ANIK
 */
public class ComboDataFromTable {

    private Connection connection = com.vsi.db.OraDbConnection.connection();
    private List<String> list1=new ArrayList<>();
    private List<Integer> list2=new ArrayList<>();

    public ComboDataFromTable() {
        for(int i=0;i<5;i++){
            list1.add("Could not find data");
            list2.add(0);
        }
    }

    public List<String> departmentList() {
        List<String> list = new ArrayList<>();
        try {
            String sql = "SELECT DEPT_NAME FROM TB_DEPARTMENT_INFO";
            PreparedStatement statement = connection.prepareCall(sql);
            ResultSet set = statement.executeQuery();

            while (set.next()) {
                list.add(set.getString(1));
            }
            statement.close();
            set.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list1;
    }

    public List<String> sectionList(String dptName) {
        List<String> list = new ArrayList<>();
        try {
            String sql = "SELECT SECTIONNM FROM TB_SECTION_INFO WHERE DEPARTTMENTNM= ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, dptName);
            ResultSet set = statement.executeQuery();

            while (set.next()) {
                list.add(set.getString(1));
            }
            statement.close();;
            set.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list1;
    }
    
    
    public List<Integer> yearList(){
        List<Integer> list=new ArrayList<>();
        
        try {
            String sql="SELECT DISTINCT FINYEAR FROM TB_DATA_MASTER ORDER BY FINYEAR DESC";
            PreparedStatement statement=connection.prepareStatement(sql);
            ResultSet rs=statement.executeQuery();
            
            while (rs.next()) {                
                list.add(rs.getInt(1));
            }
            statement.close();
            rs.close();
            return list;
       } catch (Exception e) {
           e.printStackTrace();
        }
        return list2;
    }

}
