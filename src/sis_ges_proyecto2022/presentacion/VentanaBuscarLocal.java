/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sis_ges_proyecto2022.presentacion;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import sis_ges_proyecto2022.excepciones.LocalException;
import sis_ges_proyecto2022.logica.FachadaLogica;
import sis_ges_proyecto2022.logica.Local;
import sis_ges_proyecto2022.logica.Locales;

/**
 *
 * @author mauri
 */
public class VentanaBuscarLocal extends javax.swing.JFrame {

    /**
     * Creates new form VentanaBuscarLocal
     */
    
    String documento;
            
    public VentanaBuscarLocal(String documento) throws LocalException {
        initComponents();
        this.documento = documento;
        Locales locales = FachadaLogica.listaLocales(documento);
        DefaultTableModel modelo = (DefaultTableModel) tablaLocal.getModel();
        tablaLocal.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        Object[] datoFila = new Object[5];
            for (int i= 0; i < locales.getLocales().size(); i++) {

                Local local = (Local) locales.getLocales().get(i);
                
                datoFila[0] = local.getId();
                datoFila[1] = local.getNegocio();
                datoFila[2] = local.getNumero();
                datoFila[3] = local.getEncargado();
                datoFila[4] = local.getDireccion();
                //datoFila[4] = preg.getPuntos();

                modelo.addRow(datoFila);
            }
    }

    private VentanaBuscarLocal() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLocal = new javax.swing.JTable();
        Agregar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaLocal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Negocio", "Numero de local", "Encargado", "Direccion"
            }
        ));
        tablaLocal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaLocalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaLocal);

        Agregar1.setText("Agregar local");
        Agregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Agregar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(Agregar1)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(106, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(Agregar1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaLocalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaLocalMouseClicked
        // TODO add your handling code here:
        TableModel model = tablaLocal.getModel();
        int index = tablaLocal.getSelectedRow();
        String id = (String) model.getValueAt(index, 0);
        try {
            //System.out.println(documento);
            new VentanaModificarLocal(id).setVisible(true);
        } catch (LocalException ex) {
            Logger.getLogger(VentanaBuscarLocal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tablaLocalMouseClicked

    private void Agregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Agregar1ActionPerformed
        // TODO add your handling code here:
        new VentanaAgregarLocal(documento).setVisible(true);
    }//GEN-LAST:event_Agregar1ActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaBuscarLocal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaBuscarLocal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaBuscarLocal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaBuscarLocal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaBuscarLocal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaLocal;
    // End of variables declaration//GEN-END:variables
}