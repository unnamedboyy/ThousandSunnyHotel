
package view;

import costum.JpanelGradient;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class LoginView extends javax.swing.JFrame {
    
    public LoginView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        base = new javax.swing.JPanel();
        jpanelGradient1 = new view.JpanelGradient();
        jpanelRound1 = new costum.JpanelRound();
        jLabel1 = new javax.swing.JLabel();
        loginBtn = new javax.swing.JButton();
        UsernamePanel = new javax.swing.JPanel();
        userInput = new javax.swing.JTextField();
        userlabel = new javax.swing.JLabel();
        passPanel = new javax.swing.JPanel();
        passwordInput = new javax.swing.JTextField();
        passlabel1 = new javax.swing.JLabel();
        pesanLabe = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        userlabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        base.setBackground(new java.awt.Color(40, 15, 62));

        jpanelGradient1.setBackground(new java.awt.Color(40, 15, 62));
        jpanelGradient1.setColorEnd(new java.awt.Color(40, 15, 62));
        jpanelGradient1.setColorStart(new java.awt.Color(83, 37, 103));

        jpanelRound1.setBackground(new java.awt.Color(244, 233, 225));
        jpanelRound1.setRoundBottomLeft(30);
        jpanelRound1.setRoundBottomRight(30);
        jpanelRound1.setRoundTopLeft(30);
        jpanelRound1.setRoundTopRight(30);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 55)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SELAMAT DATANG");

        loginBtn.setBackground(new java.awt.Color(83, 37, 103));
        loginBtn.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        loginBtn.setForeground(new java.awt.Color(245, 245, 245));
        loginBtn.setText("Login");
        loginBtn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                loginBtnFocusGained(evt);
            }
        });
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });
        loginBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginBtnKeyPressed(evt);
            }
        });

        UsernamePanel.setBackground(new java.awt.Color(244, 233, 225));

        userInput.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        userInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userInputActionPerformed(evt);
            }
        });

        userlabel.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        userlabel.setText("Username");

        javax.swing.GroupLayout UsernamePanelLayout = new javax.swing.GroupLayout(UsernamePanel);
        UsernamePanel.setLayout(UsernamePanelLayout);
        UsernamePanelLayout.setHorizontalGroup(
            UsernamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UsernamePanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(UsernamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userlabel)
                    .addComponent(userInput, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        UsernamePanelLayout.setVerticalGroup(
            UsernamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UsernamePanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(userlabel)
                .addGap(0, 0, 0)
                .addComponent(userInput, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        passPanel.setBackground(new java.awt.Color(244, 233, 225));

        passwordInput.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        passwordInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordInputActionPerformed(evt);
            }
        });

        passlabel1.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        passlabel1.setText("Password");

        javax.swing.GroupLayout passPanelLayout = new javax.swing.GroupLayout(passPanel);
        passPanel.setLayout(passPanelLayout);
        passPanelLayout.setHorizontalGroup(
            passPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 616, Short.MAX_VALUE)
            .addGroup(passPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(passPanelLayout.createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(passPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(passPanelLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(passlabel1)
                    .addContainerGap(396, Short.MAX_VALUE)))
        );
        passPanelLayout.setVerticalGroup(
            passPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 145, Short.MAX_VALUE)
            .addGroup(passPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(passPanelLayout.createSequentialGroup()
                    .addGap(76, 76, 76)
                    .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(passPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(passPanelLayout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(passlabel1)
                    .addContainerGap(67, Short.MAX_VALUE)))
        );

        pesanLabe.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        pesanLabe.setText("Pastikan anda masih bernafas");

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 55)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SILAHKAN LOGIN");

        javax.swing.GroupLayout jpanelRound1Layout = new javax.swing.GroupLayout(jpanelRound1);
        jpanelRound1.setLayout(jpanelRound1Layout);
        jpanelRound1Layout.setHorizontalGroup(
            jpanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelRound1Layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jpanelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelRound1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jpanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelRound1Layout.createSequentialGroup()
                        .addGroup(jpanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelRound1Layout.createSequentialGroup()
                                .addComponent(UsernamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelRound1Layout.createSequentialGroup()
                        .addComponent(pesanLabe)
                        .addGap(241, 241, 241))))
        );
        jpanelRound1Layout.setVerticalGroup(
            jpanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelRound1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UsernamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pesanLabe)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        userlabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        userlabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/hotelDepan.png"))); // NOI18N

        javax.swing.GroupLayout jpanelGradient1Layout = new javax.swing.GroupLayout(jpanelGradient1);
        jpanelGradient1.setLayout(jpanelGradient1Layout);
        jpanelGradient1Layout.setHorizontalGroup(
            jpanelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelGradient1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(userlabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpanelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(230, 230, 230))
        );
        jpanelGradient1Layout.setVerticalGroup(
            jpanelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelGradient1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jpanelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(userlabel1)
                    .addComponent(jpanelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout baseLayout = new javax.swing.GroupLayout(base);
        base.setLayout(baseLayout);
        baseLayout.setHorizontalGroup(
            baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        baseLayout.setVerticalGroup(
            baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(base, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(base, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginBtnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_loginBtnFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_loginBtnFocusGained

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed

      if(userInput.getText().equals("admin")){
            if( passwordInput.getText().equals("password")){
               MainViewForm main = new MainViewForm();
               this.dispose();
               main.setVisible(true);
             }else{
               JOptionPane.showMessageDialog(this,"Username dan Password tidak cocok!");
            }
       }else{
           JOptionPane.showMessageDialog(this,"Username tidak terdaftar!");
       }
      
    }//GEN-LAST:event_loginBtnActionPerformed

    private void loginBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginBtnKeyPressed
 
    }//GEN-LAST:event_loginBtnKeyPressed

    private void userInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userInputActionPerformed

    private void passwordInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordInputActionPerformed

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
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel UsernamePanel;
    private javax.swing.JPanel base;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private view.JpanelGradient jpanelGradient1;
    private costum.JpanelRound jpanelRound1;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPanel passPanel;
    private javax.swing.JLabel passlabel1;
    private javax.swing.JTextField passwordInput;
    private javax.swing.JLabel pesanLabe;
    private javax.swing.JTextField userInput;
    private javax.swing.JLabel userlabel;
    private javax.swing.JLabel userlabel1;
    // End of variables declaration//GEN-END:variables

}
