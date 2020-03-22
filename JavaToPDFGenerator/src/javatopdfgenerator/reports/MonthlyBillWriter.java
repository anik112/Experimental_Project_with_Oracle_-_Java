/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatopdfgenerator.reports;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author VSI-ANIK
 */
public class MonthlyBillWriter {
    
    private String billDate="May 07, 2019";
    private String billNo="052019";
    private String toCompanyName="5f Apparels Limited";
    private String toCompanyAddress="Zirabo, Ashulia, Savar, Dhaka.";
    
    private String footerTxt="";

    public MonthlyBillWriter() {
    }
    
    public void writeMonthlyBill(){
        
        Document document=new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("D:\\test.pdf"));
            document.open();
            document.add(new Paragraph("\n\n"+billDate+"\n\n"
                                       +"Bill No: "+billNo+"\n"
                                       +"To\n"
                                       +toCompanyName+"\n"
                                       +toCompanyAddress+"\n\n"));
            document.add(new Paragraph("Dear Sir/Madam,\n" +
                    "Thank you for using our software. Please pay the bill as follows:"));
            
            document.add(new Paragraph("------------------------------------------------------------------------------------------------"));
            
            String table[][]=new String[3][3];
            
            table[0][0]="   SL  ";
            table[0][1]="               Description of the services            ";
            table[0][2]="   Amount (Taka)  ";
            
            table[1][0]="__";
            table[1][1]="+___________________________";
            table[1][2]="+_______________";
            
            document.add(new Paragraph(table[1][0]+table[1][1]+table[1][2]));
            document.add(new Paragraph(table[0][0]+table[0][1]+table[0][2]));
            
            document.close();
        } catch (Exception ex) {
            Logger.getLogger(MonthlyBillWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
