/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataDuctCore;

import databaseConnection.OraDbConnection;
import dataDuctModel.OtHoursDuctModel;
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

    private Connection dataConnect;
    private SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    private List<OtHoursDuctModel> modelData = new ArrayList<>();
    private int str = 0;
    private int end = 0;

    /**
     * Data process method.this method push card no to another lib method
     *
     * @param ductAmountOfHours
     * @param finYear
     * @param finMonth
     */
    public void dataProcess(int ductAmountOfHours, int finYear, String finMonth, boolean complience) {

        int temp = 1;
        str = 0;
        end = 200;

        System.out.println("data ==========>" + modelData.size());
        if (ductAmountOfHours > 0) {
            OtHoursDuctModelLib otLib = new OtHoursDuctModelLib();
            // this loop control data limit
            outerLoop:
            while (temp != 0) {
                try {
                    dataConnect = databaseConnection.OraDbConnection.connection();
                    //  this loop control single person data
                    for (int i = str; i < end; i++) {
                        System.out.println("==================================================== " + i + " cardno: "
                                + modelData.get(i).getCardno());

                        otLib.updateAttendence(ductAmountOfHours, finYear, finMonth, 
                                modelData.get(i).getCardno(), dataConnect,complience);

                        if (i == (modelData.size() - 1)) {
                            break outerLoop;
                        }
                    }
                    str = end;
                    end += 200;
                    dataConnect.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        JOptionPane.showMessageDialog(null, " Ot " + ductAmountOfHours + " Hours Dusuction Successfully ",
                ":: Successfull :: ", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * This method store card no from database using section name filter
     *
     * @param sectionNm
     * @param lineNo
     * @exception sql exception
     */
    public void setData(String sectionNm, String lineNo) {
        try {

            ResultSet rs = null;
            dataConnect = OraDbConnection.connection();
            String sqlStatement="SELECT CARDNO,SECRETENO,EMPID FROM TB_PERSONAL_INFO WHERE OTORG='Y' AND ACTIVE=0 "
                    + "AND SECTIONNM=? ";
            if(!"Nil".equals(lineNo)){
                sqlStatement += "AND LINENO=?";
            }
            PreparedStatement statement = dataConnect.prepareStatement(sqlStatement);
            statement.setString(1, sectionNm);
            if(!"Nil".equals(lineNo)){
                statement.setString(2, lineNo);
            }
            rs = statement.executeQuery();
            
            int count = 0;
            try {
                while (rs.next()) {
                    System.out.println(rs.getString(1));

                    OtHoursDuctModel model = new OtHoursDuctModel();
                    model.setCardno(rs.getString(1));
                    model.setSecreteno(rs.getString(2));
                    model.setEmpID(rs.getInt(3));

                    modelData.add(model);
                    count++;
                }

            } finally {
                System.out.println("rs ==============>" + count);
                statement.close();
                rs.close();
                dataConnect.close();
            }

            JOptionPane.showMessageDialog(null, " Data Initialize Successfully ",
                    ":: Successfull :: ", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, " Data Initialize Not Successfully ",
                    "Class: OtHoursDuct ", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * This method helps us to get all section name from database and push
     * result in view class.
     *
     * @return set of section name
     */
    public ResultSet getSectionName() {
        try {
            dataConnect = OraDbConnection.connection();
            PreparedStatement statement = dataConnect.prepareStatement("SELECT SECTIONNM FROM TB_SECTION_INFO");
            ResultSet rs = statement.executeQuery();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, " No Section In Database",
                    ":: Class: OtHoursDuct :: ", JOptionPane.INFORMATION_MESSAGE);
        }
        return null;
    }

    /**
     * This method helps us to get all section name from database and push
     * result in view class.
     *
     * @return set of section name
     */
    public ResultSet getLineNo() {
        try {
            dataConnect = OraDbConnection.connection();
            PreparedStatement statement = dataConnect.prepareStatement(""
                    + "SELECT DISTINCT LINENO FROM TB_PERSONAL_INFO ORDER BY LINENO ASC"
                    + "");
            ResultSet rs = statement.executeQuery();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, " No Line no In Database",
                    ":: Class: OtHoursDuct :: ", JOptionPane.INFORMATION_MESSAGE);
        }
        return null;
    }

}
