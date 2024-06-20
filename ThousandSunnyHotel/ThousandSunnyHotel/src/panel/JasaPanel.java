/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package panel;


import Control.BookingControl;
import Control.PenyediaJasaControl;
import exception.InputKosongException;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import model.PenyediaJasa;
import model.Booking;

import Control.KamarControl;
import Control.CustomerControl;
import Control.PetugasControl;
import model.Kamar;
import model.Customer;
import model.Petugas;

public class JasaPanel extends javax.swing.JPanel {
 
    private BookingControl bookingControl;
    private PenyediaJasaControl penyediaJasaControl;
    
    private PetugasControl petugasControl;
    private KamarControl kamarControl;
    private CustomerControl customerControl;
    
    private PenyediaJasa data = null;
    String action = null, tempId_Jasa;
    String selectedId = "";
    
    List<Booking> bookingList;
    List<Kamar> kamarList;
    List<Customer> customerList;
    List<Petugas> petugasList;

    // set count
    public void setCount(){
        kamarList = kamarControl.showListKamar();
        customerList = customerControl.showListCustomer();
        petugasList = petugasControl.showListPetugas();
        
        if(kamarList.size() < 10){
            jLabel2.setText("0" + kamarList.size());
        }else {
            jLabel2.setText("" + kamarList.size());
        }
        
        if(customerList.size() < 10){
            jLabel3.setText("0" + customerList.size());
        }else {
            jLabel3.setText("" + customerList.size());
        }
        
        if(petugasList.size() < 10){
            jLabel6.setText("0" + petugasList.size());
        }else {
            jLabel6.setText("" + petugasList.size());
        }

    }
    
    private Component rootPane;
    
    public void setPetugasToDropdown(){
        petugasList = petugasControl.showListPetugas();
        for(int i=0; i<petugasList.size();i++){
            PetugasComboBox1.addItem(petugasList.get(i));
        }
    }
    
    public void setCustomerToDropdown(){
        bookingList = bookingControl.showListBooking();
        for(int i = 0; i < bookingList.size(); i++){
            CustomerComboBox.addItem(bookingList.get(i));
        }
    }
    
    public void inputKosongException() throws InputKosongException{
        if(PetugasComboBox1.getSelectedIndex()==-1 || CustomerComboBox.getSelectedIndex()==-1
                || tanggalDate == null
                || (!pijat.isSelected() && !morningcall.isSelected() && !antarbarang.isSelected())){
            throw new InputKosongException();
        }
    }
    
    public void showTableBySearch(String target){
        TableLayanan.setModel(penyediaJasaControl.showTable(target));
    }
    
    public void clearText(){
        PetugasComboBox1.setSelectedIndex(-1);
        CustomerComboBox.setSelectedIndex(-1);
        
        pijat.setSelected(false);
        morningcall.setSelected(false);
        antarbarang.setSelected(false);
        
        inputSearch.setText("");
        tanggalDate.setDate(null);
    }
    
    public void setEditDeleteBtn(boolean value){
        editBtn.setEnabled(value);
        deleteBtn.setEnabled(value);
    }
    
    
    public void setComponent(boolean value){
        PetugasComboBox1.setEnabled(value);
        CustomerComboBox.setEnabled(value);
        tanggalDate.setEnabled(value);
        
        pijat.setEnabled(value);
        morningcall.setEnabled(value);
        antarbarang.setEnabled(value);
        
        saveBtn.setEnabled(value);
        cancelBtn.setEnabled(value);
    }
    
