/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportgenerator.corefunction;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import reportgenerator.dao.HardwareQutComponent;
import reportgenerator.dao.ReqQutComponent;

/**
 *
 * @author Anik
 */
public class WriteHardwareQut {

    private String configAmountListUrl = "setup\\NumberInWord.txt";

    private final String to = "To";
    private final String greetingtextHead = "Dear Sir/Madam,";
    private final String greetingtextBody = "Thank you for using our software. Please pay the bill as follows:";
    private final String colHeader01 = "S/L";
    private final String colHeader02="Intro";
    private final String colHeader03 = "Description of the products";
    private final String colHeader06 = "Amount (TK.)";
    private final String colHeader04="Qty";
    private final String colHeader05="Unit Price";
    private final String colFooterTxt = "Total Amount";
    private final String tableFooterTxt = "VAT and TAX not included.";
    private final String amountTage = "Amount in word: ";
    private final String noteTxt = "N.B: All payments should be in a/c payee cheque in favour of “ Vistasoft IT Bangladesh Ltd.”";
    private final String sign = "..................................\nAuthorized Signatory";
    private int totalamount = 0;

    public boolean writeHardwareQutInPdfFile(List<HardwareQutComponent> components, File selectedFile) {

        try {
            Document document = new Document(); // create a new document
            // call pdfWriter for write data in pdf file  
            // there FileOutputStream help us make a new file
            PdfWriter pw = PdfWriter.getInstance(document, new FileOutputStream(selectedFile));
            Rectangle rectangle = document.getPageSize(); // get total page size in a rectangle
            pw.setBoxSize("rectangle", rectangle); // set rectangle in pdfWriter

            document.setMargins(40, 40, 20, 20); // set document margen
            document.open(); // open this doucment

            // set logo in top
            Image topLogo = Image.getInstance("img\\logoWithFooterTxt.jpg"); // make image object
            topLogo.setAlignment(topLogo.ALIGN_RIGHT); // set image alignment
            topLogo.scaleAbsolute(180, 60);  // set image absolute size
            //topLogo.setSpacingBefore(100);
            document.add(topLogo); // add this logo in document
            FontFactory.register("font\\calibri.ttf", "calibri"); // call font factory for setup font style
            Font f1 = FontFactory.getFont("calibri", 10);  // set font style and size into font object

            // make first text in document
            Paragraph docHeader = new Paragraph("\nDate: " + components.get(0).getDate() + "\n\n"
                    + to + "\n"
                    + components.get(0).getCompanyName() + "\n"
                    + components.get(0).getAddress() + "\n\n"
                    + greetingtextHead + "\n"
                    + greetingtextBody,
                    f1);
            document.add(docHeader); // add text in document
            // make a table in pdf file using PdfTable object
            PdfPTable table = new PdfPTable(6); // 6 is number of col
            table.setWidthPercentage(100); // set table width
            table.setSpacingBefore(15f); // set upper spacing size
            table.setSpacingAfter(3f); // set lower spacing size

            // ========================================================
            Font f2 = FontFactory.getFont("calibri", 10); // set font style and size. 12 is  font size     
            Font f4 = FontFactory.getFont("calibri", 8); // set font style and size
            Font f5 = FontFactory.getFont("calibri", 8);
            
            // make a float array for set each colume size
            float[] colomWidth = {0.3f, 0.9f, 0.9f, 0.5f, 0.5f, 0.5f};
            table.setWidths(colomWidth); // add total size in table

            
            // ================================================================
            // make row header 01
            PdfPCell cellHeader01 = new PdfPCell(new Paragraph(colHeader01, f5));
            cellHeader01.setPaddingLeft(10);
            cellHeader01.setPaddingTop(10);
            cellHeader01.setPaddingBottom(10);
            cellHeader01.setPaddingRight(10);
            cellHeader01.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellHeader01.setVerticalAlignment(Element.ALIGN_MIDDLE);

            // make row header 02
            PdfPCell cellHeader02 = new PdfPCell(new Paragraph(new Paragraph(colHeader02, f5)));
            cellHeader02.setPaddingLeft(10);
            cellHeader02.setPaddingTop(10);
            cellHeader02.setPaddingBottom(10);
            cellHeader02.setPaddingRight(10);
            cellHeader02.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellHeader02.setVerticalAlignment(Element.ALIGN_MIDDLE);

            // make row header 03
            PdfPCell cellHeader03 = new PdfPCell(new Paragraph(colHeader03, f5));
            cellHeader03.setPaddingLeft(10);
            cellHeader03.setPaddingTop(10);
            cellHeader03.setPaddingBottom(10);
            cellHeader03.setPaddingRight(10);
            cellHeader03.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellHeader03.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            // make row header 04
            PdfPCell cellHeader04 = new PdfPCell(new Paragraph(colHeader04, f5));
            cellHeader04.setPaddingLeft(10);
            cellHeader04.setPaddingTop(10);
            cellHeader04.setPaddingBottom(10);
            cellHeader04.setPaddingRight(10);
            cellHeader04.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellHeader04.setVerticalAlignment(Element.ALIGN_MIDDLE);

            // make row header 05
            PdfPCell cellHeader05 = new PdfPCell(new Paragraph(colHeader05, f5));
            cellHeader05.setPaddingLeft(10);
            cellHeader05.setPaddingTop(10);
            cellHeader05.setPaddingBottom(10);
            cellHeader05.setPaddingRight(10);
            cellHeader05.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellHeader05.setVerticalAlignment(Element.ALIGN_MIDDLE);
            

            // make row header 06
            PdfPCell cellHeader06 = new PdfPCell(new Paragraph(colHeader06, f5));
            cellHeader06.setPaddingLeft(10);
            cellHeader06.setPaddingTop(10);
            cellHeader06.setPaddingBottom(10);
            cellHeader06.setPaddingRight(10);
            cellHeader06.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellHeader06.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            
            // adding col header
            table.addCell(cellHeader01);
            table.addCell(cellHeader02);
            table.addCell(cellHeader03);
            table.addCell(cellHeader04);
            table.addCell(cellHeader05);
            table.addCell(cellHeader06);
            // ================================================================
            
            
            // set padding
            float rowBttomPadding = 5;
            float rowTopPadding = 5;
            float padding = 10;
           
            
            

            try {
                // make row cell
                // 15 is max cell size
                PdfPCell[] row1 = new PdfPCell[15];
                PdfPCell[] row2=new PdfPCell[15];
                PdfPCell[] row3=new PdfPCell[15];
                PdfPCell[] row4=new PdfPCell[15];
                PdfPCell[] row5=new PdfPCell[15];
                PdfPCell[] row6=new PdfPCell[15];

                // adding row in table
                for (int i = 0; i < 7; i++) {
                    String count = ""; // make row number list
                    count = String.valueOf(i + 1);
                    
                    row1[i]=new PdfPCell();
                    row2[i]=new PdfPCell();
                    row3[i]=new PdfPCell();
                    row4[i]=new PdfPCell();
                    row5[i]=new PdfPCell();
                    row6[i]=new PdfPCell();
                    
                    if(i<2){
                        row1[i].setPhrase(new Paragraph(count,f4));
                        row2[i].setPhrase(new Paragraph(""
                            + "Time Attendence Device\n\n"
                            + "Brand: uFace 8000\n"
                            + "Model: Zkt\n"
                            + "Origin: Bangladesh\n\n"
                            + "1 Year Warranty ",f4
                        ));
                        row3[i].setPhrase(new Paragraph(""
                            + "Face Capacity: 20000\n"
                            + "Finger Capacity: 20000\n"
                            + "ID Card: 10000\n"
                            + "Event Log: 100,0000\n\n"
                            + "Communication:\n" 
                            +"RS485, TCP/IP, USB-host",f4
                        ));
                        row4[i].setPhrase(new Paragraph("5000 PCS",f4));
                        row5[i].setPhrase(new Paragraph("1035000",f4));
                        row6[i].setPhrase(new Paragraph("1035000",f4));
                    }else{
                        row1[i].setPhrase(new Paragraph(count,f4));
                        row2[i].setPhrase(new Paragraph("----",f4));
                        row3[i].setPhrase(new Paragraph("-----",f4));
                        row4[i].setPhrase(new Paragraph("5000 PCS",f4));
                        row5[i].setPhrase(new Paragraph("1035000",f4));
                        row6[i].setPhrase(new Paragraph("1035000",f4));
                    }
                    
                    
                    //============ Row 01
                    row1[i].setPaddingLeft(padding);
                    row1[i].setPaddingTop(padding);
                    row1[i].setPaddingBottom(padding);
                    row1[i].setPaddingRight(padding);
                    row1[i].setHorizontalAlignment(Element.ALIGN_LEFT);
                    row1[i].setVerticalAlignment(Element.ALIGN_TOP);
                    
                    //  =================== Row 02
                    row2[i].setPaddingLeft(padding);
                    row2[i].setPaddingTop(padding);
                    row2[i].setPaddingBottom(padding);
                    row2[i].setPaddingRight(padding);
                    row2[i].setHorizontalAlignment(Element.ALIGN_LEFT);
                    row2[i].setVerticalAlignment(Element.ALIGN_TOP);
                    
                    
                    // ================ Row 03
                    row3[i].setPaddingLeft(padding);
                    row3[i].setPaddingTop(padding);
                    row3[i].setPaddingBottom(padding);
                    row3[i].setPaddingRight(padding);
                    row3[i].setHorizontalAlignment(Element.ALIGN_LEFT);
                    row3[i].setVerticalAlignment(Element.ALIGN_TOP);
                    
                    // ================ Row 04
                    row4[i].setPaddingLeft(padding);
                    row4[i].setPaddingTop(padding);
                    row4[i].setPaddingBottom(padding);
                    row4[i].setPaddingRight(padding);
                    row4[i].setHorizontalAlignment(Element.ALIGN_LEFT);
                    row4[i].setVerticalAlignment(Element.ALIGN_TOP);
                    
                    
                    // ================ Row 05
                    row5[i].setPaddingLeft(padding);
                    row5[i].setPaddingTop(padding);
                    row5[i].setPaddingBottom(padding);
                    row5[i].setPaddingRight(padding);
                    row5[i].setHorizontalAlignment(Element.ALIGN_LEFT);
                    row5[i].setVerticalAlignment(Element.ALIGN_TOP);
                    
                    
                    // ================ Row 06
                    row6[i].setPaddingLeft(padding);
                    row6[i].setPaddingTop(padding);
                    row6[i].setPaddingBottom(padding);
                    row6[i].setPaddingRight(padding);
                    row6[i].setHorizontalAlignment(Element.ALIGN_LEFT);
                    row6[i].setVerticalAlignment(Element.ALIGN_TOP);
                    
                    table.addCell(row1[i]);
                    table.addCell(row2[i]);
                    table.addCell(row3[i]);
                    table.addCell(row4[i]);
                    table.addCell(row5[i]);
                    table.addCell(row6[i]);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            // last row body text
            PdfPCell row02Body = new PdfPCell(new Paragraph(colFooterTxt, f2));
            row02Body.setPaddingLeft(padding);
            row02Body.setPaddingTop(padding);
            row02Body.setPaddingBottom(padding);
            row02Body.setPaddingRight(padding);
            row02Body.setHorizontalAlignment(Element.ALIGN_RIGHT);
            row02Body.setVerticalAlignment(Element.ALIGN_TOP);
            row02Body.setColspan(2);

            // last row footer txt
            PdfPCell row02Footer = new PdfPCell(new Paragraph(String.valueOf(totalamount) + ".00", f2));
            row02Footer.setPaddingLeft(padding);
            row02Footer.setPaddingTop(padding);
            row02Footer.setPaddingBottom(padding);
            row02Footer.setPaddingRight(padding);
            row02Footer.setHorizontalAlignment(Element.ALIGN_CENTER);
            row02Footer.setVerticalAlignment(Element.ALIGN_TOP);

            table.addCell(row02Body); // add row in table
            table.addCell(row02Footer); // add row in table

            document.add(table); // add table in document

            // set font style and size
            Font f3 = FontFactory.getFont("SansSerif", 8);
            document.add(new Paragraph(tableFooterTxt, f3));

            document.add(new Paragraph("\n" + amountTage + (new IOFunction().getNumberInWord(totalamount, configAmountListUrl)) + " only.", f1));
            document.add(new Paragraph(noteTxt + "\n\n", f2));

            Image sirSing = Image.getInstance("img\\Sir-Sign.jpg");
            sirSing.setAlignment(sirSing.ALIGN_LEFT);
            sirSing.scaleAbsolute(100, 30);
            document.add(sirSing);

            document.add(new Paragraph(sign + "\n\n", f2));

            document.add(new Paragraph("\n"));
            Image footerImage = Image.getInstance("img\\footer.jpg");
            footerImage.setAlignment(footerImage.ALIGN_LEFT);
            footerImage.setBottom(1f);
            footerImage.scaleAbsolute(document.getPageSize().getWidth() - 80, 90);
            footerImage.setAbsolutePosition(40, rectangle.getBottom());
            document.add(footerImage);

            document.close();
            return true;

        } catch (Exception ex) {
            Logger.getLogger(WriteQutitoin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    ":: Error-06 :: ", JOptionPane.INFORMATION_MESSAGE);
        }

        return false;
    }
}
