/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testapplication002;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author VSI-ANIK
 */
public class TestApplication002 extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FileWriter fileWriter = new FileWriter("./test121.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print("Some String\n");
        printWriter.printf("Product name is %s and its price is %d $\n", "iPhone", 1000);
        printWriter.printf("Product name is %s and its price is %d $", "iPhone", 200);
        printWriter.close();
        System.exit(0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
