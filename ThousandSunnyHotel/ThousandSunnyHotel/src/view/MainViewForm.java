
package view;

import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;
import java.awt.Color;
import com.formdev.flatlaf.FlatLightLaf;
import panel.*;
import javax.swing.JComponent;
import javax.swing.UIManager;

public class MainViewForm extends javax.swing.JFrame {
      
    private int selectedIndex = -1;
    
    private void setForm(JComponent com){
        contentPanel.removeAll();
        contentPanel.add(com);
        contentPanel.repaint();
        contentPanel.revalidate();
    }
    
    private void recolorDefaultSwitchPanel(){
        repaint();
        jpanelRoundRooms.setBackground(new Color (40, 15, 62));
        jpanelRoundCustomer.setBackground(new Color (40, 15, 62));
        jpanelRoundPetugas.setBackground(new Color (40, 15, 62));
        jpanelRoundBooking.setBackground(new Color (40, 15, 62));
        jpanelRoundJasa.setBackground(new Color (40, 15, 62));
    }
    
    public MainViewForm() {
        try{
            FlatLightLaf.setup();
            UIManager.put("TextComponent.arc", 15);
        } catch (Exception e){
            e.printStackTrace();
        }
        initComponents();
        recolorDefaultSwitchPanel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        sidePanel = new javax.swing.JPanel();
        customerPanel = new javax.swing.JPanel();
        jpanelRoundCustomer = new costum.JpanelRound();
        customerLogo = new javax.swing.JLabel();
        customerLabel = new javax.swing.JLabel();
        kamarPanel = new javax.swing.JPanel();
        jpanelRoundRooms = new costum.JpanelRound();
        roomLabel = new javax.swing.JLabel();
        roomLogo = new javax.swing.JLabel();
        bookingPanel = new javax.swing.JPanel();
        jpanelRoundBooking = new costum.JpanelRound();
        bookingLogo = new javax.swing.JLabel();
        bookingLabel = new javax.swing.JLabel();
        petugasPanel = new javax.swing.JPanel();
        jpanelRoundPetugas = new costum.JpanelRound();
        petugasLogo = new javax.swing.JLabel();
        petugasLabel = new javax.swing.JLabel();
        jasaPanel = new javax.swing.JPanel();
        jpanelRoundJasa = new costum.JpanelRound();
        jasaLabel = new javax.swing.JLabel();
        jasaLogo = new javax.swing.JLabel();
        mainLogoPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(244, 233, 225));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainPanel.setBackground(new java.awt.Color(244, 233, 225));
        mainPanel.setBorder(null);
        mainPanel.setPreferredSize(new java.awt.Dimension(1360, 757));

