/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filefinder;

import com.filefinder.view.MainScreen;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author VSI-ANIK
 */
public class FileFinder extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        new MainScreen().setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
