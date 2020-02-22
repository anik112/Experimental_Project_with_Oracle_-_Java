/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatopdfgenerator;

import javafx.application.Application;
import javafx.stage.Stage;
import javatopdfgenerator.reports.MonthlyBillWriter;

/**
 *
 * @author VSI-ANIK
 */
public class Apps extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        new MonthlyBillWriter().writeMonthlyBill();
        System.out.println("Job Done....");
        System.exit(0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
