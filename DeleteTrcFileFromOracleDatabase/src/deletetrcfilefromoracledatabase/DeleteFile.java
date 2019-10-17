/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deletetrcfilefromoracledatabase;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VSI-ANIK
 */
public class DeleteFile {

    // Set file folder location
    private final File bdumpFileLocation = new File("D:\\oracle\\product\\10.2.0\\admin\\payroll\\bdump\\"); // for bdump folder
    private final File udumpFileLocation = new File("D:\\oracle\\product\\10.2.0\\admin\\payroll\\udump\\"); // for udump folder

    // get all file name list from folder
    private final String[] fileListBdump = bdumpFileLocation.list(); // bdump folder 
    private final String[] fileListUdump = udumpFileLocation.list(); // udump folder

    // get all file from those folder
    private final File[] bdumpFiles = bdumpFileLocation.listFiles(); // bdump folder
    private final File[] udumpFiles = udumpFileLocation.listFiles(); // udump folder

    private final List<String> deletedFileList = new ArrayList<>(); // arry for get deleted file name dynamic

    public void deleteFileFromFolder() {
        // Delete file one by one
        int fileCount = 0, deleteCount = 0; // check wather
        // loop for traversing files from bdump folder
        for (String name : fileListBdump) {
            // 1MB = 1048576 byte
            System.out.println(name + " ======>" + fileListBdump[fileCount].length());
            // check file size
            if (bdumpFiles[fileCount].length() >= 1024) {
                // check file delete or not
                if (bdumpFiles[fileCount].delete()) {
                    deletedFileList.add(name + " => bdump folder \n"); // store name in array
                    deleteCount++; // count increment
                }
            }
            fileCount++;
        }

        fileCount = 0;
        // loop for traversing files from udump folder
        for (String name : fileListUdump) {
            // 1MB = 1048576 byte
            System.out.println(name + " ======>" + fileListUdump[fileCount].length());
            // check file size
            if (udumpFiles[fileCount].length() >= 1024) {
                // check file delete or not
                if (udumpFiles[fileCount].delete()) {
                    deletedFileList.add(name + " => udump folder \n"); // store name in array
                    deleteCount++; // count increment
                }
            }
            fileCount++;
        }

        System.out.println("Total Delete : " + deleteCount);
        System.out.println("-------------------------------------------------");

        Consols consols = new Consols();
        consols.setVisible(true);
        consols.getTxtAreaColsolWindow().setText("Total Delete File: " + deleteCount+"\n\n");

        for (String s : deletedFileList) {
            System.out.println("-- " + s);
            consols.getTxtAreaColsolWindow().setText(consols.getTxtAreaColsolWindow().getText()+s);
        }
    }

}
