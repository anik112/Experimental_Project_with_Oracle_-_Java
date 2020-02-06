/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util.process;

/**
 *
 * @author VSI-ANIK
 */
public class WdayList {

    public final String WDAY_SA="Saturday";
    public final String WDAY_SU="Sunday";
    public final String WDAY_MO="Monday";
    public final String WDAY_TU="Tuesday";
    public final String WDAY_WE="Wednesday";
    public final String WDAY_TH="Thursday";
    public final String WDAY_FR="Friday";

    public String getWDAY_SA() {
        return WDAY_SA;
    }

    public String getWDAY_SU() {
        return WDAY_SU;
    }

    public String getWDAY_MO() {
        return WDAY_MO;
    }

    public String getWDAY_TU() {
        return WDAY_TU;
    }

    public String getWDAY_WE() {
        return WDAY_WE;
    }

    public String getWDAY_TH() {
        return WDAY_TH;
    }

    public String getWDAY_FR() {
        return WDAY_FR;
    }
    
    public String getDayNameFromDayNumber(int day){
        switch(day){
            case 1:
                return WDAY_SU;
            case 2:
                return WDAY_MO;
            case 3:
                return WDAY_TU;
            case 4:
                return WDAY_WE;
            case 5:
                return WDAY_TH;
            case 6:
                return WDAY_FR;
            case 7:
                return WDAY_SA;
        }
        return "";
    }
    

    
}
