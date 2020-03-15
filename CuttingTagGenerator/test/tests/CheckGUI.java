/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import data.DBConnection;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import models.MarkerPlan;

/**
 *
 * @author VSI-ANIK
 */
public class CheckGUI extends JFrame {

    // JFrame 
    static JFrame f;

    // label to display text 
    static JLabel l;

    public static int lngth;
    public static int rollQty[];
    public static String rolls[];
    public static JTextField txtRollNo[];
    public static JTextField txtQty[];
    public static String sizeList[]={"XXS","XS","S","M","L","XL","XXL"};

    public CheckGUI() throws HeadlessException {
    }
    

    // main class 
    public static void main(String[] args) {
  
        // create a new frame to store text field and button 
        f = new JFrame("panel");
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // create a panel to add buttons and textfield and a layout 
        JPanel p = new JPanel();

        // set Box Layout 
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

        JTextField as = new JTextField();
        JButton btn = new JButton("Show");
        p.add(as);
        p.add(btn);
  
        btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lngth = Integer.valueOf(as.getText());

                txtRollNo = new JTextField[lngth];
                txtQty = new JTextField[lngth];
                JButton btnSubmit = new JButton("Submit");
                for (int i = 0; i < lngth; i++) {

                    txtRollNo[i] = new JTextField();
                    txtRollNo[i].setSize(50, 20);
                    txtQty[i]=new JTextField();
                    txtQty[i].setSize(50, 20);

                    p.add(txtRollNo[i]);
                    p.add(txtQty[i]);
                }
                
                p.add(btnSubmit);

                btnSubmit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        rollQty = new int[lngth];
                        rolls = new String[lngth];

                        for (int i = 0; i < lngth; i++) {
                            rolls[i] = txtRollNo[i].getText();
                            rollQty[i] = Integer.valueOf(txtQty[i].getText());
                            System.out.println("Roll No: " + rolls[i] + "  Qty: " + rollQty[i]);
                        }
                        
                        selectStyleAndPo("BLACK-OS","S1254120");
                    }
                });
            }
        });

        // setbackground of panel 
        p.setBackground(Color.red);

        // add panel to frame 
        f.add(p);

        // set the size of frame 
        f.setSize(300, 300);

        f.show();
    }
    
    
    public static void selectStyleAndPo(String style,String po){
        
        Connection c=DBConnection.connection();
        MarkerPlan mp=new MarkerPlan();
        
        try{
            PreparedStatement statement=c.prepareCall("SELECT * FROM TB_MARKER_PLAN WHERE STYLE_NAME='"+style+"' AND PO_NUMBER='"+po+"'");
            ResultSet rs=statement.executeQuery();
            
            while(rs.next()){
                mp.setStyleName(rs.getString(2));
                mp.setPoNumber(rs.getString(3));
                mp.setStdPlyHeight(rs.getInt(4));
                mp.setYy(rs.getInt(6));
                mp.setXxs(rs.getInt(7));
                mp.setXs(rs.getInt(8));
                mp.setS(rs.getInt(9));
                mp.setM(rs.getInt(10));
                mp.setL(rs.getInt(11));
                mp.setXl(rs.getInt(12));
                mp.setXxl(rs.getInt(13));
                mp.setTotal(rs.getInt(14));
                
                System.out.println("========== "+mp.getPoNumber());
            }
        }catch(Exception e){
            System.err.println("Test: -> "+e.getMessage());
        }
        
        List<String> existsPartsDtls=new ArrayList<>();
        
        try{
            PreparedStatement statement=c.prepareCall("SELECT PARTS_NAME FROM TB_PARTS_PIVOT WHERE STYLE_NAME='"+style+"'");
            ResultSet rs=statement.executeQuery();
            
            while (rs.next()) {                
                String s=rs.getString(1);
                existsPartsDtls.add(s);
                System.out.println("---> "+s);
            }
        }catch(Exception e){
            System.err.println("Style&PO: -> "+e.getMessage());
        }
        
        System.out.println(existsPartsDtls.size()+" --- "+lngth);
        int bundel= 1;
        int serialCount=1;
        
        // main loop 
        for(int i=0;i<existsPartsDtls.size();i++){
            for(int j=0;j<lngth;j++){
                
                System.out.println("=========================================");
                System.out.println("Bundel No: "+bundel+" --- Po: "+po);
                System.out.println("Style: "+style+" ---- Parts: "+existsPartsDtls.get(i));
                System.out.println("Roll No: "+rolls[j]+" ----- Size: S");
                System.out.println("Qty: "+(rollQty[j]*mp.getS()));
                System.out.println("Serial No: "+serialCount+" to "+((serialCount+rollQty[j])-1));
                System.out.println("=========================================");
                serialCount += rollQty[j];
                bundel++;
            }
        }
            
        
    }
    
    
    
}
