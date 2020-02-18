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

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author VSI-ANIK
 */
public class Test {

    public static void main(String[] args) throws SQLException {

//        try {
            //        String rtaFromDate="20191122";
//        String rtaToDate="20191123";
//        
//          // ========== RMS ============
//            Connection getRtaConn = AccessConnection.dbRTAConnection(); // get RMS server connection
//            String sql03 = "SELECT NODE_NO,CARD_NO,D_CARD,T_CARD FROM DATA_CARD WHERE (((data_card.d_card)='"+rtaFromDate+"')) OR (((data_card.d_card)='"+rtaToDate+"'));";
//            PreparedStatement rtaStatement = getRtaConn.prepareStatement(sql03); // statement create
//            ResultSet rtaSet = rtaStatement.executeQuery(); // statement execute           
//            //System.exit(0);
//        // wite data in txt file
//        int maxSize = rtaSet.getRow();
//        int rowCount=0;
//        System.out.println("Arry Size: "+maxSize);
//        // "00"+STRING(NODE_NO)+":"+CARD_NO+":"+D_CARD+":"+T_CARD+":"+"BLANK !!"+":"+"11"
//        while (rtaSet.next()) {
//            System.out.println("----------- "+rowCount);
//            try {
//                // Make string format
//                String finalText = ("0" + rtaSet.getString(1) + ":" + rtaSet.getString(2) + ":" + rtaSet.getString(3) + ":" + rtaSet.getString(4) + ":" + "BLANK !!:11");
//                System.out.println(finalText);
//                
//            } catch (SQLException ex) {
//                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            rowCount++; // row count
//        }
//        Connection cSQLS = AccessConnection.dbNITGENconnection();
//        PreparedStatement statement = cSQLS.prepareCall("select [TerminalID],[UserID],[TransactionTime] from NGAC_AUTHLOG where NGAC_AUTHLOG.TransactionTime between '2020-01-02 10:00:00' and '2020-01-03 10:00:00' \n"
//                + "order by TransactionTime desc");
//        ResultSet rs = statement.executeQuery();
//
//        while (rs.next()) {
//            String timeAndDate = rs.getString(3);
//            String year = timeAndDate.substring(0, 4);
//            String month = timeAndDate.substring(5, 7);
//            String day = timeAndDate.substring(8, 10);
//            String hours = timeAndDate.substring(11, 13);
//            String min = timeAndDate.substring(14, 16);
//            String sec = timeAndDate.substring(17, 19);
//            String terminalId = rs.getString(1);
//            if (terminalId.length() == 1) {
//                terminalId = "00" + terminalId;
//            } else if (terminalId.length() == 2) {
//                terminalId = "0" + terminalId;
//            }
//            System.out.println("TID: " + terminalId);
////            System.out.println("UID: " + rs.getString(2));
////            System.out.println(timeAndDate);
////            System.out.println("D: " + year + month + day);
////            System.out.println("T: " + hours + min + sec);
////            System.out.println("-----------------------------");
//        }

//        PasswordEnqDnq ped = new PWS();
//
//        String str = ped.passwordEnq("0000");
//        System.out.println(str);
//        String str02=ped.passwordDnq(str);
//        System.out.println(str02);
//        
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        try {
            // FileReader fileReader = new FileReader("D:\\AccessToTextConvert\\config.txt");
//            File file=new File("D:\\AccessToTextConvert\\config.txt");
//            Scanner scanner=new Scanner(file);
            
//            System.out.println(scanner.nextLine());
//            System.out.println(scanner.nextLine());
//            System.out.println(scanner.nextLine());
//            
//            String tempDb=scanner.nextLine();
//            System.out.println(tempDb);

//            String a=scanner.nextLine();
//            String b=scanner.nextLine();
//            String c=scanner.nextLine();
//            String d=scanner.nextLine();
//            
//            String serverNameTrim=a.substring(4, a.length());
//            String userNameTrim=b.substring(4, b.length());
//            String passwordTrim=c.substring(4, c.length());
//            String dbNameTrim=d.substring(4, d.length());
//           
//            System.out.println(passwordTrim);
//            PasswordEnqDnq enqDnq=new PWS();
//            passwordTrim=enqDnq.passwordDnq(passwordTrim);
//            
//            System.out.println(serverNameTrim);
//            System.out.println(userNameTrim);
//            System.out.println(passwordTrim);
//            System.out.println(dbNameTrim);
//            
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }


        Date date=new Date(System.currentTimeMillis());
        System.out.println(date.getDate());
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        System.out.println();
    }
}