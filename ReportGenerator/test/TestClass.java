
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Anik
 */
public class TestClass {

    private static String configComapnyListUrl = "setup\\CompanyName.txt";

    public static void main(String[] args) {
        System.out.println(configComapnyListUrl);
        try {
//            File selectedFile = new File("D:\\0-VisioApls.pdf");
//            if (!selectedFile.exists()) {
//                PrintWriter pw;
//
//                pw = new PrintWriter(selectedFile);
//
//                System.out.println("--------------->> file create");
//                pw.close();
//            }

//              string check
//            String s = "19032a";
//            if (s.matches("-?\\d+(\\.\\d+)?")) {
//                System.out.println("Is number");
//            }else{
//                System.out.println("Is not number");
//            }
            // date check
            System.out.println(Math.round(Float.valueOf("10.00")));
            
            // check dynamic variable
//            int n1=1,n2=3,n3=4;
//            for(int i=1;i<4;i++){
//                System.out.println(n<i>);
//            }

        } catch (Exception ex) {
            Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
