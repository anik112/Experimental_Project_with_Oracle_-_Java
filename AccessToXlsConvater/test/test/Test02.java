/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author VSI-ANIK
 */
public class Test02 {
    //        String sql02 = "SELECT CHECKINOUT.CHECKTIME,CHECKINOUT.SENSORID,CHECKINOUT.USERID,USERINFO.Badgenumber "
//                + "FROM CHECKINOUT,USERINFO WHERE "
//                + "(CHECKINOUT.CHECKTIME) between (#3/3/2018 9:00:00 AM#) and (#3/4/2018 9:00:00 AM#)"
//                + "AND USERINFO.USERID=CHECKINOUT.USERID";
//        PreparedStatement statement2 = DBconnection.getConnection().prepareStatement(sql02);
//        ResultSet rs2 = statement2.executeQuery();
//
//        while (rs2.next()) {
//            System.out.println(rs2.getString(1));
//        }
//
//        Workbook wb;
//        Sheet sheet;
//        FileInputStream fis;
//        FileOutputStream fos;
//        Row row;
//        Cell cell = null;
//
//        ResultSetMetaData rsmd = rs2.getMetaData();
//        System.out.println(rsmd);
//        List<String> column = new ArrayList<String>();
//        
//        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
//            column.add(rsmd.getColumnLabel(i));
//            System.out.println("=====>> rsmd" + i);
//        }
//
//        
//        wb = new XSSFWorkbook();
//        sheet = wb.createSheet();
//        row = sheet.createRow(0);
//        for (int i = 0; i < column.size(); i++) {
//            row.createCell(i).setCellValue(column.get(i));
//        }
//        
//        int rowIndex = 0;
//        while (rs2.next()) {
//            Row row1 = sheet.createRow(++rowIndex);
//            for (int i = 0; i < column.size(); i++) {
//                String value = Objects.toString(column.get(i), "");
//                cell.setCellValue(value);
//            }
//        }
//
//        fos = new FileOutputStream("testData01.xlsx");
//        wb.write(fos);

//        String[] clomun = {"Name", "Mobile"};
//
//        List<Information> contact = new ArrayList<>();
//
//        contact.add(new Information("anik", "01826995639"));
//        contact.add(new Information("Tomal", "015264852"));
//        contact.add(new Information("Saiful", "01523648"));
//
//        org.apache.poi.ss.usermodel.Workbook book = new XSSFWorkbook();
//        Sheet sheet = book.createSheet();
//
//        Row headerRow = sheet.createRow(0);
//
//        for (int i = 0; i < clomun.length; i++) {
//            Cell cell = headerRow.createCell(i);
//            cell.setCellFormula(clomun[i]);
//        }
//
//        int rowCount = 1;
//
//        for (Information c : contact) {
//            Row r = sheet.createRow(rowCount++);
//            r.createCell(0).setCellValue(c.getName());
//            r.createCell(0).setCellValue(c.getMobileNumber());
//        }
//
//        
//        for (int i = 0; i < clomun.length; i++) {
//            sheet.autoSizeColumn(i);
//        }
//
//        System.out.println("============= 2");
//        try {
//            FileOutputStream fos = new FileOutputStream(new File("check.xlsx"));
//            book.write(fos);
//            System.out.println("=============== 3");
//            fos.close();
//            book.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
}
