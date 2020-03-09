/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author VSI-ANIK
 */
public class PurchaseOrder {

    private int id;
    private String buyerName;
    private String styleName;
    private String poNumber;
    private String factoryName;
    private String firstCuttingDate;
    private int fabricAmount;
    private String issueDate;
    private String cargoReciveDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getFirstCuttingDate() {
        return firstCuttingDate;
    }

    public void setFirstCuttingDate(String firstCuttingDate) {
        this.firstCuttingDate = firstCuttingDate;
    }

    public int getFabricAmount() {
        return fabricAmount;
    }

    public void setFabricAmount(int fabricAmount) {
        this.fabricAmount = fabricAmount;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getCargoReciveDate() {
        return cargoReciveDate;
    }

    public void setCargoReciveDate(String cargoReciveDate) {
        this.cargoReciveDate = cargoReciveDate;
    }

    
    
}
