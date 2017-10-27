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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 204, 255));
        setUndecorated(true);

        rutaTXT.setEditable(false);
        rutaTXT.setFont(new java.awt.Font("Cambria Math", 1, 14)); // NOI18N
        rutaTXT.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        rutaBTN.setFont(new java.awt.Font("Cambria Math", 1, 14)); // NOI18N
        rutaBTN.setText("RUTA");
        rutaBTN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        rutaBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rutaBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rutaBTNMouseClicked(evt);
            }
        });

        contenidoTXT.setEditable(false);
        contenidoTXT.setColumns(20);
        contenidoTXT.setFont(new java.awt.Font("Cambria Math", 1, 14)); // NOI18N
        contenidoTXT.setRows(5);
        contenidoTXT.setText("NOMBRE: \nAPELLIDO:\nID CLIENTE:\n# CUENTA:\nOPERACION: \nCANTIDAD:\nFECHA:");
        jScrollPane1.setViewportView(contenidoTXT);

        reciboBTN.setFont(new java.awt.Font("Cambria Math", 1, 14)); // NOI18N
        reciboBTN.setText("GENERAR RECIBO");
        reciboBTN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        reciboBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reciboBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reciboBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(rutaTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(rutaBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(reciboBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rutaTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rutaBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(reciboBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
