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

/**
 *
 * @author Anik
 */
public class WriteHardwareQutBillHardCopy {

    private String configAmountListUrl = "setup\\NumberInWord.txt";

    private final String to = "To";
    private final String greetingtextHead = "Dear Sir,";
    private final String greetingtextBody = "Thank you for choosing us. Please pay the bill as follows:";
    private final String colHeader01 = "S/L";
    private final String colHeader02="Name of the products";
    private final String colHeader03 = "Description";
    private final String colHeader06 = "Amount (TK.)";
    private final String colHeader04="Qty";
    private final String colHeader05="Unit Price";
    private final String colFooterTxt = "Total Amount";
    private final String tableFooterTxtWithoutVat = "VAT and TAX not included.";
    private final String tableFooterTxtWithVat = "VAT and TAX included.";
    private final String amountTage = "Amount in word: ";
    private final String noteTxt = "N.B: All payments should be in A/C payee cheque in favour of “ Vistasoft IT Bangladesh Ltd.”";
    private final String sign = "..................................\nAuthorized Signatory";
    private float totalamount = 0;
    private String amountInWord;

    public WriteHardwareQutBillHardCopy() {
    }
    
    public String getAmountInWord() {
        return amountInWord;
    }

    public void setAmountInWord(String amountInWord) {
        this.amountInWord = amountInWord;
    }
    
