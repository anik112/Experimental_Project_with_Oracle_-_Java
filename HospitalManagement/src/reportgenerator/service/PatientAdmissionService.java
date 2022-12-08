package reportgenerator.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import reportgenerator.dao.DoctorInfo;
import reportgenerator.dao.PatientAdmissionInfo;
import reportgenerator.dbConnection.DBConnection;

/**
 *
 * @author Administrator
 */
public class PatientAdmissionService {

    public void saveData(PatientAdmissionInfo info) {

        Connection connection = DBConnection.getConnection();

        try {
            System.out.println("from Doctor service");

            PreparedStatement statement = connection.prepareStatement("INSERT INTO `admission_details`( "
                    + "`admission_id`, "
                    + "`patient_id`,"
                    + "`guardian_name`,"
                    + "`guardian_phone`,"
                    + "`room_ward_no`,"
                    + "`bad_no`,"
                    + "`ref_doctor`,"
                    + "`admission_date`,"
                    + "`admission_time`,"
                    + "`emergency`)"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?)");

            statement.setInt(1, info.getAdmission_id());
            statement.setInt(2, info.getPatient_id());
            statement.setString(3, info.getGuardian_name());
            statement.setString(4, info.getGuardian_phone());
            statement.setInt(5, info.getRoom_no());
            statement.setInt(6, info.getBad_no());
            statement.setString(7, info.getRef_doctor());
            statement.setString(8, info.getAdmission_date());
            statement.setString(9, info.getAdmission_time());
            statement.setString(10, info.getEmergency());

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

    public List<PatientAdmissionInfo> getDataFromDoctorTable() {

        List<PatientAdmissionInfo> listOfData = new ArrayList<>();

        Connection connection = DBConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT `admission_id`, "
                    + "`patient_id`,"
                    + "`guardian_name`,"
                    + "`guardian_phone`,"
                    + "`room_ward_no`,"
                    + "`bad_no`,"
                    + "`ref_doctor`,"
                    + "`admission_date`,"
                    + "`admission_time`,"
                    + "`emergency` FROM `admission_details` ORDER BY admission_id DESC");

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                PatientAdmissionInfo di = new PatientAdmissionInfo();

                di.setAdmission_id(rs.getInt(1));
                di.setPatient_id(rs.getInt(2));
                di.setGuardian_name(rs.getString(3));
                di.setGuardian_phone(rs.getString(4));
                di.setRoom_no(rs.getInt(5));
                di.setBad_no(rs.getInt(6));
                di.setRef_doctor(rs.getString(7));
                di.setAdmission_date(rs.getString(8));
                di.setAdmission_time(rs.getString(9));
                di.setEmergency(rs.getString(10));

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

    public List<PatientAdmissionInfo> searchData(int patient_id) {

        List<PatientAdmissionInfo> listOfData = new ArrayList<>();

        Connection connection = DBConnection.getConnection();
        PreparedStatement statement;

        try {
            if (patient_id > 0) {
                statement = connection.prepareStatement("SELECT `admission_id`, "
                        + "`patient_id`,"
                        + "`guardian_name`,"
                        + "`guardian_phone`,"
                        + "`room_ward_no`,"
                        + "`bad_no`,"
                        + "`ref_doctor`,"
                        + "`admission_date`,"
                        + "`admission_time`,"
                        + "`emergency` "
                        + "FROM `admission_details` "
                        + "WHERE `patient_id`=" + patient_id
                        + " ORDER BY admission_id DESC");
            } else {
                statement = connection.prepareStatement("SELECT `admission_id`, "
                        + "`patient_id`,"
                        + "`guardian_name`,"
                        + "`guardian_phone`,"
                        + "`room_ward_no`,"
                        + "`bad_no`,"
                        + "`ref_doctor`,"
                        + "`admission_date`,"
                        + "`admission_time`,"
                        + "`emergency` FROM `admission_details` ORDER BY admission_id DESC");
            }

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                PatientAdmissionInfo di = new PatientAdmissionInfo();

                di.setAdmission_id(rs.getInt(1));
                di.setPatient_id(rs.getInt(2));
                di.setGuardian_name(rs.getString(3));
                di.setGuardian_phone(rs.getString(4));
                di.setRoom_no(rs.getInt(5));
                di.setBad_no(rs.getInt(6));
                di.setRef_doctor(rs.getString(7));
                di.setAdmission_date(rs.getString(8));
                di.setAdmission_time(rs.getString(9));
                di.setEmergency(rs.getString(10));

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
