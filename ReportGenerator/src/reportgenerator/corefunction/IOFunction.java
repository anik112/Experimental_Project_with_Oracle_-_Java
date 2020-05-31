/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportgenerator.corefunction;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Anik
 */
public class IOFunction {

    /**
     * this function use for get number converted word list
     *
     * @param number
     * @return word format of number
     */
    public String getNumberInWord(int number, String url) {
        String numberInWord = "";
        try {
            // open setup file
            File f = new File(url);
            Scanner scanner = new Scanner(f); // scanner class for read file
            // loop working until last line of file
            while (scanner.hasNext()) {
                String line = scanner.nextLine(); // take text from file line wise
                String[] parts = line.split("-"); // split text
                // check given number is present in file
                if (Integer.parseInt(parts[0]) == number) {
                    numberInWord = parts[1]; // get number word from
                    System.out.println("> " + parts[1]);
                    break; // stop loop
                }
            }
            return numberInWord;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    ":: Error-09 :: ", JOptionPane.INFORMATION_MESSAGE);
        }
        return numberInWord;
    }

    /**
     * This function user for take company name and address.
     *
     * @return company and address list.
     */
    public List<String> getCompanyNameAndAddress(String url) {

        List<String> comNameNdAddList = new ArrayList<>(); // make a list

        try {
            // open setup file
            File f = new File(url);
            Scanner scanner = new Scanner(f); // scanner class for read file

            // loop working until last line of file
            while (scanner.hasNext()) {
                String line = scanner.nextLine(); // take text from file line wise
                comNameNdAddList.add(line);
            }
            return comNameNdAddList;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    ":: Error-08 :: ", JOptionPane.INFORMATION_MESSAGE);
        }
        return comNameNdAddList;
    }

    /**
     * This take all pending bill number.
     *
     * @return company and address list.
     */
    public List<String> getBillPendingList(String url) {

        List<String> pendingBillList = new ArrayList<>(); // make a list

        try {
            // open setup file
            File f = new File(url);
            Scanner scanner = new Scanner(f); // scanner class for read file

            // loop working until last line of file
            while (scanner.hasNext()) {
                String line = scanner.nextLine(); // take text from file line wise
                pendingBillList.add(line);
            }
            return pendingBillList;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    ":: Error-09 :: ", JOptionPane.INFORMATION_MESSAGE);
        }
        return pendingBillList;
    }

    public void writeBillNumber(String billNo,String companyName, String url) {
        FileWriter fWriter = null;
        try {
            File getFile = new File(url);
            fWriter = new FileWriter(getFile, true);
            fWriter.write(billNo +"/"+companyName+ "\n");
            fWriter.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    ":: Error-10 :: ", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
