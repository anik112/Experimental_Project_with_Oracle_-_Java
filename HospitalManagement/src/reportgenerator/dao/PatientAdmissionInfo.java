package reportgenerator.dao;

/**
 *
 * @author Administrator
 */
public class PatientAdmissionInfo {
    
    private int admission_id;
    private int patient_id;
    private String guardian_name;
    private String guardian_phone;
    private int room_no;
    private int bad_no;
    private String ref_doctor;
    private String admission_date;
    private String admission_time;
    private String emergency;

    public int getAdmission_id() {
        return admission_id;
    }

    public String getAdmission_date() {
        return admission_date;
    }

    public void setAdmission_date(String admission_date) {
        this.admission_date = admission_date;
    }

    public void setAdmission_id(int admission_id) {
        this.admission_id = admission_id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public String getGuardian_name() {
        return guardian_name;
    }

    public void setGuardian_name(String guardian_name) {
        this.guardian_name = guardian_name;
    }

    public String getGuardian_phone() {
        return guardian_phone;
    }

    public void setGuardian_phone(String guardian_phone) {
        this.guardian_phone = guardian_phone;
    }

    public int getRoom_no() {
        return room_no;
    }

    public void setRoom_no(int room_no) {
        this.room_no = room_no;
    }

    public int getBad_no() {
        return bad_no;
    }

    public void setBad_no(int bad_no) {
        this.bad_no = bad_no;
    }

    public String getRef_doctor() {
        return ref_doctor;
    }

    public void setRef_doctor(String ref_doctor) {
        this.ref_doctor = ref_doctor;
    }

    

    public String getAdmission_time() {
        return admission_time;
    }

    public void setAdmission_time(String admission_time) {
        this.admission_time = admission_time;
    }

    public String getEmergency() {
        return emergency;
    }

    public void setEmergency(String emergency) {
        this.emergency = emergency;
    }
     
    
}
