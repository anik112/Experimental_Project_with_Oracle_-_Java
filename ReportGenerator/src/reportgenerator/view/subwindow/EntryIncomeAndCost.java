/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportgenerator.view.subwindow;

import java.awt.event.KeyEvent;

/**
 *
 * @author Anik
 */
public class EntryIncomeAndCost extends javax.swing.JPanel {

    
    private int keyTypeChecker=0;
    
    /**
     * Creates new form EntryIncomeAndCost
     */
    public EntryIncomeAndCost() {
        initComponents();
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
        txtDate = new javax.swing.JTextField();
        txtCost = new javax.swing.JTextField();
        txtIncome = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        checkBoxEdit = new javax.swing.JCheckBox();
        lblID = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();
        lblTotalAmount = new javax.swing.JLabel();
        comboDtls = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblShowIncomeAndCost = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtDate.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        txtDate.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Date", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Sans", 0, 12))); // NOI18N
        txtDate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDateFocusGained(evt);
            }
        });
        txtDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateActionPerformed(evt);
            }
        });
        txtDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDateKeyPressed(evt);
            }
        });

        txtCost.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        txtCost.setText("0");
        txtCost.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cost", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Sans", 0, 12))); // NOI18N
        txtCost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCostKeyPressed(evt);
            }
        });

        txtIncome.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        txtIncome.setText("0");
        txtIncome.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Income", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Sans", 0, 12))); // NOI18N
        txtIncome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIncomeKeyPressed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnSearch.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        checkBoxEdit.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        checkBoxEdit.setText("Edit?");
        checkBoxEdit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        checkBoxEdit.setIconTextGap(6);

        lblID.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        lblID.setText(" ");
        lblID.setBorder(javax.swing.BorderFactory.createTitledBorder("ID"));

        btnRefresh.setFont(new java.awt.Font("Lucida Sans", 0, 10)); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        lblTotalAmount.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        lblTotalAmount.setText(" ");
        lblTotalAmount.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total Amount", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Sans", 0, 12))); // NOI18N

        comboDtls.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        comboDtls.setMaximumRowCount(100);
        comboDtls.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Company Name" }));
        comboDtls.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIncome, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                    .addComponent(txtDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(lblTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(comboDtls, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(txtCost, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(checkBoxEdit)
                            .addGap(84, 84, 84)
                            .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDate)
                    .addComponent(comboDtls))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblID, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(txtIncome)
                    .addComponent(checkBoxEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tblShowIncomeAndCost.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        tblShowIncomeAndCost.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Date", "Emp Name", "Amount", "Cost", "Cash In Hand", "Athorize"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblShowIncomeAndCost.setRowHeight(25);
        tblShowIncomeAndCost.setRowMargin(2);
        tblShowIncomeAndCost.setSelectionBackground(new java.awt.Color(0, 102, 102));
        tblShowIncomeAndCost.setShowVerticalLines(false);
        tblShowIncomeAndCost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblShowIncomeAndCostMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblShowIncomeAndCost);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtDateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDateFocusGained
        // TODO add your handling code here:
        txtDate.setText("");
        keyTypeChecker = 0;
    }//GEN-LAST:event_txtDateFocusGained

    private void txtDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateActionPerformed

    private void txtDateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDateKeyPressed
        // TODO add your handling code here:

        if (keyTypeChecker == 8) {
            String date = txtDate.getText();
            String day = date.substring(0, 2);
            String month = date.substring(2, 4);
            String year = date.substring(4, 8);

            System.out.println(day + "/" + month + "/" + year);
            txtDate.setText(day + "/" + month + "/" + year);
            comboDtls.requestFocus();
        }
        keyTypeChecker++;
    }//GEN-LAST:event_txtDateKeyPressed

    private void txtCostKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnSave.requestFocus();
        }
    }//GEN-LAST:event_txtCostKeyPressed

    private void txtIncomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIncomeKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && txtIncome.getText().length() > 0) {
            txtCost.requestFocus();
        }
    }//GEN-LAST:event_txtIncomeKeyPressed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:

