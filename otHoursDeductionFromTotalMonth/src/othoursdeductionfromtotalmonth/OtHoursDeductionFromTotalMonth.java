/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package othoursdeductionfromtotalmonth;

import dataView.MonthlyOtHoursDuctView;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author VSIANIK
 */
public class OtHoursDeductionFromTotalMonth extends Application {

    @Override
    public void start(Stage primaryStage) {
        new MonthlyOtHoursDuctView().setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
