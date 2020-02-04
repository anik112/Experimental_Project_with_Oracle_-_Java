/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filefinder.utility;

import java.util.Date;

/**
 *
 * @author VSI-ANIK
 */
public class DaoFileNameList {
    
    private int slNo;

    public int getSlNo() {
        return slNo;
    }

    public void setSlNo(int slNo) {
        this.slNo = slNo;
    }
    private String fileName;
    private Date fileModifactionDate;
    private String isSubmited;

    public String getIsSubmited() {
        return isSubmited;
    }

    public void setIsSubmited(String isSubmited) {
        this.isSubmited = isSubmited;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getFileModifactionDate() {
        return fileModifactionDate;
    }

    public void setFileModifactionDate(Date fileModifactionDate) {
        this.fileModifactionDate = fileModifactionDate;
    }
    
    
    
}
