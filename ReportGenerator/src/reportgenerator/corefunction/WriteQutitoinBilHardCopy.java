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
import reportgenerator.dao.ReqQutComponent;

/**
 *
 * @author Anik
 */
public class WriteQutitoinBilHardCopy {

    private String configAmountListUrl = "setup\\NumberInWord.txt";

    private final String to = "To";
    private final String greetingtextHead = "Dear Sir/Madam,";
    private final String greetingtextBody = "Thank you for using our software. Please pay the bill as follows:";
    private final String colHeder01 = "S/L";
    private final String colHeder02 = "Description of the products/Services";
    private final String colHeader03 = "Amount (TK.)";
    private final String colFooterTxt = "Total Amount";
    private final String tableFooterTxtWithoutVat = "VAT and TAX not included.";
    private final String tableFooterTxtWithVat = "VAT and TAX included.";
    private final String amountTage = "Amount in word: ";
    private final String noteTxt = "N.B: All payments should be in A/C payee cheque in favour of “ Vistasoft IT Bangladesh Ltd.”";
    private final String sign = "..................................\nAuthorized Signatory";
    private int totalamount = 0;

    public int getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(int totalamount) {
        this.totalamount = totalamount;
    }
    
    private String amountInWord="";
    
    public String getAmountInWord() {
        return amountInWord;
    }

    public void setAmountInWord(String amountInWord) {
        this.amountInWord = amountInWord;
    }
        
