/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginRegistration;

/**
 *
 * @author rahat
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import net.codejava.sql.ConnectionToSQL;

public class Registration extends javax.swing.JFrame {

    /**
     * Creates new form Registration
     */
    public Registration() {
        initComponents();
    }
    
    Connection connection = null;
    
    public void clear(){
        registerName_TF.setText("");
        contact_TF.setText("");
        address_TF.setText("");
        nid_TF.setText("");
        position_TF.setText("");
        password_TF.setText("");
        password_TF1.setText("");
    }
    
    public void submitDataToDataBase() {
        try{
            connection = ConnectionToSQL.getConnection();
            
            String url = "insert into REGISTRATION values(?, ?, ?, ?, ?, ?)";
            
            PreparedStatement ps = connection.prepareStatement(url);
            ps.setString(1, registerName_TF.getText());
            ps.setString(2, contact_TF.getText());
            ps.setString(3, address_TF.getText());
            ps.setString(4, nid_TF.getText());
            ps.setString(5, position_TF.getText());
            ps.setString(6, password_TF.getText());
            
            int i = ps.executeUpdate();
            
            if(i>0){
                JOptionPane.showMessageDialog(this, "Record saved Successfully!!");
            }
            clear();
        }catch(Exception e){
            
        }
    }
    
    public boolean validatePassword(){
        String pass1 = password_TF.getText();
        String pass2 = password_TF1.getText();
        
        if(!pass1.equals(pass2)){
            JOptionPane.showMessageDialog(this, "The Password don't match, check again");
            return false;
        }
        else return true;
    }
    
    public boolean checkAllFields(){
        if(registerName_TF.getText().isEmpty() || contact_TF.getText().isEmpty() || address_TF.getText().isEmpty() || nid_TF.getText().isEmpty() || position_TF.getText().isEmpty() || password_TF.getText().isEmpty() || password_TF1.getText().isEmpty()){
             JOptionPane.showMessageDialog(this, "Please, Fill each field !!");
             return false;
        }
        else return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Gender = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        registerName_TF = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        contact_TF = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        address_TF = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        nid_TF = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        position_TF = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        register_BTN = new javax.swing.JLabel();
        password_TF = new javax.swing.JPasswordField();
        jSeparator7 = new javax.swing.JSeparator();
        password_TF1 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1024, 600));

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));

        jLabel7.setFont(new java.awt.Font("MV Boli", 0, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Inventory");

        jLabel6.setFont(new java.awt.Font("MV Boli", 0, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Management");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(154, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        registerName_TF.setBackground(new java.awt.Color(0, 102, 102));
        registerName_TF.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        registerName_TF.setForeground(new java.awt.Color(255, 255, 255));
        registerName_TF.setBorder(null);
        registerName_TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerName_TFActionPerformed(evt);
            }
        });
        jPanel3.add(registerName_TF, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 310, 30));

        jSeparator1.setBackground(new java.awt.Color(51, 0, 51));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 320, 10));

        contact_TF.setBackground(new java.awt.Color(0, 102, 102));
        contact_TF.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        contact_TF.setForeground(new java.awt.Color(255, 255, 255));
        contact_TF.setBorder(null);
        contact_TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contact_TFActionPerformed(evt);
            }
        });
        jPanel3.add(contact_TF, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 310, 30));

        jSeparator2.setBackground(new java.awt.Color(51, 0, 51));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 320, 10));

        address_TF.setBackground(new java.awt.Color(0, 102, 102));
        address_TF.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        address_TF.setForeground(new java.awt.Color(255, 255, 255));
        address_TF.setBorder(null);
        address_TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                address_TFActionPerformed(evt);
            }
        });
        jPanel3.add(address_TF, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 310, 30));

        jSeparator3.setBackground(new java.awt.Color(51, 0, 51));
        jPanel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 320, 10));

        nid_TF.setBackground(new java.awt.Color(0, 102, 102));
        nid_TF.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        nid_TF.setForeground(new java.awt.Color(255, 255, 255));
        nid_TF.setBorder(null);
        nid_TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nid_TFActionPerformed(evt);
            }
        });
        jPanel3.add(nid_TF, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 310, 30));

        jSeparator4.setBackground(new java.awt.Color(51, 0, 51));
        jPanel3.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 320, 10));

        position_TF.setBackground(new java.awt.Color(0, 102, 102));
        position_TF.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        position_TF.setForeground(new java.awt.Color(255, 255, 255));
        position_TF.setBorder(null);
        position_TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                position_TFActionPerformed(evt);
            }
        });
        jPanel3.add(position_TF, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 310, 30));

        jSeparator5.setBackground(new java.awt.Color(51, 0, 51));
        jPanel3.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 320, 10));

        jSeparator6.setBackground(new java.awt.Color(51, 0, 51));
        jPanel3.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, 320, 10));

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        register_BTN.setBackground(new java.awt.Color(0, 102, 102));
        register_BTN.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        register_BTN.setForeground(new java.awt.Color(255, 255, 255));
        register_BTN.setText("        Register");
        register_BTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                register_BTNMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(register_BTN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(register_BTN, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 550, 120, 30));

        password_TF.setBackground(new java.awt.Color(0, 102, 102));
        password_TF.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        password_TF.setForeground(new java.awt.Color(255, 255, 255));
        password_TF.setBorder(null);
        password_TF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                password_TFFocusGained(evt);
            }
        });
        password_TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password_TFActionPerformed(evt);
            }
        });
        jPanel3.add(password_TF, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, 310, 30));

        jSeparator7.setBackground(new java.awt.Color(51, 0, 51));
        jPanel3.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 460, 320, 10));

        password_TF1.setBackground(new java.awt.Color(0, 102, 102));
        password_TF1.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        password_TF1.setForeground(new java.awt.Color(255, 255, 255));
        password_TF1.setBorder(null);
        password_TF1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                password_TF1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                password_TF1FocusLost(evt);
            }
        });
        jPanel3.add(password_TF1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, 310, 30));

        jLabel1.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Contact");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 160, 30));

        jLabel2.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 160, 30));

        jLabel4.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("NID");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 160, 30));

        jLabel5.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Address");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 160, 30));

        jLabel8.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Password");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 160, 30));

        jLabel9.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Confirm Password");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 160, 30));

        jLabel10.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Position");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 160, 30));

        jLabel11.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Date of Birth");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 160, 30));

        jDateChooser1.setBackground(new java.awt.Color(0, 102, 102));
        jDateChooser1.setForeground(new java.awt.Color(255, 255, 255));
        jDateChooser1.setDateFormatString("yyyy/MM/dd");
        jPanel3.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 320, 30));

        jLabel12.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Gender");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 160, 30));

        jRadioButton1.setBackground(new java.awt.Color(0, 102, 102));
        Gender.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("Male");
        jPanel3.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, -1, -1));

        jRadioButton2.setBackground(new java.awt.Color(0, 102, 102));
        Gender.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("Female");
        jPanel3.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void registerName_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerName_TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registerName_TFActionPerformed

    private void contact_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contact_TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contact_TFActionPerformed

    private void address_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_address_TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_address_TFActionPerformed

    private void nid_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nid_TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nid_TFActionPerformed

    private void position_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_position_TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_position_TFActionPerformed

    private void password_TFFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_password_TFFocusGained
        
    }//GEN-LAST:event_password_TFFocusGained

    private void password_TF1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_password_TF1FocusGained
        
    }//GEN-LAST:event_password_TF1FocusGained

    private void password_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password_TFActionPerformed

    private void register_BTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_register_BTNMouseClicked
        if(checkAllFields() && validatePassword()){
            submitDataToDataBase();
        }

    }//GEN-LAST:event_register_BTNMouseClicked

    private void password_TF1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_password_TF1FocusLost
        validatePassword();
    }//GEN-LAST:event_password_TF1FocusLost

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
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Gender;
    private javax.swing.JTextField address_TF;
    private javax.swing.JTextField contact_TF;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTextField nid_TF;
    private javax.swing.JPasswordField password_TF;
    private javax.swing.JPasswordField password_TF1;
    private javax.swing.JTextField position_TF;
    private javax.swing.JTextField registerName_TF;
    private javax.swing.JLabel register_BTN;
    // End of variables declaration//GEN-END:variables
}
