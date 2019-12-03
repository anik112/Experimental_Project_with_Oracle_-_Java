/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testproject;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;

/**
 *
 * @author VSI-ANIK
 */
public class MouseEvent {

    public void event() throws InterruptedException, AWTException {
        Thread.sleep(1000);
        Point p = MouseInfo.getPointerInfo().getLocation();
        System.out.println(p);
        System.out.println(new Robot().getPixelColor(new Point(MouseInfo.getPointerInfo().getLocation()).x,
                new Point(MouseInfo.getPointerInfo().getLocation()).y));
        
        
    }

}
