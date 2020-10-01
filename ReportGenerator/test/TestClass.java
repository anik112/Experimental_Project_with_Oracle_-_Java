
import com.sun.net.httpserver.Filter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import reportgenerator.corefunction.WriteChallanReport;
import reportgenerator.corefunction.WriteHardwareQut;
import reportgenerator.dao.AdvanceAmount;
import reportgenerator.dao.ChallanReportComponent;
import reportgenerator.dao.EntrySubmitedBillDao;
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
//            HardwareQutComponent component1 = new HardwareQutComponent();
//            component1.setDate("04/04/2020");
//            component1.setAddress("Dhaka");
//            component1.setAmount(1000);
//            component1.setCompanyName("Vision");
//            component1.setYear("2020");
//            component1.setMonth("May");
//            components.add(component1);
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

//            Connection connection = DBConnection.getConnection();
//            //PreparedStatement statement = connection.prepareStatement("SELECT * FROM TB_ADVANCE_AMOUNT ORDER BY ID DESC");
//            // + "WHERE COM_NAME='"+comName+"'");
//            //ResultSet rs = statement.executeQuery();
//            PreparedStatement statement=connection.prepareStatement("SELECT * FROM TB_ADVANCE_AMOUNT ORDER BY ID DESC");
//            Statement statement1=connection.createStatement();
//            String qry="SELECT * FROM TB_ADVANCE_AMOUNT ORDER BY ID DESC";
//            ResultSet rs=statement.executeQuery(qry);
//            System.out.println();
//            int i = 0;
//            while (rs.next()) {
//                System.out.println(rs.getString(2));
//                i++;
//            }
//            System.out.println(i);
//            try {
//
//                Connection connection = DBConnection.getConnection();
//
//                JasperReport jasperReport = JasperCompileManager.compileReport("reports\\FindAdvanceAmountByAuthorized.jrxml");
//
//                Map<String, Object> parameters = new HashMap<>();
//                parameters.put("F_AUTH", "NO");
//
//                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);
//                //JasperPrintManager.printReport(jasperPrint, true);
//                JasperViewer jv = new JasperViewer(jasperPrint, true);
//                jv.setVisible(true);
//                JasperExportManager.exportReportToPdfFile(jasperPrint, "report1.pdf");
//
//                File f = new File("report1.pdf");
//                Desktop desktop = Desktop.getDesktop();
//                try {
//                    desktop.open(f);
//                } catch (IOException ex) {
//                    Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                System.out.println("Done!");
//            } catch (JRException ex) {
//                Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            File f = new File("D:\\test.pdf");
//            List<ChallanReportComponent> components = new ArrayList<>();
//            for (int i = 0; i < 14; i++) {
//                ChallanReportComponent component = new ChallanReportComponent();
//                component.setCompanyName("9 star Apparels Industries Ltd.");
//                component.setAddress("Plot#56, House#116, Road#05, Nurani Madrasa Road, "
//                        + "Vatulia, Turag, Dhaka");
//                component.setAttention("Mr. Towheed");
//                component.setChallanNo("16-0620200001");
//                component.setWorkOrderDate("June-2020");
//                component.setDeliveryPerson("Pranta");
//                component.setDeliveryDate("16-06-2020");
//                component.setProductName("sst");
//                component.setQuantity(12);
//                component.setRemarks("");
//                components.add(component);
//            }
//            new WriteChallanReport().writeChallanReportInPdfFile(components, f);
            String pattern = "ddMMyyyy-HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyy-HH:mm:ss");
            String date = simpleDateFormat.format(new Date());
            System.out.println(date);
        } catch (Exception ex) {
            Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
