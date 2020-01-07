/*
 * Copyright (C) 2019 VSI-ANIK
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package tstcor;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;
import utility.PWS;
import utility.PasswordEnqDnq;

/**
 *
 * @author VSI-ANIK
 */
public class TestCore implements Runnable{

    @Override
    public void run() {
        
//        
//            PreparedStatement statement02 = getConn.prepareStatement(sql02); // statement create
//            ResultSet rs02 = statement02.executeQuery(); // statement execute
//        
//        // loop for push data in txt file
//                while (rs02.next()) {
//                    Date date = rs02.getTimestamp(1); // get date/time form result sheet
//                    String strDate = formatter.format(date); // format date using date formatter
//                    System.out.println(strDate);
//                    String onlyDate = strDate.substring(0, 10); // get only date from (date/time)
//                    onlyDate = onlyDate.replace("/", ""); // remove '/' from date
//                    System.out.println(onlyDate);
//                    String onlyTime = strDate.substring(11, 22); // get only time form (date/time)
//                    onlyTime = onlyTime.substring(0, 8); // resize time
//                    onlyTime = onlyTime.replace(":", ""); // remove ':' from time
//                    System.out.println(onlyTime);
//
//                    // Make string format
//                    String finalText = (rs02.getString(2) + ":00" + rs02.getString(4) + ":" + onlyDate + ":" + onlyTime + ":" + "BLANK !!:11");
//                    printWriter.println(finalText); // write text in file
//
//                    System.out.println(rs02.getString(2) + ":" + rs02.getString(4) + ":" + onlyDate + ":" + onlyTime + ":" + "BLANK !!:11");
//                    rowCount++; // row count
//                }
//
//            } catch (IOException e) {
//                JOptionPane.showMessageDialog(null, "ConverterCore.java | " + e.getMessage(),
//                        ":: File Error ZKT server :: ", JOptionPane.INFORMATION_MESSAGE);
//            }

    }
    
}
