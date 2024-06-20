
package panel;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import java.awt.Component;
import Control.KamarControl;
import Control.CustomerControl;
import Control.PetugasControl;
import model.Kamar;
import model.Customer;
import model.Petugas;
import exception.*;

public class PetugasPanel extends javax.swing.JPanel {

    private PetugasControl pc = new PetugasControl();
    private Petugas p = null;
    
    private KamarControl kamarControl;
    private CustomerControl customerControl;
    private PetugasControl petugasControl;
    
    String action = null, selectedId = "";
    private Component rootPane;

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
    
    public boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    // EXCEPTION
    public void inputKosongException() throws InputKosongException{
        if(inputIdPetugas.getText().isEmpty() || namaTextField.getText().isEmpty() 
            || tahunTextField.getText().isEmpty() || nomorTeleponTextField.getText().isEmpty()
            ||jenisKelaminGroup.getSelection() == null){
               throw new InputKosongException();
        }        
    }
    
    private void InvalidNoTelpException() throws InvalidNoTelpException{
        if(!nomorTeleponTextField.getText().matches("^\\+?[0-9]+$"))
            throw new InvalidNoTelpException();
    }
    
    //RADIO BUTTON
    public void setRadioButtonValue(){
        lakiBtn.setActionCommand("Laki-laki");
        perempuanBtn.setActionCommand("Perempuan");
    }
    
    //TABLE SHOW
    public void showTableBySearch(String target){
        TablePetugas.setModel(pc.showTable(target));
    }
    
    //Method-method

    private void setPetugasEditDeleteButton(boolean value) {
        editBtn.setEnabled(value);
        deleteBtn.setEnabled(value);
    }
    
    public void clearText(){
        
        //RESET RADIOBUTTON
        jenisKelaminGroup.clearSelection();
        
        //RESET TEXT
        inputIdPetugas.setText("");
        namaTextField.setText("");
        tahunTextField.setText("");
        nomorTeleponTextField.setText("");
    }
        
    public void setComponent(boolean value){
        inputIdPetugas.setEnabled(value);
        namaTextField.setEnabled(value);
        tahunTextField.setEnabled(value);
        nomorTeleponTextField.setEnabled(value);
        
        saveBtn.setEnabled(value);
        cancelBtn.setEnabled(value);
    }

    public void setRadioComponent(boolean value){
        lakiBtn.setEnabled(value);
        perempuanBtn.setEnabled(value);
    }

    private void doSearchCustomer() {
        if (inputSearch.getText().isEmpty())
            return;

        Petugas p = pc.searchPetugasById(inputSearch.getText());

        if (p != null) {
            setPetugasEditDeleteButton(true);
            inputIdPetugas.setText(p.getId_petugas());
            namaTextField.setText(p.getNama_petugas());
            tahunTextField.setText(Integer.toString(p.getTahun_bekerja()));
            nomorTeleponTextField.setText(p.getNo_telp());

        } else {
            JOptionPane.showMessageDialog(this,"Kamar tidak ditemukan!");
        }
    }
    
