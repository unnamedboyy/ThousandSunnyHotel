
package costum;

import java.awt.Color;
import model.Customer;
import model.Kamar;
import model.Booking;
import panel.*;
import view.LoginView;
import javax.swing.JComponent;

public class JpanelConfirmMassageBooking extends javax.swing.JPanel {
    
    public void setDetail(Booking B, Customer C, Kamar K){
        customerJawab.setText(C.getNama());
        kamarJawab.setText(K.getId_kamar());
        checkInJawab.setText(B.getCheckInDate());
        checkOutJawab.setText(B.getCheckOutDate());
        hargaJawab.setText(String.valueOf(B.getTotal_harga()));
        
    }

    public JpanelConfirmMassageBooking(Booking B, Customer C, Kamar K) {
        initComponents();
        setDetail(B, C, K);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        yesBtn = new javax.swing.JButton();
        No = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        userlabel = new javax.swing.JLabel();
        userlabel1 = new javax.swing.JLabel();
        userlabel2 = new javax.swing.JLabel();
        userlabel3 = new javax.swing.JLabel();
        userlabel4 = new javax.swing.JLabel();
        customerJawab = new javax.swing.JLabel();
        kamarJawab = new javax.swing.JLabel();
        checkInJawab = new javax.swing.JLabel();
        checkOutJawab = new javax.swing.JLabel();
        hargaJawab = new javax.swing.JLabel();
        detailLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(248, 247, 243));

        yesBtn.setBackground(new java.awt.Color(0, 61, 121));
        yesBtn.setFont(new java.awt.Font("Montserrat SemiBold", 1, 18)); // NOI18N
        yesBtn.setForeground(new java.awt.Color(255, 255, 255));
        yesBtn.setText("Yes");
        yesBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                yesBtnMouseClicked(evt);
            }
        });
        yesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yesBtnActionPerformed(evt);
            }
        });

        No.setBackground(new java.awt.Color(220, 53, 69));
        No.setFont(new java.awt.Font("Montserrat SemiBold", 1, 18)); // NOI18N
        No.setForeground(new java.awt.Color(255, 255, 255));
        No.setText("Delete");
        No.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NoMouseClicked(evt);
            }
        });
        No.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(248, 247, 243));

        userlabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        userlabel.setText("Nomor Kamar");

        userlabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        userlabel1.setText("Nama Pemesan");

        userlabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        userlabel2.setText("Tanggal Check In");

        userlabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        userlabel3.setText("Tanggal Check Out");

        userlabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        userlabel4.setText("Total Pembayaran");

        customerJawab.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        customerJawab.setText("Nama Pemesan");

        kamarJawab.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        kamarJawab.setText("Nama Pemesan");

        checkInJawab.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        checkInJawab.setText("Nama Pemesan");

        checkOutJawab.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        checkOutJawab.setText("Nama Pemesan");

        hargaJawab.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        hargaJawab.setText("Nama Pemesan");

        detailLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        detailLabel.setText("DETAIL PEMESANAN ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userlabel1)
                            .addComponent(userlabel)
                            .addComponent(userlabel2)
                            .addComponent(userlabel3)
                            .addComponent(userlabel4))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hargaJawab)
                            .addComponent(checkOutJawab)
                            .addComponent(checkInJawab)
                            .addComponent(kamarJawab)
                            .addComponent(customerJawab)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(detailLabel)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(detailLabel)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userlabel1)
                    .addComponent(customerJawab))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userlabel)
                    .addComponent(kamarJawab))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userlabel2)
                    .addComponent(checkInJawab))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userlabel3)
                    .addComponent(checkOutJawab))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userlabel4)
                    .addComponent(hargaJawab))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(yesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(No, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(No, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void yesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yesBtnActionPerformed

    }//GEN-LAST:event_yesBtnActionPerformed

    private void yesBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yesBtnMouseClicked
       this.setVisible(false);
    }//GEN-LAST:event_yesBtnMouseClicked

    private void NoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoActionPerformed

    }//GEN-LAST:event_NoActionPerformed

    private void NoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NoMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_NoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton No;
    private javax.swing.JLabel checkInJawab;
    private javax.swing.JLabel checkOutJawab;
    private javax.swing.JLabel customerJawab;
    private javax.swing.JLabel detailLabel;
    private javax.swing.JLabel hargaJawab;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel kamarJawab;
    private javax.swing.JLabel userlabel;
    private javax.swing.JLabel userlabel1;
    private javax.swing.JLabel userlabel2;
    private javax.swing.JLabel userlabel3;
    private javax.swing.JLabel userlabel4;
    private javax.swing.JButton yesBtn;
    // End of variables declaration//GEN-END:variables
}
