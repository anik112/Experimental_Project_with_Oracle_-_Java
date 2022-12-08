package reportgenerator.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import reportgenerator.dao.MedicalServiceInfo;
import reportgenerator.dbConnection.DBConnection;

/**
 *
 * @author Administrator
 */
public class MedicalService {

    public void saveData(MedicalServiceInfo medical) {

        Connection connection = DBConnection.getConnection();

        try {
            System.out.println("from Doctor service");
//            PreparedStatement statement=connection.prepareStatement("INSERT INTO TB_ADVANCE_AMOUNT "
//                    + "(SUB_DATE,EMP_NAME,AMOUNT,COST,CASH_IN_HAND,AUTHORIZED) VALUES "
//                    + "('"+amount.getGivenDate()+"',"
//                    + "'"+amount.getAdvanceHolderName()+"',"
//                    + amount.getAmountOfAdvance()+","
//                    + amount.getAmountOfCost()+","
//                    + amount.getAmountCashOnHand()+","
//                    + "'NO')");

            PreparedStatement statement = connection.prepareStatement("INSERT INTO `service`( "
                    + "`channel_service`,"
                    + "`duration_of_service`,"
                    + "`charge_for_service`,"
                    + "`service_notes`) "
                    + "VALUES (?,?,?,?)");
            statement.setString(1, medical.getChannel_service());
            statement.setInt(2, medical.getDuration_of_service());
            statement.setInt(3, medical.getCharge_for_service());
            statement.setString(4, medical.getService_notes());

            statement.executeUpdate();
            System.out.println("Pass the Save function.");
            
             JOptionPane.showMessageDialog(null, "Data Save !!",
                    ":: Sys Says :: ", JOptionPane.INFORMATION_MESSAGE);

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    ":: ERROR- SERVICE ADVANCE AMOUNT [SAVE DATA] :: ", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public List<MedicalServiceInfo> getDataFromDoctorTable() {

        List<MedicalServiceInfo> listOfData = new ArrayList<>();

        Connection connection = DBConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT `channel_service_id`, "
                    + "`channel_service`, "
                    + "`duration_of_service`, "
                    + "`charge_for_service`, "
                    + "`service_notes` "
                    + "FROM service ORDER BY channel_service_id DESC");

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                MedicalServiceInfo di = new MedicalServiceInfo();

                di.setId(rs.getInt(1));
                di.setChannel_service(rs.getString(2));
                di.setDuration_of_service(rs.getInt(3));
                di.setCharge_for_service(rs.getInt(4));
                di.setService_notes(rs.getString(5));

                listOfData.add(di);
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    ":: ERROR- SERVICE ADVANCE AMOUNT [SELECT DATA] :: ", JOptionPane.INFORMATION_MESSAGE);
        }
        return listOfData;
    }

    public void updateData(MedicalServiceInfo info) {

        Connection connection = DBConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE service set "
                    + "`channel_service`=" + info.getChannel_service() + ","
                    + "`duration_of_service`=" + info.getDuration_of_service() + ","
                    + "`charge_for_service`=" + info.getCharge_for_service() + ","
                    + "`service_notes`=" + info.getService_notes()
                    + "WHERE ID=" + info.getId());
            statement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    ":: ERROR- SERVICE ADVANCE AMOUNT [UPDATE DATA] :: ", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public List<MedicalServiceInfo> searchByDateAndEmpName(String date, String name) {
        Connection connection = DBConnection.getConnection();
        List<MedicalServiceInfo> listOfData = new ArrayList<>();

        try {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM TB_ADVANCE_AMOUNT "
                    + "WHERE SUB_DATE='" + date + "'"
                    + "AND EMP_NAME='" + name + "' "
                    + "ORDER BY ID DESC");

            ResultSet rs = statement.executeQuery();
/*
            while (rs.next()) {
                AdvanceAmount amount = new AdvanceAmount();
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
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    ":: ERROR- SERVICE ADVANCE AMOUNT [SELECT DATA] :: ", JOptionPane.INFORMATION_MESSAGE);
        }

        return listOfData;
    }

}
