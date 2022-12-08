package reportgenerator.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import reportgenerator.dao.DoctorInfo;
import reportgenerator.dbConnection.DBConnection;

/**
 *
 * @author Administrator
 */
public class DoctorService {

    public void saveData(DoctorInfo doctor) {

        Connection connection = DBConnection.getConnection();
        DoctorInfo doctorInfo = new DoctorInfo();

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

            PreparedStatement statement = connection.prepareStatement("INSERT INTO `doctor_dtls`( "
                    + "`doctor_fname`, "
                    + "`doctor_sex`, "
                    + "`doctor_nid`, "
                    + "`doctor_hphone`,"
                    + "`doctor_address`, "
                    + "`doctor_qualfication`, "
                    + "`doctor_specialization`, "
                    + "`doctor_type`, "
                    + "`doctor_vcharge`, "
                    + "`doctor_ccharge`) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?)");
            statement.setString(1, doctorInfo.getName());
            statement.setString(2, doctor.getGender());
            statement.setString(3, doctor.getNid());
            statement.setString(4, doctor.getPhone());
            statement.setString(5, doctor.getAddress());
            statement.setString(6, doctor.getQualfication());
            statement.setString(7, doctor.getSpecialization());
            statement.setString(8, doctor.getType());
            statement.setInt(9, doctor.getvCharge());
            statement.setInt(10, doctor.getcCharge());

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

    public List<DoctorInfo> getDataFromDoctorTable() {

        List<DoctorInfo> listOfData = new ArrayList<>();

        Connection connection = DBConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT `doctor_id`, "
                    + "`doctor_fname`, "
                    + "`doctor_sex`, "
                    + "`doctor_nid`, "
                    + "`doctor_hphone`, "
                    + "`doctor_address`, "
                    + "`doctor_qualfication`, "
                    + "`doctor_specialization`, "
                    + "`doctor_vcharge`, "
                    + "`doctor_ccharge` FROM doctor_dtls ORDER BY doctor_id DESC");

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                DoctorInfo di = new DoctorInfo();

                di.setId(rs.getInt(1));
                di.setName(rs.getString(2));
                di.setNid(rs.getString(3));
                di.setPhone(rs.getString(4));
                di.setAddress(rs.getString(5));
                di.setQualfication(rs.getString(6));
                di.setSpecialization(rs.getString(7));
                di.setType(rs.getString(8));
                di.setvCharge(rs.getInt(9));
                di.setcCharge(rs.getInt(10));

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

    public void updateData(DoctorInfo info) {

        Connection connection = DBConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE doctor_dtls set "
                    + "`doctor_fname`= "+info.getName()
                    + "`doctor_sex`="+info.getGender()
                    + "`doctor_nid`="+info.getNid()
                    + "`doctor_hphone`="+info.getPhone()
                    + "`doctor_address`="+info.getAddress()
                    + "`doctor_qualfication`="+info.getQualfication()
                    + "`doctor_specialization`= "+info.getSpecialization()
                    + "`doctor_vcharge`="+info.getvCharge()
                    + "`doctor_ccharge`="+info.getcCharge()
                    + "WHERE doctor_id=" + info.getId());

            statement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    ":: ERROR- SERVICE ADVANCE AMOUNT [UPDATE DATA] :: ", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public List<DoctorInfo> searchByDateAndEmpName(String date, String name) {
        Connection connection = DBConnection.getConnection();
        List<DoctorInfo> listOfData = new ArrayList<>();

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
