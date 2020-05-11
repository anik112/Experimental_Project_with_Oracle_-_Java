/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.core;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VSI-ANIK
 */
public class Notifaction extends Thread {

    private int msgListSize = 0;
    private String fileLoc = "";
    private List<String> allMsgList = new ArrayList<>();

    public Notifaction(int msgSize, String fileLoc) {
        this.msgListSize = msgSize;
        this.fileLoc = fileLoc;
    }

    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                while (true) {
                    allMsgList = new CoreFunction().getMsgList(fileLoc);
                    if (allMsgList.size() > msgListSize) {
                        System.out.println("You have new massage::: ");
                        msgListSize = allMsgList.size();
                    }else{
                        System.out.println("No-");
                    }
                    Thread.sleep(10000);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Notifaction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

//        (new Thread() {
//            public void run() {
//                for (int i = 0; i < 50; i++) {
//                    try {
//                        showList.removeAll();
//                        viewDataInTable(senderFileLoc);
//                        Thread.sleep(5000);
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//            }
//        }).start();
