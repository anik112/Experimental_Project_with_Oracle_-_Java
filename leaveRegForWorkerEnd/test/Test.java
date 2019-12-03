
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author VSIANIK
 */
public class Test {

    public static void main(String[] args) {

        try {
            String fullDate = "01052019";
            String day = fullDate.substring(0, 2);
            String month = fullDate.substring(2, 4);
            String year = fullDate.substring(4, 8);
            
            System.out.println(day);
            System.out.println(month);
            System.out.println(year);
            
            String sDate1 = "31/12/1998";
            java.util.Date date1 = new SimpleDateFormat("MM/dd/yyyy").parse(sDate1);
            System.out.println(sDate1 + "\t" + date1);
        } catch (ParseException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
