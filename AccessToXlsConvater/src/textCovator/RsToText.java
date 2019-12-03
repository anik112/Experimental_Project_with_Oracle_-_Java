/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textCovator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author VSI-ANIK
 */
public class RsToText {

    public void givenWritingStringToFile_whenUsingPrintWriter_thenCorrect()
            throws IOException {
        FileWriter fileWriter = new FileWriter("./test121.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print("Some String");
        printWriter.printf("Product name is %s and its price is %d $", "iPhone", 1000);
        printWriter.close();
    }

}
