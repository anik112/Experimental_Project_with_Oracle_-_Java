/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test02;

import test01.Console;

/**
 *
 * @author VSIANIK
 */
public class TestConsol{
    
    
    
    public void showMsg(){
        
    }
    
    public static void main(String args[]){
        
        TestConsol testConsol=new TestConsol();
        testConsol.showMsg();
        
        TestConsolCheck testConsolCheck=new TestConsolCheck();
        Console co=new Console();
        co.setVisible(true);
    }
    
    
}
