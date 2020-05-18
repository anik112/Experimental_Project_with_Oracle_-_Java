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
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anik
 */
public class WriteMonthlyBill {

    private String date;
    private String billNo;
    private String companyName;
    private String address;
    private String month;
    private String year;
    private int amount;

    private final String to = "To";
    private final String greetingtextHead = "Dear Sir/Madam,";
    private final String greetingtextBody = "Thank you for using our software  A¶i . Please pay the bill as follows:";
    private final String colHeder01 = "S/L";
    private final String colHeder02 = "Description of the products/Services";
    private final String colHeader03 = "Amount (TK.)";
    private final String rowBody = "Monthly software support bill for the month of ";
    private final String colFooterTxt = "Total Amount";
    private final String tableFooterTxt = "VAT and TAX not included.";
    private final String amountTage = "Amount in word: ";
    private final String noteTxt = "N.B: All payments should be in a/c payee cheque in favour of “ Vistasoft IT Bangladesh Ltd.”";
    private final String sign = "..................................\nAuthorized Signatory";

    public static void main(String[] arg) {

        new WriteMonthlyBill().writeMonthlyBillInPdfFile();
    }

    public void writeMonthlyBillInPdfFile() {

        date = "May 05, 2020";
        billNo = "052020";
        month = "May";
        year = "2020";
        companyName = "Alif Embroidery Village Ltd.";
        address = "Bangabandhu Road, Tongabari , Ashulia, Savar, Dhaka.";
        amount = 4000;

        try {
            Document document = new Document();

            PdfWriter.getInstance(document, new FileOutputStream("D:\\test01.pdf"));
            document.setMargins(40, 40, 20, 20);
            document.open();

            Image topLogo = Image.getInstance("img\\logoWithFooterTxt.jpg");
            topLogo.setAlignment(topLogo.ALIGN_RIGHT);
            topLogo.scaleAbsolute(180, 60);
            //topLogo.setSpacingBefore(100);
            document.add(topLogo);
            
            FontFactory.register("font\\calibri.ttf", "calibri");
            Font f1 = FontFactory.getFont("calibri", 12);

            Paragraph docHeader = new Paragraph("\nDate: " + date + "\n\n"
                    + "Bill no: " + billNo + "\n\n"
                    + to + "\n"
                    + companyName + "\n"
                    + address + "\n\n"
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

            PdfPCell row01Body = new PdfPCell(new Paragraph(rowBody + " " + month + ", " + year, f2));
            row01Body.setPaddingLeft(padding);
            row01Body.setPaddingTop(rowTopPadding);
            row01Body.setPaddingBottom(rowBttomPadding);
            row01Body.setPaddingRight(padding);
            row01Body.setHorizontalAlignment(Element.ALIGN_LEFT);
            row01Body.setVerticalAlignment(Element.ALIGN_TOP);

            PdfPCell row01Footer = new PdfPCell(new Paragraph(String.valueOf(amount) + ".00", f2));
            row01Footer.setPaddingLeft(padding);
            row01Footer.setPaddingTop(rowTopPadding);
            row01Footer.setPaddingBottom(rowBttomPadding);
            row01Footer.setPaddingRight(padding);
            row01Footer.setHorizontalAlignment(Element.ALIGN_CENTER);
            row01Footer.setVerticalAlignment(Element.ALIGN_TOP);

            PdfPCell row02Body = new PdfPCell(new Paragraph(colFooterTxt, f2));
            row02Body.setPaddingLeft(padding);
            row02Body.setPaddingTop(padding);
            row02Body.setPaddingBottom(padding);
            row02Body.setPaddingRight(padding);
            row02Body.setHorizontalAlignment(Element.ALIGN_RIGHT);
            row02Body.setVerticalAlignment(Element.ALIGN_TOP);
            row02Body.setColspan(2);

            PdfPCell row02Footer = new PdfPCell(new Paragraph(String.valueOf(amount) + ".00", f2));
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
            
            
            Font f3 = FontFactory.getFont("SansSerif", 10);
            document.add(new Paragraph(tableFooterTxt, f3));

            document.add(new Paragraph("\n"+amountTage,f1));
            document.add(new Paragraph(noteTxt+"\n\n\n",f1));
            
            Image sirSing=Image.getInstance("img\\Sir-Sign.jpg");
            sirSing.setAlignment(sirSing.ALIGN_LEFT);
            sirSing.scaleAbsolute(100, 30);
            document.add(sirSing);
            
            document.add(new Paragraph(sign+"\n\n",f1));            
            
            
            
            Image footerImage=Image.getInstance("img\\footer.jpg");
            footerImage.setAlignment(footerImage.ALIGN_LEFT);
            footerImage.scaleAbsolute(document.getPageSize().getWidth()-80, 80);
            document.add(footerImage);
            
            document.close();

        } catch (Exception ex) {
            Logger.getLogger(WriteMonthlyBill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//    
//    private Image getWatermarkedImage(PdfDocument pdfDoc, Image img, String watermark) {
//        float width = img.getImageScaledWidth();
//        float height = img.getImageScaledHeight();
//        float coordX = width / 2;
//        float coordY = height / 2;
//        float angle = (float) Math.PI * 30f / 180f;
//        PdfFormXObject template = new PdfFormXObject(new Rectangle(width, height));
//        new Canvas(template, pdfDoc)
//                .add(img)
//                .setFontColor(DeviceGray.WHITE)
//                .showTextAligned(watermark, coordX, coordY, TextAlignment.CENTER, angle)
//                .close();
//        return new Image(template);
//    }

}
