/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takescreenshort;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.application.Application;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 *
 * @author VSI-ANIK
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws AWTException, IOException, InterruptedException {
        
        // While loop for run this program untill stop the service.
        while (true) {
            // get current date from system.
            Date date = new Date(System.currentTimeMillis());
            System.out.println(date);
            // date formater for format date in given string
            SimpleDateFormat format = new SimpleDateFormat("MMddyyyyhhmmss");
            String formatedDate = format.format(date); // format date
            System.out.println(formatedDate);
            // set a dynamic file name and file path.
            String fileNamePath = "C:\\Users\\Public\\icon\\" + formatedDate + ".png";
            // make file object for create this image file.
            File file = new File(fileNamePath);
            /**
             * get screen size using rectangle object. 
             * This object create a rectangle using (X and Y) value.
             * 
             * Toolkit.getDefaultToolkit().getScreenSize() this method
             * helps us to get full screen size in X and Y value.
             */
            Rectangle rectangle = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            /**
             * BufferedImage this class helps us to make a image from pixel.
             * 
             * Robot().createScreenCapture() this method helps to take current screen
             * pixel from system. This method take pixel and send it in BufferedImage
             * object which store all pixel.
             * 
             * Robot class helps us to generate even in system. Robot Example:
             * new Robot().delay(5000); // wait a system event.
             * new Robot().mouseMove(0, 0); // move cursor automatically. 
             */
            BufferedImage bufferedImage = new Robot().createScreenCapture(rectangle);
            /**
             * ImageIO.write() this method make a file from pixel.
             * this method take pixel, format and file location then put
             * pixel in the file using given format.
             */
            ImageIO.write(bufferedImage, "png", file);
            
            /**
             * Thread.sleep() this method helps to hold this program.
             * in this case hold this program 3min. after 3min this
             * work as begin.
             */
            Thread.sleep(180000);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
