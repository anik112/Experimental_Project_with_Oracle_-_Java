/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author VSI-ANIK
 */
public class BundlesPlan {
    
    private int id;
    private String poNumber;
    private String styleName;
    private int cuttingNumber;
    private String rollNumber;
    private int lays;
    private String sizeName;
    private int dbl;
    private String partsName;
    private int serialTo;
    private int serialFrom;
    private int qty;

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

    public int getCuttingNumber() {
        return cuttingNumber;
    }

    public void setCuttingNumber(int cuttingNumber) {
        this.cuttingNumber = cuttingNumber;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public int getLays() {
        return lays;
    }

    public void setLays(int lays) {
        this.lays = lays;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public int getDbl() {
        return dbl;
    }

    public void setDbl(int dbl) {
        this.dbl = dbl;
    }

    public String getPartsName() {
        return partsName;
    }

    public void setPartsName(String partsName) {
        this.partsName = partsName;
    }

    public int getSerialTo() {
        return serialTo;
    }

    public void setSerialTo(int serialTo) {
        this.serialTo = serialTo;
    }

    public int getSerialFrom() {
        return serialFrom;
    }

    public void setSerialFrom(int serialFrom) {
        this.serialFrom = serialFrom;
    }
    
    
    
}