    public JasaPanel() {
        initComponents();
        setOpaque(false);
        
        penyediaJasaControl = new PenyediaJasaControl();
        bookingControl = new BookingControl();
        petugasControl = new PetugasControl();
        customerControl = new CustomerControl();
        kamarControl = new KamarControl();
       
        setCustomerToDropdown();
        setPetugasToDropdown();
        
        showTableBySearch("");
        
        //RESET
        setCount();
        clearText();
        setComponent(false);
        setEditDeleteBtn(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        buttonLayananPanel = new javax.swing.JPanel();
        deleteBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        searchLayananPanel = new javax.swing.JPanel();
        inputSearch = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        tableLayanan = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableLayanan = new javax.swing.JTable();
        thumbnailPanel = new costum.JpanelRound();
        roomPict = new javax.swing.JLabel();
        countPanel = new costum.JpanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        layananFormPanel = new costum.JpanelRound();
        LayananPanelbox = new javax.swing.JPanel();
        layananLabel = new javax.swing.JLabel();
        pijat = new javax.swing.JCheckBox();
        morningcall = new javax.swing.JCheckBox();
        antarbarang = new javax.swing.JCheckBox();
        namaKamarPanel = new javax.swing.JPanel();
        namaLabel = new javax.swing.JLabel();
        CustomerComboBox = new javax.swing.JComboBox<>();
        namaPetugasPanel = new javax.swing.JPanel();
        namaLabel1 = new javax.swing.JLabel();
        PetugasComboBox1 = new javax.swing.JComboBox<>();
        tanggalLayananPanel = new javax.swing.JPanel();
        tanggalLabel = new javax.swing.JLabel();
        tanggalDate = new com.toedter.calendar.JDateChooser();
        saveBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        judulKamarPanel = new javax.swing.JPanel();
        judulHotelLabel = new javax.swing.JLabel();
        judulCustomerLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(244, 233, 225));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainPanel.setBackground(new java.awt.Color(244, 233, 225));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonLayananPanel.setBackground(new java.awt.Color(244, 233, 225));
        buttonLayananPanel.setPreferredSize(new java.awt.Dimension(141, 47));

        deleteBtn.setBackground(new java.awt.Color(220, 53, 69));
        deleteBtn.setFont(new java.awt.Font("Montserrat SemiBold", 1, 18)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        editBtn.setBackground(new java.awt.Color(255, 183, 0));
        editBtn.setFont(new java.awt.Font("Montserrat SemiBold", 1, 18)); // NOI18N
        editBtn.setForeground(new java.awt.Color(255, 255, 255));
        editBtn.setText("Edit");
        editBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editBtnMouseClicked(evt);
            }
        });
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        addBtn.setBackground(new java.awt.Color(0, 61, 121));
        addBtn.setFont(new java.awt.Font("Montserrat SemiBold", 1, 18)); // NOI18N
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setText("Add");
        addBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addBtnMouseClicked(evt);
            }
        });
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonLayananPanelLayout = new javax.swing.GroupLayout(buttonLayananPanel);
        buttonLayananPanel.setLayout(buttonLayananPanelLayout);
        buttonLayananPanelLayout.setHorizontalGroup(
            buttonLayananPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonLayananPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonLayananPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(editBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        buttonLayananPanelLayout.setVerticalGroup(
            buttonLayananPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonLayananPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.add(buttonLayananPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(464, 20, 200, 150));

        searchLayananPanel.setBackground(new java.awt.Color(244, 233, 225));
        searchLayananPanel.setPreferredSize(new java.awt.Dimension(141, 47));

        inputSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inputSearchMouseClicked(evt);
            }
        });

        searchBtn.setBackground(new java.awt.Color(0, 61, 121));
        searchBtn.setFont(new java.awt.Font("Montserrat SemiBold", 1, 18)); // NOI18N
        searchBtn.setForeground(new java.awt.Color(255, 255, 255));
        searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon-search.png"))); // NOI18N
        searchBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBtnMouseClicked(evt);
            }
        });
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchLayananPanelLayout = new javax.swing.GroupLayout(searchLayananPanel);
        searchLayananPanel.setLayout(searchLayananPanelLayout);
        searchLayananPanelLayout.setHorizontalGroup(
            searchLayananPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchLayananPanelLayout.createSequentialGroup()
                .addComponent(inputSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        searchLayananPanelLayout.setVerticalGroup(
            searchLayananPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchLayananPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchLayananPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.add(searchLayananPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 120, 480, 50));

        tableLayanan.setBackground(new java.awt.Color(244, 233, 225));

        TableLayanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TableLayanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableLayananMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableLayanan);

        javax.swing.GroupLayout tableLayananLayout = new javax.swing.GroupLayout(tableLayanan);
        tableLayanan.setLayout(tableLayananLayout);
        tableLayananLayout.setHorizontalGroup(
            tableLayananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tableLayananLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
        );
        tableLayananLayout.setVerticalGroup(
            tableLayananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tableLayananLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        mainPanel.add(tableLayanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 166, 490, -1));

        thumbnailPanel.setRoundBottomLeft(50);
        thumbnailPanel.setRoundBottomRight(50);
        thumbnailPanel.setRoundTopLeft(50);
        thumbnailPanel.setRoundTopRight(50);

        roomPict.setFont(new java.awt.Font("Arial", 1, 3)); // NOI18N
        roomPict.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        roomPict.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/jasaPict.png"))); // NOI18N
        roomPict.setToolTipText("");

        javax.swing.GroupLayout thumbnailPanelLayout = new javax.swing.GroupLayout(thumbnailPanel);
        thumbnailPanel.setLayout(thumbnailPanelLayout);
        thumbnailPanelLayout.setHorizontalGroup(
            thumbnailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
            .addGroup(thumbnailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(roomPict, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        thumbnailPanelLayout.setVerticalGroup(
            thumbnailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
            .addGroup(thumbnailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(roomPict, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.add(thumbnailPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 640, 220));

        countPanel.setBackground(new java.awt.Color(83, 37, 103));
        countPanel.setRoundBottomLeft(25);
        countPanel.setRoundBottomRight(25);
        countPanel.setRoundTopLeft(25);
        countPanel.setRoundTopRight(25);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Rooms count");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 65)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("00");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 65)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("00");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Customer count");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Waiter count");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 65)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("00");

        javax.swing.GroupLayout countPanelLayout = new javax.swing.GroupLayout(countPanel);
        countPanel.setLayout(countPanelLayout);
        countPanelLayout.setHorizontalGroup(
            countPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(countPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(countPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(countPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addGroup(countPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );
        countPanelLayout.setVerticalGroup(
            countPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(countPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(countPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(countPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, countPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(countPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        mainPanel.add(countPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 430, 150));

        layananFormPanel.setBackground(new java.awt.Color(83, 37, 103));
        layananFormPanel.setRoundBottomLeft(25);
        layananFormPanel.setRoundBottomRight(25);
        layananFormPanel.setRoundTopLeft(25);
        layananFormPanel.setRoundTopRight(25);

        LayananPanelbox.setBackground(new java.awt.Color(83, 37, 103));

        layananLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        layananLabel.setForeground(new java.awt.Color(255, 255, 255));
        layananLabel.setText("Jenis Layanan");

        pijat.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        pijat.setForeground(new java.awt.Color(255, 255, 255));
        pijat.setText("Pijat");

        morningcall.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        morningcall.setForeground(new java.awt.Color(255, 255, 255));
        morningcall.setText("Morning Call");

        antarbarang.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        antarbarang.setForeground(new java.awt.Color(255, 255, 255));
        antarbarang.setText("Antar Barang");

        javax.swing.GroupLayout LayananPanelboxLayout = new javax.swing.GroupLayout(LayananPanelbox);
        LayananPanelbox.setLayout(LayananPanelboxLayout);
        LayananPanelboxLayout.setHorizontalGroup(
            LayananPanelboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LayananPanelboxLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LayananPanelboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LayananPanelboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(layananLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(morningcall)
                        .addComponent(pijat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(antarbarang))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LayananPanelboxLayout.setVerticalGroup(
            LayananPanelboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LayananPanelboxLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(layananLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pijat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(morningcall)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(antarbarang)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        namaKamarPanel.setBackground(new java.awt.Color(83, 37, 103));

        namaLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        namaLabel.setForeground(new java.awt.Color(255, 255, 255));
        namaLabel.setText("Nama Customer");

        CustomerComboBox.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        CustomerComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout namaKamarPanelLayout = new javax.swing.GroupLayout(namaKamarPanel);
        namaKamarPanel.setLayout(namaKamarPanelLayout);
        namaKamarPanelLayout.setHorizontalGroup(
            namaKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, namaKamarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(namaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(CustomerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        namaKamarPanelLayout.setVerticalGroup(
            namaKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namaKamarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(namaKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CustomerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        namaPetugasPanel.setBackground(new java.awt.Color(83, 37, 103));

        namaLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        namaLabel1.setForeground(new java.awt.Color(255, 255, 255));
        namaLabel1.setText("Nama Petugas");

        PetugasComboBox1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

        javax.swing.GroupLayout namaPetugasPanelLayout = new javax.swing.GroupLayout(namaPetugasPanel);
        namaPetugasPanel.setLayout(namaPetugasPanelLayout);
        namaPetugasPanelLayout.setHorizontalGroup(
            namaPetugasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, namaPetugasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(namaLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(PetugasComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        namaPetugasPanelLayout.setVerticalGroup(
            namaPetugasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namaPetugasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(namaPetugasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PetugasComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tanggalLayananPanel.setBackground(new java.awt.Color(83, 37, 103));

        tanggalLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        tanggalLabel.setForeground(new java.awt.Color(255, 255, 255));
        tanggalLabel.setText("Tanggal Layanan");

        tanggalDate.setDateFormatString("yyyy-MM-dd");
        tanggalDate.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

        javax.swing.GroupLayout tanggalLayananPanelLayout = new javax.swing.GroupLayout(tanggalLayananPanel);
        tanggalLayananPanel.setLayout(tanggalLayananPanelLayout);
        tanggalLayananPanelLayout.setHorizontalGroup(
            tanggalLayananPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tanggalLayananPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(tanggalLayananPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tanggalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tanggalDate, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        tanggalLayananPanelLayout.setVerticalGroup(
            tanggalLayananPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tanggalLayananPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tanggalLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tanggalDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        saveBtn.setBackground(new java.awt.Color(13, 110, 253));
        saveBtn.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setText("Save");
        saveBtn.setBorder(null);
        saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        cancelBtn.setBackground(new java.awt.Color(220, 53, 69));
        cancelBtn.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        cancelBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelBtn.setText("Cancel");
        cancelBtn.setBorder(null);
        cancelBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layananFormPanelLayout = new javax.swing.GroupLayout(layananFormPanel);
        layananFormPanel.setLayout(layananFormPanelLayout);
        layananFormPanelLayout.setHorizontalGroup(
            layananFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layananFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layananFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(namaKamarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(namaPetugasPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layananFormPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layananFormPanelLayout.createSequentialGroup()
                        .addComponent(LayananPanelbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tanggalLayananPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        layananFormPanelLayout.setVerticalGroup(
            layananFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layananFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(namaKamarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namaPetugasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layananFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LayananPanelbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tanggalLayananPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layananFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        mainPanel.add(layananFormPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 640, 370));

        judulKamarPanel.setBackground(new java.awt.Color(244, 233, 225));

        judulHotelLabel.setFont(new java.awt.Font("Arial Black", 1, 22)); // NOI18N
        judulHotelLabel.setText("Thousand Sunny Management System");

        judulCustomerLabel.setFont(new java.awt.Font("Arial Black", 1, 22)); // NOI18N
        judulCustomerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judulCustomerLabel.setText("Service Managment");

        javax.swing.GroupLayout judulKamarPanelLayout = new javax.swing.GroupLayout(judulKamarPanel);
        judulKamarPanel.setLayout(judulKamarPanelLayout);
        judulKamarPanelLayout.setHorizontalGroup(
            judulKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(judulKamarPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(judulKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(judulHotelLabel)
                    .addComponent(judulCustomerLabel))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        judulKamarPanelLayout.setVerticalGroup(
            judulKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(judulKamarPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(judulHotelLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(judulCustomerLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.add(judulKamarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, 480, 90));

        add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, -1, 870));
    }// </editor-fold>//GEN-END:initComponents

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        action = "delete";

        int dialog = JOptionPane.showConfirmDialog(rootPane, "yakin ingin melakukan " + action + "?");
        if(dialog == JOptionPane.CLOSED_OPTION || dialog == JOptionPane.NO_OPTION || dialog == JOptionPane.CANCEL_OPTION){
            return;
        } else if (dialog == JOptionPane.OK_OPTION){
            penyediaJasaControl.deleteData(selectedId);
        }
        
        setCount();
        clearText();
        setComponent(false);
        setEditDeleteBtn(false);
        addBtn.setEnabled(true);
        showTableBySearch("");
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void editBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBtnMouseClicked

    }//GEN-LAST:event_editBtnMouseClicked

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        action = "edit";
        setComponent(true);
        CustomerComboBox.setEnabled(false);
        setEditDeleteBtn(true);
    }//GEN-LAST:event_editBtnActionPerformed

    private void addBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseClicked

    }//GEN-LAST:event_addBtnMouseClicked

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        action = "add";
        setComponent(true);
    }//GEN-LAST:event_addBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        try{
            // EXCEPTION
            inputKosongException();

            // SET ATRIBUT DAN METODE PEMBAYARAN
            int counter = 0;
            String radio = "", tempJenis = "";
            float tempHarga = 0;
            Date now = new Date();
            
            // HARGA JASA
            float hargaMorningcall = 10000;
            float hargaPijat = 50000;
            float hargaAntarbarang = 15000;
                    
            

            // MENCARI INDEX YANG DITUNJUK OLEH DROPDOWN
            // CUSTOMER
            int selectedIndexCustomer = CustomerComboBox.getSelectedIndex();
            Booking selectedBooking= bookingList.get(selectedIndexCustomer);
            
            // PETUGAS
            int selectedIndexPetugas = PetugasComboBox1.getSelectedIndex();
            Petugas selectedPetugas = petugasList.get(selectedIndexPetugas);     
            
            String tempId_jasa = penyediaJasaControl.generateId();
            
            
            if(pijat.isSelected() && morningcall.isSelected() && antarbarang.isSelected()){
                tempHarga = hargaMorningcall + hargaPijat + hargaAntarbarang ;
                tempJenis = "Semua Jasa";
            }else{
                if(pijat.isSelected()){
                    if(morningcall.isSelected()){
                        tempHarga = hargaPijat + hargaMorningcall;
                        tempJenis = "Pijat dan Morning call";
                    } else if (antarbarang.isSelected()){
                        tempHarga = hargaPijat + hargaAntarbarang;
                        tempJenis = "Pijat dan Antar barang";
                    } else {
                        tempHarga = hargaPijat;
                        tempJenis = "Pijat";
                    }
                }
                
                if(morningcall.isSelected()){
                    if(pijat.isSelected()){
                        tempHarga = hargaMorningcall + hargaPijat;
                        tempJenis = "Pijat dan Morning call";
                    } else if (antarbarang.isSelected()){
                        tempHarga = hargaMorningcall + hargaAntarbarang;
                        tempJenis = "Morning call dan Antar barang";
                    } else {
                        tempHarga = hargaMorningcall;
                        tempJenis = "Morning call";
                    }
                }

                if(antarbarang.isSelected()){
                    if(pijat.isSelected()){
                        tempHarga = hargaAntarbarang + hargaPijat;
                        tempJenis = "Pijat dan Antar barang";
                    } else if (morningcall.isSelected()){
                        tempHarga = hargaAntarbarang + hargaMorningcall;
                        tempJenis = "Morning call dan Antar barang";
                    } else {
                        tempHarga = hargaAntarbarang;
                        tempJenis = "Antar Barang";
                    }
                }
            }
            
            String toDate1 = tanggalDate.getDate().toString();
            String toDate2 = now.toString();
            
            SimpleDateFormat inputFormatTime = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");            
            Date date1 = null, date2 = null, date3 = null, date4 = null;

            try {               
                date1 = inputFormatTime.parse(toDate1);
                date2 = inputFormatTime.parse(toDate2);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate1 = outputFormat.format(date1);
            System.out.println(formattedDate1);
            
            try {               
                date3 = outputFormat.parse(selectedBooking.getCheckInDate());
                date4 = outputFormat.parse(selectedBooking.getCheckOutDate());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(date1);
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(date2);
            Calendar cal3 = Calendar.getInstance();
            cal3.setTime(date3);
            Calendar cal4 = Calendar.getInstance();
            cal4.setTime(date4);
           
                        
                         cal1.set(Calendar.HOUR_OF_DAY, 0);
                         cal1.set(Calendar.MINUTE, 0);
                         cal1.set(Calendar.SECOND, 0);
                         cal1.set(Calendar.MILLISECOND, 0);

                         cal2.set(Calendar.HOUR_OF_DAY, 0);
                         cal2.set(Calendar.MINUTE, 0);
                         cal2.set(Calendar.SECOND, 0);
                         cal2.set(Calendar.MILLISECOND, 0);
                         
                         cal3.set(Calendar.HOUR_OF_DAY, 0);
                         cal3.set(Calendar.MINUTE, 0);
                         cal3.set(Calendar.SECOND, 0);
                         cal3.set(Calendar.MILLISECOND, 0);

                         cal4.set(Calendar.HOUR_OF_DAY, 0);
                         cal4.set(Calendar.MINUTE, 0);
                         cal4.set(Calendar.SECOND, 0);
                         cal4.set(Calendar.MILLISECOND, 0);

                    if ((cal1.after(cal3) && cal1.before(cal4)) || ((cal1.equals(cal3)|| cal1.equals(cal4))) ){
                        
                    } else{
                        JOptionPane.showMessageDialog(this, "TANGGAL TIDAK TERMASUK DALAM TANGGAL BOOKING ");
                        return;
                    }
            
            int dialog = JOptionPane.showConfirmDialog(rootPane, "yakin ingin melakukan " + action + "?");
            if(dialog == JOptionPane.CLOSED_OPTION || dialog == JOptionPane.NO_OPTION || dialog == JOptionPane.CANCEL_OPTION){
                return;
            } else if (dialog == JOptionPane.OK_OPTION){
                if(action.equals("add")){
                    PenyediaJasa dataNew = new PenyediaJasa(tempId_jasa, selectedBooking.getId_customer(), selectedPetugas.getId_petugas(), tempJenis, tempHarga,  formattedDate1,
                         selectedBooking, selectedPetugas);
                    penyediaJasaControl.insertData(dataNew);
                } else {
                    PenyediaJasa dataNew = new PenyediaJasa(selectedBooking.getId_customer(), selectedPetugas.getId_petugas(), tempJenis, tempHarga,  formattedDate1,
                         selectedBooking, selectedPetugas);
                    penyediaJasaControl.updateData(dataNew, selectedId);
                    selectedId = "-1";
                }
            }
        }catch(InputKosongException e){
            JOptionPane.showMessageDialog(this, e.message());
        }
        
        setCount();
        clearText();
        setComponent(false);
        setEditDeleteBtn(false);
        addBtn.setEnabled(true);
        showTableBySearch("");
              
    }//GEN-LAST:event_saveBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
                clearText();
                setComponent(false);
                setEditDeleteBtn(false);
        
                addBtn.setEnabled(true);
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void inputSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputSearchMouseClicked

    }//GEN-LAST:event_inputSearchMouseClicked

    private void searchBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBtnMouseClicked

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        showTableBySearch(inputSearch.getText());

        clearText();
        setComponent(false);
        setEditDeleteBtn(false);
        addBtn.setEnabled(true);
    }//GEN-LAST:event_searchBtnActionPerformed

    private void TableLayananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableLayananMouseClicked
        // TODO add your handling code here:
        int indexPetugas = -1, indexCustomer = -1;
        action = "edit";
        
        addBtn.setEnabled(false);
        cancelBtn.setEnabled(true);
        saveBtn.setEnabled(true);
        setEditDeleteBtn(true);

        setComponent(false);
        
        int clickedRow = TableLayanan.getSelectedRow();
        TableModel tableModel = TableLayanan.getModel();
        
        String selectedIdLayanan = tableModel.getValueAt(clickedRow, 5).toString();
        selectedId = selectedIdLayanan;
        
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = inputFormat.parse(tableModel.getValueAt(clickedRow, 3).toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
            calendar.set(Calendar.HOUR_OF_DAY, 17);
            calendar.set(Calendar.MINUTE, 19);
            calendar.set(Calendar.SECOND, 27);
        }
        
        Date dateWithTime = calendar.getTime();
        SimpleDateFormat outputFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        tanggalDate.setDate(dateWithTime);
        
        String checkbox = tableModel.getValueAt(clickedRow, 2).toString();
        
        pijat.setSelected(false);
        morningcall.setSelected(false);
        antarbarang.setSelected(false);
        
        switch(checkbox){
            case "Pijat" :
                pijat.setSelected(true);
            break;
            case "Morning call":
                morningcall.setSelected(true);
            break;
            case "Antar Barang" :
                antarbarang.setSelected(true);
            break;
            case "Semua Jasa" : 
                pijat.setSelected(true);
                morningcall.setSelected(true);
                antarbarang.setSelected(true);
            break;
            case "Pijat dan Morning call":
                pijat.setSelected(true);
                morningcall.setSelected(true);
            break;
            case "Pijat dan Antar barang" :
                pijat.setSelected(true);
                antarbarang.setSelected(true);
            break;
            case "Morning call dan Antar barang" : 
                morningcall.setSelected(true);    
                antarbarang.setSelected(true);
            break;
        }
        
        for(Petugas petugas : petugasList){
            if(petugas.getId_petugas().equals(tableModel.getValueAt(clickedRow, 7).toString())){
                indexPetugas = petugasList.indexOf(petugas);
            }
        }
        
        for(Booking booking : bookingList){
            if(booking.getId_booking().equals(tableModel.getValueAt(clickedRow, 6).toString())){
                indexCustomer = bookingList.indexOf(booking);
            }
        }
        
        CustomerComboBox.setSelectedIndex(indexCustomer);
        PetugasComboBox1.setSelectedIndex(indexPetugas);
        cancelBtn.setEnabled(true);
    }//GEN-LAST:event_TableLayananMouseClicked

    private void CustomerComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CustomerComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Booking> CustomerComboBox;
    private javax.swing.JPanel LayananPanelbox;
    private javax.swing.JComboBox<Petugas> PetugasComboBox1;
    private javax.swing.JTable TableLayanan;
    private javax.swing.JButton addBtn;
    private javax.swing.JCheckBox antarbarang;
    private javax.swing.JPanel buttonLayananPanel;
    private javax.swing.JButton cancelBtn;
    private costum.JpanelRound countPanel;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JTextField inputSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel judulCustomerLabel;
    private javax.swing.JLabel judulHotelLabel;
    private javax.swing.JPanel judulKamarPanel;
    private costum.JpanelRound layananFormPanel;
    private javax.swing.JLabel layananLabel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JCheckBox morningcall;
    private javax.swing.JPanel namaKamarPanel;
    private javax.swing.JLabel namaLabel;
    private javax.swing.JLabel namaLabel1;
    private javax.swing.JPanel namaPetugasPanel;
    private javax.swing.JCheckBox pijat;
    private javax.swing.JLabel roomPict;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JPanel searchLayananPanel;
    private javax.swing.JPanel tableLayanan;
    private com.toedter.calendar.JDateChooser tanggalDate;
    private javax.swing.JLabel tanggalLabel;
    private javax.swing.JPanel tanggalLayananPanel;
    private costum.JpanelRound thumbnailPanel;
    // End of variables declaration//GEN-END:variables
}
