/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesstotextconvert;

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
public class AccessToTextConvert extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        new ConverterView().setVisible(true);
        
        //new DataDelete().deleteAttendenceDataInAccessDb("10/10/2019");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
