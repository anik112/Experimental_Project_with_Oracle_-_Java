/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportgenerator.corefunction;

import com.itextpdf.text.BaseColor;
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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import reportgenerator.dao.ChallanReportComponent;
import reportgenerator.dao.MonthlyBillComponent;

/**
 *
 * @author Anik
 */
public class WriteChallanReport {
    
    private final String headerText = "Challan Report";
    private final int bodyTablePadding=5;
    private final int headerTablePadding = 5;
    private final float[] colomWidthForHeaderTable = {1f, 3.8f, .2f, 1f, 2f};
    private final float[] colomWidthForBodyTable = {0.5f, 4f, 1.5f, 2f};  
    private final Font headerTextFont = FontFactory.getFont("calibri", 20, Font.BOLD);
    private final Font titleTextFont = FontFactory.getFont("calibri", 10, Font.BOLD);
    private final Font bodyTextFont = FontFactory.getFont("calibri", 10);

    public WriteChallanReport() {
        FontFactory.register("font\\calibri.ttf", "calibri");
    }
    
    public boolean writeChallanReportInPdfFile(List<ChallanReportComponent> components, File selectedFile) {
        
        try {
            Document document = new Document();
            
            PdfWriter.getInstance(document, new FileOutputStream(selectedFile));
            document.setMargins(40, 40, 20, 20);
            document.open();

            // set logo in top
            Image topLogo = Image.getInstance("img\\logoWithFooterTxt.jpg"); // make image object
            topLogo.setAlignment(topLogo.ALIGN_RIGHT); // set image alignment
            topLogo.scaleAbsolute(180, 60);  // set image absolute size
            //topLogo.setSpacingBefore(100);
            document.add(topLogo); // add this logo in document

            // Header text
            PdfPTable headerTable = new PdfPTable(1);
            
            PdfPCell cell = new PdfPCell(new Paragraph(headerText, headerTextFont));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setBorderColor(BaseColor.WHITE);
            headerTable.addCell(cell);
            document.add(headerTable);
            document.add(new Paragraph("\n"));

            // Make info table
            PdfPTable infoTable = new PdfPTable(5);
            infoTable.setWidthPercentage(100);
            
            infoTable.setWidths(colomWidthForHeaderTable);
            
            infoTable.addCell(cellProperties("Company Name", titleTextFont, Element.ALIGN_CENTER, headerTablePadding, true));
            infoTable.addCell(cellProperties(components.get(0).getCompanyName(), titleTextFont, Element.ALIGN_CENTER, headerTablePadding, true));
            infoTable.addCell(cellProperties("", titleTextFont, Element.ALIGN_CENTER, headerTablePadding, false));
            infoTable.addCell(cellProperties("Challan No", titleTextFont, Element.ALIGN_CENTER, headerTablePadding, true));
            infoTable.addCell(cellProperties(components.get(0).getChallanNo(), bodyTextFont, Element.ALIGN_CENTER, headerTablePadding, true));
            infoTable.addCell(cellProperties("Address", titleTextFont, Element.ALIGN_CENTER, headerTablePadding, true));
            infoTable.addCell(cellProperties(components.get(0).getAddress(), bodyTextFont, Element.ALIGN_CENTER, headerTablePadding, true));
            infoTable.addCell(cellProperties("", titleTextFont, Element.ALIGN_CENTER, headerTablePadding, false));
            infoTable.addCell(cellProperties("Work Order Date", titleTextFont, Element.ALIGN_CENTER, headerTablePadding, true));
            infoTable.addCell(cellProperties(components.get(0).getWorkOrderDate(), bodyTextFont, Element.ALIGN_CENTER, headerTablePadding, true));
            infoTable.addCell(cellProperties("Delivery Person", titleTextFont, Element.ALIGN_CENTER, headerTablePadding, true));
            infoTable.addCell(cellProperties(components.get(0).getDeliveryPerson(), bodyTextFont, Element.ALIGN_CENTER, headerTablePadding, true));
            infoTable.addCell(cellProperties("", titleTextFont, Element.ALIGN_CENTER, headerTablePadding, false));
            infoTable.addCell(cellProperties("Attention", titleTextFont, Element.ALIGN_CENTER, headerTablePadding, true));
            infoTable.addCell(cellProperties(components.get(0).getAttention(), bodyTextFont, Element.ALIGN_CENTER, headerTablePadding, true));
            infoTable.addCell(cellProperties("Delivery Date", titleTextFont, Element.ALIGN_CENTER, headerTablePadding, true));
            infoTable.addCell(cellProperties(components.get(0).getDeliveryDate(), bodyTextFont, Element.ALIGN_CENTER, headerTablePadding, true));
            
            document.add(infoTable);
            
            document.add(new Paragraph("\n"));
            
            PdfPTable bodyTable = new PdfPTable(4);
            bodyTable.setWidthPercentage(100);
            
            
            bodyTable.setWidths(colomWidthForBodyTable);
            
            bodyTable.addCell(cellProperties("S/L", titleTextFont, Element.ALIGN_CENTER, bodyTablePadding, true));
            bodyTable.addCell(cellProperties("Product Name", titleTextFont, Element.ALIGN_CENTER, bodyTablePadding, true));
            bodyTable.addCell(cellProperties("Quantity", titleTextFont, Element.ALIGN_CENTER, bodyTablePadding, true));
            bodyTable.addCell(cellProperties("Remarks", titleTextFont, Element.ALIGN_CENTER, bodyTablePadding, true));
            
            int sl=1;
            for (ChallanReportComponent crc: components) {
                bodyTable.addCell(cellProperties(String.valueOf(sl), bodyTextFont, Element.ALIGN_CENTER, bodyTablePadding, true));
                bodyTable.addCell(cellProperties(crc.getProductName(), bodyTextFont, Element.ALIGN_CENTER, bodyTablePadding, true));
                bodyTable.addCell(cellProperties(String.valueOf(crc.getQuantity()), bodyTextFont, Element.ALIGN_CENTER, bodyTablePadding, true));
                bodyTable.addCell(cellProperties(crc.getRemarks(), bodyTextFont, Element.ALIGN_CENTER, bodyTablePadding, true));
                sl++;
            }
            
            document.add(bodyTable);
            
            document.add(new Paragraph("\n"));
            Image footerImage = Image.getInstance("img\\footer.jpg");
            footerImage.setAlignment(footerImage.ALIGN_LEFT);
            footerImage.scaleAbsolute(document.getPageSize().getWidth() - 80, 90);
            document.add(footerImage);
            
            document.close();
            return true;
            
        } catch (Exception ex) {
            Logger.getLogger(WriteChallanReport.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    ":: Error-05 :: ", JOptionPane.INFORMATION_MESSAGE);
        }
        
        return false;
    }
    
    private PdfPCell cellProperties(String text, Font f, int horiAlignment, int padding, boolean showBorder) {
        PdfPCell cell = new PdfPCell(new Paragraph(text, f));
        cell.setHorizontalAlignment(horiAlignment);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setPaddingLeft(padding / 2);
        cell.setPaddingTop(padding);
        cell.setPaddingBottom(padding);
        cell.setPaddingRight(padding / 2);
        
        if (showBorder) {
            cell.setBorderWidth(0.5f);
            cell.setBorderColor(BaseColor.BLACK);
        } else {
            cell.setBorder(0);
        }
        
        return cell;
    }
}
