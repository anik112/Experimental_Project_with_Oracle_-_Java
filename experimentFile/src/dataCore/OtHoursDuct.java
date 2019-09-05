/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataCore;

import dataConnection.OraDbConnection;
import dataModel.OtHoursDuctModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author VSIANIK
 */
public class OtHoursDuct {

    private Connection dataConnect = OraDbConnection.connection();
    private String sectionNM = "Sewing";
    private String finMonth = "March";
    private int finYear = 2019;
    private SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    private List<OtHoursDuctModel> modelData = new ArrayList<>();
    private int str = 0;
    private int end = 0;
    private int ductAmountOfHours = 0;

    public void dataProcess() throws SQLException {
        
        int temp = 1;
        str = 0;
        end = 200;
        dataConnect=dataConnection.OraDbConnection.connection();
        
        System.out.println("data ==========>" + modelData.size());
        // this loop control data limit
        outerLoop:
        while (temp != 0) {
            OtHoursDuctModelLib otLib=new OtHoursDuctModelLib();
            
            //  this loop control single person data
            for (int i = str; i < end; i++) {
                
                ductAmountOfHours = 4; // total ot duct hours.
                otLib.updateAttendence(ductAmountOfHours, finYear, finMonth, modelData.get(i).getCardno(),dataConnect);
                
                if (i == (modelData.size() - 1)) {
                    break outerLoop;
                }
                
                System.out.println("========================================== "+i+" cardno: "+modelData.get(i).getCardno());

            }
            str = end;
            end += 200;
        }
    }

    public void setData() throws SQLException {

        ResultSet rs = null;

        PreparedStatement statement = dataConnect.prepareStatement(""
                + "SELECT CARDNO,SECRETENO,EMPID FROM TB_PERSONAL_INFO "
                + "WHERE OTORG='Y' AND ACTIVE=0 AND SECTIONNM=?");
        statement.setString(1, sectionNM);

        rs = statement.executeQuery();
        //int count = 0;
        try {
            while (rs.next()) {

                //System.out.println(rs.getString(1));
                OtHoursDuctModel model = new OtHoursDuctModel();
                model.setCardno(rs.getString(1));
                model.setSecreteno(rs.getString(2));
                model.setEmpID(rs.getInt(3));

                modelData.add(model);
            }
        } finally {
            //System.out.println("rs ==============>" + rs.getRow());
            statement.close();
            rs.close();
            dataConnect.close();
        }

//        for (int i = 0; i < modelData.size(); i++) {
//            System.out.println(modelData.get(i).getEmpID() + " == " + modelData.get(i).getCardno() 
//                    +" == " + modelData.get(i).getSecreteno());
//        }
    }

    public static void main(String[] args) throws Throwable {
        OtHoursDuct otHoursDuct = new OtHoursDuct();
        otHoursDuct.setData();
        otHoursDuct.dataProcess();
        //Application.launch(args);
    }

}

