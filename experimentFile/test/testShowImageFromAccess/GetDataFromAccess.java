/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testShowImageFromAccess;

import dataConnection.OraDbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author VSIANIK
 */
public class GetDataFromAccess {

    public static void main(String[] args) {

        try {
            Connection accCo = OraDbConnection.accessConnection();
            PreparedStatement statement = accCo.prepareStatement("select userid, name from userinfo where userid=?");
            statement.setInt(1, 14);
            ResultSet rs=statement.executeQuery();
            
            
            while (rs.next()) {
                System.out.println(rs.getInt(1)+" ------ "+rs.getString(2));
            }
            

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
