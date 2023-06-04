package com.unicauca.edu.co.openmarket.client.presentation;

import com.unicauca.edu.co.openmarket.client.access.ProductAccessImplSockets;
import com.unicauca.edu.co.openmarket.client.commands.OMAddProductCommand;
import com.unicauca.edu.co.openmarket.client.commands.OMInvoker;
import com.unicauca.edu.co.openmarket.client.infra.Messages;
import static com.unicauca.edu.co.openmarket.client.infra.Messages.*;
import com.unicauca.edu.co.openmarket.commons.domain.Product;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.*;
import reloj.frameworkobsobs.Observador;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import com.unicauca.edu.co.openmarket.client.presentation.GUIBuyer;
/**
 *
 * @author Libardo Pantoja
 */
public class GUIBuy extends javax.swing.JFrame implements Observador{

    private long contID = 0;
    private ProductAccessImplSockets productAccess;
    private boolean addOption;
    private OMInvoker ominvoker;
    private JFrame frame;
    JLabel etiquetaProducto = new JLabel();

    /**
     * Creates new form GUIProducts
     */
    public GUIBuy(GUIBuyer aThis, boolean par, ProductAccessImplSockets productAccess1) {
       
        initComponents();
        productAccess = new ProductAccessImplSockets();
        ominvoker = new OMInvoker();
        /*setTitle("Realizar Compra");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());*/
        //stateInitial();
        setLocationRelativeTo(null);

    }

    public ProductAccessImplSockets getProductAccess() {
        return productAccess;
    }

