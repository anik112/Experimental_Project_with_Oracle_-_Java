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

import accesstotextconvert.AccessConnection;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author VSI-ANIK
 */
public class Test {
    
    
    public static void main(String[] args) throws SQLException {
        
        String rtaFromDate="20191122";
        String rtaToDate="20191123";
        
          // ========== RMS ============
            Connection getRtaConn = AccessConnection.dbRTAConnection(); // get RMS server connection
            String sql03 = "SELECT NODE_NO,CARD_NO,D_CARD,T_CARD FROM DATA_CARD WHERE (((data_card.d_card)='"+rtaFromDate+"')) OR (((data_card.d_card)='"+rtaToDate+"'));";
            PreparedStatement rtaStatement = getRtaConn.prepareStatement(sql03); // statement create
            ResultSet rtaSet = rtaStatement.executeQuery(); // statement execute           
            //System.exit(0);
        // wite data in txt file
        int maxSize = rtaSet.getRow();
        int rowCount=0;
        System.out.println("Arry Size: "+maxSize);
        // "00"+STRING(NODE_NO)+":"+CARD_NO+":"+D_CARD+":"+T_CARD+":"+"BLANK !!"+":"+"11"
        while (rtaSet.next()) {
            System.out.println("----------- "+rowCount);
            try {
                // Make string format
                String finalText = ("0" + rtaSet.getString(1) + ":" + rtaSet.getString(2) + ":" + rtaSet.getString(3) + ":" + rtaSet.getString(4) + ":" + "BLANK !!:11");
                System.out.println(finalText);
                
            } catch (SQLException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
            rowCount++; // row count
        }
        
    }
}
