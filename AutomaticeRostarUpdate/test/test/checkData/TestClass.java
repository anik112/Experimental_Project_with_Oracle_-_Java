/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.checkData;

import com.util.process.WdayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author VSI-ANIK
 */
public class TestClass {

    public static void main(String arg[]) {
        WdayList list=new WdayList();
        Date date = new Date(System.currentTimeMillis());
        System.out.println(date);
        
        Calendar calendar=Calendar.getInstance();
        System.out.println(calendar);
        System.out.println(list.getDayNameFromDayNumber(calendar.get(7)));

    }

}
