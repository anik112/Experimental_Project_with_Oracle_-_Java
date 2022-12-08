package reportgenerator.dao;

import java.util.Date;

/**
 *
 * @author Administrator
 */
public class PatientInfo {

    private int id;
    private String name;
    private String address;
    private String telephone;
    private String status;
    private String notes;
    private Date patient_dob;
    private String patient_sex;
    private String patient_nid;
    private String patient_hphone;
    private int patient_hight;
    private int patient_weight;
    private String patient_blood_group;
    private String patient_notes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getPatient_dob() {
        return patient_dob;
    }

    public void setPatient_dob(Date patient_dob) {
        this.patient_dob = patient_dob;
    }

    public String getPatient_sex() {
        return patient_sex;
    }

    public void setPatient_sex(String patient_sex) {
        this.patient_sex = patient_sex;
    }

    public String getPatient_nid() {
        return patient_nid;
    }

    public void setPatient_nid(String patient_nid) {
        this.patient_nid = patient_nid;
    }

    public String getPatient_hphone() {
        return patient_hphone;
    }

    public void setPatient_hphone(String patient_hphone) {
        this.patient_hphone = patient_hphone;
    }

    public int getPatient_hight() {
        return patient_hight;
    }

    public void setPatient_hight(int patient_hight) {
        this.patient_hight = patient_hight;
    }

    public int getPatient_weight() {
        return patient_weight;
    }

    public void setPatient_weight(int patient_weight) {
        this.patient_weight = patient_weight;
    }

    public String getPatient_blood_group() {
        return patient_blood_group;
    }

    public void setPatient_blood_group(String patient_blood_group) {
        this.patient_blood_group = patient_blood_group;
    }

    public String getPatient_notes() {
        return patient_notes;
    }

    public void setPatient_notes(String patient_notes) {
        this.patient_notes = patient_notes;
    }
    
    public java.sql.Date getSqlDate(java.util.Date dt){
        java.sql.Date v_date = new java.sql.Date(dt.getTime());
        return v_date;
    }
    
    public java.util.Date getUtilDate(java.sql.Date dt){
        java.util.Date v_date = new java.util.Date(dt.getTime());
        return v_date;
    }

}
