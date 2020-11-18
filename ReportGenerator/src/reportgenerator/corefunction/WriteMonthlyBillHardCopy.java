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
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import reportgenerator.dao.MonthlyBillComponent;

/**
 *
 * @author Anik
 */
public class WriteMonthlyBillHardCopy {

    private String configAmountListUrl = "setup\\NumberInWord.txt";

    private final String to = "To";
    private final String greetingtextHead = "Dear Sir,";
    private final String greetingtextBody = "Thank you for using our software. Please pay the bill as follows:";
    private final String colHeder01 = "S/L";
    private final String colHeder02 = "Description";
    private final String colHeader03 = "Amount (TK.)";
    private final String rowBody = "Monthly software requirement modification & support bill for the month of ";
    private final String colFooterTxt = "Total Amount";
    private final String tableFooterTxtWithoutVat = "VAT and TAX not included.";
    private final String tableFooterTxtWithVat = "VAT and TAX included.";
    private final String amountTage = "Amount in word: ";
    private final String noteTxt = "N.B: All payments should be in A/C payee cheque in favour of “ Vistasoft IT Bangladesh Ltd.”";
    private final String sign = "..................................\nAuthorized Signatory";
    private String amountInWord="";

    public String getAmountInWord() {
        return amountInWord;
    }

    public void setAmountInWord(String amountInWord) {
        this.amountInWord = amountInWord;
    }
    

