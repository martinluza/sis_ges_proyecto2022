/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sis_ges_proyecto2022.presentacion;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import sis_ges_proyecto2022.excepciones.AfiliacionException;
import sis_ges_proyecto2022.excepciones.AfiliacionesException;
import sis_ges_proyecto2022.excepciones.LocalException;
import sis_ges_proyecto2022.logica.Afiliado;
import sis_ges_proyecto2022.logica.FachadaLogica;

/**
 *
 * @author mauri
 */
public class VentanaModificarAfiliado extends javax.swing.JFrame {
    
    /**
     * Creates new form VentanaModificarAfiliado
     */
    String documento;
    String estado;
    
    public VentanaModificarAfiliado(String documento, String estado) {
        initComponents();
        this.documento = documento;
        this.estado = estado;
        if (estado.equals("activo")){
            baja.setText("dar de baja");
        } else {
            baja.setText("reactivar");
        }
        documento1.setText(documento);
        Afiliado afiliado = new Afiliado();
        afiliado = FachadaLogica.buscarAfiliado(documento);
        nombre1.setText(afiliado.getNombre());
        apellido1.setText(afiliado.getApellido());
        nacionalidad1.setText(afiliado.getNacionalidad());
        direccion1.setText(afiliado.getDireccion());
        telefono1.setText(Integer.toString(afiliado.getTelefono()));
        mail1.setText(afiliado.getMail());
        //System.out.println(afiliado.getNacimiento());
        //afiliado.setNacimiento("0123-56-89");
        String y = afiliado.getNacimiento().substring(0, 4);
        String m = afiliado.getNacimiento().substring(5, 7);
        String d = afiliado.getNacimiento().substring(8, 10);
        nacimiento1.setText(d + "/" + m + "/" + y);
//        System.out.println(afiliado.getNacimiento());
//        System.out.println(y);
//        System.out.println(d);
//        System.out.println(m);
        rubro1.setText(afiliado.getRubro());
    }

    private VentanaModificarAfiliado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        documento1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nombre1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        apellido1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nacionalidad1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        direccion1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        telefono1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        mail1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        rubro1 = new javax.swing.JTextField();
        nacimiento1 = new javax.swing.JFormattedTextField();
        modificar = new javax.swing.JButton();
        Locales = new javax.swing.JButton();
        baja = new javax.swing.JToggleButton();
        volver = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        afiliacion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Documento:");

        documento1.setEditable(false);
        documento1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                documento1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre:");

        jLabel3.setText("Apelllido:");

        jLabel4.setText("Nacionalidad:");

        jLabel5.setText("Direccion:");

        jLabel6.setText("Telefono:");

        telefono1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefono1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Mail:");

        jLabel8.setText("Nacimiento:");

        jLabel9.setText("Rubro:");

        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        Locales.setText("Locales");
        Locales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocalesActionPerformed(evt);
            }
        });

        baja.setText("Dar de baja");
        baja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bajaActionPerformed(evt);
            }
        });

        volver.setText("Volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });

        jLabel10.setText("Modificar afiliado");

        afiliacion.setText("Afiliacion");
        afiliacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                afiliacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1))
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(volver)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(baja)
                        .addGap(29, 29, 29)
                        .addComponent(modificar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Locales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rubro1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(mail1)
                            .addComponent(telefono1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nacionalidad1)
                                    .addComponent(apellido1)
                                    .addComponent(direccion1, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(documento1)
                            .addComponent(nombre1)
                            .addComponent(nacimiento1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(afiliacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(113, 113, 113))))
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jLabel10)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(documento1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(apellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nacionalidad1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(direccion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(telefono1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(mail1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(nacimiento1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(rubro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Locales)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(afiliacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modificar)
                    .addComponent(baja)
                    .addComponent(volver))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void documento1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_documento1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_documento1ActionPerformed

    private void telefono1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefono1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefono1ActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        // TODO add your handling code here:
        
        String nombre = this.nombre1.getText();
        String apellido = this.apellido1.getText();
        String nacionalidad = this.nacionalidad1.getText();
        String direccion = this.direccion1.getText();
        int telefono = Integer.parseInt(this.telefono1.getText());   
        String mail = this.mail1.getText();
        String nacimiento = this.nacimiento1.getText();
        String rubro = this.rubro1.getText();
        Afiliado afiliado = new Afiliado();
        afiliado.setDocumento(documento);
        afiliado.setNombre(nombre);
        afiliado.setApellido(apellido);
        afiliado.setNacionalidad(nacionalidad);
        afiliado.setDireccion(direccion);
        afiliado.setTelefono(telefono);
        afiliado.setMail(mail);
        afiliado.setNacimiento(nacimiento);
        afiliado.setRubro(rubro);
        try {
            FachadaLogica.modificarAfiliado(afiliado);
            JLabel mensajeLbl = new JLabel();
            JOptionPane.showMessageDialog(mensajeLbl, "Afiliado modificado con exito");
        } catch (AfiliacionException ex) {
            Logger.getLogger(VentanaModificarAfiliado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_modificarActionPerformed

    private void LocalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocalesActionPerformed
        try {
            // TODO add your handling code here:
            new VentanaBuscarLocal(documento, estado).setVisible(true);
            this.dispose();
        } catch (LocalException ex) {
            Logger.getLogger(VentanaModificarAfiliado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_LocalesActionPerformed

    private void bajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bajaActionPerformed
        if (estado.equals("activo")){    
            try {
                FachadaLogica.bajaAfiliado(documento);
                JLabel mensajeLbl = new JLabel();
                JOptionPane.showMessageDialog(mensajeLbl, "Afiliado dado de baja con exito");
            } catch (AfiliacionException ex) {
                Logger.getLogger(VentanaModificarAfiliado.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                FachadaLogica.altaAfiliado(documento);
                JLabel mensajeLbl = new JLabel();
                JOptionPane.showMessageDialog(mensajeLbl, "Afiliado reactivado con exito");
                
            } catch (AfiliacionException ex) {
                Logger.getLogger(VentanaModificarAfiliado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        new VentanaBuscarAfiliado().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bajaActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        // TODO add your handling code here:
        new VentanaBuscarAfiliado().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_volverActionPerformed

    private void afiliacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_afiliacionActionPerformed
        try {
            // TODO add your handling code here:
            new VentanaModificarAfiliacion(documento, estado).setVisible(true);
        } catch (AfiliacionesException ex) {
            Logger.getLogger(VentanaModificarAfiliado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VentanaModificarAfiliado.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_afiliacionActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaModificarAfiliado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaModificarAfiliado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaModificarAfiliado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaModificarAfiliado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaModificarAfiliado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Locales;
    private javax.swing.JButton afiliacion;
    private javax.swing.JTextField apellido1;
    private javax.swing.JToggleButton baja;
    private javax.swing.JTextField direccion1;
    private javax.swing.JTextField documento1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField mail1;
    private javax.swing.JButton modificar;
    private javax.swing.JFormattedTextField nacimiento1;
    private javax.swing.JTextField nacionalidad1;
    private javax.swing.JTextField nombre1;
    private javax.swing.JTextField rubro1;
    private javax.swing.JTextField telefono1;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
