/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopnotification;

import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author VSI-ANIK
 */
public class SendNotifaction {

    public void showNotification(String msgTitle, String msgBody) {
        try {
            SystemTray tray = SystemTray.getSystemTray();
            Image i = Toolkit.getDefaultToolkit().createImage("");
            TrayIcon icon = new TrayIcon(i);
            icon.setImageAutoSize(true);
            tray.add(icon);
            icon.displayMessage(msgTitle, msgBody, TrayIcon.MessageType.INFO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getMyIp(String loc) {
        String myIp = "";
        try {
            File f = new File(loc);
            Scanner s = new Scanner(f);

            while (s.hasNext()) {
                myIp = s.nextLine();
            }
            return myIp;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return myIp;
    }

    public int getMsgSize(String fileLocation) {
        List<String> allMsgList = new ArrayList<>();
        int size=0;
        try {
            int i = 0;
            File fileName = new File(fileLocation);
            Scanner scanner = new Scanner(fileName);
            while (scanner.hasNext()) {
                allMsgList.add(scanner.nextLine());
                //System.out.println(scanner.nextLine());
            }
            size=allMsgList.size();
            return size;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return size;
    }
}
