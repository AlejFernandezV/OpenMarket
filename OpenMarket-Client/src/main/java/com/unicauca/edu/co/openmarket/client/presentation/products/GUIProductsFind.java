/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.edu.co.openmarket.client.presentation.products;

import com.unicauca.edu.co.openmarket.client.access.ProductAccessImplSockets;
import com.unicauca.edu.co.openmarket.commons.domain.Product;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import reloj.frameworkobsobs.Observador;

/**
 *
 * @author Libardo Pantoja
 */
public class GUIProductsFind extends javax.swing.JDialog implements Observador{
    private ProductAccessImplSockets productAccess;
    /**
     * Creates new form GUIProductsFind
     */
    public GUIProductsFind(java.awt.Frame parent, boolean modal,ProductAccessImplSockets productAccess) {
        super(parent, modal);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlCenter = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();
        pnlNorth = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rdoId = new javax.swing.JRadioButton();
        rdoName = new javax.swing.JRadioButton();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnSearchAll = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Búsqueda de productos");

        pnlCenter.setLayout(new java.awt.BorderLayout());

        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Descripción"
            }
        ));
        jScrollPane1.setViewportView(tblProducts);

        pnlCenter.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jLabel1.setText("Buscar por:");

        buttonGroup1.add(rdoId);
        rdoId.setSelected(true);
        rdoId.setText("Id");

        buttonGroup1.add(rdoName);
        rdoName.setText("Nombre del producto");

        txtSearch.setPreferredSize(new java.awt.Dimension(62, 32));

        btnSearch.setText("Buscar");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnSearchAll.setText("Mostrar Todos");
        btnSearchAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlNorthLayout = new javax.swing.GroupLayout(pnlNorth);
        pnlNorth.setLayout(pnlNorthLayout);
        pnlNorthLayout.setHorizontalGroup(
            pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNorthLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdoId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdoName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearch)
                .addGap(18, 18, 18)
                .addComponent(btnSearchAll)
                .addContainerGap())
        );
        pnlNorthLayout.setVerticalGroup(
            pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNorthLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnSearch)
                    .addComponent(btnSearchAll)
                    .addComponent(rdoName)
                    .addComponent(rdoId)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        pnlCenter.add(pnlNorth, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(pnlCenter, java.awt.BorderLayout.CENTER);

        btnClose.setText("Cerrar");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        jPanel1.add(btnClose);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        initializeTable();
        DefaultTableModel model = (DefaultTableModel) tblProducts.getModel();
        Object rowData[] = new Object[3];//No columnas
        Product objProduct = null;
        if(this.rdoId.isSelected()){
            try {
                objProduct = productAccess.findById(Long.parseLong(this.txtSearch.getText()));
                
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
                objProduct = productAccess.findByName(this.txtSearch.getText());
                rowData[0] = objProduct.getProductId();
                rowData[1] = objProduct.getName();
                rowData[2] = objProduct.getDescription();
                
                model.addRow(rowData);
                
            } catch (Exception ex) {
                Logger.getLogger(GUIProductsFind.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnSearchAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchAllActionPerformed
        try {
            fillTable(productAccess.findAll());
        } catch (Exception ex) {
            Logger.getLogger(GUIProductsFind.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchAllActionPerformed
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearchAll;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlNorth;
    private javax.swing.JRadioButton rdoId;
    private javax.swing.JRadioButton rdoName;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
    
    @Override
    public void actualizar() {
        try {
            fillTable(productAccess.findAll() );
        } catch (Exception ex) {
            Logger.getLogger(GUIProductsFind.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
