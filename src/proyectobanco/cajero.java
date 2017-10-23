package proyectobanco;
import static java.lang.Integer.parseInt;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class cajero extends javax.swing.JFrame {
    public cajero() {
        initComponents();
        setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        loginBTN = new javax.swing.JButton();
        usu1TXT = new javax.swing.JTextField();
        contraTXT = new javax.swing.JPasswordField();
        cerrarBTN = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
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

        jLabel2.setFont(new java.awt.Font("Cambria Math", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("INGRESE EL NUMERO DE LA TARJETA");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 440, 20));

        jLabel3.setFont(new java.awt.Font("Cambria Math", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("INGRESE SU PIN");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 200, -1));

        loginBTN.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        loginBTN.setText("INICIAR SESION");
        loginBTN.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        loginBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginBTN.setOpaque(false);
        loginBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBTNActionPerformed(evt);
            }
        });
        getContentPane().add(loginBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 360, 120, 40));

        usu1TXT.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        usu1TXT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usu1TXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usu1TXTActionPerformed(evt);
            }
        });
        usu1TXT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                usu1TXTKeyTyped(evt);
            }
        });
        getContentPane().add(usu1TXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 250, 40));

        contraTXT.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        contraTXT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        contraTXT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                contraTXTKeyTyped(evt);
            }
        });
        getContentPane().add(contraTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 250, 40));

        cerrarBTN.setBackground(new java.awt.Color(255, 255, 255));
        cerrarBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar X.png"))); // NOI18N
        cerrarBTN.setContentAreaFilled(false);
        cerrarBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarBTNActionPerformed(evt);
            }
        });
        getContentPane().add(cerrarBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 30, 30));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/user_icon-icons.com_66546.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, 140));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo-login.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void loginBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBTNActionPerformed

        MySQL db = new MySQL();
        try {
            try{
                int tarjeta = parseInt(usu1TXT.getText());
                int pin = parseInt(contraTXT.getText());
                menu m = new menu();
                m.setVisible(true);
                //this.setVisible(false);
                db.MySQLConnection();
                db.validarUsuario(tarjeta, pin);
                db.getValues();
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "NO INGRESE LETRAS");
            }
        } catch (Exception ex) {
            Logger.getLogger(cajero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_loginBTNActionPerformed

    private void cerrarBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarBTNActionPerformed
        System.exit(0);
    }//GEN-LAST:event_cerrarBTNActionPerformed

    private void contraTXTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contraTXTKeyTyped
        int limite = 3;
        if(contraTXT.getText().length() > limite){
            JOptionPane.showMessageDialog(null, "CONTRASEÑA NO VALIDA");
            contraTXT.setText(null);
        }
    }//GEN-LAST:event_contraTXTKeyTyped

    private void usu1TXTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usu1TXTKeyTyped
        int limite = 16;
        if(usu1TXT.getText().length() > limite){
            JOptionPane.showMessageDialog(null, "NUMERO DE TARJETA INVALIDO");
            usu1TXT.setText(null);
        }
    }//GEN-LAST:event_usu1TXTKeyTyped

    private void usu1TXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usu1TXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usu1TXTActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cajero().setVisible(true);
            }
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cerrarBTN;
    private javax.swing.JPasswordField contraTXT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton loginBTN;
    private javax.swing.JTextField usu1TXT;
    // End of variables declaration//GEN-END:variables
}
