/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.view;

import chat.core.CoreFunction;
import chat.core.DaoCoreFunction;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JTextArea;

/**
 *
 * @author Anik
 */
public class MainView extends javax.swing.JFrame {

    private String senderFileLoc = "";
    private String reciverFileLoc;
    private String frndListLoc = "D:\\LANChat\\frndList.txt";
    private String configLoc = "D:\\LANChat\\config.txt";
    private List<DaoCoreFunction> getFrndList;

    private String urlHeader = "\\\\";
    private String urlMid = "\\LiveApps\\LANChat\\";
    private String fileExns = ".txt";
    private String serverIp = "192.168.1.210";
    private String myip;
    private String dateTime = "00/00/0000 00:00:00";

    public MainView() {
        initComponents();

        dateTime = getDateAndTime();
        System.out.println(dateTime);
        myip = new CoreFunction().getMyIp(configLoc);
        senderFileLoc = urlHeader + serverIp + urlMid + myip + fileExns;
        viewDataInTable(senderFileLoc);
        txtArWriteMsg.setLineWrap(true);
        showList.setBackground(Color.white);
        showFrndListInBox();
        setNikNameInEditor(comboSenderList.getSelectedItem().toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        comboSenderList = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtArWriteMsg = new javax.swing.JTextArea();
        btnSendMsg = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        showList = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LANChat V0.1");
        setAlwaysOnTop(true);
        setLocation(new java.awt.Point(200, 100));
        setLocationByPlatform(true);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(51, 102, 0));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        comboSenderList.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboSenderListItemStateChanged(evt);
            }
        });
        comboSenderList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSenderListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboSenderList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(comboSenderList, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        txtArWriteMsg.setColumns(20);
        txtArWriteMsg.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        txtArWriteMsg.setRows(5);
        txtArWriteMsg.setDragEnabled(true);
        txtArWriteMsg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtArWriteMsgKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(txtArWriteMsg);

        btnSendMsg.setText("Send");
        btnSendMsg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendMsgActionPerformed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setHorizontalScrollBar(null);

        showList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                showListMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout showListLayout = new javax.swing.GroupLayout(showList);
        showList.setLayout(showListLayout);
        showListLayout.setHorizontalGroup(
            showListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 643, Short.MAX_VALUE)
        );
        showListLayout.setVerticalGroup(
            showListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 323, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(showList);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSendMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSendMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        jMenu1.setText("Setup");

        jMenuItem1.setText("Refresh");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Exit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboSenderListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSenderListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSenderListActionPerformed

    private void btnSendMsgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendMsgActionPerformed
        // TODO add your handling code here:
        sendMsg();
    }//GEN-LAST:event_btnSendMsgActionPerformed

    private void txtArWriteMsgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtArWriteMsgKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txtArWriteMsg.getText() != null) {
                sendMsg();
                setNikNameInEditor(comboSenderList.getSelectedItem().toString());
            }
        }
    }//GEN-LAST:event_txtArWriteMsgKeyPressed

    private void comboSenderListItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboSenderListItemStateChanged
        // TODO add your handling code here
        setNikNameInEditor(comboSenderList.getSelectedItem().toString());
    }//GEN-LAST:event_comboSenderListItemStateChanged

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        refMsgList();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void showListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showListMouseEntered
        // TODO add your handling code here:
        showList.removeAll();
        viewDataInTable(senderFileLoc);
    }//GEN-LAST:event_showListMouseEntered

    private void viewDataInTable(String fileLoc) {
        String keyPerson01 = "-1";
        String keyPerson02 = "-2";

        try {
            List<String> msgList = new CoreFunction().getMsgList(fileLoc);
            //System.out.println(msgList.size());

            int i = 0;
            while (i != msgList.size()) {
                showList.setLayout(new GridLayout(0, 1, 5, 5));
                String s = msgList.get(i);
                //System.out.println(s);
                String key = s.substring(0, 2);
                //System.out.println(key);
                String getDate = s.substring(2, s.length());
                //System.out.println(getDate);

                String personName = "Unknown";

                if (key.equals(keyPerson02)) {
                    for (int k = 0; k < getFrndList.size(); k++) {
                        if (getFrndList.get(k).getIpAddress().equals(msgList.get(i + 1))) {
                            personName = getFrndList.get(k).getFrndName();
                            break;
                        }
                    }

                    JTextArea field = new JTextArea(personName + getDate 
                                                    + "\n\n" 
                                                    + msgList.get(i + 2));
                    field.setLineWrap(true);
                    field.setBackground(new Color(0, 153, 153));
                    field.setForeground(new java.awt.Color(255, 255, 255));
                    Font font = new Font("Lucida Sans",Font.PLAIN, 14);
                    field.setFont(font);

                    showList.add(field);
                    showList.revalidate();
                    showList.repaint();

                } else if (key.equals(keyPerson01)) {
                    for (int k = 0; k < getFrndList.size(); k++) {
                        if (getFrndList.get(k).getIpAddress().equals(msgList.get(i + 1))) {
                            personName = getFrndList.get(k).getFrndName();
                            break;
                        }
                    }
                    JTextArea field = new JTextArea(personName + getDate 
                                                    + "\n\n"
                                                    + msgList.get(i + 2));
                    field.setLineWrap(true);
                    Font font = new Font("Lucida Sans",Font.PLAIN, 14);
                    field.setFont(font);

                    showList.add(field);
                    showList.revalidate();
                    showList.repaint();
                }

                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }

    private void sendMsg() {
        if (txtArWriteMsg.getText().length() > 1) {

//            for(int i=0;i<getFrndList.size();i++){
//                String ip=getFrndList.get(i).getIpAddress();
//                if(ip=="192.168.1.204"){
//                    senderFileLoc=urlHeader+ip+urlMid+ip;
//                }
//            }
            String reciverIp;
            for (int i = 0; i < getFrndList.size(); i++) {
                String selectedFrnd = comboSenderList.getSelectedItem().toString();
                String frndName = getFrndList.get(i).getFrndName();
                if (frndName.equals(selectedFrnd)) {
                    reciverIp = getFrndList.get(i).getIpAddress().toString();
                    reciverFileLoc = urlHeader + serverIp + urlMid + reciverIp + fileExns;
                    new CoreFunction().writeMsg(senderFileLoc, reciverFileLoc, txtArWriteMsg.getText(), myip, dateTime);
                    break;
                }
            }

            setNikNameInEditor(comboSenderList.getSelectedItem().toString());
            refMsgList();
        }
    }

    private void showFrndListInBox() {
        getFrndList = new ArrayList<>();
        getFrndList = new CoreFunction().frndsList(frndListLoc);

        for (DaoCoreFunction dcf : getFrndList) {
            comboSenderList.addItem(dcf.getFrndName());
        }
    }

    private void refMsgList() {
        txtArWriteMsg.setText("");
        showList.removeAll();
        viewDataInTable(senderFileLoc);
    }

    private String getDateAndTime() {
        Date d = new Date(System.currentTimeMillis());
        System.out.println(d);
        SimpleDateFormat format = new SimpleDateFormat("dd/M/yyyy hh:mm:ss");
        String dateAndTime = format.format(d);

        return dateAndTime;
    }

    private void setNikNameInEditor(String selectedName) {
        txtArWriteMsg.setText(selectedName + ": ");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSendMsg;
    private javax.swing.JComboBox<String> comboSenderList;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel showList;
    private javax.swing.JTextArea txtArWriteMsg;
    // End of variables declaration//GEN-END:variables
}