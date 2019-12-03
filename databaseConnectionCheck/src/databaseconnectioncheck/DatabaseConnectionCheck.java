/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseconnectioncheck;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.application.Application;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import remoteDatabaseConnection.*;

/**
 *
 * @author VSIANIK
 */
public class DatabaseConnectionCheck extends Application {

    @Override
    public void start(Stage primaryStage) {

//        try {
//
//            Connection conn = OraDbConnection1.connection();
//            PreparedStatement statement = conn.prepareStatement("select cardno from TB_CONN_BTW_WORKR_SUPRVISOR");
//            ResultSet rs=statement.executeQuery();
//            
//            String msg="";
//            while(rs.next()){
//                msg += " "+rs.getString(1);
//            }
//            
//            JOptionPane.showMessageDialog(null, msg,":: Connected ::", JOptionPane.INFORMATION_MESSAGE);
//            System.exit(0);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        OraDbConnection1.connection();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
