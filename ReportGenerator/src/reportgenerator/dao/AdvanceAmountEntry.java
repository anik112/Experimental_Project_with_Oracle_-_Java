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
public class AdvanceAmountEntry {
    
    private String date;
    private String empName;
    private float amount;
    private float cost;
    private float cashInHand;
    private String authorized;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getCashInHand() {
        return cashInHand;
    }

    public void setCashInHand(float cashInHand) {
        this.cashInHand = cashInHand;
    }

    public String getAuthorized() {
        return authorized;
    }

    public void setAuthorized(String authorized) {
        this.authorized = authorized;
    }
    
    
    
}