    public boolean writeHardwareQutBillInPdfFile(List<HardwareQutComponent> components, File selectedFile) {

        try {
            Document document = new Document(); // create a new document
            // call pdfWriter for write data in pdf file  
            // there FileOutputStream help us make a new file
            PdfWriter pw = PdfWriter.getInstance(document, new FileOutputStream(selectedFile));
            Rectangle rectangle = document.getPageSize(); // get total page size in a rectangle
            pw.setBoxSize("rectangle", rectangle); // set rectangle in pdfWriter

            document.setMargins(40, 40, 40, 40); // set document margen
            document.open(); // open this doucment
            
            FontFactory.register("font\\calibri.ttf", "calibri"); // call font factory for setup font style
            Font f1 = FontFactory.getFont("calibri", 10);  // set font style and size into font object

            // make first text in document
            Paragraph docHeader = new Paragraph("\nDate: " + components.get(0).getDate()+ "\n"
                    + "Bill No: " + components.get(0).getBillNo()+ "\n"
                    + to + "\n"
                    + components.get(0).getCompanyName()+ "\n"
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
                for (int i = 0; i < components.size(); i++) {
                    String count = ""; // make row number list
                    count = String.valueOf(i + 1);
                    
                    row1[i]=new PdfPCell();
                    row2[i]=new PdfPCell();
                    row3[i]=new PdfPCell();
                    row4[i]=new PdfPCell();
                    row5[i]=new PdfPCell();
                    row6[i]=new PdfPCell();
                    
                    if(!components.get(i).getBrand().isEmpty()){
                        row1[i].setPhrase(new Paragraph(count,f4));
                        row2[i].setPhrase(new Paragraph(""
                            + "Time Attendence Device\n\n"
                            + "Brand: "+components.get(i).getBrand()+"\n"
                            + "Model: "+components.get(i).getModel()+"\n"
                            + "Origin: "+components.get(i).getOrigin()+"\n\n"
                            + components.get(i).getWarranty()+" Year Warranty ",f4
                        ));
                        row3[i].setPhrase(new Paragraph(""
                            + "Face Capacity: "+components.get(i).getFaceCapacity()+"\n"
                            + "Finger Capacity: "+components.get(i).getFingerCapacity()+"\n"
                            + "ID Card: "+components.get(i).getCardCapacity()+"\n"
                            + "Event Log: "+components.get(i).getEventLog()+"\n\n"
                            + "Communication:\n" 
                            +components.get(i).getCommunicationWay(),f4
                        ));
                        row4[i].setPhrase(new Paragraph(String.valueOf(components.get(i).getDeviceQty()+" PCS"),f4));
                        String amountUnit=String.format("%.02f", components.get(i).getDeviceUnitPrice());
                        row5[i].setPhrase(new Paragraph(amountUnit,f4));
                        String amount=String.format("%.02f", components.get(i).getDeviceTotalPrice());
                        row6[i].setPhrase(new Paragraph(amount,f4));
                        totalamount += components.get(i).getDeviceTotalPrice();
                    }else{
                        row1[i].setPhrase(new Paragraph(count,f4));
                        row2[i].setPhrase(new Paragraph(components.get(i).getDtls01(),f4));
                        row3[i].setPhrase(new Paragraph(components.get(i).getDtls02(),f4));
                        row4[i].setPhrase(new Paragraph(String.valueOf(components.get(i).getQty())+" "+components.get(i).getQtyType(),f4));
                        String amountUnit=String.format("%.02f", components.get(i).getUnitPrice());
                        row5[i].setPhrase(new Paragraph(amountUnit,f4));
                        String amount=String.format("%.02f", components.get(i).getTotalPrice());
                        row6[i].setPhrase(new Paragraph(amount,f4));
                        totalamount += components.get(i).getTotalPrice();
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
            
            
            Paragraph paraOfColFooter;
            Paragraph paraOfAmount;
            if(components.get(0).getVatAmount()>0){
                paraOfColFooter=new Paragraph("VAT "+components.get(0).getVatPrcn()+"% (+)\n\n"+colFooterTxt, f4);
                float totalAmt=(totalamount+components.get(0).getVatAmount());
                String amount=String.format("%.02f", totalAmt);
                String vatAmount=String.format("%.02f", components.get(0).getVatAmount());
                paraOfAmount=new Paragraph(vatAmount+"\n\n"+amount+"", f4);
            }else{
                String amount=String.format("%.02f", totalamount);
                paraOfColFooter=new Paragraph(colFooterTxt, f4);
                paraOfAmount=new Paragraph(amount, f4);
            }

            // last row body text
            PdfPCell row02Body = new PdfPCell(paraOfColFooter);
            row02Body.setPaddingLeft(padding);
            row02Body.setPaddingTop(padding);
            row02Body.setPaddingBottom(padding);
            row02Body.setPaddingRight(padding);
            row02Body.setHorizontalAlignment(Element.ALIGN_RIGHT);
            row02Body.setVerticalAlignment(Element.ALIGN_TOP);
            row02Body.setColspan(5);

            // last row footer txt
            PdfPCell row02Footer = new PdfPCell(paraOfAmount);
            row02Footer.setPaddingLeft(padding);
            row02Footer.setPaddingTop(padding);
            row02Footer.setPaddingBottom(padding);
            row02Footer.setPaddingRight(padding);
            row02Footer.setHorizontalAlignment(Element.ALIGN_LEFT);
            row02Footer.setVerticalAlignment(Element.ALIGN_TOP);

            table.addCell(row02Body); // add row in table
            table.addCell(row02Footer); // add row in table

            document.add(table); // add table in document

            // set font style and size
            Font f3 = FontFactory.getFont("calibri", 8);
            if(components.get(0).getVatAmount()>0){
                document.add(new Paragraph(tableFooterTxtWithVat, f3));
            }else{
                document.add(new Paragraph(tableFooterTxtWithoutVat, f3));
            }

            //document.add(new Paragraph("\n" + amountTage + (new IOFunction().getNumberInWord((int) totalamount, configAmountListUrl)) + " only.", f1));
            document.add(new Paragraph("\n" + amountTage + this.getAmountInWord(), f1));            
            document.add(new Paragraph(noteTxt + "\n\n", f2));

            Image sirSing = Image.getInstance("img\\Sir-Sign-Blank.jpg");
            sirSing.setAlignment(sirSing.ALIGN_LEFT);
            sirSing.scaleAbsolute(100, 30);
            document.add(sirSing);

            document.add(new Paragraph(sign + "\n\n", f2));

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
