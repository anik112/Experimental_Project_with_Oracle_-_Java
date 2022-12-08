package reportgenerator.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import reportgenerator.dao.DoctorAppointmentInfo;
import reportgenerator.dao.DoctorInfo;
import reportgenerator.dbConnection.DBConnection;

/**
 *
 * @author Administrator
 */
public class DoctorAppointmentService {

    public void saveData(DoctorAppointmentInfo info) {

        Connection connection = DBConnection.getConnection();

        try {
            System.out.println("from Doctor service");

            PreparedStatement statement = connection.prepareStatement("INSERT INTO `doctor_appointment` "
                    + "(`appointment_id`, "
                    + "`patient_id`,"
                    + "`doctor_id`,"
                    + "`appointment_date`,"
                    + "`appointment_time`)"
                    + "VALUES (?,?,?,?,?)");
            
                statement.setInt(1, info.getAppointment_id());
                statement.setInt(2, info.getPatient_id());
                statement.setInt(3, info.getDoctor_id());
                statement.setString(4, info.getAppointment_date());
                statement.setString(5, info.getAppointment_time());
                
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

    public List<DoctorAppointmentInfo> getDataFromDoctorTable() {

        List<DoctorAppointmentInfo> listOfData = new ArrayList<>();

        Connection connection = DBConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT `appointment_id`, "
                    + "`patient_id`,"
                    + "`doctor_id`,"
                    + "`appointment_date`,"
                    + "`appointment_time` FROM `doctor_appointment` ORDER BY appointment_id DESC");

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                DoctorAppointmentInfo di = new DoctorAppointmentInfo();

                di.setAppointment_id(rs.getInt(1));
                di.setPatient_id(rs.getInt(2));
                di.setDoctor_id(rs.getInt(3));
                di.setAppointment_date(rs.getString(4));
                di.setAppointment_time(rs.getString(5));

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
            PreparedStatement statement = connection.prepareStatement("UPDATE doctor_id set "
                    + "doctor_fname='" + info.getName() + "',"
                    + "doctor_sex='" + info.getGender() + "',"
                    + "doctor_nid='" + info.getNid() + "',"
                    + "doctor_hphone='" + info.getPhone() + "',"
                    + "doctor_address='" + info.getAddress() + "',"
                    + "doctor_qualfication='" + info.getQualfication() + "',"
                    + "doctor_specialization='" + info.getSpecialization() + "',"
                    + "doctor_type='" + info.getType() + "',"
                    + "doctor_vcharge=" + info.getvCharge() + ","
                    + "doctor_ccharge=" + info.getcCharge()
                    + "WHERE ID=" + info.getId());

            statement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    ":: ERROR- SERVICE ADVANCE AMOUNT [UPDATE DATA] :: ", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public List<DoctorAppointmentInfo> searchData(int doctorId) {

        List<DoctorAppointmentInfo> listOfData = new ArrayList<>();

        Connection connection = DBConnection.getConnection();
        PreparedStatement statement;

        try {
            if(doctorId > 0){
                statement = connection.prepareStatement("SELECT `appointment_id`, "
                        + "`patient_id`,"
                        + "`doctor_id`,"
                        + "`appointment_date`,"
                        + "`appointment_time` "
                        + "FROM `doctor_appointment` "
                        + "WHERE `doctor_id` = "+doctorId
                        + " ORDER BY appointment_id DESC");
            }else{
                statement = connection.prepareStatement("SELECT `appointment_id`, "
                        + "`patient_id`,"
                        + "`doctor_id`,"
                        + "`appointment_date`,"
                        + "`appointment_time` "
                        + "FROM `doctor_appointment` "
                        + "ORDER BY appointment_id DESC");
                
            }

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                DoctorAppointmentInfo di = new DoctorAppointmentInfo();

                di.setAppointment_id(rs.getInt(1));
                di.setPatient_id(rs.getInt(2));
                di.setDoctor_id(rs.getInt(3));
                di.setAppointment_date(rs.getString(4));
                di.setAppointment_time(rs.getString(5));

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

}