    public boolean writeReqQtBillInPdfFile(List<ReqQutComponent> components, String billNo, File selectedFile) {

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
            Font f1 = FontFactory.getFont("calibri", 12);  // set font style and size into font object

            // make first text in document
            Paragraph docHeader = new Paragraph("\nDate: " + components.get(0).getDate() + "\n"
                    + "Bill No: " + billNo+ "\n"
                    + to + "\n"
                    + components.get(0).getCompanyName() + "\n"
                    + components.get(0).getAddress() + "\n\n"
                    + greetingtextHead + "\n"
                    + greetingtextBody,
                    f1);
            document.add(docHeader); // add text in document
            // make a table in pdf file using PdfTable object
            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(100); // set table width
            table.setSpacingBefore(15f); // set upper spacing size
            table.setSpacingAfter(3f); // set lower spacing size

            Font f2 = FontFactory.getFont("calibri", 12); // set font style and size. 12 is  font size     
            Font f4 = FontFactory.getFont("calibri", 10); // set font style and size
            // make a float array for set each colume size
            float[] colomWidth = {0.3f, 2f, 0.6f};
            table.setWidths(colomWidth); // add total size in table

            // make row header 01
            PdfPCell cellHeader01 = new PdfPCell(new Paragraph(colHeder01, f4));
            cellHeader01.setPaddingLeft(10);
            cellHeader01.setPaddingTop(20);
            cellHeader01.setPaddingBottom(20);
            cellHeader01.setPaddingRight(10);
            cellHeader01.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellHeader01.setVerticalAlignment(Element.ALIGN_MIDDLE);

            // make row header 02
            PdfPCell cellHeader02 = new PdfPCell(new Paragraph(new Paragraph(colHeder02, f4)));
            cellHeader02.setPaddingLeft(10);
            cellHeader02.setPaddingTop(20);
            cellHeader02.setPaddingBottom(20);
            cellHeader02.setPaddingRight(10);
            cellHeader02.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellHeader02.setVerticalAlignment(Element.ALIGN_MIDDLE);

            // make row header 03
            PdfPCell cellHeader03 = new PdfPCell(new Paragraph(colHeader03, f4));
            cellHeader03.setPaddingLeft(10);
            cellHeader03.setPaddingTop(20);
            cellHeader03.setPaddingBottom(20);
            cellHeader03.setPaddingRight(10);
            cellHeader03.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellHeader03.setVerticalAlignment(Element.ALIGN_MIDDLE);

            // adding col header
            table.addCell(cellHeader01);
            table.addCell(cellHeader02);
            table.addCell(cellHeader03);

            // set padding
            float rowBttomPadding = 5;
            float rowTopPadding = 5;
            float padding = 10;
            
            try {
                // adding row in table
                for (int i = 0; i < components.size(); i++) {
                    String count = ""; // make row number list
                    count = String.valueOf(i + 1);
                    
                    // add row header
                    PdfPCell rowHead = new PdfPCell(new Paragraph(count, f4));
                    rowHead.setPaddingLeft(padding);
                    rowHead.setPaddingTop(rowTopPadding);
                    rowHead.setPaddingBottom(rowBttomPadding);
                    rowHead.setPaddingRight(padding);
                    rowHead.setHorizontalAlignment(Element.ALIGN_LEFT);
                    rowHead.setVerticalAlignment(Element.ALIGN_TOP);
                    // add row body
                    PdfPCell rowBody = new PdfPCell(new Paragraph(components.get(i).getBodyContent(), f4));
                    rowBody.setPaddingLeft(padding);
                    rowBody.setPaddingTop(rowTopPadding);
                    rowBody.setPaddingBottom(rowBttomPadding);
                    rowBody.setPaddingRight(padding);
                    rowBody.setHorizontalAlignment(Element.ALIGN_LEFT);
                    rowBody.setVerticalAlignment(Element.ALIGN_TOP);
                    // add row footer
                    PdfPCell rowFooter = new PdfPCell(new Paragraph(components.get(i).getAmount()+(
                                    components.get(i).getAmount().length()>0?".00":""
                                ), f4));
                    rowFooter.setPaddingLeft(padding);
                    rowFooter.setPaddingTop(rowTopPadding);
                    rowFooter.setPaddingBottom(rowBttomPadding);
                    rowFooter.setPaddingRight(padding);
                    rowFooter.setHorizontalAlignment(Element.ALIGN_CENTER);
                    rowFooter.setVerticalAlignment(Element.ALIGN_TOP);

                    table.addCell(rowHead);
                    table.addCell(rowBody);
                    table.addCell(rowFooter);
                    // check if amount have any charecter 
                    if (components.get(i).getAmount().matches("-?\\d+(\\.\\d+)?")) {
                        totalamount += Math.round(Float.valueOf((components.get(i).getAmount()))); // amount added
                    }
                    System.out.println("------------>" + i);
                }
            }catch(Exception e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e.getMessage(),
                    ":: Error-07 :: ", JOptionPane.INFORMATION_MESSAGE);
            }

            
            Paragraph paraOfColFooter;
            Paragraph paraOfAmount;
            if(components.get(0).getVatAmount()>0){
                paraOfColFooter=new Paragraph("VAT "+components.get(0).getVatPrcn()+"% (+)\n\n"+colFooterTxt, f4);
                int totalAmt=(totalamount+components.get(0).getVatAmount());
                paraOfAmount=new Paragraph(components.get(0).getVatAmount()+".00\n\n"+totalAmt+".00", f4);
            }else{
                paraOfColFooter=new Paragraph(colFooterTxt, f4);
                paraOfAmount=new Paragraph(String.valueOf(totalamount)+".00", f4);
            }
            
            
            // last row body text
            PdfPCell row02Body = new PdfPCell(paraOfColFooter);
            row02Body.setPaddingLeft(padding);
            row02Body.setPaddingTop(padding);
            row02Body.setPaddingBottom(padding);
            row02Body.setPaddingRight(padding);
            row02Body.setHorizontalAlignment(Element.ALIGN_RIGHT);
            row02Body.setVerticalAlignment(Element.ALIGN_TOP);
            row02Body.setColspan(2);

            // last row footer txt
            PdfPCell row02Footer = new PdfPCell(paraOfAmount);
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
            Font f3 = FontFactory.getFont("calibri", 10);
            if(components.get(0).getVatAmount()>0){
                document.add(new Paragraph(tableFooterTxtWithVat, f3));
            }else{
                document.add(new Paragraph(tableFooterTxtWithoutVat, f3));
            }
            
//            if(amountInWord.length() < 1){
//                amountInWord = (new IOFunction().getNumberInWord(totalamount, configAmountListUrl));
//            }
            
            document.add(new Paragraph("\n" + amountTage + amountInWord + " only.", f1));
            document.add(new Paragraph(noteTxt + "\n\n", f1));

            Image sirSing = Image.getInstance("img\\Sir-Sign-Blank.jpg");
            sirSing.setAlignment(sirSing.ALIGN_LEFT);
            sirSing.scaleAbsolute(100, 30);
            document.add(sirSing);

            document.add(new Paragraph(sign + "\n\n", f1));

            document.close();
            return true;

        } catch (Exception ex) {
            Logger.getLogger(WriteQutitoinBilHardCopy.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    ":: Error-08 :: ", JOptionPane.INFORMATION_MESSAGE);
        }

        return false;
    }
}
