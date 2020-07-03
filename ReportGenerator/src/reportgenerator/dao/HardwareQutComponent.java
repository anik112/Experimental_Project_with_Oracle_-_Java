/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportgenerator.dao;

/**
 *
 * @author Anik
 */
public class HardwareQutComponent {

    private String date;
    private String billNo;
    private String companyName;
    private String address;
    private String month;
    private String year;
    private String brand;
    private String model;
    private String origin;
    private String dtls01;
    private String dtls02;
    private float totalPrice;
    private int warranty;
    private int amount;
    private int faceCapacity;
    private int fingerCapacity;
    private int cardCapacity;
    private int eventLog;
    private String communicationWay;
    private int qty;
    private float unitPrice;
    private int deviceQty;
    private float deviceUnitPrice;
    private float deviceTotalPrice;
    private String qtyType;

    public String getQtyType() {
        return qtyType;
    }

    public void setQtyType(String qtyType) {
        this.qtyType = qtyType;
    }

    public int getDeviceQty() {
        return deviceQty;
    }

    public void setDeviceQty(int deviceQty) {
        this.deviceQty = deviceQty;
    }

    public float getDeviceUnitPrice() {
        return deviceUnitPrice;
    }

    public void setDeviceUnitPrice(float deviceUnitPrice) {
        this.deviceUnitPrice = deviceUnitPrice;
    }

    public float getDeviceTotalPrice() {
        return deviceTotalPrice;
    }

    public void setDeviceTotalPrice(float deviceTotalPrice) {
        this.deviceTotalPrice = deviceTotalPrice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getFaceCapacity() {
        return faceCapacity;
    }

    public void setFaceCapacity(int faceCapacity) {
        this.faceCapacity = faceCapacity;
    }

    public int getFingerCapacity() {
        return fingerCapacity;
    }

    public void setFingerCapacity(int fingerCapacity) {
        this.fingerCapacity = fingerCapacity;
    }

    public int getCardCapacity() {
        return cardCapacity;
    }

    public void setCardCapacity(int cardCapacity) {
        this.cardCapacity = cardCapacity;
    }

    public int getEventLog() {
        return eventLog;
    }

    public void setEventLog(int eventLog) {
        this.eventLog = eventLog;
    }

    public String getCommunicationWay() {
        return communicationWay;
    }

    public void setCommunicationWay(String communicationWay) {
        this.communicationWay = communicationWay;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getDtls01() {
        return dtls01;
    }

    public void setDtls01(String dtls01) {
        this.dtls01 = dtls01;
    }

    public String getDtls02() {
        return dtls02;
    }

    public void setDtls02(String dtls02) {
        this.dtls02 = dtls02;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }

    public int getWarranty() {
        return this.warranty;
    }

}
