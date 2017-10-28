package proyectobanco;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import static proyectobanco.MySQL.ID;
import static proyectobanco.MySQL.apellido;
import static proyectobanco.MySQL.cantidad;
import static proyectobanco.MySQL.cuenta;
import static proyectobanco.MySQL.nombre;
import static proyectobanco.MySQL.operacion;

public class recibo extends javax.swing.JFrame {
    
    public recibo() {
        initComponents();
        setLocationRelativeTo(null);
        fecha f = new fecha();
        f.fecha();
        
        contenidoTXT.setText(" NOMBRE: "+ nombre + "\n APELLIDO: " + apellido + 
                             "\n ID CLIENTE: "+ ID + "\n # CUENTA: "+ cuenta + "\n OPERACION: " + operacion +
                             "\n CANTIDAD: $" + cantidad + "\n FECHA Y HORA: " + f.fecha);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rutaTXT = new javax.swing.JTextField();
        rutaBTN = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        contenidoTXT = new javax.swing.JTextArea();
        reciboBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(new java.awt.Color(153, 153, 153));
        setMinimumSize(new java.awt.Dimension(443, 401));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rutaTXT.setEditable(false);
        rutaTXT.setFont(new java.awt.Font("Cambria Math", 1, 14)); // NOI18N
        rutaTXT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(rutaTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 230, 34));

        rutaBTN.setBackground(new java.awt.Color(204, 204, 204));
        rutaBTN.setFont(new java.awt.Font("Cambria Math", 1, 14)); // NOI18N
        rutaBTN.setText("RUTA");
        rutaBTN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        rutaBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rutaBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rutaBTNMouseClicked(evt);
            }
        });
        rutaBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rutaBTNActionPerformed(evt);
            }
        });
        getContentPane().add(rutaBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 100, 30));

        contenidoTXT.setEditable(false);
        contenidoTXT.setColumns(20);
        contenidoTXT.setFont(new java.awt.Font("Cambria Math", 1, 14)); // NOI18N
        contenidoTXT.setRows(5);
        contenidoTXT.setText("NOMBRE: \n\nAPELLIDO:\n\nID CLIENTE:\n\n# CUENTA:\n\nOPERACION: \n\nCANTIDAD:\n\nFECHA:");
        jScrollPane1.setViewportView(contenidoTXT);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 392, 261));

        reciboBTN.setBackground(new java.awt.Color(204, 204, 204));
        reciboBTN.setFont(new java.awt.Font("Cambria Math", 1, 14)); // NOI18N
        reciboBTN.setText("GENERAR RECIBO");
        reciboBTN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        reciboBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reciboBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reciboBTNActionPerformed(evt);
            }
        });
        getContentPane().add(reciboBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, 173, 37));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rutaBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rutaBTNMouseClicked
        JFileChooser dlg = new JFileChooser();
        int option = dlg.showSaveDialog(this);
        if(option == JFileChooser.APPROVE_OPTION){
            File f = dlg.getSelectedFile();
            rutaTXT.setText(f.toString());
        }
        
    }//GEN-LAST:event_rutaBTNMouseClicked

    private void reciboBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reciboBTNActionPerformed
        // TODO add your handling code here:
        String ruta = rutaTXT.getText();
        String recibo = contenidoTXT.getText();
        
        try{
            FileOutputStream archivo = new FileOutputStream(ruta+".pdf");
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            doc.add(new Paragraph(recibo));
            doc.close();
            JOptionPane.showMessageDialog(null, "RECIBO CREADO EXITOSAMENTE", "MENSAJE INFORMATIVO",
            JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR EN EL RECIVO", "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_reciboBTNActionPerformed

    private void rutaBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rutaBTNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rutaBTNActionPerformed

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
            java.util.logging.Logger.getLogger(recibo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(recibo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(recibo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(recibo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new recibo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea contenidoTXT;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton reciboBTN;
    private javax.swing.JButton rutaBTN;
    private javax.swing.JTextField rutaTXT;
    // End of variables declaration//GEN-END:variables
}
