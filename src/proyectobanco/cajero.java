package proyectobanco;

import java.util.logging.Level;
import java.util.logging.Logger;

public class cajero extends javax.swing.JFrame {
    public cajero() {
        initComponents();
        setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        registroBTN = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        loginBTN = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        usuTXT = new javax.swing.JTextField();
        conPASS = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        registroBTN.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        registroBTN.setText("Registrarse");
        registroBTN.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        registroBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registroBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroBTNActionPerformed(evt);
            }
        });
        getContentPane().add(registroBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 100, 40));

        jLabel2.setFont(new java.awt.Font("Cambria Math", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuario");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 80, 20));

        jLabel3.setFont(new java.awt.Font("Cambria Math", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Contraseña");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, -1, -1));

        loginBTN.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        loginBTN.setText("Iniciar Sesion");
        loginBTN.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        loginBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBTNActionPerformed(evt);
            }
        });
        getContentPane().add(loginBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 100, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/2.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/3.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 70, 70));

        usuTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuTXTActionPerformed(evt);
            }
        });
        getContentPane().add(usuTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 140, 20));
        getContentPane().add(conPASS, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 140, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/green-background-920072_960_720.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void registroBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroBTNActionPerformed
        registro abrir = new registro ();
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_registroBTNActionPerformed

    private void usuTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuTXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuTXTActionPerformed

    private void loginBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBTNActionPerformed
        menu abrir = new menu();
        abrir.setVisible(true);
        this.setVisible(false);
        try {
            
            String usuario = "Roberto";
            String contra = "Maltez";
            
            MySQL db = new MySQL();
            db.crearConexion();
            db.validarUsuario(usuario, contra);
                    } catch (Exception ex) {
            Logger.getLogger(cajero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_loginBTNActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cajero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField conPASS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton loginBTN;
    private javax.swing.JButton registroBTN;
    private javax.swing.JTextField usuTXT;
    // End of variables declaration//GEN-END:variables
}
