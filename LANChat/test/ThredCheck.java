


import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author VSI-ANIK
 */
public class ThredCheck extends Thread{
    
    public void run() {
        for(int i=0;i<50;i++){
            try {
                System.out.println("Hello from a thread!");
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThredCheck.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
