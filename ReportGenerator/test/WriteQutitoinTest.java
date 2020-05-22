/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import reportgenerator.corefunction.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import reportgenerator.dao.ReqQutComponent;

/**
 *
 * @author Anik
 */
public class WriteQutitoinTest {

    private String configAmountListUrl = "setup\\NumberInWord.txt";

    private final String to = "To";
    private final String greetingtextHead = "Dear Sir/Madam,";
    private final String greetingtextBody = "Thank you for using our software. Please pay the bill as follows:";
    private final String colHeder01 = "S/L";
    private final String colHeder02 = "Description of the products/Services";
    private final String colHeader03 = "Amount (TK.)";
    private final String colFooterTxt = "Total Amount";
    private final String tableFooterTxt = "VAT and TAX not included.";
    private final String amountTage = "Amount in word: ";
    private final String noteTxt = "N.B: All payments should be in a/c payee cheque in favour of “ Vistasoft IT Bangladesh Ltd.”";
    private final String sign = "..................................\nAuthorized Signatory";
    private int totalamount = 0;

    public static void main(String[] arg) {
        List<ReqQutComponent> components=new ArrayList<>();
        File f=new File("D:\\check-req.pdf");
        new WriteQutitoinTest().writeReqQtInPdfFile(components);
    }

    public boolean writeReqQtInPdfFile(List<ReqQutComponent> components) {

        try {
            Document document = new Document();

            PdfWriter pw = PdfWriter.getInstance(document, new FileOutputStream("D:\\check-req.pdf"));

            Rectangle rectangle = new Rectangle(30, 30, 550, 800);
            pw.setBoxSize("rectangle", rectangle);
//            
//            ColumnText.showTextAligned(pw.getDirectContent(), 
//                    Element.ALIGN_RIGHT,
//                    new Phrase("Txt------------- "),
//                    rectangle.getRight(),
//                    rectangle.getTop(),
//                    0);
//            
            
            document.setMargins(40, 40, 20, 20);
            document.open();
            
            Image footerImage = Image.getInstance("img\\footer.jpg");
            footerImage.setAlignment(footerImage.ALIGN_LEFT);
            footerImage.setBottom(1f);
            footerImage.scaleAbsolute(document.getPageSize().getWidth() - 80, 90);
            footerImage.setAbsolutePosition(rectangle.ALIGN_RIGHT, rectangle.ALIGN_TOP);
            document.add(footerImage);
//
//            Image topLogo = Image.getInstance("img\\logoWithFooterTxt.jpg");
//            topLogo.setAlignment(topLogo.ALIGN_RIGHT);
//            topLogo.scaleAbsolute(180, 60);
//            //topLogo.setSpacingBefore(100);
//            document.add(topLogo);
//            FontFactory.register("font\\calibri.ttf", "calibri");
//            Font f1 = FontFactory.getFont("calibri", 12);
//
//            Paragraph docHeader = new Paragraph("\nDate: " + components.get(0).getDate() + "\n\n"
//                    + to + "\n"
//                    + components.get(0).getCompanyName() + "\n"
//                    + components.get(0).getAddress() + "\n\n"
//                    + greetingtextHead + "\n"
//                    + greetingtextBody,
//                    f1);
//            document.add(docHeader);
//
//            PdfPTable table = new PdfPTable(3);
//            table.setWidthPercentage(100);
//            table.setSpacingBefore(15f);
//            table.setSpacingAfter(3f);
//
//            Font f2 = FontFactory.getFont("calibri", 12);
//
//            float[] colomWidth = {0.3f, 2f, 0.6f};
//            table.setWidths(colomWidth);
//
//            // make row header 01
//            PdfPCell cellHeader01 = new PdfPCell(new Paragraph(colHeder01, f2));
//            cellHeader01.setPaddingLeft(10);
//            cellHeader01.setPaddingTop(20);
//            cellHeader01.setPaddingBottom(20);
//            cellHeader01.setPaddingRight(10);
//            cellHeader01.setHorizontalAlignment(Element.ALIGN_CENTER);
//            cellHeader01.setVerticalAlignment(Element.ALIGN_MIDDLE);
//
//            // make row header 02
//            PdfPCell cellHeader02 = new PdfPCell(new Paragraph(new Paragraph(colHeder02, f2)));
//            cellHeader02.setPaddingLeft(10);
//            cellHeader02.setPaddingTop(20);
//            cellHeader02.setPaddingBottom(20);
//            cellHeader02.setPaddingRight(10);
//            cellHeader02.setHorizontalAlignment(Element.ALIGN_CENTER);
//            cellHeader02.setVerticalAlignment(Element.ALIGN_MIDDLE);
//
//            // make row header 03
//            PdfPCell cellHeader03 = new PdfPCell(new Paragraph(colHeader03, f2));
//            cellHeader03.setPaddingLeft(10);
//            cellHeader03.setPaddingTop(20);
//            cellHeader03.setPaddingBottom(20);
//            cellHeader03.setPaddingRight(10);
//            cellHeader03.setHorizontalAlignment(Element.ALIGN_CENTER);
//            cellHeader03.setVerticalAlignment(Element.ALIGN_MIDDLE);
//
//            // adding col header
//            table.addCell(cellHeader01);
//            table.addCell(cellHeader02);
//            table.addCell(cellHeader03);
//
//            // set padding
//            float rowBttomPadding = 10;
//            float rowTopPadding = 10;
//            float padding = 10;
//
//            // adding row in table
//            for (int i = 0; i < components.size(); i++) {
//
//                PdfPCell rowHead = new PdfPCell(new Paragraph(String.valueOf(i), f2));
//                rowHead.setPaddingLeft(padding);
//                rowHead.setPaddingTop(rowTopPadding);
//                rowHead.setPaddingBottom(rowBttomPadding);
//                rowHead.setPaddingRight(padding);
//                rowHead.setHorizontalAlignment(Element.ALIGN_LEFT);
//                rowHead.setVerticalAlignment(Element.ALIGN_TOP);
//
//                PdfPCell rowBody = new PdfPCell(new Paragraph(components.get(i).getBodyContent(), f2));
//                rowBody.setPaddingLeft(padding);
//                rowBody.setPaddingTop(rowTopPadding);
//                rowBody.setPaddingBottom(rowBttomPadding);
//                rowBody.setPaddingRight(padding);
//                rowBody.setHorizontalAlignment(Element.ALIGN_LEFT);
//                rowBody.setVerticalAlignment(Element.ALIGN_TOP);
//
//                PdfPCell rowFooter = new PdfPCell(new Paragraph(components.get(i).getAmount(), f2));
//                rowFooter.setPaddingLeft(padding);
//                rowFooter.setPaddingTop(rowTopPadding);
//                rowFooter.setPaddingBottom(rowBttomPadding);
//                rowFooter.setPaddingRight(padding);
//                rowFooter.setHorizontalAlignment(Element.ALIGN_CENTER);
//                rowFooter.setVerticalAlignment(Element.ALIGN_TOP);
//
//                table.addCell(rowHead);
//                table.addCell(rowBody);
//                table.addCell(rowFooter);
//
//                if (components.get(i).getAmount().matches("-?\\d+(\\.\\d+)?")) {
//                    totalamount += Integer.parseInt(components.get(i).getAmount());
//                }
//
//            }
//
//            PdfPCell row02Body = new PdfPCell(new Paragraph(colFooterTxt, f2));
//            row02Body.setPaddingLeft(padding);
//            row02Body.setPaddingTop(padding);
//            row02Body.setPaddingBottom(padding);
//            row02Body.setPaddingRight(padding);
//            row02Body.setHorizontalAlignment(Element.ALIGN_RIGHT);
//            row02Body.setVerticalAlignment(Element.ALIGN_TOP);
//            row02Body.setColspan(2);
//
//            PdfPCell row02Footer = new PdfPCell(new Paragraph(String.valueOf(totalamount) + ".00", f2));
//            row02Footer.setPaddingLeft(padding);
//            row02Footer.setPaddingTop(padding);
//            row02Footer.setPaddingBottom(padding);
//            row02Footer.setPaddingRight(padding);
//            row02Footer.setHorizontalAlignment(Element.ALIGN_CENTER);
//            row02Footer.setVerticalAlignment(Element.ALIGN_TOP);
//
//            table.addCell(row02Body);
//            table.addCell(row02Footer);
//
//            document.add(table);
//
//            Font f3 = FontFactory.getFont("SansSerif", 10);
//            document.add(new Paragraph(tableFooterTxt, f3));
//
//            document.add(new Paragraph("\n" + amountTage + (new IOFunction().getNumberInWord(totalamount, configAmountListUrl)) + " only.", f1));
//            document.add(new Paragraph(noteTxt + "\n\n\n", f1));
//
//            Image sirSing = Image.getInstance("img\\Sir-Sign.jpg");
//            sirSing.setAlignment(sirSing.ALIGN_LEFT);
//            sirSing.scaleAbsolute(100, 30);
//            document.add(sirSing);
//
//            document.add(new Paragraph(sign + "\n\n", f1));
//
//            Image footerImage = Image.getInstance("img\\footer.jpg");
//            footerImage.setAlignment(footerImage.ALIGN_LEFT);
//            footerImage.setBottom(1f);
//            footerImage.scaleAbsolute(document.getPageSize().getWidth() - 80, 90);
//            document.add(footerImage);
            document.close();
            return true;

        } catch (Exception ex) {
            Logger.getLogger(WriteQutitoinTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
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
