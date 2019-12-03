/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import converter.Information;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author VSI-ANIK
 */
public class CheckXls {
    
    public static void main(String[] args) {
        
        String[] clomun={"Name","Mobile"};
        
        List<converter.Information> contact=new ArrayList<converter.Information>();
        
        contact.add(new Information("anik","01826995639"));
        contact.add(new Information("Tomal", "015264852"));
        contact.add(new Information("Saiful", "01523648"));
        
        Workbook book=new XSSFWorkbook();
        Sheet sheet=book.createSheet();
        
        Row headerRow=sheet.createRow(0);
        
        for(int i=0;i<clomun.length;i++){
            Cell cell=headerRow.createCell(i);
            cell.setCellFormula(clomun[i]);
        }
        
        int rowCount=1;
        
        for(Information c : contact){
            Row r=sheet.createRow(rowCount++);
            r.createCell(0).setCellValue(c.getName());
            r.createCell(0).setCellValue(c.getMobileNumber());
        }
        
        for(int i=0;i<clomun.length;i++){
            sheet.autoSizeColumn(i);
        }
        
        try {
            FileOutputStream fos=new FileOutputStream(new File("check.xlsx"));
            book.write(fos);
            fos.close();
            book.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