        sidePanel.setBackground(new java.awt.Color(40, 15, 62));
        sidePanel.setBorder(null);
        sidePanel.setToolTipText("");
        sidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        customerPanel.setBackground(new java.awt.Color(40, 15, 62));
        customerPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerPanelMouseClicked(evt);
            }
        });

        jpanelRoundCustomer.setBackground(new java.awt.Color(15, 15, 15));
        jpanelRoundCustomer.setRoundBottomLeft(20);
        jpanelRoundCustomer.setRoundBottomRight(20);
        jpanelRoundCustomer.setRoundTopLeft(20);
        jpanelRoundCustomer.setRoundTopRight(20);

        customerLogo.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        customerLogo.setForeground(new java.awt.Color(244, 233, 225));
        customerLogo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        customerLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/customer.png"))); // NOI18N

        customerLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        customerLabel.setForeground(new java.awt.Color(244, 233, 225));
        customerLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        customerLabel.setText("Customer");

        javax.swing.GroupLayout jpanelRoundCustomerLayout = new javax.swing.GroupLayout(jpanelRoundCustomer);
        jpanelRoundCustomer.setLayout(jpanelRoundCustomerLayout);
        jpanelRoundCustomerLayout.setHorizontalGroup(
            jpanelRoundCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelRoundCustomerLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(customerLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(customerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpanelRoundCustomerLayout.setVerticalGroup(
            jpanelRoundCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelRoundCustomerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanelRoundCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(customerLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(customerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout customerPanelLayout = new javax.swing.GroupLayout(customerPanel);
        customerPanel.setLayout(customerPanelLayout);
        customerPanelLayout.setHorizontalGroup(
            customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerPanelLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jpanelRoundCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        customerPanelLayout.setVerticalGroup(
            customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpanelRoundCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sidePanel.add(customerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 160, -1));

        kamarPanel.setBackground(new java.awt.Color(40, 15, 62));
        kamarPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kamarPanelMouseClicked(evt);
            }
        });

        jpanelRoundRooms.setBackground(new java.awt.Color(15, 15, 15));
        jpanelRoundRooms.setRoundBottomLeft(20);
        jpanelRoundRooms.setRoundBottomRight(20);
        jpanelRoundRooms.setRoundTopLeft(20);
        jpanelRoundRooms.setRoundTopRight(20);

        roomLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        roomLabel.setForeground(new java.awt.Color(244, 233, 225));
        roomLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        roomLabel.setText("Rooms");

        roomLogo.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        roomLogo.setForeground(new java.awt.Color(244, 233, 225));
        roomLogo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        roomLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/room.png"))); // NOI18N

        javax.swing.GroupLayout jpanelRoundRoomsLayout = new javax.swing.GroupLayout(jpanelRoundRooms);
        jpanelRoundRooms.setLayout(jpanelRoundRoomsLayout);
        jpanelRoundRoomsLayout.setHorizontalGroup(
            jpanelRoundRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelRoundRoomsLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(roomLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roomLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jpanelRoundRoomsLayout.setVerticalGroup(
            jpanelRoundRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelRoundRoomsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanelRoundRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roomLogo)
                    .addComponent(roomLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout kamarPanelLayout = new javax.swing.GroupLayout(kamarPanel);
        kamarPanel.setLayout(kamarPanelLayout);
        kamarPanelLayout.setHorizontalGroup(
            kamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kamarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpanelRoundRooms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        kamarPanelLayout.setVerticalGroup(
            kamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kamarPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jpanelRoundRooms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        sidePanel.add(kamarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 160, 50));

        bookingPanel.setBackground(new java.awt.Color(40, 15, 62));
        bookingPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookingPanelMouseClicked(evt);
            }
        });

        jpanelRoundBooking.setBackground(new java.awt.Color(15, 15, 15));
        jpanelRoundBooking.setRoundBottomLeft(20);
        jpanelRoundBooking.setRoundBottomRight(20);
        jpanelRoundBooking.setRoundTopLeft(20);
        jpanelRoundBooking.setRoundTopRight(20);

        bookingLogo.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        bookingLogo.setForeground(new java.awt.Color(244, 233, 225));
        bookingLogo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bookingLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/booking.png"))); // NOI18N

        bookingLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bookingLabel.setForeground(new java.awt.Color(244, 233, 225));
        bookingLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bookingLabel.setText("Booking");

        javax.swing.GroupLayout jpanelRoundBookingLayout = new javax.swing.GroupLayout(jpanelRoundBooking);
        jpanelRoundBooking.setLayout(jpanelRoundBookingLayout);
        jpanelRoundBookingLayout.setHorizontalGroup(
            jpanelRoundBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelRoundBookingLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(bookingLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bookingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpanelRoundBookingLayout.setVerticalGroup(
            jpanelRoundBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelRoundBookingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanelRoundBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bookingLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bookingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout bookingPanelLayout = new javax.swing.GroupLayout(bookingPanel);
        bookingPanel.setLayout(bookingPanelLayout);
        bookingPanelLayout.setHorizontalGroup(
            bookingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookingPanelLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jpanelRoundBooking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        bookingPanelLayout.setVerticalGroup(
            bookingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpanelRoundBooking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sidePanel.add(bookingPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 160, -1));

        petugasPanel.setBackground(new java.awt.Color(40, 15, 62));
        petugasPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                petugasPanelMouseClicked(evt);
            }
        });

        jpanelRoundPetugas.setBackground(new java.awt.Color(15, 15, 15));
        jpanelRoundPetugas.setRoundBottomLeft(20);
        jpanelRoundPetugas.setRoundBottomRight(20);
        jpanelRoundPetugas.setRoundTopLeft(20);
        jpanelRoundPetugas.setRoundTopRight(20);

        petugasLogo.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        petugasLogo.setForeground(new java.awt.Color(244, 233, 225));
        petugasLogo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        petugasLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/petugas.png"))); // NOI18N

        petugasLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        petugasLabel.setForeground(new java.awt.Color(244, 233, 225));
        petugasLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        petugasLabel.setText("Petugas");

        javax.swing.GroupLayout jpanelRoundPetugasLayout = new javax.swing.GroupLayout(jpanelRoundPetugas);
        jpanelRoundPetugas.setLayout(jpanelRoundPetugasLayout);
        jpanelRoundPetugasLayout.setHorizontalGroup(
            jpanelRoundPetugasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelRoundPetugasLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(petugasLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(petugasLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpanelRoundPetugasLayout.setVerticalGroup(
            jpanelRoundPetugasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelRoundPetugasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanelRoundPetugasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(petugasLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(petugasLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout petugasPanelLayout = new javax.swing.GroupLayout(petugasPanel);
        petugasPanel.setLayout(petugasPanelLayout);
        petugasPanelLayout.setHorizontalGroup(
            petugasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(petugasPanelLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jpanelRoundPetugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        petugasPanelLayout.setVerticalGroup(
            petugasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(petugasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpanelRoundPetugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sidePanel.add(petugasPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 160, -1));

        jasaPanel.setBackground(new java.awt.Color(40, 15, 62));
        jasaPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jasaPanelMouseClicked(evt);
            }
        });

        jpanelRoundJasa.setBackground(new java.awt.Color(15, 15, 15));
        jpanelRoundJasa.setRoundBottomLeft(20);
        jpanelRoundJasa.setRoundBottomRight(20);
        jpanelRoundJasa.setRoundTopLeft(20);
        jpanelRoundJasa.setRoundTopRight(20);

        jasaLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jasaLabel.setForeground(new java.awt.Color(244, 233, 225));
        jasaLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jasaLabel.setText("Service");

        jasaLogo.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jasaLogo.setForeground(new java.awt.Color(244, 233, 225));
        jasaLogo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jasaLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/service.png"))); // NOI18N

        javax.swing.GroupLayout jpanelRoundJasaLayout = new javax.swing.GroupLayout(jpanelRoundJasa);
        jpanelRoundJasa.setLayout(jpanelRoundJasaLayout);
        jpanelRoundJasaLayout.setHorizontalGroup(
            jpanelRoundJasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelRoundJasaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jasaLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jasaLabel)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jpanelRoundJasaLayout.setVerticalGroup(
            jpanelRoundJasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelRoundJasaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanelRoundJasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jasaLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jasaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jasaPanelLayout = new javax.swing.GroupLayout(jasaPanel);
        jasaPanel.setLayout(jasaPanelLayout);
        jasaPanelLayout.setHorizontalGroup(
            jasaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jasaPanelLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jpanelRoundJasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jasaPanelLayout.setVerticalGroup(
            jasaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jasaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpanelRoundJasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        sidePanel.add(jasaPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 160, 60));

        mainLogoPanel.setBackground(new java.awt.Color(40, 15, 62));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/mainLogo.png"))); // NOI18N

        javax.swing.GroupLayout mainLogoPanelLayout = new javax.swing.GroupLayout(mainLogoPanel);
        mainLogoPanel.setLayout(mainLogoPanelLayout);
        mainLogoPanelLayout.setHorizontalGroup(
            mainLogoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLogoPanelLayout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );
        mainLogoPanelLayout.setVerticalGroup(
            mainLogoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sidePanel.add(mainLogoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, -1));

        contentPanel.setBackground(new java.awt.Color(244, 233, 225));
        contentPanel.setBorder(null);
        contentPanel.setOpaque(false);
        contentPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, -8, 1370, 890));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kamarPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kamarPanelMouseClicked
        if(selectedIndex == 1)
            return;
        
        recolorDefaultSwitchPanel();
        jpanelRoundRooms.setBackground(new Color(83, 37, 103));
        setForm(new KamarPanel());
        selectedIndex = 1;
    }//GEN-LAST:event_kamarPanelMouseClicked

    private void bookingPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookingPanelMouseClicked
        if(selectedIndex == 3)
            return;
        
        recolorDefaultSwitchPanel();
        jpanelRoundBooking.setBackground(new Color(83, 37, 103));
        setForm(new BookingPanel());
        selectedIndex = 3;
    }//GEN-LAST:event_bookingPanelMouseClicked

    private void petugasPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petugasPanelMouseClicked
        if(selectedIndex == 4)
        return;

        recolorDefaultSwitchPanel();
        jpanelRoundPetugas.setBackground(new Color(83, 37, 103));
        setForm(new PetugasPanel());
        selectedIndex = 4;
    }//GEN-LAST:event_petugasPanelMouseClicked

    private void jasaPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jasaPanelMouseClicked
        if(selectedIndex == 5)
        return;

        recolorDefaultSwitchPanel();
        jpanelRoundJasa.setBackground(new Color(83, 37, 103));
        setForm(new JasaPanel());
        selectedIndex = 5;
    }//GEN-LAST:event_jasaPanelMouseClicked

    private void customerPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerPanelMouseClicked
        if(selectedIndex == 2)
        return;

        recolorDefaultSwitchPanel();
        jpanelRoundCustomer.setBackground(new Color(83, 37, 103));
        setForm(new CustomerPanel());
        selectedIndex = 2;
    }//GEN-LAST:event_customerPanelMouseClicked

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
            java.util.logging.Logger.getLogger(MainViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainViewForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bookingLabel;
    private javax.swing.JLabel bookingLogo;
    private javax.swing.JPanel bookingPanel;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel customerLabel;
    private javax.swing.JLabel customerLogo;
    private javax.swing.JPanel customerPanel;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jasaLabel;
    private javax.swing.JLabel jasaLogo;
    private javax.swing.JPanel jasaPanel;
    private costum.JpanelRound jpanelRoundBooking;
    private costum.JpanelRound jpanelRoundCustomer;
    private costum.JpanelRound jpanelRoundJasa;
    private costum.JpanelRound jpanelRoundPetugas;
    private costum.JpanelRound jpanelRoundRooms;
    private javax.swing.JPanel kamarPanel;
    private javax.swing.JPanel mainLogoPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel petugasLabel;
    private javax.swing.JLabel petugasLogo;
    private javax.swing.JPanel petugasPanel;
    private javax.swing.JLabel roomLabel;
    private javax.swing.JLabel roomLogo;
    private javax.swing.JPanel sidePanel;
    // End of variables declaration//GEN-END:variables
}
