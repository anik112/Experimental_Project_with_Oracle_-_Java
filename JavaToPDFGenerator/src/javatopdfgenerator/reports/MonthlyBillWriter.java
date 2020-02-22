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
            
            document.add(new Paragraph("Hello i am anik paul"));
            document.add(new Paragraph("Hello i am anik paul asdhj oasn. jsdk,asjjhas .jsjdhbchgja ,."
                    + "sudhas hgas.sdjkavb yeascbasc,"));
            document.close();
        } catch (Exception ex) {
            Logger.getLogger(MonthlyBillWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
