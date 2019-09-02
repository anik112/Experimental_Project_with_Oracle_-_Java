/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package experimentfile;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author VSIANIK
 */
public class MainClass extends Application{
    
    public static void main(String[] args) throws Throwable {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
       new deleteDataView.DeleteAttendenceOfLeaveEmp().setVisible(true);
    }
    
    
    
}
