/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportgenerator.dao;

import java.util.Date;

/**
 *
 * @author Anik
 */
public class AdvanceAmount {
    
    private int id;
    private Date givenDate;
    private String advanceHolderName;
    private String couseOfAdvance;
    private float amountOfAdvance;
    private boolean authorized;
    private Date writeDate;
    private String writePerson;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getGivenDate() {
        return givenDate;
    }

    public void setGivenDate(Date givenDate) {
        this.givenDate = givenDate;
    }

    public String getAdvanceHolderName() {
        return advanceHolderName;
    }

    public void setAdvanceHolderName(String advanceHolderName) {
        this.advanceHolderName = advanceHolderName;
    }

    public String getCouseOfAdvance() {
        return couseOfAdvance;
    }

    public void setCouseOfAdvance(String couseOfAdvance) {
        this.couseOfAdvance = couseOfAdvance;
    }

    public float getAmountOfAdvance() {
        return amountOfAdvance;
    }

    public void setAmountOfAdvance(float amountOfAdvance) {
        this.amountOfAdvance = amountOfAdvance;
    }

    public boolean isAuthorized() {
        return authorized;
    }

    public void setAuthorized(boolean authorized) {
        this.authorized = authorized;
    }

    public Date getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(Date writeDate) {
        this.writeDate = writeDate;
    }

    public String getWritePerson() {
        return writePerson;
    }

    public void setWritePerson(String writePerson) {
        this.writePerson = writePerson;
    }
    
    
    
    
    
}