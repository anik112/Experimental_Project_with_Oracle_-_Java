/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataDuctModel;

/**
 *
 * @author VSI-ANIK
 */
public class OtDuctParameters {
    
    private int comId=0;
    private int year=0;
    private String month="";
    private String section="";
    private String lineNo="";
    private int ductHours=0;
    private boolean complience=false;
    private boolean hAndm=false;
    private boolean halfHourOtCalculation=false;
    private boolean otpart=false;

    public boolean isOtpart() {
        return otpart;
    }

    public void setOtpart(boolean otpart) {
        this.otpart = otpart;
    }

    public int getComId() {
        return comId;
    }

    public boolean isComplience() {
        return complience;
    }

    public void setComplience(boolean complience) {
        this.complience = complience;
    }

    public boolean ishAndm() {
        return hAndm;
    }

    public void sethAndm(boolean hAndm) {
        this.hAndm = hAndm;
    }

    public boolean isHalfHourOtCalculation() {
        return halfHourOtCalculation;
    }

    public void setHalfHourOtCalculation(boolean halfHourOtCalculation) {
        this.halfHourOtCalculation = halfHourOtCalculation;
    }

    public void setComId(int comId) {
        this.comId = comId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getLineNo() {
        return lineNo;
    }

    public void setLineNo(String lineNo) {
        this.lineNo = lineNo;
    }

    public int getDuctHours() {
        return ductHours;
    }

    public void setDuctHours(int ductHours) {
        this.ductHours = ductHours;
    }
    
    
    
}