    public PetugasPanel() {
        initComponents();
        setOpaque(false);

        setRadioButtonValue();
        showTableBySearch("");
        
        customerControl = new CustomerControl();
        kamarControl = new KamarControl();
        petugasControl = new PetugasControl();
        
        //RESET
        setCount();
        clearText();
        setComponent(false);
        setRadioComponent(false);
        setPetugasEditDeleteButton(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jenisKelaminGroup = new javax.swing.ButtonGroup();
        mainPanel = new javax.swing.JPanel();
        searchCustomerPanel = new javax.swing.JPanel();
        inputSearch = new javax.swing.JTextField();
        tabelPetugasPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablePetugas = new javax.swing.JTable();
        judulKamarPanel = new javax.swing.JPanel();
        judulHotelLabel = new javax.swing.JLabel();
        judulKamarLabel = new javax.swing.JLabel();
        countPanel = new costum.JpanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        buttonPetugasPanel = new javax.swing.JPanel();
        addBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        thumbnailPanel = new costum.JpanelRound();
        jLabel8 = new javax.swing.JLabel();
        formPetugasPanel = new costum.JpanelRound();
        idPanel = new javax.swing.JPanel();
        idLabel = new javax.swing.JLabel();
        inputIdPetugas = new javax.swing.JTextField();
        namaPanel = new javax.swing.JPanel();
        namaLabel = new javax.swing.JLabel();
        namaTextField = new javax.swing.JTextField();
        tahunPanel = new javax.swing.JPanel();
        tahunLabel = new javax.swing.JLabel();
        tahunTextField = new javax.swing.JTextField();
        nomorTeleponPanel = new javax.swing.JPanel();
        nomorTeleponLabel = new javax.swing.JLabel();
        nomorTeleponTextField = new javax.swing.JTextField();
        kelaminPanel = new javax.swing.JPanel();
        kelaminLabel = new javax.swing.JLabel();
        lakiBtn = new javax.swing.JRadioButton();
        perempuanBtn = new javax.swing.JRadioButton();
        saveBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        searchBtn = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainPanel.setBackground(new java.awt.Color(244, 233, 225));

        searchCustomerPanel.setBackground(new java.awt.Color(244, 233, 225));
        searchCustomerPanel.setPreferredSize(new java.awt.Dimension(141, 47));

        inputSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inputSearchMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout searchCustomerPanelLayout = new javax.swing.GroupLayout(searchCustomerPanel);
        searchCustomerPanel.setLayout(searchCustomerPanelLayout);
        searchCustomerPanelLayout.setHorizontalGroup(
            searchCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(inputSearch, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        searchCustomerPanelLayout.setVerticalGroup(
            searchCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchCustomerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
        );

        tabelPetugasPanel.setBackground(new java.awt.Color(244, 233, 225));
        tabelPetugasPanel.setPreferredSize(new java.awt.Dimension(141, 47));

        TablePetugas.setModel(new javax.swing.table.DefaultTableModel(
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
        TablePetugas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablePetugasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablePetugas);

        javax.swing.GroupLayout tabelPetugasPanelLayout = new javax.swing.GroupLayout(tabelPetugasPanel);
        tabelPetugasPanel.setLayout(tabelPetugasPanelLayout);
        tabelPetugasPanelLayout.setHorizontalGroup(
            tabelPetugasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(tabelPetugasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tabelPetugasPanelLayout.createSequentialGroup()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        tabelPetugasPanelLayout.setVerticalGroup(
            tabelPetugasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 611, Short.MAX_VALUE)
            .addGroup(tabelPetugasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tabelPetugasPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        judulKamarPanel.setBackground(new java.awt.Color(244, 233, 225));

        judulHotelLabel.setBackground(new java.awt.Color(244, 233, 225));
        judulHotelLabel.setFont(new java.awt.Font("Arial Black", 1, 22)); // NOI18N
        judulHotelLabel.setText("Thousand Sunny Management System");

        judulKamarLabel.setBackground(new java.awt.Color(244, 233, 225));
        judulKamarLabel.setFont(new java.awt.Font("Arial Black", 1, 22)); // NOI18N
        judulKamarLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judulKamarLabel.setText("Petugas Managment");

        javax.swing.GroupLayout judulKamarPanelLayout = new javax.swing.GroupLayout(judulKamarPanel);
        judulKamarPanel.setLayout(judulKamarPanelLayout);
        judulKamarPanelLayout.setHorizontalGroup(
            judulKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(judulKamarPanelLayout.createSequentialGroup()
                .addGroup(judulKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(judulHotelLabel)
                    .addComponent(judulKamarLabel))
                .addGap(0, 32, Short.MAX_VALUE))
        );
        judulKamarPanelLayout.setVerticalGroup(
            judulKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(judulKamarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(judulHotelLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(judulKamarLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(countPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addGroup(countPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonPetugasPanel.setBackground(new java.awt.Color(244, 233, 225));
        buttonPetugasPanel.setPreferredSize(new java.awt.Dimension(141, 47));

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

        deleteBtn.setBackground(new java.awt.Color(220, 53, 69));
        deleteBtn.setFont(new java.awt.Font("Montserrat SemiBold", 1, 18)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonPetugasPanelLayout = new javax.swing.GroupLayout(buttonPetugasPanel);
        buttonPetugasPanel.setLayout(buttonPetugasPanelLayout);
        buttonPetugasPanelLayout.setHorizontalGroup(
            buttonPetugasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPetugasPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(buttonPetugasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)))
        );
        buttonPetugasPanelLayout.setVerticalGroup(
            buttonPetugasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPetugasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        thumbnailPanel.setBackground(new java.awt.Color(255, 255, 255));
        thumbnailPanel.setRoundBottomLeft(50);
        thumbnailPanel.setRoundBottomRight(50);
        thumbnailPanel.setRoundTopLeft(50);
        thumbnailPanel.setRoundTopRight(50);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/roomPict.png"))); // NOI18N

        javax.swing.GroupLayout thumbnailPanelLayout = new javax.swing.GroupLayout(thumbnailPanel);
        thumbnailPanel.setLayout(thumbnailPanelLayout);
        thumbnailPanelLayout.setHorizontalGroup(
            thumbnailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(thumbnailPanelLayout.createSequentialGroup()
                .addComponent(jLabel8)
                .addGap(0, 0, 0))
        );
        thumbnailPanelLayout.setVerticalGroup(
            thumbnailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        formPetugasPanel.setBackground(new java.awt.Color(83, 37, 103));
        formPetugasPanel.setMinimumSize(new java.awt.Dimension(669, 370));
        formPetugasPanel.setPreferredSize(new java.awt.Dimension(669, 370));
        formPetugasPanel.setRoundBottomLeft(25);
        formPetugasPanel.setRoundBottomRight(25);
        formPetugasPanel.setRoundTopLeft(25);
        formPetugasPanel.setRoundTopRight(25);
        formPetugasPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        idPanel.setBackground(new java.awt.Color(83, 37, 103));

        idLabel.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        idLabel.setForeground(new java.awt.Color(255, 255, 255));
        idLabel.setText("ID Petugas");

        inputIdPetugas.setBackground(new java.awt.Color(83, 37, 103));
        inputIdPetugas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        inputIdPetugas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        inputIdPetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputIdPetugasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout idPanelLayout = new javax.swing.GroupLayout(idPanel);
        idPanel.setLayout(idPanelLayout);
        idPanelLayout.setHorizontalGroup(
            idPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, idPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(idLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(inputIdPetugas, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        idPanelLayout.setVerticalGroup(
            idPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(idPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(idPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputIdPetugas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        formPetugasPanel.add(idPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 240, 50));

        namaPanel.setBackground(new java.awt.Color(83, 37, 103));

        namaLabel.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        namaLabel.setForeground(new java.awt.Color(255, 255, 255));
        namaLabel.setText("Nama");

        namaTextField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        namaTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        namaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout namaPanelLayout = new javax.swing.GroupLayout(namaPanel);
        namaPanel.setLayout(namaPanelLayout);
        namaPanelLayout.setHorizontalGroup(
            namaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, namaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(namaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addComponent(namaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        namaPanelLayout.setVerticalGroup(
            namaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(namaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(namaLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        formPetugasPanel.add(namaPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 620, 50));

        tahunPanel.setBackground(new java.awt.Color(83, 37, 103));

        tahunLabel.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        tahunLabel.setForeground(new java.awt.Color(255, 255, 255));
        tahunLabel.setText("Tahun Bekerja");

        tahunTextField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tahunTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tahunTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tahunTextFieldActionPerformed(evt);
            }
        });
        tahunTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tahunTextFieldKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout tahunPanelLayout = new javax.swing.GroupLayout(tahunPanel);
        tahunPanel.setLayout(tahunPanelLayout);
        tahunPanelLayout.setHorizontalGroup(
            tahunPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tahunPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tahunLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(tahunTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        tahunPanelLayout.setVerticalGroup(
            tahunPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tahunPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tahunPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tahunTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tahunLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        formPetugasPanel.add(tahunPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 620, 50));

        nomorTeleponPanel.setBackground(new java.awt.Color(83, 37, 103));

        nomorTeleponLabel.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        nomorTeleponLabel.setForeground(new java.awt.Color(255, 255, 255));
        nomorTeleponLabel.setText("Nomor Telepon");

        nomorTeleponTextField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nomorTeleponTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        nomorTeleponTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomorTeleponTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout nomorTeleponPanelLayout = new javax.swing.GroupLayout(nomorTeleponPanel);
        nomorTeleponPanel.setLayout(nomorTeleponPanelLayout);
        nomorTeleponPanelLayout.setHorizontalGroup(
            nomorTeleponPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nomorTeleponPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nomorTeleponLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(nomorTeleponTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        nomorTeleponPanelLayout.setVerticalGroup(
            nomorTeleponPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nomorTeleponPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(nomorTeleponPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomorTeleponTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomorTeleponLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        formPetugasPanel.add(nomorTeleponPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 620, -1));

        kelaminPanel.setBackground(new java.awt.Color(83, 37, 103));

        kelaminLabel.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        kelaminLabel.setForeground(new java.awt.Color(255, 255, 255));
        kelaminLabel.setText("Jenis Kelamin");

        jenisKelaminGroup.add(lakiBtn);
        lakiBtn.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lakiBtn.setForeground(new java.awt.Color(255, 255, 255));
        lakiBtn.setText("Laki-laki");

        jenisKelaminGroup.add(perempuanBtn);
        perempuanBtn.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        perempuanBtn.setForeground(new java.awt.Color(255, 255, 255));
        perempuanBtn.setText("Perempuan");

        javax.swing.GroupLayout kelaminPanelLayout = new javax.swing.GroupLayout(kelaminPanel);
        kelaminPanel.setLayout(kelaminPanelLayout);
        kelaminPanelLayout.setHorizontalGroup(
            kelaminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kelaminPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kelaminLabel)
                .addGap(44, 44, 44)
                .addComponent(lakiBtn)
                .addGap(18, 18, 18)
                .addComponent(perempuanBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kelaminPanelLayout.setVerticalGroup(
            kelaminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kelaminPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kelaminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kelaminLabel)
                    .addComponent(lakiBtn)
                    .addComponent(perempuanBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        formPetugasPanel.add(kelaminPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 500, -1));

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
        formPetugasPanel.add(saveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, 101, 48));

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
        formPetugasPanel.add(cancelBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 290, 103, 48));

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

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(countPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonPetugasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(thumbnailPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(formPetugasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tabelPetugasPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(searchCustomerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(judulKamarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(judulKamarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(searchCustomerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tabelPetugasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(countPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonPetugasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(thumbnailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(formPetugasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void searchBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBtnMouseClicked

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        showTableBySearch(inputSearch.getText());

        clearText();
        setComponent(false);
        setPetugasEditDeleteButton(false);
        setRadioComponent(false);
        jenisKelaminGroup.clearSelection();
        addBtn.setEnabled(true);
    }//GEN-LAST:event_searchBtnActionPerformed

    private void inputSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputSearchMouseClicked

    }//GEN-LAST:event_inputSearchMouseClicked

    private void TablePetugasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePetugasMouseClicked
        int indexCustomer = -1;
        action = "edit";

        addBtn.setEnabled(false);
        deleteBtn.setEnabled(true);
        saveBtn.setEnabled(true);
        setPetugasEditDeleteButton(true);

        setComponent(false);
        setRadioComponent(false);
        jenisKelaminGroup.clearSelection();

        int clickedRow = TablePetugas.getSelectedRow();
        TableModel tableModel = TablePetugas.getModel();

        String selectedIdPetugas = tableModel.getValueAt(clickedRow, 0).toString();
        selectedId = selectedIdPetugas;
        inputIdPetugas.setText(tableModel.getValueAt(clickedRow, 0).toString());
        namaTextField.setText(tableModel.getValueAt(clickedRow, 1).toString());

        tahunTextField.setText(tableModel.getValueAt(clickedRow, 4).toString());
        nomorTeleponTextField.setText(tableModel.getValueAt(clickedRow, 2).toString());

        String jenisKelamin = tableModel.getValueAt(clickedRow, 3).toString();

        switch(jenisKelamin){
            case "Laki-laki" :
            lakiBtn.setSelected(true);
            break;
            case "Perempuan" :
            perempuanBtn.setSelected(true);
            break;
        }

        cancelBtn.setEnabled(true);
        inputIdPetugas.setEnabled(false);
    }//GEN-LAST:event_TablePetugasMouseClicked

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        action = "delete";

        int dialog = JOptionPane.showConfirmDialog(this, "yakin ingin melakukan " + action + "?");
        if(dialog == JOptionPane.CLOSED_OPTION || dialog == JOptionPane.NO_OPTION || dialog == JOptionPane.CANCEL_OPTION){
            return;
        } else if (dialog == JOptionPane.OK_OPTION){
           pc.deleteDataPetugas(selectedId);
        }
        
        setCount();
        clearText();
        setComponent(false);
        inputIdPetugas.setEnabled(false);
        namaTextField.setEnabled(false);
        tahunTextField.setEnabled(false);
        nomorTeleponTextField.setEnabled(false);
        setPetugasEditDeleteButton(false);
        setRadioComponent(false);
        addBtn.setEnabled(true);
        showTableBySearch("");
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void editBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBtnMouseClicked

    }//GEN-LAST:event_editBtnMouseClicked

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        action = "edit";
        setComponent(true);
        inputIdPetugas.setEnabled(false);
        namaTextField.setEnabled(true);
        tahunTextField.setEnabled(true);
        nomorTeleponTextField.setEnabled(true);
        setPetugasEditDeleteButton(true);
        setRadioComponent(true);
    }//GEN-LAST:event_editBtnActionPerformed

    private void addBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseClicked

    }//GEN-LAST:event_addBtnMouseClicked

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        action = "add";
        setComponent(true);
        setRadioComponent(true);
        
        inputIdPetugas.setEditable(false);
        inputIdPetugas.setText(pc.generateId());
    }//GEN-LAST:event_addBtnActionPerformed

    private void inputIdPetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputIdPetugasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputIdPetugasActionPerformed

    private void namaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaTextFieldActionPerformed

    private void tahunTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tahunTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tahunTextFieldActionPerformed

    private void nomorTeleponTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomorTeleponTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomorTeleponTextFieldActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        try{

            // EXCEPTION
            inputKosongException();
            InvalidNoTelpException();
            String jenisKelamin = "";

            jenisKelamin = jenisKelaminGroup.getSelection().getActionCommand();

            int dialog = JOptionPane.showConfirmDialog(this, "yakin ingin melakukan " + action + "?");
            if(dialog == JOptionPane.CLOSED_OPTION || dialog == JOptionPane.NO_OPTION || dialog == JOptionPane.CANCEL_OPTION){
                return;
            } else if (dialog == JOptionPane.OK_OPTION){
                if(action.equals("add")){
                    Petugas data = new Petugas(
                        inputIdPetugas.getText(),
                        namaTextField.getText(),
                        nomorTeleponTextField.getText(),
                        jenisKelamin,
                        Integer.parseInt(tahunTextField.getText()));
                    pc.InsertDataPetugas(data);
                } else {
                    Petugas data = new Petugas(
                        inputIdPetugas.getText(),
                        namaTextField.getText(),
                        nomorTeleponTextField.getText(),
                        jenisKelamin,
                        Integer.parseInt(tahunTextField.getText()));
                    pc.updatePetugas(data,selectedId);
                    selectedId = "-1";
                }
            }
        }catch(InputKosongException e){
            JOptionPane.showMessageDialog(this, e.message());
        }catch(InvalidNoTelpException e){
            JOptionPane.showMessageDialog(rootPane, e.message());
        }

        setCount();
        clearText();
        setComponent(false);
        setPetugasEditDeleteButton(false);;
        setRadioComponent(false);
        jenisKelaminGroup.clearSelection();
        addBtn.setEnabled(true);
        showTableBySearch("");
    }//GEN-LAST:event_saveBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        clearText();
        setComponent(false);
        setPetugasEditDeleteButton(false);
        setRadioComponent(false);

        addBtn.setEnabled(true);
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void tahunTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tahunTextFieldKeyTyped
        char key = evt.getKeyChar();
        if(!Character.isDigit(key) || key == '.'){
            evt.consume();
            JOptionPane.showMessageDialog(
                null, "Hanya bisa masukan angka !!", "Input Failure", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tahunTextFieldKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablePetugas;
    private javax.swing.JButton addBtn;
    private javax.swing.JPanel buttonPetugasPanel;
    private javax.swing.JButton cancelBtn;
    private costum.JpanelRound countPanel;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private costum.JpanelRound formPetugasPanel;
    private javax.swing.JLabel idLabel;
    private javax.swing.JPanel idPanel;
    private javax.swing.JTextField inputIdPetugas;
    private javax.swing.JTextField inputSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.ButtonGroup jenisKelaminGroup;
    private javax.swing.JLabel judulHotelLabel;
    private javax.swing.JLabel judulKamarLabel;
    private javax.swing.JPanel judulKamarPanel;
    private javax.swing.JLabel kelaminLabel;
    private javax.swing.JPanel kelaminPanel;
    private javax.swing.JRadioButton lakiBtn;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel namaLabel;
    private javax.swing.JPanel namaPanel;
    private javax.swing.JTextField namaTextField;
    private javax.swing.JLabel nomorTeleponLabel;
    private javax.swing.JPanel nomorTeleponPanel;
    private javax.swing.JTextField nomorTeleponTextField;
    private javax.swing.JRadioButton perempuanBtn;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JPanel searchCustomerPanel;
    private javax.swing.JPanel tabelPetugasPanel;
    private javax.swing.JLabel tahunLabel;
    private javax.swing.JPanel tahunPanel;
    private javax.swing.JTextField tahunTextField;
    private costum.JpanelRound thumbnailPanel;
    // End of variables declaration//GEN-END:variables
}
