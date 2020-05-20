
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
            File selectedFile = new File("D:\\0-VisioApls.pdf");
            if (!selectedFile.exists()) {
                PrintWriter pw;

                pw = new PrintWriter(selectedFile);

                System.out.println("--------------->> file create");
                pw.close();
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
