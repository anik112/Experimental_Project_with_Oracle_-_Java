/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.awt.Color;
import java.awt.Insets;
import java.awt.TextField;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author VSI-ANIK
 */
public class CheckGUI extends JFrame{
    // JFrame 
    static JFrame f; 
  
    // JButton 
    static JButton b, b1, b2, b3, b4,b5,b6; 
  
    // label to display text 
    static JLabel l; 
  
    // main class 
    public static void main(String[] args) 
    { 
        // create a new frame to store text field and button 
        f = new JFrame("panel"); 
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // create a label to display text 
        l = new JLabel("panel label"); 
  
        // create a new buttons 
        b = new JButton("button1"); 
        b1 = new JButton("button2"); 
        b2 = new JButton("button3"); 
        b3 = new JButton("button4"); 
        b4 = new JButton("button4"); 
        b5 = new JButton("button4"); 
        b6 = new JButton("button4"); 
  
        // create a panel to add buttons and textfield and a layout 
        JPanel p = new JPanel(); 

        // set Box Layout 
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS)); 
        
        JTextField field[]=new JTextField[5];
        JButton button[]=new JButton[5];
        
//        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(p);
//            p.setLayout(jPanel1Layout);
//            jPanel1Layout.setHorizontalGroup(
//                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 539, Short.MAX_VALUE)
//            );
//            jPanel1Layout.setVerticalGroup(
//                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 418, Short.MAX_VALUE)
//            );
        
        for(int i=0;i<5;i++){
            
            field[i]=new JTextField();
            button[i]=new JButton();
            
            field[i].setSize(50, 20);
            button[i].setSize(20, 20);
            button[i].setText("Button "+i);
            button[i].setAlignmentX(RIGHT_ALIGNMENT);
            button[i].setMargin(new Insets(10, 10, 10, 10));
            button[i].setLayout(new BoxLayout(button[i], BoxLayout.Y_AXIS));
            
            
            p.add(field[i]);
            p.add(button[i]);    
        }
        
        
        
  
        // add buttons and textfield to panel 
//        p.add(b); 
//        p.add(b1); 
//        p.add(b2); 
//        p.add(b3); 
//        p.add(l); 
// 
//        
//        p.add(b3); 
//        p.add(b4); 
//        p.add(b5); 
//        p.add(b6); 
//        
//        TextField field=new TextField();
//        p.add(field);
//        
//        // setbackground of panel 
        p.setBackground(Color.red); 
  
        // add panel to frame 
        f.add(p); 
  
        // set the size of frame 
        f.setSize(300, 300); 
  
        f.show(); 
    }
}
