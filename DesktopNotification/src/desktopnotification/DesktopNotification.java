/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopnotification;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author VSI-ANIK
 */
public class DesktopNotification extends Application {

    private int prevSize = 0;
    private int currentSize = 0;
    private String configLoc = "D:\\LANChat\\config.txt";
    private String urlHeader = "\\\\";
    private String urlMid = "\\LiveApps\\LANChat\\";
    private String fileExns = ".txt";
    private String serverIp = "192.168.1.210";
    private int counter=1;
    
    private String myip;

    @Override
    public void start(Stage primaryStage) {
        myip = new SendNotifaction().getMyIp(configLoc);

        //String fileUrl = urlHeader + serverIp + urlMid + myip + fileExns;
        String fileUrl = "D:\\LANChat\\"+myip+".txt";
        
        try {
            while (true) {
                currentSize = new SendNotifaction().getMsgSize(fileUrl,myip);
                //System.out.println("Cutrrent Size:  --> "+currentSize);
                if (currentSize > prevSize) {
                    //System.out.println("You have new massage::: ");
                    new SendNotifaction().showNotification("You have a new massage", "Please open LANChat and check the massage.");
                    prevSize=currentSize;
                    currentSize=0;
                } else {
                    System.out.println("No-");
                }
                Thread.sleep(10000);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(DesktopNotification.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
