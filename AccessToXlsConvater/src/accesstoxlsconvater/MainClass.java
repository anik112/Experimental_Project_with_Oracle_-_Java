/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesstoxlsconvater;

import converter.CoreConverter;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author VSI-ANIK
 */
public class MainClass extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        new CoreConverter().convertAccessToXls();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

//         try {
//            new converter.ExcelDatabaseConvert().exlsEntry();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

}
