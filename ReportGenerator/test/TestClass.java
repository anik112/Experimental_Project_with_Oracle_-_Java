
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import reportgenerator.corefunction.WriteHardwareQut;
import reportgenerator.dao.AdvanceAmount;
import reportgenerator.dao.HardwareQutComponent;
import reportgenerator.dbConnection.DBConnection;
import reportgenerator.service.AdvanceAmountService;
import reportgenerator.view.subwindow.AdvanceAmountEntry;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Anik
 */
public class TestClass {

    private static String configComapnyListUrl = "setup\\CompanyName.txt";

    public static void main(String[] args) {
        try {
            //        System.out.println(configComapnyListUrl);
//        try {
//            File selectedFile = new File("D:\\0-VisioApls.pdf");
//            if (!selectedFile.exists()) {
//                PrintWriter pw;
//
//                pw = new PrintWriter(selectedFile);
//
//                System.out.println("--------------->> file create");
//                pw.close();
//            }

//              string check
//            String s = "19032a";
//            if (s.matches("-?\\d+(\\.\\d+)?")) {
//                System.out.println("Is number");
//            }else{
//                System.out.println("Is not number");
//            }
// date check
//System.out.println(Math.round(Float.valueOf("10.00")));
// check dynamic variable
//            int n1=1,n2=3,n3=4;
//            for(int i=1;i<4;i++){
//                System.out.println(n<i>);
//            }
//            List<HardwareQutComponent> components = new ArrayList<>();
//            HardwareQutComponent component = new HardwareQutComponent();
//            component.setDate("04/04/2020");
//            component.setAddress("Dhaka");
//            component.setAmount(1000);
//            component.setCompanyName("Vision");
//            component.setYear("2020");
//            component.setMonth("May");
//            components.add(component);
//
//            new WriteHardwareQut().writeHardwareQutInPdfFile(components, selectedFile);
//
//        } catch (Exception ex) {
//            Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        String url = "D:\\FileFinder\\fileFinder\\amex.xml";
//        String parts[] = url.split("amex");
//
//        for (int i = 0; i < parts.length; i++) {
//            System.out.println(parts[i]);
//        }
//        System.out.println("Amex.".replace(".", ""));
//        
        System.out.println(DBConnection.getConnection());
//        
//        AdvanceAmount aa=new AdvanceAmount();
//        aa.setGivenDate("12/12/2020");
//        aa.setAdvanceHolderName("Shuvo02");
//        aa.setAmountOfAdvance(30);
//        aa.setAmountOfCost(12);
//        aa.setAmountCashOnHand(13);
//        
//        new AdvanceAmountService().saveData(aa);
//            Connection connection = DBConnection.getConnection();
//            PreparedStatement statement = connection.prepareStatement("INSERT INTO TB_ADVANCE_AMOUNT (SUB_DATE,EMP_NAME,AMOUNT,COST,CASH_IN_HAND,AUTHORIZED) VALUES ('12/01/2020','Suvo',2,1,3,'NO')");
//            statement.executeUpdate();
//            System.out.println("Update::");
//            System.exit(0);
        } catch (Exception ex) {
            Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