    public boolean writeMonthlyBillInPdfFile(MonthlyBillComponent component, File selectedFile) {

        try {
            Document document = new Document();

            PdfWriter.getInstance(document, new FileOutputStream(selectedFile));
            document.setMargins(40, 40, 90, 20);
            document.open();

            FontFactory.register("font\\calibri.ttf", "calibri");
            Font f1 = FontFactory.getFont("calibri", 12);

            Paragraph docHeader = new Paragraph("\nDate: " + component.getDate() + "\n\n"
                    + "Bill No: " + component.getBillNo() + "\n\n"
                    + to + "\n"
                    + component.getCompanyName() + "\n"
                    + component.getAddress() + "\n\n"
                    + greetingtextHead + "\n"
                    + greetingtextBody,
                    f1);
            document.add(docHeader);

            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(100);
            table.setSpacingBefore(15f);
            table.setSpacingAfter(3f);

            Font f2 = FontFactory.getFont("calibri", 12);

            float[] colomWidth = {0.3f, 2f, 0.6f};
            table.setWidths(colomWidth);

            PdfPCell cellHeader01 = new PdfPCell(new Paragraph(colHeder01, f2));
            cellHeader01.setPaddingLeft(10);
            cellHeader01.setPaddingTop(20);
            cellHeader01.setPaddingBottom(20);
            cellHeader01.setPaddingRight(10);
            cellHeader01.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellHeader01.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell cellHeader02 = new PdfPCell(new Paragraph(new Paragraph(colHeder02, f2)));
            cellHeader02.setPaddingLeft(10);
            cellHeader02.setPaddingTop(20);
            cellHeader02.setPaddingBottom(20);
            cellHeader02.setPaddingRight(10);
            cellHeader02.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellHeader02.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell cellHeader03 = new PdfPCell(new Paragraph(colHeader03, f2));
            cellHeader03.setPaddingLeft(10);
            cellHeader03.setPaddingTop(20);
            cellHeader03.setPaddingBottom(20);
            cellHeader03.setPaddingRight(10);
            cellHeader03.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellHeader03.setVerticalAlignment(Element.ALIGN_MIDDLE);

            float rowBttomPadding = 120;
            float rowTopPadding = 20;
            float padding = 10;

            PdfPCell row01Head = new PdfPCell(new Paragraph("01", f2));
            row01Head.setPaddingLeft(padding);
            row01Head.setPaddingTop(rowTopPadding);
            row01Head.setPaddingBottom(rowBttomPadding);
            row01Head.setPaddingRight(padding);
            row01Head.setHorizontalAlignment(Element.ALIGN_LEFT);
            row01Head.setVerticalAlignment(Element.ALIGN_TOP);

            PdfPCell row01Body = new PdfPCell(new Paragraph(rowBody + " " + component.getMonth() + ", " + component.getYear(), f2));
            row01Body.setPaddingLeft(padding);
            row01Body.setPaddingTop(rowTopPadding);
            row01Body.setPaddingBottom(rowBttomPadding);
            row01Body.setPaddingRight(padding);
            row01Body.setHorizontalAlignment(Element.ALIGN_LEFT);
            row01Body.setVerticalAlignment(Element.ALIGN_TOP);

            PdfPCell row01Footer = new PdfPCell(new Paragraph(String.valueOf(component.getAmount()) + ".00", f2));
            row01Footer.setPaddingLeft(padding);
            row01Footer.setPaddingTop(rowTopPadding);
            row01Footer.setPaddingBottom(rowBttomPadding);
            row01Footer.setPaddingRight(padding);
            row01Footer.setHorizontalAlignment(Element.ALIGN_CENTER);
            row01Footer.setVerticalAlignment(Element.ALIGN_TOP);

            
            Paragraph paraOfColFooter=new Paragraph();
            Paragraph paraOfAmount=new Paragraph();
            if(component.getVatAmount()>0){
                paraOfColFooter.add("VAT "+component.getVatPrcn()+"% (+)\n\n"+colFooterTxt);
                paraOfColFooter.setFont(f2);
                int totalAmt=(component.getAmount()+component.getVatAmount());
                paraOfAmount.add(component.getVatAmount()+".00\n\n"+totalAmt+".00");
                paraOfAmount.setFont(f2);
            }else{
                paraOfColFooter.add(colFooterTxt);
                paraOfColFooter.setFont(f2);
                paraOfAmount.add(String.valueOf(component.getAmount())+".00");
                paraOfAmount.setFont(f2);
            }
            
            PdfPCell row02Body = new PdfPCell(paraOfColFooter);
            row02Body.setPaddingLeft(padding);
            row02Body.setPaddingTop(padding);
            row02Body.setPaddingBottom(padding);
            row02Body.setPaddingRight(padding);
            row02Body.setHorizontalAlignment(Element.ALIGN_RIGHT);
            row02Body.setVerticalAlignment(Element.ALIGN_TOP);
            row02Body.setColspan(2);

            PdfPCell row02Footer = new PdfPCell(paraOfAmount);
            row02Footer.setPaddingLeft(padding);
            row02Footer.setPaddingTop(padding);
            row02Footer.setPaddingBottom(padding);
            row02Footer.setPaddingRight(padding);
            row02Footer.setHorizontalAlignment(Element.ALIGN_CENTER);
            row02Footer.setVerticalAlignment(Element.ALIGN_TOP);

            table.addCell(cellHeader01);
            table.addCell(cellHeader02);
            table.addCell(cellHeader03);
            table.addCell(row01Head);
            table.addCell(row01Body);
            table.addCell(row01Footer);
            table.addCell(row02Body);
            table.addCell(row02Footer);

            document.add(table);

            Font f3 = FontFactory.getFont("calibri", 10);
            if(component.getVatAmount()>0){
                document.add(new Paragraph(tableFooterTxtWithVat, f3));
            }else{
                document.add(new Paragraph(tableFooterTxtWithoutVat, f3));
            }

            if(amountInWord.length() < 1){
                amountInWord=(new IOFunction().getNumberInWord(component.getAmount(), configAmountListUrl));
            }
            
            document.add(new Paragraph("\n" + amountTage + amountInWord + " only.", f1));
            document.add(new Paragraph(noteTxt + "\n\n\n", f1));

            Image sirSing = Image.getInstance("img\\Sir-Sign-Blank.jpg");
            sirSing.setAlignment(sirSing.ALIGN_LEFT);
            sirSing.scaleAbsolute(100, 30);
            document.add(sirSing);
            
            document.add(new Paragraph(sign + "\n\n", f2));
            document.close();
            return true;

        } catch (Exception ex) {
            Logger.getLogger(WriteMonthlyBillHardCopy.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    ":: Error-05 :: ", JOptionPane.INFORMATION_MESSAGE);
        }

        return false;
    }

}
