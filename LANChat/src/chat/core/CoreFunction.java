/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.core;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Anik
 */
public class CoreFunction {

    private List<String> allMsgList;
    private List<DaoCoreFunction> frndList;

    public List<String> getMsgList(String fileLocation) {
        allMsgList = new ArrayList<>();

        try {
            int i = 0;
            File fileName = new File(fileLocation);
            Scanner scanner = new Scanner(fileName);
            while (scanner.hasNext()) {
                String check = scanner.nextLine();
                allMsgList.add(check);
                //System.out.println(check);
            }
            return allMsgList;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return allMsgList;
    }

    public void writeMsg(String fileLocationSender, String fileLocationReciver, String tempMsg, String senderIp, String date) {

        try {
            
            String msg=tempMsg.replace('\n', '\b');
            System.out.println(msg);
            
            File getFileReciver = new File(fileLocationReciver);
            FileWriter fwReciver = new FileWriter(getFileReciver, true);
            File getFileSender = new File(fileLocationSender);
            FileWriter fwSender = new FileWriter(getFileSender, true);

            fwReciver.write("-2 " + date + "\n");
            fwReciver.write(senderIp + "\n");
            fwReciver.write(msg+"\n");
            fwReciver.close();

            fwSender.write("-1 " + date + "\n");
            fwSender.write(senderIp + "\n");
            fwSender.write(msg+"\n");
            fwSender.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<DaoCoreFunction> frndsList(String location) {
        frndList = new ArrayList<>();

        try {
            File f = new File(location);
            Scanner s = new Scanner(f);

            while (s.hasNext()) {
                String line = s.nextLine();
                if (line.equals("-")) {
                    continue;
                } else {
                    DaoCoreFunction dcf = new DaoCoreFunction();
                    dcf.setFrndName(line);
                    dcf.setIpAddress(s.nextLine());

                    System.out.println(dcf.getFrndName() + " -- " + dcf.getIpAddress());
                    frndList.add(dcf);
                }
            }

            return frndList;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return frndList;
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

}