//        AdvanceAmount amount = new AdvanceAmount();
//
//        amount.setGivenDate(txtDate.getText());
//        amount.setAdvanceHolderName(txtEmpName.getText());
//        amount.setAmountOfAdvance(Float.valueOf(txtAmount.getText()));
//        amount.setAmountOfCost(Float.valueOf(txtIncome.getText()));
//        amount.setAmountCashOnHand(Float.valueOf(txtCost.getText()));
//        amount.setAuthorized("NO");
//
//        if (checkBoxEdit.isSelected()) {
//            if ((!txtDate.getText().isEmpty()) && (!txtEmpName.getText().isEmpty()) && (!txtAmount.getText().isEmpty())) {
//                amount.setId(Integer.valueOf(lblID.getText()));
//                new AdvanceAmountService().updateData(amount);
//                JOptionPane.showMessageDialog(null, "Data Save",
//                    ":: DATA SAVE :: ", JOptionPane.INFORMATION_MESSAGE);
//            } else {
//                JOptionPane.showMessageDialog(null, "Please check Date, Emp Name, Amount",
//                    ":: ERROR- WINDOW ADVANCE AMOUNT:: ", JOptionPane.ERROR_MESSAGE);
//            }
//        } else {
//            if ((!txtDate.getText().isEmpty()) && (!txtEmpName.getText().isEmpty()) && (!txtAmount.getText().isEmpty())) {
//                new AdvanceAmountService().saveData(amount);
//                JOptionPane.showMessageDialog(null, "Data Save",
//                    ":: DATA SAVE :: ", JOptionPane.INFORMATION_MESSAGE);
//            } else {
//                JOptionPane.showMessageDialog(null, "Please check Date, Emp Name, Amount",
//                    ":: ERROR- WINDOW ADVANCE AMOUNT:: ", JOptionPane.ERROR_MESSAGE);
//            }
//        }
//        showDataListInTable();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void tblShowIncomeAndCostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblShowIncomeAndCostMouseClicked
        // TODO add your handling code here:

//        AdvanceAmount amount = new AdvanceAmount();
//        int selectedRow = tblShowIncomeAndCost.getSelectedRow();
//
//        if (checkSearchBtnIsClecked) {
//            lblID.setText(String.valueOf(searchResult.get(selectedRow).getId()));
//            lblTotalAmount.setText(searchResult.get(selectedRow).getAuthorized());
//            txtDate.setText(searchResult.get(selectedRow).getGivenDate());
//            txtEmpName.setText(searchResult.get(selectedRow).getAdvanceHolderName());
//            txtAmount.setText(String.valueOf(searchResult.get(selectedRow).getAmountOfAdvance()));
//            txtIncome.setText(String.valueOf(searchResult.get(selectedRow).getAmountOfCost()));
//            txtCost.setText(String.valueOf(searchResult.get(selectedRow).getAmountCashOnHand()));
//
//        } else {
//            lblID.setText(String.valueOf(listOfAdvanceAmount.get(selectedRow).getId()));
//            lblTotalAmount.setText(listOfAdvanceAmount.get(selectedRow).getAuthorized());
//            txtDate.setText(listOfAdvanceAmount.get(selectedRow).getGivenDate());
//            txtEmpName.setText(listOfAdvanceAmount.get(selectedRow).getAdvanceHolderName());
//            txtAmount.setText(String.valueOf(listOfAdvanceAmount.get(selectedRow).getAmountOfAdvance()));
//            txtIncome.setText(String.valueOf(listOfAdvanceAmount.get(selectedRow).getAmountOfCost()));
//            txtCost.setText(String.valueOf(listOfAdvanceAmount.get(selectedRow).getAmountCashOnHand()));
//        }
//        // request to update data
//        if (evt.getClickCount() == 2 && lblTotalAmount.getText().equals("NO")) {
//            //System.out.println(listOfAdvanceAmount.get(selectedRow).getId()+"  ==>"+selectedRow);
//            amount.setId(Integer.valueOf(lblID.getText()));
//            amount.setGivenDate(txtDate.getText());
//            amount.setAdvanceHolderName(txtEmpName.getText());
//            amount.setAmountOfAdvance(Float.valueOf(txtAmount.getText()));
//            amount.setAmountOfCost(Float.valueOf(txtIncome.getText()));
//            amount.setAmountCashOnHand(Float.valueOf(txtCost.getText()));
//            amount.setAuthorized("NO");
//            checkSearchBtnIsClecked=false;
//
//            new UpdateAuthorizedData(amount);
//        }
    }//GEN-LAST:event_tblShowIncomeAndCostMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    public javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JCheckBox checkBoxEdit;
    private javax.swing.JComboBox<String> comboDtls;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblTotalAmount;
    private javax.swing.JTable tblShowIncomeAndCost;
    private javax.swing.JTextField txtCost;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtIncome;
    // End of variables declaration//GEN-END:variables
}