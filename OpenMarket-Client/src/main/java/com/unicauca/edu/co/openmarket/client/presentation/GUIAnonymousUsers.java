/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.unicauca.edu.co.openmarket.client.presentation;

import com.unicauca.edu.co.openmarket.client.access.ProductAccessImplSockets;
import com.unicauca.edu.co.openmarket.commons.domain.Product;
import com.unicauca.edu.co.openmarket.client.infra.Messages;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import reloj.frameworkobsobs.Observador;

/**
 *
 * @author manue
 */
public class GUIAnonymousUsers extends javax.swing.JFrame {
    private ProductAccessImplSockets productAccess;
    private Messages mns;
    
    /**
     * Creates new form GUIUsers
     */
    public GUIAnonymousUsers(java.awt.Frame parent, boolean modal,ProductAccessImplSockets productAccess) {
        //super(parent, modal);
        initComponents();
        initializeTable();
        this.productAccess = productAccess;
        setLocationRelativeTo(null); //centrar al ventana
    }

    public GUIAnonymousUsers(ProductAccessImplSockets productAccess) {
        initComponents();
        initializeTable();
        this.productAccess = productAccess;
        setLocationRelativeTo(null); //centrar al ventana
    }

    
    private void initializeTable() {
        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Id", "Name", "Description"
                }
        ));
    }
    
    private void fillTable(List<Product> listProducts) {
        initializeTable();
        DefaultTableModel model = (DefaultTableModel) tblProducts.getModel();

        Object rowData[] = new Object[3];//No columnas
        for (int i = 0; i < listProducts.size(); i++) {
            rowData[0] = listProducts.get(i).getProductId();
            rowData[1] = listProducts.get(i).getName();
            rowData[2] = listProducts.get(i).getDescription();
            
            model.addRow(rowData);
        }
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
        btnMostrarProductos = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblBuscarP = new javax.swing.JLabel();
        txtProductToFind = new javax.swing.JTextField();
        btnFindP = new javax.swing.JButton();
        rbtnName = new javax.swing.JRadioButton();
        rbtnDescription = new javax.swing.JRadioButton();
        jScrollProductsAU = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnCloseAU = new javax.swing.JButton();
        btnComprar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnMostrarProductos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMostrarProductos.setForeground(new java.awt.Color(0, 153, 0));
        btnMostrarProductos.setText("Mostrar Productos");
        btnMostrarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarProductosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(339, 339, 339)
                .addComponent(btnMostrarProductos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMostrarProductos)
                .addContainerGap())
        );

        lblBuscarP.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblBuscarP.setText("Buscar por:");

        btnFindP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnFindP.setText("Buscar");
        btnFindP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindPActionPerformed(evt);
            }
        });

        rbtnName.setSelected(true);
        rbtnName.setText("Nombre");

        rbtnDescription.setText("Descripción");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(lblBuscarP)
                .addGap(18, 18, 18)
                .addComponent(rbtnName)
                .addGap(18, 18, 18)
                .addComponent(rbtnDescription)
                .addGap(18, 18, 18)
                .addComponent(txtProductToFind, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFindP)
                .addContainerGap(191, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscarP)
                    .addComponent(txtProductToFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFindP)
                    .addComponent(rbtnName)
                    .addComponent(rbtnDescription))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Nombre producto", "Descripción"
            }
        ));
        tblProducts.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tblProducts);

        jScrollProductsAU.setViewportView(jScrollPane1);

        btnCloseAU.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCloseAU.setText("Cerrar");
        btnCloseAU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseAUActionPerformed(evt);
            }
        });

        btnComprar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnComprar.setText("Comprar");
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(326, 326, 326)
                .addComponent(btnCloseAU)
                .addGap(18, 18, 18)
                .addComponent(btnComprar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCloseAU)
                    .addComponent(btnComprar))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollProductsAU, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollProductsAU, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMostrarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarProductosActionPerformed
        // TODO add your handling code here:
        try {
            fillTable(productAccess.findAll());
        } catch (Exception ex) {
            Logger.getLogger(GUIProductsFind.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnMostrarProductosActionPerformed

    private void btnCloseAUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseAUActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCloseAUActionPerformed

    private void btnFindPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindPActionPerformed
        // TODO add your handling code here:
        initializeTable();
        DefaultTableModel model = (DefaultTableModel) tblProducts.getModel();
        Object rowData[] = new Object[3];//No columnas
        Product objProduct = null;
        if(this.rbtnName.isSelected()){
            try {
                objProduct = productAccess.findByName(this.txtProductToFind.getText());
                
                rowData[0] = objProduct.getProductId();
                rowData[1] = objProduct.getName();
                rowData[2] = objProduct.getDescription();
                
                model.addRow(rowData);
                
            } catch (Exception ex) {
                Logger.getLogger(GUIProductsFind.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            try {
                objProduct = productAccess.findByDescription(this.txtProductToFind.getText());
                rowData[0] = objProduct.getProductId();
                rowData[1] = objProduct.getName();
                rowData[2] = objProduct.getDescription();
                
                model.addRow(rowData);
                
            } catch (Exception ex) {
                Logger.getLogger(GUIProductsFind.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnFindPActionPerformed

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnComprarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCloseAU;
    private javax.swing.JButton btnComprar;
    private javax.swing.JButton btnFindP;
    private javax.swing.JButton btnMostrarProductos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollProductsAU;
    private javax.swing.JLabel lblBuscarP;
    private javax.swing.JRadioButton rbtnDescription;
    private javax.swing.JRadioButton rbtnName;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTextField txtProductToFind;
    // End of variables declaration//GEN-END:variables
    public void actualizar() {
        try {
            fillTable(productAccess.findAll() );
        } catch (Exception ex) {
            Logger.getLogger(GUIProductsFind.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
