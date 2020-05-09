
import chat.core.CoreFunction;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Anik
 */
public class TestFunction {

    private static String filePathSender = "D:\\test.txt";
    private static String filePathReciver="D:\\test2.txt";
    private static List<String> listMsg;

    public static void main(String[] arg) {
        //D:\test.txt

//        CoreFunction cf = new CoreFunction();
//
//        try {
//            listMsg = cf.getMsgList(filePath);
//            int i=0;
//            while(i!=listMsg.size()){
//                System.out.println(listMsg.get(i));
//                i++;
//            }
//            
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
        new CoreFunction().writeMsg(filePathSender,filePathReciver, "What is your name -- anik?");
    }
}
