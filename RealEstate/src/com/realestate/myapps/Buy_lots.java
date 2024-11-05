/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.realestate.myapps;

import com.realestate.mylibs.Block;
import com.realestate.mylibs.Lot;
import com.realestate.mylibs.LotFactory;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
public class Buy_lots extends javax.swing.JFrame {

 private DefaultTableModel model;
    public Buy_lots() {
       initComponents();
       initializeLotsAndBlocks();    
             addSearchListener();
    }
     private void initializeLotsAndBlocks() {
        LotFactory lotFactory = LotFactory.getInstance();
        model = (DefaultTableModel) jTable1.getModel();

        // Create 5 blocks with 20 lots each
        for (int i = 1; i <= 5; i++) {
            String blockName = "Block " + i;
            Block block = lotFactory.createBlock(blockName);
            for (int j = 1; j <= 20; j++) {
                String size = j * 10 + " sqm"; // Example size
                String location = "Location " + i; // Example location
                double price = j * 1000.0; // Example price
                String status = (j % 2 == 0) ? "Available" : "Sold"; // Example status
                Lot lot = lotFactory.createLot(blockName, j, size, location, price, status);
                block.addLot(lot);

                // Add lot details to the table model
                model.addRow(new Object[]{
                        block.getBlockName(),
                        lot.getLotNumber(),
                        lot.getSize(),
                        lot.getLocation(),
                        lot.getPrice(),
                        lot.getStatus()
                });
            }
        }
    }
    private void addSearchListener() {
        search.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filterTable();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filterTable();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filterTable();
            }
        });
    }

    private void filterTable() {
        String searchText = search.getText().toLowerCase();
        // Create a new model for filtered data
        DefaultTableModel filteredModel = new DefaultTableModel(new Object[]{
            "Block", "Lot", "Size", "Location", "Price", "Status"
        }, 0);

        // Iterate through original data and add matches to the filtered model
        for (int i = 0; i < model.getRowCount(); i++) {
            String block = model.getValueAt(i, 0).toString().toLowerCase();
            String lot = model.getValueAt(i, 1).toString().toLowerCase();
            String size = model.getValueAt(i, 2).toString().toLowerCase();
            String location = model.getValueAt(i, 3).toString().toLowerCase();
            String price = model.getValueAt(i, 4).toString().toLowerCase();
            String status = model.getValueAt(i, 5).toString().toLowerCase();

            // Check if any of the fields contain the search text
            if (block.contains(searchText) || lot.contains(searchText) || size.contains(searchText) || 
                location.contains(searchText) || price.contains(searchText) || status.contains(searchText)) {
                filteredModel.addRow(new Object[]{
                    model.getValueAt(i, 0),
                    model.getValueAt(i, 1),
                    model.getValueAt(i, 2),
                    model.getValueAt(i, 3),
                    model.getValueAt(i, 4),
                    model.getValueAt(i, 5)
                });
            }
        }

        // Update the table with the filtered data
        jTable1.setModel(filteredModel);
    }

  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Lots = new javax.swing.JLabel();
        buyLots = new javax.swing.JLabel();
        Logout = new javax.swing.JButton();
        BuyLots = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Block", "Lot", "Size", "Location", "Price", "Status"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/img/agreement.png"))); // NOI18N

        Lots.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Lots.setForeground(new java.awt.Color(51, 102, 255));
        Lots.setText("All Lot's");
        Lots.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LotsMouseClicked(evt);
            }
        });

        buyLots.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        buyLots.setForeground(new java.awt.Color(51, 102, 255));
        buyLots.setText("Buy Lot's");
        buyLots.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buyLotsMouseClicked(evt);
            }
        });

        Logout.setBackground(new java.awt.Color(255, 102, 102));
        Logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/img/shutdown.png"))); // NOI18N
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Lots)
                .addGap(53, 53, 53)
                .addComponent(buyLots)
                .addGap(47, 47, 47)
                .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Lots, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buyLots, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(39, 39, 39))
        );

        BuyLots.setBackground(new java.awt.Color(0, 204, 153));
        BuyLots.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BuyLots.setForeground(new java.awt.Color(255, 255, 153));
        BuyLots.setText("Buy Lots");
        BuyLots.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuyLotsActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Search");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 997, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(BuyLots, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(BuyLots, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BuyLotsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuyLotsActionPerformed
        // Get the selected row from the table
        int selectedRow = jTable1.getSelectedRow();

        // Check if a row is selected
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a lot to buy.", "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Retrieve lot information from the selected row
        String blockName = jTable1.getValueAt(selectedRow, 0).toString();
        String lotNumber = jTable1.getValueAt(selectedRow, 1).toString();
        String size = jTable1.getValueAt(selectedRow, 2).toString();
        String location = jTable1.getValueAt(selectedRow, 3).toString();
        double price = (double) jTable1.getValueAt(selectedRow, 4);
        String status = jTable1.getValueAt(selectedRow, 5).toString();

        // Check if the lot is already sold
        if (status.equals("Sold")) {
            JOptionPane.showMessageDialog(this, "This lot is already sold.", "Sold Lot", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Show confirmation dialog
        int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to buy this Lot?", "Confirm Purchase", JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.YES_OPTION) {
            // Update the status to "Sold"
            jTable1.setValueAt("Sold", selectedRow, 5);

            // Generate a report
            generateReport(blockName, lotNumber, size, location, price, "Sold");

            // Show success message
            JOptionPane.showMessageDialog(this, "You have successfully purchased the lot!", "Purchase Successful", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BuyLotsActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LogoutActionPerformed

    private void buyLotsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buyLotsMouseClicked
        new Buy_lots().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buyLotsMouseClicked

    private void LotsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LotsMouseClicked
        new Home().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LotsMouseClicked
private void generateReport(String blockName, String lotNumber, String size, String location, double price, String status) {
    try {
        // Create the report file
        String fileName = "LotPurchaseReport_" + lotNumber + ".csv"; // or .txt based on your preference
        FileWriter writer = new FileWriter(fileName);
        
        // Write the report header
        writer.append("Block,Lot,Size,Location,Price,Status\n");
        
        // Write the lot information
        writer.append(String.join(",", blockName, lotNumber, size, location, String.valueOf(price), status));
        writer.append("\n");
        
        // Close the writer
        writer.flush();
        writer.close();
        
        JOptionPane.showMessageDialog(this, "Report generated: " + fileName, "Report Generated", JOptionPane.INFORMATION_MESSAGE);
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error generating report: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
        
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Buy_lots.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Buy_lots.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Buy_lots.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Buy_lots.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Buy_lots().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BuyLots;
    private javax.swing.JButton Logout;
    private javax.swing.JLabel Lots;
    private javax.swing.JLabel buyLots;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
