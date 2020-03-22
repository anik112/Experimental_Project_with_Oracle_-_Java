/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testproject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 *
 * @author VSI-ANIK
 */
public class WriteOnTxt {
    
    public static void main(String[] args) throws IOException {

//        // call file.
//        File file = new File("D:\\AccessToTextConvert\\test-chk.txt");
//        FileWriter fileWriter=new FileWriter(file);
//        PrintWriter printWriter = new PrintWriter(fileWriter); // call printWriter for write text in file
//        
//        printWriter.write("Hello i am test-- ");
//        printWriter.close();
        try (OutputStream out = new FileOutputStream("F:\\Pranto Project File\\TestProject\\src\\resource\\newproperties.properties")) {
            
            Properties p = new Properties();
            
            p.setProperty("url", "c:\\Anik-abc");
            p.setProperty("name", "Anik-paul");
            p.store(out, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try (InputStream input =new FileInputStream("F:\\Pranto Project File\\TestProject\\src\\resource\\newproperties.properties")) {
            
            Properties p=new Properties();
            
            p.load(input);
            
            System.out.println(p.getProperty("url"));
            System.out.println(p.getProperty("name"));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
