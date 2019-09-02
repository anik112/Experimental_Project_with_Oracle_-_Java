/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package experimentfile;

import deleteDataCore.DeleteAttendenceDataByLeaveDate;

/**
 *
 * @author VSIANIK
 */
public class MainClass {
    
    public static void main(String[] args) throws Throwable {
        
//        deleteDataCore.DeleteAttendenceDataByLeaveDate delAttData=new DeleteAttendenceDataByLeaveDate();
//        
//        delAttData.getAllLeaveEmployee(2019,"January");
//        delAttData.deleteAttendeceOfLeaveEmployee();
        
        new deleteDataView.DeleteAttendenceOfLeaveEmp().setVisible(true);
    }
    
}