    public void setProductAccess(ProductAccessImplSockets productAccess) {
        this.productAccess = productAccess;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlNorth = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlCenter = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        btnAccept = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        pnlSouth = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Productos");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("¿Como quieres pagar?");

        javax.swing.GroupLayout pnlNorthLayout = new javax.swing.GroupLayout(pnlNorth);
        pnlNorth.setLayout(pnlNorthLayout);
        pnlNorthLayout.setHorizontalGroup(
            pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNorthLayout.createSequentialGroup()
                .addContainerGap(270, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(267, 267, 267))
        );
        pnlNorthLayout.setVerticalGroup(
            pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNorthLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        getContentPane().add(pnlNorth, java.awt.BorderLayout.PAGE_START);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Selecciona el tipo de Tarjeta");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "    ","Visa", "Mastercard", "PSE" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        btnAccept.setText("Aceptar");
        btnAccept.setAlignmentX(10.0F);
        btnAccept.setAlignmentY(50.0F);
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlCenterLayout = new javax.swing.GroupLayout(pnlCenter);
        pnlCenter.setLayout(pnlCenterLayout);
        pnlCenterLayout.setHorizontalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCenterLayout.createSequentialGroup()
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCenterLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCenterLayout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(222, 222, 222))
        );
        pnlCenterLayout.setVerticalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCenterLayout.createSequentialGroup()
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlCenterLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65)
                        .addComponent(jLabel3)))
                .addContainerGap(400, Short.MAX_VALUE))
        );

        getContentPane().add(pnlCenter, java.awt.BorderLayout.CENTER);

        pnlSouth.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlSouth.setAlignmentX(1.5F);
        pnlSouth.setAlignmentY(5.0F);

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSouthLayout = new javax.swing.GroupLayout(pnlSouth);
        pnlSouth.setLayout(pnlSouthLayout);
        pnlSouthLayout.setHorizontalGroup(
            pnlSouthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSouthLayout.createSequentialGroup()
                .addGap(390, 390, 390)
                .addComponent(btnCerrar))
        );
        pnlSouthLayout.setVerticalGroup(
            pnlSouthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSouthLayout.createSequentialGroup()
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(pnlSouth, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents
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
            java.util.logging.Logger.getLogger(GUIBuy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIBuy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIBuy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIBuy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIBuy(this, true, productAccess).setVisible(true);
            }
        });*/
    }

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed
       
         btnAccept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) jComboBox1.getSelectedItem();
                if (selectedOption.equals("Visa")) {
                    showMenuOption1();
                } else if (selectedOption.equals("Mastercard")) {
                    showMenuOption2();
                } else if (selectedOption.equals("PSE")) {
                    showMenuOption3();
                }
                
            }
            
        });
         
         
        frame.setLayout(new FlowLayout());
        frame.add(jComboBox1);
        //frame.add(btnAccept);
        frame.pack();
        frame.setVisible(true);
         
    }//GEN-LAST:event_btnAcceptActionPerformed
    private void stateEdit() {
       
       
        //btnCancelar.setVisible(true);
        btnCerrar.setVisible(false);

       /* txtId.setEnabled(true);
        txtName.setEnabled(true);
        txtDescription.setEnabled(true);*/
    }

    private void stateInitial() {
      
        //btnCancelar.setVisible(false);
        btnCerrar.setVisible(true);
       
       /* txtId.setEnabled(false);
        txtName.setEnabled(false);
        txtDescription.setEnabled(false);*/
    

    }
    
     private void showMenuOption1() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 10));

        JLabel lblNumeroTarjeta = new JLabel("Número de Tarjeta:");
        JTextField txtNumeroTarjeta = new JTextField();

        JLabel lblFechaVencimiento = new JLabel("Fecha de Vencimiento:");
        JTextField txtFechaVencimiento = new JTextField();

        JLabel lblCodigoSeguridad = new JLabel("Codigo de Seguridad:");
        JTextField txtCodigoSeguridad = new JTextField();

        JLabel lblNombreTitular = new JLabel("Nombre del Titular:");
        JTextField txtNombreTitular = new JTextField();

        JLabel lblDireccionFact = new JLabel("Direccion de Facturación:");
        JTextField txtDireccionFact = new JTextField();

        panel.add(lblNumeroTarjeta);
        panel.add(txtNumeroTarjeta);
        panel.add(lblFechaVencimiento);
        panel.add(txtFechaVencimiento); 
        panel.add(lblCodigoSeguridad);
        panel.add(txtCodigoSeguridad);
        panel.add(lblNombreTitular);
        panel.add(txtNombreTitular);
        panel.add(lblDireccionFact);
        panel.add(txtDireccionFact);
    

     int result = JOptionPane.showConfirmDialog(frame, panel, "Ingrese los datos", JOptionPane.OK_CANCEL_OPTION);

     if (result == JOptionPane.OK_OPTION) {
         String numeroTarjeta = txtNumeroTarjeta.getText();
         String FechaVencimiento = txtFechaVencimiento.getText();
         String CodigoSeguridad = txtCodigoSeguridad.getText();
         String nombreTitular = txtNombreTitular.getText();
         String DireccionFact = txtDireccionFact.getText();
         

         if (numeroTarjeta.isEmpty() || FechaVencimiento.isEmpty() || CodigoSeguridad.isEmpty() || nombreTitular.isEmpty() || DireccionFact.isEmpty()) {
             JOptionPane.showMessageDialog(frame, "Debe completar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
             showMenuOption1(); // Vuelve a llamar al método para mostrar el cuadro de diálogo nuevamente
         } else {
             String mensaje = "Número de tarjeta: " + numeroTarjeta  + "\n Fecha de Vencimiento: " + FechaVencimiento + "\n Codigo de Seguridad: "+CodigoSeguridad+ "\n Nombre del titular: " +nombreTitular
                 + "\n Direccion de Facturacion: " +DireccionFact;
             JOptionPane.showMessageDialog(frame, mensaje);
            }
        }
     
     
    }
     
    private void showMenuOption2() {
       JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 10));

        JLabel lblNumeroTarjeta = new JLabel("Número de Tarjeta:");
        JTextField txtNumeroTarjeta = new JTextField();

        JLabel lblFechaVencimiento = new JLabel("Fecha de Vencimiento:");
        JTextField txtFechaVencimiento = new JTextField();

        JLabel lblCodigoSeguridad = new JLabel("Codigo de Seguridad:");
        JTextField txtCodigoSeguridad = new JTextField();

        JLabel lblNombreTitular = new JLabel("Nombre del Titular:");
        JTextField txtNombreTitular = new JTextField();

        JLabel lblDireccionFact = new JLabel("Direccion de Facturación:");
        JTextField txtDireccionFact = new JTextField();

        panel.add(lblNumeroTarjeta);
        panel.add(txtNumeroTarjeta);
        panel.add(lblFechaVencimiento);
        panel.add(txtFechaVencimiento); 
        panel.add(lblCodigoSeguridad);
        panel.add(txtCodigoSeguridad);
        panel.add(lblNombreTitular);
        panel.add(txtNombreTitular);
        panel.add(lblDireccionFact);
        panel.add(txtDireccionFact);
    

     int result = JOptionPane.showConfirmDialog(frame, panel, "Ingrese los datos", JOptionPane.OK_CANCEL_OPTION);

     if (result == JOptionPane.OK_OPTION) {
         String numeroTarjeta = txtNumeroTarjeta.getText();
         String FechaVencimiento = txtFechaVencimiento.getText();
         String CodigoSeguridad = txtCodigoSeguridad.getText();
         String nombreTitular = txtNombreTitular.getText();
         String DireccionFact = txtDireccionFact.getText();
         

         if (numeroTarjeta.isEmpty() || FechaVencimiento.isEmpty() || CodigoSeguridad.isEmpty() || nombreTitular.isEmpty() || DireccionFact.isEmpty()) {
             JOptionPane.showMessageDialog(frame, "Debe completar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
             showMenuOption1(); // Vuelve a llamar al método para mostrar el cuadro de diálogo nuevamente
         } else {
             String mensaje = "Número de tarjeta: " + numeroTarjeta  + "\n Fecha de Vencimiento: " + FechaVencimiento + "\n Codigo de Seguridad: "+CodigoSeguridad+ "\n Nombre del titular: " +nombreTitular
                 + "\n Direccion de Facturacion: " +DireccionFact;
             JOptionPane.showMessageDialog(frame, mensaje);
            }
        }
    }

    private void showMenuOption3() {
       JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 10));

        JLabel lblBanco = new JLabel("Banco:");
        JTextField txtBanco = new JTextField();

        JLabel lblTipoCuenta = new JLabel("Tipo de Cuenta");
        JTextField txtTipoCuenta = new JTextField();

        JLabel lblNumeroCuenta = new JLabel("Numero de cuenta:");
        JTextField txtNumeroCuenta = new JTextField();

        JLabel lblNumeroId = new JLabel("Numero de identificacion");
        JTextField txtNumeroId = new JTextField();

        JLabel lblNombres = new JLabel("Nombre y Apellido");
        JTextField txtNombres = new JTextField();
        
        JLabel lblCorreoElec = new JLabel("Correo electronico:");
        JTextField txtCorreoElec = new JTextField();
        
        JLabel lblTel = new JLabel("Telefono de contacto:");
        JTextField txtTel = new JTextField();


        panel.add(lblBanco);
        panel.add(txtBanco);
        panel.add(lblTipoCuenta);
        panel.add(txtTipoCuenta); 
        panel.add(lblNumeroCuenta);
        panel.add(txtNumeroCuenta);
        panel.add(lblNumeroId);
        panel.add(txtNumeroId);
        panel.add(lblNombres);
        panel.add(txtNombres);
        panel.add(lblCorreoElec);
        panel.add(txtCorreoElec);
        panel.add(lblTel);
        panel.add(txtTel);
    

     int result = JOptionPane.showConfirmDialog(frame, panel, "Ingrese los datos", JOptionPane.OK_CANCEL_OPTION);

     if (result == JOptionPane.OK_OPTION) {
         String Banco = txtBanco.getText();
         String TipoCuenta = txtTipoCuenta.getText();
         String NumeroCuenta  = txtNumeroCuenta.getText();
         String NumeroId = txtNumeroId.getText();
         String Nombres = txtNombres.getText();
         String CorreoElec = txtCorreoElec.getText();
         String Tel = txtTel.getText();
         

         if (Banco.isEmpty() || TipoCuenta.isEmpty() || NumeroCuenta.isEmpty() || NumeroId.isEmpty() || Nombres.isEmpty() || CorreoElec.isEmpty()|| Tel.isEmpty()) {
             JOptionPane.showMessageDialog(frame, "Debe completar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
             showMenuOption1(); // Vuelve a llamar al método para mostrar el cuadro de diálogo nuevamente
         } else {
             String mensaje = "Banco: " + Banco  + "\n Tipo de Cuenta: " + TipoCuenta + "\n Numero de Cuenta: "+NumeroCuenta+ "\n Numero de identificación: " +NumeroId
                 + "\n Nombres y Apellidos " +Nombres+ "\n Correo Electronivo " +CorreoElec +"\n Telefono: ";
             JOptionPane.showMessageDialog(frame, mensaje);
            }
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlNorth;
    private javax.swing.JPanel pnlSouth;
    // End of variables declaration//GEN-END:variables

   /* private void stateNew() {
       
        btnCancelar.setVisible(true);
        btnCerrar.setVisible(false);
      
        txtId.setEnabled(false);
        txtName.setEnabled(true);
        txtDescription.setEnabled(true);
       

    }
*/
    private void cleanControls() {
       // txtId.setText("");
        //txtName.setText("");
        //txtDescription.setText("");
    }
/*
    private void addProduct() throws Exception {
        Product product = new Product();
        this.contID ++;
        String name = txtName.getText().trim();
        String description = txtDescription.getText().trim();
        
        product.setProductId(contID);
        product.setName(name);
        product.setDescription(description);
        
        OMAddProductCommand comm= new OMAddProductCommand(product, productAccess);
        ominvoker.addCommand(comm);
        ominvoker.execute();
    
        if (comm.result()) {
            Messages.successMessage("Se grabó con éxito", "Atención");
            cleanControls();
            stateInitial();
        } else {
            Messages.successMessage("Error al grabar, lo siento mucho", "Atención");
        }
    }

    private void editProduct() throws Exception {
        String id = txtId.getText().trim();
        if (id.equals("")) {
            successMessage("Debe buscar el producto a editar", "Atención");
            txtId.requestFocus();
            return;
        }
        Long productId = Long.parseLong(id);
        Product prod = new Product();
        prod.setName(txtName.getText().trim());
        prod.setDescription(txtDescription.getText().trim());

        if (productAccess.edit(productId, prod)) {
            Messages.successMessage("Se editó con éxito", "Atención");
            cleanControls();
            stateInitial();
        } else {
            Messages.successMessage("Error al editar, lo siento mucho", "Atención");
        }
    }*/

      @Override
    public void actualizar() {
        try {
            fillTable(productAccess.findAll() );
        } catch (Exception ex) {
            Logger.getLogger(GUIBuyer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fillTable(java.util.List<Product> findAll) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     public void mostrarTabla(){
        try {
            fillTable(productAccess.findAll());
        } catch (Exception ex) {
            Logger.getLogger(GUIBuyer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     /*listProdcuts.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // Obtén el producto seleccionado de la lista
        Product productoSeleccionado = (Product) listaProductos.getSelectedItem();

        // Muestra los datos del producto en la etiqueta de texto
        etiquetaProducto.setText("Nombre: " + productoSeleccionado.getName()+ ", Precio: " + productoSeleccionado.getDescription());
    }
});*/
     
     
}