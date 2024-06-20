package panel;
//import exception.*;

import Control.BookingControl;
import javax.swing.UIManager;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import java.awt.Component;
import Control.KamarControl;
import Control.CustomerControl;
import Control.PetugasControl;
import model.Kamar;
import model.Customer;
import model.Petugas;
import costum.*;
import exception.InputKosongException;
import java.awt.Color;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import model.Booking;


public class KamarPanel extends javax.swing.JPanel {
    
    private KamarControl kamarControl;
    private CustomerControl customerControl;
    private PetugasControl petugasControl;
    
    private KamarControl kc = new KamarControl();
    
    private Kamar k = null;
    String action = null, selectedId = "";
    int idKamar = 0;
    
    List<Kamar> kamarList;
    List<Customer> customerList;
    List<Petugas> petugasList;
    List<Booking> bookingList;
    
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
        if(inputNomorKamar.getText().isEmpty() || inputHargaKamar.getText().isEmpty()
            ||(!ac.isSelected() && !tv.isSelected() && !heater.isSelected())
            || tipeKamarGroup.getSelection() == null){
               throw new InputKosongException();
        }        
    }
    
    //RADIO BUTTON
    public void setRadioButtonValue(){
        singleRadio.setActionCommand("Single");
        doubleRadio.setActionCommand("Double");
        suiteRadio.setActionCommand("Suite");
    }
    
    //TABLE SHOW
    public void showTableBySearch(String target){
        tabelKamar.setModel(kc.showTable(target));
    }
    
    //Method-method

    private void setKamarEditDeleteButton(boolean value) {
        editBtn.setEnabled(value);
        deleteBtn.setEnabled(value);
    }
    
    public void clearText(){
        
        //RESET CHECKBOX
        ac.setSelected(false);
        tv.setSelected(false);
        heater.setSelected(false);
        
        //RESET RADIOBUTTON
        tipeKamarGroup.clearSelection();
        
        //RESET TEXT
        inputNomorKamar.setText("");
        inputHargaKamar.setText("");

    }
        
    public void setComponent(boolean value){
        inputNomorKamar.setEnabled(value);
        inputHargaKamar.setEnabled(value);
               
        ac.setEnabled(value);
        tv.setEnabled(value);
        heater.setEnabled(value);
        
        saveBtn.setEnabled(value);
        cancelBtn.setEnabled(value);
    }

    public void setRadioComponent(boolean value){
        singleRadio.setEnabled(value);
        doubleRadio.setEnabled(value);
        suiteRadio.setEnabled(value);
    }

    private void doSearchKamar() {
        if (inputSearch.getText().isEmpty())
            return;

        Kamar k = kc.searchKamarByNomor(inputSearch.getText());

        if (k != null) {
            setKamarEditDeleteButton(true);
            inputNomorKamar.setText(k.getId_kamar());
            inputHargaKamar.setText(Float.toString(k.getHarga()));

        } else {
            JOptionPane.showMessageDialog(this,"Kamar tidak ditemukan!");
        }
    }
    
    public KamarPanel() {
        
        initComponents();
        setOpaque(false);
        setRadioButtonValue();

        customerControl = new CustomerControl();
        kamarControl = new KamarControl();
        petugasControl = new PetugasControl();
        
        showTableBySearch("");
        
        //RESET
        setCount();
        clearText();
        setComponent(false);
        setRadioComponent(false);
        setKamarEditDeleteButton(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipeKamarGroup = new javax.swing.ButtonGroup();
        mainPanel = new javax.swing.JPanel();
        judulKamarPanel = new javax.swing.JPanel();
        judulHotelLabel = new javax.swing.JLabel();
        judulKamarLabel = new javax.swing.JLabel();
        searchKamarPanel = new javax.swing.JPanel();
        searchBtn = new javax.swing.JButton();
        inputSearch = new javax.swing.JTextField();
        tabelKamarPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelKamar = new javax.swing.JTable();
        jpanelRound1 = new costum.JpanelRound();
        namaLabel1 = new javax.swing.JLabel();
        buttonKamarPanel = new javax.swing.JPanel();
        deleteBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        countPanel = new costum.JpanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        formKamarPanel = new costum.JpanelRound();
        hargaKamarPanel = new javax.swing.JPanel();
        inputHargaKamar = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        hargaLabel1 = new javax.swing.JLabel();
        namaKamarPanel = new javax.swing.JPanel();
        namaLabel = new javax.swing.JLabel();
        inputNomorKamar = new javax.swing.JTextField();
        jenisKamarPanel = new javax.swing.JPanel();
        jenisLabel = new javax.swing.JLabel();
        singleRadio = new javax.swing.JRadioButton();
        doubleRadio = new javax.swing.JRadioButton();
        suiteRadio = new javax.swing.JRadioButton();
        fasititasKamarPanel = new javax.swing.JPanel();
        fasilitasLabel = new javax.swing.JLabel();
        ac = new javax.swing.JCheckBox();
        tv = new javax.swing.JCheckBox();
        heater = new javax.swing.JCheckBox();
        thumbnailPanel = new costum.JpanelRound();
        roomPict = new javax.swing.JLabel();

        setBackground(new java.awt.Color(244, 233, 225));

        mainPanel.setBackground(new java.awt.Color(244, 233, 225));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        judulKamarPanel.setBackground(new java.awt.Color(244, 233, 225));

        judulHotelLabel.setBackground(new java.awt.Color(244, 233, 225));
        judulHotelLabel.setFont(new java.awt.Font("Arial Black", 1, 22)); // NOI18N
        judulHotelLabel.setText("Thousand Sunny Management System");

        judulKamarLabel.setBackground(new java.awt.Color(244, 233, 225));
        judulKamarLabel.setFont(new java.awt.Font("Arial Black", 1, 22)); // NOI18N
        judulKamarLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judulKamarLabel.setText("Rooms Managment");

        javax.swing.GroupLayout judulKamarPanelLayout = new javax.swing.GroupLayout(judulKamarPanel);
        judulKamarPanel.setLayout(judulKamarPanelLayout);
        judulKamarPanelLayout.setHorizontalGroup(
            judulKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(judulKamarPanelLayout.createSequentialGroup()
                .addGroup(judulKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(judulHotelLabel)
                    .addComponent(judulKamarLabel))
                .addGap(0, 0, Short.MAX_VALUE))
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

        mainPanel.add(judulKamarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 20, 470, -1));

        searchKamarPanel.setBackground(new java.awt.Color(244, 233, 225));
        searchKamarPanel.setPreferredSize(new java.awt.Dimension(141, 47));

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

        inputSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inputSearchMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout searchKamarPanelLayout = new javax.swing.GroupLayout(searchKamarPanel);
        searchKamarPanel.setLayout(searchKamarPanelLayout);
        searchKamarPanelLayout.setHorizontalGroup(
            searchKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchKamarPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(inputSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        searchKamarPanelLayout.setVerticalGroup(
            searchKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchKamarPanelLayout.createSequentialGroup()
                .addGroup(searchKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(inputSearch)
                    .addComponent(searchBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        mainPanel.add(searchKamarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 120, 470, -1));

        tabelKamarPanel.setBackground(new java.awt.Color(244, 233, 225));
        tabelKamarPanel.setPreferredSize(new java.awt.Dimension(141, 47));

        tabelKamar.setAutoCreateRowSorter(true);
        tabelKamar.setBorder(null);
        tabelKamar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tabelKamar.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelKamar.setGridColor(new java.awt.Color(255, 255, 255));
        tabelKamar.setName(""); // NOI18N
        tabelKamar.setSelectionBackground(new java.awt.Color(159, 168, 208));
        tabelKamar.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tabelKamar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelKamarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelKamar);

        jpanelRound1.setBackground(new java.awt.Color(83, 37, 103));
        jpanelRound1.setBorder(null);
        jpanelRound1.setRoundBottomLeft(25);
        jpanelRound1.setRoundBottomRight(25);
        jpanelRound1.setRoundTopLeft(25);
        jpanelRound1.setRoundTopRight(25);

        namaLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        namaLabel1.setForeground(new java.awt.Color(255, 255, 255));
        namaLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        namaLabel1.setText("Sunsets proof that endings can be beautiful.");

        javax.swing.GroupLayout jpanelRound1Layout = new javax.swing.GroupLayout(jpanelRound1);
        jpanelRound1.setLayout(jpanelRound1Layout);
        jpanelRound1Layout.setHorizontalGroup(
            jpanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(namaLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpanelRound1Layout.setVerticalGroup(
            jpanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelRound1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(namaLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tabelKamarPanelLayout = new javax.swing.GroupLayout(tabelKamarPanel);
        tabelKamarPanel.setLayout(tabelKamarPanelLayout);
        tabelKamarPanelLayout.setHorizontalGroup(
            tabelKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabelKamarPanelLayout.createSequentialGroup()
                .addGroup(tabelKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpanelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 18, Short.MAX_VALUE))
        );
        tabelKamarPanelLayout.setVerticalGroup(
            tabelKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabelKamarPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpanelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 73, Short.MAX_VALUE))
        );

        mainPanel.add(tabelKamarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(697, 176, 500, 696));

        buttonKamarPanel.setBackground(new java.awt.Color(244, 233, 225));
        buttonKamarPanel.setPreferredSize(new java.awt.Dimension(141, 47));

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

        javax.swing.GroupLayout buttonKamarPanelLayout = new javax.swing.GroupLayout(buttonKamarPanel);
        buttonKamarPanel.setLayout(buttonKamarPanelLayout);
        buttonKamarPanelLayout.setHorizontalGroup(
            buttonKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonKamarPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(buttonKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(editBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        buttonKamarPanelLayout.setVerticalGroup(
            buttonKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonKamarPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        mainPanel.add(buttonKamarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(464, 17, 210, 160));

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

        formKamarPanel.setBackground(new java.awt.Color(83, 37, 103));
        formKamarPanel.setRoundBottomLeft(25);
        formKamarPanel.setRoundBottomRight(25);
        formKamarPanel.setRoundTopLeft(25);
        formKamarPanel.setRoundTopRight(25);

        hargaKamarPanel.setBackground(new java.awt.Color(83, 37, 103));

        inputHargaKamar.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        inputHargaKamar.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        inputHargaKamar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputHargaKamarActionPerformed(evt);
            }
        });
        inputHargaKamar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputHargaKamarKeyTyped(evt);
            }
        });

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

        hargaLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        hargaLabel1.setForeground(new java.awt.Color(255, 255, 255));
        hargaLabel1.setText("Harga Kamar  Rp.");

        javax.swing.GroupLayout hargaKamarPanelLayout = new javax.swing.GroupLayout(hargaKamarPanel);
        hargaKamarPanel.setLayout(hargaKamarPanelLayout);
        hargaKamarPanelLayout.setHorizontalGroup(
            hargaKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hargaKamarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(hargaKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(hargaKamarPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(hargaKamarPanelLayout.createSequentialGroup()
                        .addComponent(hargaLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(inputHargaKamar, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
        );
        hargaKamarPanelLayout.setVerticalGroup(
            hargaKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hargaKamarPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(hargaKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputHargaKamar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hargaLabel1))
                .addGap(12, 12, 12)
                .addGroup(hargaKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(saveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        namaKamarPanel.setBackground(new java.awt.Color(83, 37, 103));

        namaLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        namaLabel.setForeground(new java.awt.Color(255, 255, 255));
        namaLabel.setText("Nomor Kamar");

        inputNomorKamar.setBackground(new java.awt.Color(83, 37, 103));
        inputNomorKamar.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        inputNomorKamar.setForeground(new java.awt.Color(255, 255, 255));
        inputNomorKamar.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        javax.swing.GroupLayout namaKamarPanelLayout = new javax.swing.GroupLayout(namaKamarPanel);
        namaKamarPanel.setLayout(namaKamarPanelLayout);
        namaKamarPanelLayout.setHorizontalGroup(
            namaKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, namaKamarPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(namaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputNomorKamar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        namaKamarPanelLayout.setVerticalGroup(
            namaKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namaKamarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(namaKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputNomorKamar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jenisKamarPanel.setBackground(new java.awt.Color(83, 37, 103));

        jenisLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jenisLabel.setForeground(new java.awt.Color(255, 255, 255));
        jenisLabel.setText("Tipe Kamar");

        tipeKamarGroup.add(singleRadio);
        singleRadio.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        singleRadio.setForeground(new java.awt.Color(255, 255, 255));
        singleRadio.setText("Single ");

        tipeKamarGroup.add(doubleRadio);
        doubleRadio.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        doubleRadio.setForeground(new java.awt.Color(255, 255, 255));
        doubleRadio.setText("Double");
        doubleRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doubleRadioActionPerformed(evt);
            }
        });

        tipeKamarGroup.add(suiteRadio);
        suiteRadio.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        suiteRadio.setForeground(new java.awt.Color(255, 255, 255));
        suiteRadio.setText("Suite");

        javax.swing.GroupLayout jenisKamarPanelLayout = new javax.swing.GroupLayout(jenisKamarPanel);
        jenisKamarPanel.setLayout(jenisKamarPanelLayout);
        jenisKamarPanelLayout.setHorizontalGroup(
            jenisKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jenisKamarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jenisKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(singleRadio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(doubleRadio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(suiteRadio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jenisLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jenisKamarPanelLayout.setVerticalGroup(
            jenisKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jenisKamarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jenisLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(singleRadio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(doubleRadio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(suiteRadio)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        fasititasKamarPanel.setBackground(new java.awt.Color(83, 37, 103));

        fasilitasLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        fasilitasLabel.setForeground(new java.awt.Color(255, 255, 255));
        fasilitasLabel.setText("Fasilitas  Kamar");

        ac.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        ac.setForeground(new java.awt.Color(255, 255, 255));
        ac.setText("AC");

        tv.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        tv.setForeground(new java.awt.Color(255, 255, 255));
        tv.setText("Televisi");

        heater.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        heater.setForeground(new java.awt.Color(255, 255, 255));
        heater.setText("Heater");

        javax.swing.GroupLayout fasititasKamarPanelLayout = new javax.swing.GroupLayout(fasititasKamarPanel);
        fasititasKamarPanel.setLayout(fasititasKamarPanelLayout);
        fasititasKamarPanelLayout.setHorizontalGroup(
            fasititasKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fasititasKamarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fasititasKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(heater, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(fasititasKamarPanelLayout.createSequentialGroup()
                        .addComponent(fasilitasLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        fasititasKamarPanelLayout.setVerticalGroup(
            fasititasKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fasititasKamarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fasilitasLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ac)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tv)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(heater)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout formKamarPanelLayout = new javax.swing.GroupLayout(formKamarPanel);
        formKamarPanel.setLayout(formKamarPanelLayout);
        formKamarPanelLayout.setHorizontalGroup(
            formKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formKamarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hargaKamarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(formKamarPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(formKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formKamarPanelLayout.createSequentialGroup()
                        .addComponent(namaKamarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(formKamarPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jenisKamarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(44, 44, 44)
                        .addComponent(fasititasKamarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(267, 267, 267))))
        );
        formKamarPanelLayout.setVerticalGroup(
            formKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formKamarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(namaKamarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(formKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jenisKamarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fasititasKamarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(hargaKamarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        mainPanel.add(formKamarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 640, 370));

        thumbnailPanel.setBorder(null);
        thumbnailPanel.setRoundBottomLeft(50);
        thumbnailPanel.setRoundBottomRight(50);
        thumbnailPanel.setRoundTopLeft(50);
        thumbnailPanel.setRoundTopRight(50);

        roomPict.setFont(new java.awt.Font("Arial", 1, 3)); // NOI18N
        roomPict.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        roomPict.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/roomPict.png"))); // NOI18N
        roomPict.setToolTipText("");
        roomPict.setBorder(null);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1199, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBtnMouseClicked

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        showTableBySearch(inputSearch.getText());

        clearText();
        setComponent(false);
        setKamarEditDeleteButton(false);
        setRadioComponent(false);
        tipeKamarGroup.clearSelection();
        addBtn.setEnabled(true);
    }//GEN-LAST:event_searchBtnActionPerformed

    private void inputSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputSearchMouseClicked

    }//GEN-LAST:event_inputSearchMouseClicked

    private void tabelKamarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelKamarMouseClicked
        int indexKamar = -1;
        action = "edit";

        addBtn.setEnabled(false);
        deleteBtn.setEnabled(true);
        saveBtn.setEnabled(true);
        setKamarEditDeleteButton(true);

        setComponent(false);
        setRadioComponent(false);
        tipeKamarGroup.clearSelection();

        int clickedRow = tabelKamar.getSelectedRow();
        TableModel tableModel = tabelKamar.getModel();

        String selectedIdKamar = tableModel.getValueAt(clickedRow, 0).toString();
        selectedId = selectedIdKamar;
        inputNomorKamar.setText(tableModel.getValueAt(clickedRow, 0).toString());

        inputHargaKamar.setText(tableModel.getValueAt(clickedRow, 3).toString());

        String tipe_kamar = tableModel.getValueAt(clickedRow, 1).toString();
        String fasilitas = tableModel.getValueAt(clickedRow, 2).toString();

        switch(tipe_kamar){
            case "Single" :
            singleRadio.setSelected(true);
            break;
            case "Double" :
            doubleRadio.setSelected(true);
            break;
            case "Suite" :
            suiteRadio.setSelected(true);
            break;
        }

        ac.setSelected(false);
        tv.setSelected(false);
        heater.setSelected(false);

        switch(fasilitas){
            case "Fasilitas Lengkap" :
            ac.setSelected(true);
            tv.setSelected(true);
            heater.setSelected(true);
            break;
            case "AC dan Televisi" :
            ac.setSelected(true);
            tv.setSelected(true);
            break;
            case "AC dan Heater" :
            ac.setSelected(true);
            heater.setSelected(true);
            break;
            case "Televisi dan Heater" :
            tv.setSelected(true);
            heater.setSelected(true);
            break;
            case "AC" :
            ac.setSelected(true);
            break;
            case "Televisi" :
            tv.setSelected(true);
            break;
            case "Heater" :
            heater.setSelected(true);
            break;
        }

        cancelBtn.setEnabled(true);
        inputNomorKamar.setEnabled(false);
        //        inputHargaKamar.setEnabled(false);
    }//GEN-LAST:event_tabelKamarMouseClicked

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        action = "delete";
        
        int dialog = JOptionPane.showConfirmDialog(this, "yakin ingin melakukan " + action + "?");
        if(dialog == JOptionPane.CLOSED_OPTION || dialog == JOptionPane.NO_OPTION || dialog == JOptionPane.CANCEL_OPTION){
        return;
        } else if (dialog == JOptionPane.OK_OPTION){
            kc.deleteDataKamar(selectedId);
        }
       
        setCount();
        clearText();
        setComponent(false);
        inputNomorKamar.setEnabled(false);
        inputHargaKamar.setEnabled(false);
        setKamarEditDeleteButton(false);
        setRadioComponent(false);
        addBtn.setEnabled(true);
        showTableBySearch("");
        
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void editBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBtnMouseClicked

    }//GEN-LAST:event_editBtnMouseClicked

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        action = "edit";
        setComponent(true);
        inputNomorKamar.setEnabled(false);
        inputHargaKamar.setEnabled(true);
        setKamarEditDeleteButton(true);
        setRadioComponent(true);
    }//GEN-LAST:event_editBtnActionPerformed

    private void addBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseClicked

    }//GEN-LAST:event_addBtnMouseClicked

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        action = "add";
        setComponent(true);
        setRadioComponent(true);
        
        inputNomorKamar.setEnabled(false);
        inputNomorKamar.setText(kc.generateId()); 
    }//GEN-LAST:event_addBtnActionPerformed

    private void inputHargaKamarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputHargaKamarKeyTyped
        char key = evt.getKeyChar();
        if(!Character.isDigit(key) || key == '.'){
            evt.consume();
            JOptionPane.showMessageDialog(
                null, "Hanya bisa masukan angka !!", "Input Failure", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_inputHargaKamarKeyTyped

    private void doubleRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doubleRadioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_doubleRadioActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed

        try{

            // EXCEPTION
            inputKosongException();

            String tipe_kamar = "";
            String fasilitas = "";

            if(ac.isSelected() && tv.isSelected() && heater.isSelected()){
                fasilitas = "Fasilitas Lengkap";
            }else if(ac.isSelected() && tv.isSelected()){
                fasilitas = "AC dan Televisi";
            }else if(ac.isSelected() && heater.isSelected()){
                fasilitas = "AC dan Heater";
            }else if(tv.isSelected() && heater.isSelected()){
                fasilitas = "Televisi dan Heater";
            }else if(ac.isSelected()){
                fasilitas = "AC";
            }else if(tv.isSelected()){
                fasilitas = "Televisi";
            }else{
                fasilitas = "Heater";
            }

            tipe_kamar = tipeKamarGroup.getSelection().getActionCommand();
            float hargaKamar = Float.parseFloat(inputHargaKamar.getText());
            if (hargaKamar<=0){
                        JOptionPane.showMessageDialog(this, "INPUT HARGA TIDAK BOLEH KURANG DARI ATAU = 0!");
                        return;
              }
            
            int dialog = JOptionPane.showConfirmDialog(this, "yakin ingin melakukan " + action + "?");
            if(dialog == JOptionPane.CLOSED_OPTION || dialog == JOptionPane.NO_OPTION || dialog == JOptionPane.CANCEL_OPTION){
            return;
            } else if (dialog == JOptionPane.OK_OPTION){
                Float tempHarga = Float.parseFloat(inputHargaKamar.getText());
                if(action.equals("add")){
                    Kamar data = new Kamar(
                        inputNomorKamar.getText(),
                        tipe_kamar,
                        fasilitas,
                        tempHarga);
                    kc.InsertDataKamar(data);
                } else if (action.equals("edit")){
                    Kamar data = new Kamar(
                        inputNomorKamar.getText(),
                        tipe_kamar,
                        fasilitas,
                        tempHarga);
                    kc.updateKamar(data,selectedId);
                    selectedId = "-1";
                }
            }

        }catch(InputKosongException e){
            JOptionPane.showMessageDialog(this, e.message());
        }

        setCount();
        clearText();
        setComponent(false);
        setKamarEditDeleteButton(false);;
        setRadioComponent(false);
        tipeKamarGroup.clearSelection();
        addBtn.setEnabled(true);
        showTableBySearch("");
    }//GEN-LAST:event_saveBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed

        clearText();
        setComponent(false);
        setKamarEditDeleteButton(false);
        setRadioComponent(false);

        addBtn.setEnabled(true);
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void inputHargaKamarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputHargaKamarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputHargaKamarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ac;
    private javax.swing.JButton addBtn;
    private javax.swing.JPanel buttonKamarPanel;
    private javax.swing.JButton cancelBtn;
    private costum.JpanelRound countPanel;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JRadioButton doubleRadio;
    private javax.swing.JButton editBtn;
    private javax.swing.JLabel fasilitasLabel;
    private javax.swing.JPanel fasititasKamarPanel;
    private costum.JpanelRound formKamarPanel;
    private javax.swing.JPanel hargaKamarPanel;
    private javax.swing.JLabel hargaLabel1;
    private javax.swing.JCheckBox heater;
    private javax.swing.JTextField inputHargaKamar;
    private javax.swing.JTextField inputNomorKamar;
    private javax.swing.JTextField inputSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jenisKamarPanel;
    private javax.swing.JLabel jenisLabel;
    private costum.JpanelRound jpanelRound1;
    private javax.swing.JLabel judulHotelLabel;
    private javax.swing.JLabel judulKamarLabel;
    private javax.swing.JPanel judulKamarPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel namaKamarPanel;
    private javax.swing.JLabel namaLabel;
    private javax.swing.JLabel namaLabel1;
    private javax.swing.JLabel roomPict;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JPanel searchKamarPanel;
    private javax.swing.JRadioButton singleRadio;
    private javax.swing.JRadioButton suiteRadio;
    private javax.swing.JTable tabelKamar;
    private javax.swing.JPanel tabelKamarPanel;
    private costum.JpanelRound thumbnailPanel;
    private javax.swing.ButtonGroup tipeKamarGroup;
    private javax.swing.JCheckBox tv;
    // End of variables declaration//GEN-END:variables
}
