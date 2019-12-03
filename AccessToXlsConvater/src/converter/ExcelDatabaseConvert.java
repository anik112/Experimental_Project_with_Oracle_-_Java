/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import java.io.File;
import java.io.FileOutputStream;

/**
 *
 * @author VSI-ANIK
 */
public class ExcelDatabaseConvert {

    public void exlsEntry() throws Exception {

//         Class.forName("com.mysql.jdbc.Driver");
//      Connection connect = DriverManager.getConnection( 
//         "jdbc:mysql://localhost:3306/test" , 
//         "root" , 
//         "root"
//      );
//      
//      Statement statement = connect.createStatement();
//      ResultSet resultSet = statement.executeQuery("select * from emp_tbl");

        org.apache.poi.xssf.usermodel.XSSFWorkbook workbook = new org.apache.poi.xssf.usermodel.XSSFWorkbook();
        org.apache.poi.xssf.usermodel.XSSFSheet spreadsheet = workbook.createSheet("employe db");

        org.apache.poi.xssf.usermodel.XSSFRow row = spreadsheet.createRow(1);
        org.apache.poi.xssf.usermodel.XSSFCell cell;
        cell = row.createCell(1);
        cell.setCellValue("EMP ID");
        cell = row.createCell(2);
        cell.setCellValue("EMP NAME");
        cell = row.createCell(3);
        cell.setCellValue("DEG");
        cell = row.createCell(4);
        cell.setCellValue("SALARY");
        cell = row.createCell(5);
        cell.setCellValue("DEPT");
        int i = 2;

        row = spreadsheet.createRow(i);
        cell = row.createCell(1);
        cell.setCellValue("102");
        cell = row.createCell(2);
        cell.setCellValue("anik paul");
        cell = row.createCell(3);
        cell.setCellValue("5");
        cell = row.createCell(4);
        cell.setCellValue("1020");
        cell = row.createCell(5);
        cell.setCellValue("ASD");

//      while(resultSet.next()) {
//         row = spreadsheet.createRow(i);
//         cell = row.createCell(1);
//         cell.setCellValue(resultSet.getInt("eid"));
//         cell = row.createCell(2);
//         cell.setCellValue(resultSet.getString("ename"));
//         cell = row.createCell(3);
//         cell.setCellValue(resultSet.getString("deg"));
//         cell = row.createCell(4);
//         cell.setCellValue(resultSet.getString("salary"));
//         cell = row.createCell(5);
//         cell.setCellValue(resultSet.getString("dept"));
//         i++;
//      }
        java.io.FileOutputStream out = new FileOutputStream(new File("exceldatabase.xlsx"));
        workbook.write(out);
        out.close();
        System.out.println("exceldatabase.xlsx written successfully");
    }
}
