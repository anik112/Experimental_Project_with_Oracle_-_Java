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
        txtBillNo = new javax.swing.JTextField();
        comboCompany = new javax.swing.JComboBox<>();
        checkBoxCollected = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblShowSubmitedPanddingBill = new javax.swing.JTable();

        setBackground(new java.awt.Color(221, 221, 221));

        jPanel1.setBackground(new java.awt.Color(255, 255, 224));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtBillNo.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        txtBillNo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Bill Number", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Sans", 0, 12))); // NOI18N
        txtBillNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBillNoKeyPressed(evt);
            }
        });

        comboCompany.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        comboCompany.setMaximumRowCount(100);
        comboCompany.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Company Name" }));
        comboCompany.setToolTipText("");

        checkBoxCollected.setBackground(new java.awt.Color(0, 255, 204));
        checkBoxCollected.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        checkBoxCollected.setText("Collected?");
        checkBoxCollected.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        checkBoxCollected.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        checkBoxCollected.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jPanel2.setBackground(new java.awt.Color(0, 255, 204));

        btnSearch.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.lightGray));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        btnSave.setText("Save");
        btnSave.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.lightGray));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboCompany, 0, 390, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtBillNo)
                        .addGap(18, 18, 18)
                        .addComponent(checkBoxCollected, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(70, 70, 70))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkBoxCollected, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBillNo))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblShowSubmitedPanddingBill.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.lightGray));
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblShowSubmitedPanddingBill;
    private javax.swing.JTextField txtBillNo;
    // End of variables declaration//GEN-END:variables
}
