/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportgenerator.view.subwindow;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import reportgenerator.corefunction.IOFunction;
import reportgenerator.dao.EntrySubmitedBillDao;
import reportgenerator.service.EntrySubmitedBillService;

/**
 *
 * @author Anik
 */
public class SubmitedPanddingBill extends javax.swing.JPanel {

    private String configComapnyListUrl;

    private List<String> companyAndAddressList = new ArrayList<>();
    private List<EntrySubmitedBillDao> listOfBill;

    /**
     * Creates new form SubmitedPanddingBill
     */
    public SubmitedPanddingBill(String configComapnyListUrl) {
        this.configComapnyListUrl = configComapnyListUrl;
        initComponents();
        
        showCompanyNameInComboBox();
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
        btnSave = new javax.swing.JButton();
        txtBillNo = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        comboCompany = new javax.swing.JComboBox<>();
        checkBoxCollected = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblShowSubmitedPanddingBill = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnSave.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        txtBillNo.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        txtBillNo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Bill Number", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Sans", 0, 12))); // NOI18N
        txtBillNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBillNoKeyPressed(evt);
            }
        });

        btnSearch.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        comboCompany.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        comboCompany.setMaximumRowCount(100);
        comboCompany.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Company Name" }));
        comboCompany.setToolTipText("");

        checkBoxCollected.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        checkBoxCollected.setText("Collected?");
        checkBoxCollected.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        checkBoxCollected.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        checkBoxCollected.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comboCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxCollected, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtBillNo, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboCompany)
                    .addComponent(txtBillNo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxCollected, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblShowSubmitedPanddingBill.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        tblShowSubmitedPanddingBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Bill Number", "Company", "Amount", "Bill Type", "Collected"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblShowSubmitedPanddingBill.setRowHeight(25);
        tblShowSubmitedPanddingBill.setRowMargin(2);
        tblShowSubmitedPanddingBill.setSelectionBackground(new java.awt.Color(0, 102, 102));
        tblShowSubmitedPanddingBill.setShowVerticalLines(false);
        tblShowSubmitedPanddingBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblShowSubmitedPanddingBillMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblShowSubmitedPanddingBill);
        if (tblShowSubmitedPanddingBill.getColumnModel().getColumnCount() > 0) {
            tblShowSubmitedPanddingBill.getColumnModel().getColumn(0).setResizable(false);
            tblShowSubmitedPanddingBill.getColumnModel().getColumn(0).setPreferredWidth(20);
            tblShowSubmitedPanddingBill.getColumnModel().getColumn(1).setResizable(false);
            tblShowSubmitedPanddingBill.getColumnModel().getColumn(1).setPreferredWidth(20);
            tblShowSubmitedPanddingBill.getColumnModel().getColumn(3).setResizable(false);
            tblShowSubmitedPanddingBill.getColumnModel().getColumn(3).setPreferredWidth(20);
            tblShowSubmitedPanddingBill.getColumnModel().getColumn(4).setResizable(false);
            tblShowSubmitedPanddingBill.getColumnModel().getColumn(4).setPreferredWidth(40);
            tblShowSubmitedPanddingBill.getColumnModel().getColumn(5).setResizable(false);
            tblShowSubmitedPanddingBill.getColumnModel().getColumn(5).setPreferredWidth(20);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:

        EntrySubmitedBillDao billDao = new EntrySubmitedBillDao();
        billDao = listOfBill.get(tblShowSubmitedPanddingBill.getSelectedRow());
        billDao.setCollected("NO");

        if (checkBoxCollected.isSelected()&&(!txtBillNo.getText().isEmpty())) {
            billDao.setBillNumber(txtBillNo.getText());
            billDao.setCollected("YES");
            new EntrySubmitedBillService().updateData(billDao);
            showPendingBillList(comboCompany.getSelectedItem().toString());
            JOptionPane.showMessageDialog(null, "Bill Collected.",
                    ":: DATA UPDATE :: ", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Please check Collected is selected \nand bill no not empty.",
                    ":: ERROR- WINDOW SUBMITED PANDDING BILL :: ", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtBillNoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBillNoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnSave.requestFocus();
        }
    }//GEN-LAST:event_txtBillNoKeyPressed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        if (comboCompany.getSelectedIndex() > 0) {
            String companyName = comboCompany.getSelectedItem().toString();
            String[] parts=companyName.split("-");
            showPendingBillList(parts[1]);
        } else {
            JOptionPane.showMessageDialog(null, "Please Select Company.",
                    ":: ERROR- WINDOW SUBMITED BILL :: ", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tblShowSubmitedPanddingBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblShowSubmitedPanddingBillMouseClicked
        // TODO add your handling code here:
        
        txtBillNo.setText(listOfBill.get(tblShowSubmitedPanddingBill.getSelectedRow()).getBillNumber());

    }//GEN-LAST:event_tblShowSubmitedPanddingBillMouseClicked

    private void showCompanyNameInComboBox() {
        companyAndAddressList = new IOFunction().getCompanyNameAndAddress(configComapnyListUrl);

        int i = 0;
        while (i != companyAndAddressList.size()) {
            comboCompany.addItem(i + "-" + companyAndAddressList.get(i));
            i += 2;
        }
    }

    private void showPendingBillList(String comName) {
        listOfBill = new EntrySubmitedBillService().getBillSearchByCompany(comName);

        DefaultTableModel model = (DefaultTableModel) tblShowSubmitedPanddingBill.getModel();
        model.setRowCount(0);
        //System.out.println(listOfBill.size());
        Object[] obj = new Object[6];
        int i = 0;
        while (i != listOfBill.size()) {
            obj[0] = listOfBill.get(i).getBillDate();
            obj[1] = listOfBill.get(i).getBillNumber();
            obj[2] = listOfBill.get(i).getCompanyName();
            obj[3] = listOfBill.get(i).getAmount();
            obj[4] = listOfBill.get(i).getBillType();
            obj[5] = listOfBill.get(i).getCollected();

            model.addRow(obj);
            i++;
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JCheckBox checkBoxCollected;
    private javax.swing.JComboBox<String> comboCompany;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblShowSubmitedPanddingBill;
    private javax.swing.JTextField txtBillNo;
    // End of variables declaration//GEN-END:variables
}