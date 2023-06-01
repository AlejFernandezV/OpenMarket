/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.unicauca.edu.co.openmarket.client.presentation;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import javax.swing.ImageIcon;

/**
 *
 * @author Personal
 */
public class GUIConfirmedProduct extends javax.swing.JFrame {
    
    /**
     * Creates new form GUIConfirmedPay
     */
    public GUIConfirmedProduct() {
        initComponents();
        setSize(400, 300);
        Titulo();
        
    }

     /**
     * Mensaje inicial del panel superior
     */
    private void Titulo() {
        StringBuilder sb = new StringBuilder(90);
        sb.append("<html>" + "Tu pedido ha llegado a su destino, con exito!.<br>"
                + "No olvides darnos tu calificación, es muy importante para nosotros &#128077.<br>"
                + "</html>");
        lblTitulo.setText(sb.toString());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSouth = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JButton();
        btnCalificar = new javax.swing.JButton();
        pnlCenter = new javax.swing.JPanel();
        btnStar1 = new javax.swing.JToggleButton();
        btnStar2 = new javax.swing.JToggleButton();
        btnStar3 = new javax.swing.JToggleButton();
        btnStar4 = new javax.swing.JToggleButton();
        btnStar5 = new javax.swing.JToggleButton();
        lblCalificar = new javax.swing.JLabel();
        pnlNorth = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calificación");

        pnlSouth.setMinimumSize(new java.awt.Dimension(400, 38));
        pnlSouth.setPreferredSize(new java.awt.Dimension(400, 38));

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        pnlSouth.add(btnCerrar);

        btnCalificar.setBackground(new java.awt.Color(102, 255, 102));
        btnCalificar.setText("¡Calificar!");
        btnCalificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalificarActionPerformed(evt);
            }
        });
        pnlSouth.add(btnCalificar);

        getContentPane().add(pnlSouth, java.awt.BorderLayout.SOUTH);

        pnlCenter.setMinimumSize(new java.awt.Dimension(400, 300));
        pnlCenter.setPreferredSize(new java.awt.Dimension(400, 300));

        btnStar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/unicauca/edu/co/openmarket/client/presentation/star.png"))); // NOI18N
        btnStar1.setBorder(null);
        btnStar1.setContentAreaFilled(false);
        btnStar1.setRequestFocusEnabled(false);
        btnStar1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/unicauca/edu/co/openmarket/client/presentation/starSelected.png"))); // NOI18N
        btnStar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStar1ActionPerformed(evt);
            }
        });

        btnStar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/unicauca/edu/co/openmarket/client/presentation/star.png"))); // NOI18N
        btnStar2.setBorder(null);
        btnStar2.setContentAreaFilled(false);
        btnStar2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/unicauca/edu/co/openmarket/client/presentation/starSelected.png"))); // NOI18N
        btnStar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStar2ActionPerformed(evt);
            }
        });

        btnStar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/unicauca/edu/co/openmarket/client/presentation/star.png"))); // NOI18N
        btnStar3.setBorder(null);
        btnStar3.setContentAreaFilled(false);
        btnStar3.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/unicauca/edu/co/openmarket/client/presentation/starSelected.png"))); // NOI18N
        btnStar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStar3ActionPerformed(evt);
            }
        });

        btnStar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/unicauca/edu/co/openmarket/client/presentation/star.png"))); // NOI18N
        btnStar4.setBorder(null);
        btnStar4.setContentAreaFilled(false);
        btnStar4.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/unicauca/edu/co/openmarket/client/presentation/starSelected.png"))); // NOI18N
        btnStar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStar4ActionPerformed(evt);
            }
        });

        btnStar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/unicauca/edu/co/openmarket/client/presentation/star.png"))); // NOI18N
        btnStar5.setBorder(null);
        btnStar5.setContentAreaFilled(false);
        btnStar5.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/unicauca/edu/co/openmarket/client/presentation/starSelected.png"))); // NOI18N
        btnStar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStar5ActionPerformed(evt);
            }
        });

        lblCalificar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCalificar.setForeground(new java.awt.Color(102, 102, 102));
        lblCalificar.setText("Califique su pedido");

        javax.swing.GroupLayout pnlCenterLayout = new javax.swing.GroupLayout(pnlCenter);
        pnlCenter.setLayout(pnlCenterLayout);
        pnlCenterLayout.setHorizontalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCenterLayout.createSequentialGroup()
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCenterLayout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(btnStar1)
                        .addGap(18, 18, 18)
                        .addComponent(btnStar2)
                        .addGap(18, 18, 18)
                        .addComponent(btnStar3)
                        .addGap(18, 18, 18)
                        .addComponent(btnStar4)
                        .addGap(18, 18, 18)
                        .addComponent(btnStar5))
                    .addGroup(pnlCenterLayout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(lblCalificar)))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        pnlCenterLayout.setVerticalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCenterLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(lblCalificar)
                .addGap(18, 18, 18)
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnStar5)
                    .addComponent(btnStar4)
                    .addComponent(btnStar3)
                    .addComponent(btnStar2)
                    .addComponent(btnStar1))
                .addContainerGap(186, Short.MAX_VALUE))
        );

        getContentPane().add(pnlCenter, java.awt.BorderLayout.CENTER);

        pnlNorth.setMinimumSize(new java.awt.Dimension(276, 41));
        pnlNorth.setPreferredSize(new java.awt.Dimension(362, 50));

        lblTitulo.setText("lblTitulo");

        javax.swing.GroupLayout pnlNorthLayout = new javax.swing.GroupLayout(pnlNorth);
        pnlNorth.setLayout(pnlNorthLayout);
        pnlNorthLayout.setHorizontalGroup(
            pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNorthLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        pnlNorthLayout.setVerticalGroup(
            pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNorthLayout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(pnlNorth, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStar5ActionPerformed
        // TODO add your handling code here:
        String cal = "";
        this.btnStar1.setSelected(false);
        this.btnStar2.setSelected(false);
        this.btnStar3.setSelected(false);
        this.btnStar4.setSelected(false);

        if (this.btnStar5.isSelected()) {
            this.btnStar1.setSelected(true);
            this.btnStar2.setSelected(true);
            this.btnStar3.setSelected(true);
            this.btnStar4.setSelected(true);
            cal = "5";
        } else {
            this.btnStar1.setSelected(false);
            this.btnStar2.setSelected(false);
            this.btnStar3.setSelected(false);
            this.btnStar4.setSelected(false);
        }
        
    }//GEN-LAST:event_btnStar5ActionPerformed

    private void btnStar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStar4ActionPerformed
        // TODO add your handling code here:
        String cal ="";
        this.btnStar1.setSelected(false);
        this.btnStar2.setSelected(false);
        this.btnStar3.setSelected(false);
        this.btnStar5.setSelected(false);
        if (this.btnStar4.isSelected()) {
            this.btnStar1.setSelected(true);
            this.btnStar2.setSelected(true);
            this.btnStar3.setSelected(true);
            cal = "4";
        } else {
            this.btnStar1.setSelected(false);
            this.btnStar2.setSelected(false);
            this.btnStar3.setSelected(false);
        }
    }//GEN-LAST:event_btnStar4ActionPerformed

    private void btnStar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStar3ActionPerformed
        // TODO add your handling code here:
        String cal ="";
        this.btnStar4.setSelected(false);
        this.btnStar5.setSelected(false);
        if (this.btnStar3.isSelected()) {
            this.btnStar1.setSelected(true);
            this.btnStar2.setSelected(true);
            cal = "3";
        } else {
            this.btnStar1.setSelected(false);
            this.btnStar2.setSelected(false);
        }
    }//GEN-LAST:event_btnStar3ActionPerformed

    private void btnStar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStar2ActionPerformed
        // TODO add your handling code here:
        String cal = "";
        this.btnStar1.setSelected(false);
        this.btnStar3.setSelected(false);
        this.btnStar4.setSelected(false);
        this.btnStar5.setSelected(false);
        if (this.btnStar2.isSelected()) {
            this.btnStar1.setSelected(true);
            cal = "2"; 
        } else {
            this.btnStar1.setSelected(false);
        }
    }//GEN-LAST:event_btnStar2ActionPerformed

    private void btnStar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStar1ActionPerformed
        // TODO add your handling code here:
        this.btnStar1.setSelected(true);
        this.btnStar2.setSelected(false);
        this.btnStar3.setSelected(false);
        this.btnStar4.setSelected(false);
        this.btnStar5.setSelected(false);
        if (this.btnStar1.isSelected()) {
            this.btnStar1.setSelected(true);
            this.btnStar2.setSelected(false);
            this.btnStar3.setSelected(false);
            this.btnStar4.setSelected(false);
            this.btnStar5.setSelected(false);
        }
    }//GEN-LAST:event_btnStar1ActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnCalificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCalificarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GUIConfirmedProduct gui = new GUIConfirmedProduct();
        gui.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalificar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JToggleButton btnStar1;
    private javax.swing.JToggleButton btnStar2;
    private javax.swing.JToggleButton btnStar3;
    private javax.swing.JToggleButton btnStar4;
    private javax.swing.JToggleButton btnStar5;
    private javax.swing.JLabel lblCalificar;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlNorth;
    private javax.swing.JPanel pnlSouth;
    // End of variables declaration//GEN-END:variables

    
}
