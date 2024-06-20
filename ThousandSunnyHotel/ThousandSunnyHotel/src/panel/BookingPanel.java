
package panel;

import connection.DbConnection;
import Control.KamarControl;
import Control.CustomerControl;
import Control.BookingControl;
import Control.PetugasControl;
import exception.InputKosongException;
import exception.InvalidTanggalException;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import model.Kamar;
import model.Customer;
import model.Booking;
import model.Petugas;
import panel.*;
import costum.JpanelConfirmMassageBooking;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 

public class BookingPanel extends javax.swing.JPanel {
    
    private KamarControl kamarControl;
    private CustomerControl customerControl;
    private BookingControl bookingControl;
    private PetugasControl petugasControl;
    
    private Booking dataNew = null;
    String action = null, tempId_booking;
    String selectedId = "";
    
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
    
    private Component rootPane;
    
    // DROPDOWN 
    // Kamar
    public void setKamarToDropdown(){
        kamarList = kamarControl.showListKamar();
        for(int i = 0; i < kamarList.size(); i++){
            kamarComboBox.addItem(kamarList.get(i));
        }
    }

    // Customer
    public void setCustomerToDropdown(){
        customerList = customerControl.showListCustomer();
        for(int i = 0; i < customerList.size(); i++){
            customerComboBox.addItem(customerList.get(i));
        }
    }
    // DROPDOWN
    
    // RADIO BUTTON
    public void setRadioButtonValue(){
        bcaRadio.setActionCommand("BCA");
        briRadio.setActionCommand("BRI");
        mandiriRadio.setActionCommand("Mandiri");
        tunaiRadio.setActionCommand("Tunai");
    }
    // RADIO BUTTON
    
    // TABLE SHOW    
    public void showTableBySearch(String target){
        TableBooking.setModel(bookingControl.showTable(target));
    }
    // TABLE SHOW 
    
    // EXCEPTION
    public void inputKosongException() throws InputKosongException{
        if(kamarComboBox.getSelectedIndex() == -1 || customerComboBox.getSelectedIndex() == -1
            || inputCheckIn == null || inputCheckOut == null
            || metodePembayaranGroup.getSelection() == null){
                throw new InputKosongException();
        }        
    } 
   
    // EXCEPTION
    
    // RESET METHOD TO DEFAULT
    public void clearText(){
        // RESET DROPDOWN
        kamarComboBox.setSelectedIndex(-1);
        customerComboBox.setSelectedIndex(-1);
        
        // RESET RADIOBUTTON
        metodePembayaranGroup.clearSelection();
        
        // RESET TEXT
        hargaLabel.setText("");
        inputSearch.setText("");
        inputCheckIn.setDate(null);
        inputCheckOut.setDate(null);
    }
    
    // SET METHOD BUTTON EDIT & DELETE
    public void setEditDeleteBtn(boolean value){
        editBtn.setEnabled(value);
        deleteBtn.setEnabled(value);
    }
    
    // METHOD FOR SET COMPONENT, ENABLE / DISABLE
    public void setComponent(boolean value){
        kamarComboBox.setEnabled(value);
        customerComboBox.setEnabled(value);
        inputCheckIn.setEnabled(value);
        inputCheckOut.setEnabled(value);
        
        saveBtn.setEnabled(value);
        cancelBtn.setEnabled(value);
    }
    
    // METHOD FOR SET RADIO BUTTON
    public void setRadioComponent(boolean value){
        bcaRadio.setEnabled(value);
        briRadio.setEnabled(value);
        mandiriRadio.setEnabled(value);
        tunaiRadio.setEnabled(value);
    }
    
    // Harga
    
    private static long daysBetween(Calendar tanggalAwal, Calendar tanggalAkhir) {
        
        tanggalAwal.set(Calendar.HOUR_OF_DAY, 0);
        tanggalAwal.set(Calendar.MINUTE, 0);
        tanggalAwal.set(Calendar.SECOND, 0);
        tanggalAwal.set(Calendar.MILLISECOND, 0);

        tanggalAkhir.set(Calendar.HOUR_OF_DAY, 0);
        tanggalAkhir.set(Calendar.MINUTE, 0);
        tanggalAkhir.set(Calendar.SECOND, 0);
        tanggalAkhir.set(Calendar.MILLISECOND, 0);
        
        long lama = 0;
        
        Calendar tanggal = (Calendar) tanggalAwal.clone();
        while (tanggal.before(tanggalAkhir)) {
            tanggal.add(Calendar.DAY_OF_MONTH, 1);
            lama++;
        }
        return lama;
    }
    
    public float setHarga(Date date1, Date date2, float hargaKamar){

        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        
         cal1.set(Calendar.HOUR_OF_DAY, 0);
         cal1.set(Calendar.MINUTE, 0);
         cal1.set(Calendar.SECOND, 0);
         cal1.set(Calendar.MILLISECOND, 0);

         cal2.set(Calendar.HOUR_OF_DAY, 0);
         cal2.set(Calendar.MINUTE, 0);
         cal2.set(Calendar.SECOND, 0);
         cal2.set(Calendar.MILLISECOND, 0);
            
        Float hasil=null;
        
        if(cal1.equals(cal2)){
            hasil = 1 * hargaKamar;
        }else{
            hasil = Float.valueOf(daysBetween(cal1, cal2)) * hargaKamar;          

        }

        return hasil;
    }  
    
    public BookingPanel() {
        initComponents();
        setOpaque(false);     
        
        bookingControl = new BookingControl();
        customerControl = new CustomerControl();
        kamarControl = new KamarControl();
        petugasControl = new PetugasControl();
        
        setCustomerToDropdown();
        setKamarToDropdown();
        setRadioButtonValue();
        
        showTableBySearch("");     
        
        // RESET
        setCount();
        clearText();
        setComponent(false);
        setRadioComponent(false);
        setEditDeleteBtn(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        metodePembayaranGroup = new javax.swing.ButtonGroup();
        idBookingTemp = new javax.swing.JTextField();
        mainPanel = new javax.swing.JPanel();
        judulKamarPanel = new javax.swing.JPanel();
        judulKamarLabel2 = new javax.swing.JLabel();
        judulHotelLabel3 = new javax.swing.JLabel();
        tabelBookingPanel = new javax.swing.JPanel();
        inputSearch = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        judulHotelLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableBooking = new javax.swing.JTable();
        buttonBookingPanel = new javax.swing.JPanel();
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
        tanggalBookingPanel = new javax.swing.JPanel();
        checkOutLabel = new javax.swing.JLabel();
        checkInLabel = new javax.swing.JLabel();
        inputCheckIn = new com.toedter.calendar.JDateChooser();
        inputCheckOut = new com.toedter.calendar.JDateChooser();
        namaKamarPanel = new javax.swing.JPanel();
        namaLabel = new javax.swing.JLabel();
        kamarComboBox = new javax.swing.JComboBox<>();
        customerLabel = new javax.swing.JLabel();
        customerComboBox = new javax.swing.JComboBox<>();
        cekHarga = new javax.swing.JPanel();
        hargaLabel = new javax.swing.JLabel();
        hargaBtn = new javax.swing.JButton();
        thumbnailPanel = new costum.JpanelRound();
        pict = new javax.swing.JLabel();
        cancelBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        formKamarPanel2 = new costum.JpanelRound();
        metodePembayaranPanel = new javax.swing.JPanel();
        jenisLabel = new javax.swing.JLabel();
        bcaRadio = new javax.swing.JRadioButton();
        briRadio = new javax.swing.JRadioButton();
        mandiriRadio = new javax.swing.JRadioButton();
        tunaiRadio = new javax.swing.JRadioButton();
        jenisLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        idBookingTemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idBookingTempActionPerformed(evt);
            }
        });

        setBackground(new java.awt.Color(244, 233, 225));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainPanel.setBackground(new java.awt.Color(244, 233, 225));

        judulKamarPanel.setBackground(new java.awt.Color(244, 233, 225));

        judulKamarLabel2.setFont(new java.awt.Font("Arial Black", 0, 22)); // NOI18N
        judulKamarLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judulKamarLabel2.setText("Booking Rooms");

        judulHotelLabel3.setFont(new java.awt.Font("Arial Black", 0, 22)); // NOI18N
        judulHotelLabel3.setText("Thousand Sunny Management System");

        javax.swing.GroupLayout judulKamarPanelLayout = new javax.swing.GroupLayout(judulKamarPanel);
        judulKamarPanel.setLayout(judulKamarPanelLayout);
        judulKamarPanelLayout.setHorizontalGroup(
            judulKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(judulKamarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(judulKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(judulHotelLabel3)
                    .addComponent(judulKamarLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        judulKamarPanelLayout.setVerticalGroup(
            judulKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(judulKamarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(judulHotelLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(judulKamarLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabelBookingPanel.setBackground(new java.awt.Color(244, 233, 225));
        tabelBookingPanel.setPreferredSize(new java.awt.Dimension(141, 47));

        inputSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inputSearchMouseClicked(evt);
            }
        });
        inputSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputSearchActionPerformed(evt);
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

        judulHotelLabel.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        judulHotelLabel.setText("History Booking");

        TableBooking.setModel(new javax.swing.table.DefaultTableModel(
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
        TableBooking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableBookingMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableBooking);

        javax.swing.GroupLayout tabelBookingPanelLayout = new javax.swing.GroupLayout(tabelBookingPanel);
        tabelBookingPanel.setLayout(tabelBookingPanelLayout);
        tabelBookingPanelLayout.setHorizontalGroup(
            tabelBookingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabelBookingPanelLayout.createSequentialGroup()
                .addGroup(tabelBookingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabelBookingPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(judulHotelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(inputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        tabelBookingPanelLayout.setVerticalGroup(
            tabelBookingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabelBookingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabelBookingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(tabelBookingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(inputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(judulHotelLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addContainerGap())
        );

        buttonBookingPanel.setBackground(new java.awt.Color(244, 233, 225));
        buttonBookingPanel.setPreferredSize(new java.awt.Dimension(141, 47));

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

        javax.swing.GroupLayout buttonBookingPanelLayout = new javax.swing.GroupLayout(buttonBookingPanel);
        buttonBookingPanel.setLayout(buttonBookingPanelLayout);
        buttonBookingPanelLayout.setHorizontalGroup(
            buttonBookingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonBookingPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(buttonBookingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(editBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                    .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(59, 59, 59))
        );
        buttonBookingPanelLayout.setVerticalGroup(
            buttonBookingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonBookingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

        formKamarPanel.setBackground(new java.awt.Color(83, 37, 103));
        formKamarPanel.setRoundBottomLeft(25);
        formKamarPanel.setRoundBottomRight(25);
        formKamarPanel.setRoundTopLeft(25);
        formKamarPanel.setRoundTopRight(25);
        formKamarPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tanggalBookingPanel.setBackground(new java.awt.Color(83, 37, 103));

        checkOutLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        checkOutLabel.setForeground(new java.awt.Color(255, 255, 255));
        checkOutLabel.setText("Check Out");

        checkInLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        checkInLabel.setForeground(new java.awt.Color(255, 255, 255));
        checkInLabel.setText("Check In");

        inputCheckIn.setBackground(new java.awt.Color(83, 37, 103));
        inputCheckIn.setDateFormatString("yyyy-MM-dd");

        inputCheckOut.setBackground(new java.awt.Color(83, 37, 103));
        inputCheckOut.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout tanggalBookingPanelLayout = new javax.swing.GroupLayout(tanggalBookingPanel);
        tanggalBookingPanel.setLayout(tanggalBookingPanelLayout);
        tanggalBookingPanelLayout.setHorizontalGroup(
            tanggalBookingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tanggalBookingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tanggalBookingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkInLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkOutLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tanggalBookingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inputCheckIn, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(inputCheckOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tanggalBookingPanelLayout.setVerticalGroup(
            tanggalBookingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tanggalBookingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tanggalBookingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkInLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tanggalBookingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(checkOutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        formKamarPanel.add(tanggalBookingPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 420, -1));

        namaKamarPanel.setBackground(new java.awt.Color(83, 37, 103));

        namaLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        namaLabel.setForeground(new java.awt.Color(255, 255, 255));
        namaLabel.setText("No.Kamar");

        kamarComboBox.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

        customerLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        customerLabel.setForeground(new java.awt.Color(255, 255, 255));
        customerLabel.setText("Customer");

        customerComboBox.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        customerComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout namaKamarPanelLayout = new javax.swing.GroupLayout(namaKamarPanel);
        namaKamarPanel.setLayout(namaKamarPanelLayout);
        namaKamarPanelLayout.setHorizontalGroup(
            namaKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namaKamarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(namaKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(namaKamarPanelLayout.createSequentialGroup()
                        .addComponent(namaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(kamarComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(namaKamarPanelLayout.createSequentialGroup()
                        .addComponent(customerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(customerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        namaKamarPanelLayout.setVerticalGroup(
            namaKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namaKamarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(namaKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kamarComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(namaKamarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        formKamarPanel.add(namaKamarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 100));

        cekHarga.setBackground(new java.awt.Color(83, 37, 103));

        hargaLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        hargaLabel.setForeground(new java.awt.Color(255, 255, 255));
        hargaLabel.setText("Rp.000000,-");

        hargaBtn.setBackground(new java.awt.Color(13, 110, 253));
        hargaBtn.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        hargaBtn.setForeground(new java.awt.Color(255, 255, 255));
        hargaBtn.setText("Harga");
        hargaBtn.setBorder(null);
        hargaBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hargaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hargaBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cekHargaLayout = new javax.swing.GroupLayout(cekHarga);
        cekHarga.setLayout(cekHargaLayout);
        cekHargaLayout.setHorizontalGroup(
            cekHargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cekHargaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hargaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hargaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                .addGap(47, 47, 47))
        );
        cekHargaLayout.setVerticalGroup(
            cekHargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cekHargaLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(cekHargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hargaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hargaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        formKamarPanel.add(cekHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 400, 60));

        thumbnailPanel.setBackground(new java.awt.Color(244, 233, 225));
        thumbnailPanel.setRoundBottomLeft(50);
        thumbnailPanel.setRoundBottomRight(50);
        thumbnailPanel.setRoundTopLeft(50);
        thumbnailPanel.setRoundTopRight(50);

        pict.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        pict.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bookingPict.png"))); // NOI18N

        javax.swing.GroupLayout thumbnailPanelLayout = new javax.swing.GroupLayout(thumbnailPanel);
        thumbnailPanel.setLayout(thumbnailPanelLayout);
        thumbnailPanelLayout.setHorizontalGroup(
            thumbnailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 482, Short.MAX_VALUE)
            .addGroup(thumbnailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(thumbnailPanelLayout.createSequentialGroup()
                    .addGap(3, 3, 3)
                    .addComponent(pict, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(3, 3, 3)))
        );
        thumbnailPanelLayout.setVerticalGroup(
            thumbnailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
            .addGroup(thumbnailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pict, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
        );

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

        formKamarPanel2.setBackground(new java.awt.Color(83, 37, 103));
        formKamarPanel2.setRoundBottomLeft(25);
        formKamarPanel2.setRoundBottomRight(25);
        formKamarPanel2.setRoundTopLeft(25);
        formKamarPanel2.setRoundTopRight(25);
        formKamarPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        metodePembayaranPanel.setBackground(new java.awt.Color(83, 37, 103));

        jenisLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jenisLabel.setForeground(new java.awt.Color(255, 255, 255));
        jenisLabel.setText("Metode");

        metodePembayaranGroup.add(bcaRadio);
        bcaRadio.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        bcaRadio.setForeground(new java.awt.Color(255, 255, 255));
        bcaRadio.setText("BCA");
        bcaRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcaRadioActionPerformed(evt);
            }
        });

        metodePembayaranGroup.add(briRadio);
        briRadio.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        briRadio.setForeground(new java.awt.Color(255, 255, 255));
        briRadio.setText("BRI");
        briRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                briRadioActionPerformed(evt);
            }
        });

        metodePembayaranGroup.add(mandiriRadio);
        mandiriRadio.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        mandiriRadio.setForeground(new java.awt.Color(255, 255, 255));
        mandiriRadio.setText("Mandiri");

        metodePembayaranGroup.add(tunaiRadio);
        tunaiRadio.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        tunaiRadio.setForeground(new java.awt.Color(255, 255, 255));
        tunaiRadio.setText("Tunai");
        tunaiRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tunaiRadioActionPerformed(evt);
            }
        });

        jenisLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jenisLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jenisLabel1.setText("Pembayaran");

        javax.swing.GroupLayout metodePembayaranPanelLayout = new javax.swing.GroupLayout(metodePembayaranPanel);
        metodePembayaranPanel.setLayout(metodePembayaranPanelLayout);
        metodePembayaranPanelLayout.setHorizontalGroup(
            metodePembayaranPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(metodePembayaranPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(metodePembayaranPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jenisLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jenisLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(metodePembayaranPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(tunaiRadio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mandiriRadio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(briRadio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bcaRadio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        metodePembayaranPanelLayout.setVerticalGroup(
            metodePembayaranPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, metodePembayaranPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jenisLabel)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jenisLabel1)
                .addGap(18, 18, 18)
                .addComponent(bcaRadio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(briRadio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mandiriRadio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tunaiRadio)
                .addGap(67, 67, 67))
        );

        formKamarPanel2.add(metodePembayaranPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 200, 280));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setText("“Hard work is worthless for those that don’t");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setText("believe in themselves.\" - Naruto Uzumaki");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabelBookingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1176, Short.MAX_VALUE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(formKamarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(countPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(5, 5, 5)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(formKamarPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonBookingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(thumbnailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27))))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(judulKamarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 15, Short.MAX_VALUE)))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(countPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonBookingPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(judulKamarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel8)))
                .addGap(10, 10, 10)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(thumbnailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(formKamarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(formKamarPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(tabelBookingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void inputSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputSearchMouseClicked

    }//GEN-LAST:event_inputSearchMouseClicked

    private void inputSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputSearchActionPerformed

    }//GEN-LAST:event_inputSearchActionPerformed

    private void searchBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBtnMouseClicked

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        showTableBySearch(inputSearch.getText());

        clearText();
        setComponent(false);
        setEditDeleteBtn(false);
        setRadioComponent(false);
        metodePembayaranGroup.clearSelection();
        addBtn.setEnabled(true);
    }//GEN-LAST:event_searchBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        action = "delete";

        int dialog = JOptionPane.showConfirmDialog(rootPane, "yakin ingin melakukan " + action + "?");
        if(dialog == JOptionPane.CLOSED_OPTION || dialog == JOptionPane.NO_OPTION || dialog == JOptionPane.CANCEL_OPTION){
            return;
        } else if (dialog == JOptionPane.OK_OPTION){
            bookingControl.deleteDataBooking(selectedId);
        }
        
        setCount();
        clearText();
        setComponent(false);
        setEditDeleteBtn(false);
        setRadioComponent(false);
        metodePembayaranGroup.clearSelection();
        addBtn.setEnabled(true);
        showTableBySearch("");
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void editBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBtnMouseClicked

    }//GEN-LAST:event_editBtnMouseClicked

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        action = "edit";
        setComponent(true);
        customerComboBox.setEnabled(false);;
        setEditDeleteBtn(true);
        setRadioComponent(true);
    }//GEN-LAST:event_editBtnActionPerformed

    private void addBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseClicked

    }//GEN-LAST:event_addBtnMouseClicked

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        action = "add";
        setComponent(true);
        setRadioComponent(true);
    }//GEN-LAST:event_addBtnActionPerformed

    private void customerComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerComboBoxActionPerformed

    private void bcaRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcaRadioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bcaRadioActionPerformed

    private void briRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_briRadioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_briRadioActionPerformed

    private void tunaiRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tunaiRadioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tunaiRadioActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        try{
            // EXCEPTION
            inputKosongException();

            // SET ATRIBUT DAN METODE PEMBAYARAN
            String radio = "";
            Date now = new Date();

            // MENCARI INDEX YANG DITUNJUK OLEH DROPDOWN
            // CUSTOMER
            int selectedIndexCustomer = customerComboBox.getSelectedIndex();
            Customer selectedCustomer = customerList.get(selectedIndexCustomer);

            // Kamar
            int selectedIndexKamar = kamarComboBox.getSelectedIndex();
            Kamar selectedKamar = kamarList.get(selectedIndexKamar);         

            radio = metodePembayaranGroup.getSelection().getActionCommand();
            
            String toDate1 = inputCheckIn.getDate().toString();
            String toDate2 = inputCheckOut.getDate().toString();
            String toDate3 = now.toString();
            
            SimpleDateFormat inputFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");            
            Date date1 = null, date2 = null, date3 = null;

            try {               
                date1 = inputFormat.parse(toDate1);
                date2 = inputFormat.parse(toDate2);
                date3 = inputFormat.parse(toDate3);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(date1);
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(date2);
            Calendar cal3 = Calendar.getInstance();
            cal3.setTime(date3);
            
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate1 = outputFormat.format(date1);
            String formattedDate2 = outputFormat.format(date2);
            System.out.println(formattedDate1);
            System.out.println(formattedDate2);
            
            tempId_booking = bookingControl.generateId();           
            
            // Cek
            List<Booking> bookingList = bookingControl.showListBooking();
            
            for (Booking item : bookingList){
                
                if(item.getId_booking().equals(idBookingTemp.getText())){
                    
                }else {
                        if (item.getId_kamar().equals(selectedKamar.getId_kamar())){
                            Date date4 = null, date5 = null;
                                try {               
                                    date4 = outputFormat.parse(item.getCheckInDate());
                                    date5 = outputFormat.parse(item.getCheckOutDate());
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }

                                Calendar cal4 = Calendar.getInstance();
                                cal4.setTime(date4);
                                Calendar cal5 = Calendar.getInstance();
                                cal5.setTime(date5);

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

                                 cal5.set(Calendar.HOUR_OF_DAY, 0);
                                 cal5.set(Calendar.MINUTE, 0);
                                 cal5.set(Calendar.SECOND, 0);
                                 cal5.set(Calendar.MILLISECOND, 0);


                            if (cal1.equals(cal4) && cal2.equals(cal5)){
                                JOptionPane.showMessageDialog(this, "KAMAR DI TANGGAL TERSEBUT TIDAK TERSEDIA");
                                return;
                            } else if (date2.before(date4) || date1.after(date5) || cal2.equals(cal4) ) {
              
                            } else {
                                JOptionPane.showMessageDialog(this, "KAMAR DI TANGGAL TERSEBUT TIDAK TERSEDIA");
                                return;
                            }
                        }                                                 
                }
                 
            }
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
            
            // Memastikan date valid
            if (date1.before(date2) == false && cal1.equals(cal2) == false ){
                        JOptionPane.showMessageDialog(this, "TANGGAL CHECK IN DAN CHECK OUT TIDAK LOGIS!");
                        return;
            }

            if (cal3.before(cal2) == false || cal3.before(cal1) == false ){       
                    if(cal3.equals(cal2) || cal3.equals(cal1)){
             
                    } else {
                        JOptionPane.showMessageDialog(this, " TANGGAL CHECK IN DAN CHECK OUT TIDAK BOLEH DI MASA LALU!");
                        return; 
                    }
            }
              
            Float fixtempHarga = setHarga(date1, date2, selectedKamar.getHarga());
            
            int dialog = JOptionPane.showConfirmDialog(rootPane, "yakin ingin melakukan " + action + "?");
            if(dialog == JOptionPane.CLOSED_OPTION || dialog == JOptionPane.NO_OPTION || dialog == JOptionPane.CANCEL_OPTION){
                return;
            } else if (dialog == JOptionPane.OK_OPTION){
                if(action.equals("add")){                   
                    Booking dataNew = new Booking(tempId_booking, selectedCustomer.getId_customer(), formattedDate1, formattedDate2,
                        selectedKamar.getId_kamar(), radio, fixtempHarga, selectedCustomer, selectedKamar);
                    bookingControl.InsertDataBooking(dataNew);
                } else {     
                    Booking dataNew = new Booking(selectedCustomer.getId_customer(), formattedDate1, formattedDate2,
                        selectedKamar.getId_kamar(), radio, fixtempHarga, selectedCustomer, selectedKamar);
                    bookingControl.updateDataBooking(dataNew, selectedId);
                    selectedId = "";
                }
            }
        }catch(InputKosongException e){
            JOptionPane.showMessageDialog(this, e.message());
        }
        
        setCount();
        clearText();
        setComponent(false);
        setEditDeleteBtn(false);
        setRadioComponent(false);
        metodePembayaranGroup.clearSelection();
        addBtn.setEnabled(true);
        showTableBySearch("");
    }//GEN-LAST:event_saveBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
                clearText();
                setComponent(false);
                setEditDeleteBtn(false);
        
                addBtn.setEnabled(true);
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void TableBookingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableBookingMouseClicked
        int indexSingle = -1, indexSingle2 = -1;
        action = "edit";

        addBtn.setEnabled(false);
        cancelBtn.setEnabled(true);
        saveBtn.setEnabled(true);
        setEditDeleteBtn(true);

        setComponent(false);
        setRadioComponent(false);
        metodePembayaranGroup.clearSelection();

        int clickedRow = TableBooking.getSelectedRow();
        TableModel tableModel = TableBooking.getModel();

        selectedId = tableModel.getValueAt(clickedRow, 0).toString();
        
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        Date date2 = null;
        
        try {
            date = inputFormat.parse(tableModel.getValueAt(clickedRow, 3).toString());
            date2 = inputFormat.parse(tableModel.getValueAt(clickedRow, 4).toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
            calendar.set(Calendar.HOUR_OF_DAY, 12);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
        }
        
        Calendar calendar2 = Calendar.getInstance();
        if (date2 != null) {
            calendar2.setTime(date2);
            calendar2.set(Calendar.HOUR_OF_DAY, 12);
            calendar2.set(Calendar.MINUTE, 0);
            calendar2.set(Calendar.SECOND, 0);
        }
        
        Date dateWithTime = calendar.getTime();
        SimpleDateFormat outputFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        
        Date dateWithTime2 = calendar2.getTime();
        SimpleDateFormat outputFormat2 = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");

        inputCheckIn.setDate(dateWithTime);
        inputCheckOut.setDate(dateWithTime2);

        String radio = tableModel.getValueAt(clickedRow, 5).toString();
        idBookingTemp.setText(tableModel.getValueAt(clickedRow, 0).toString());

        switch(radio){
            case "BCA" :
            bcaRadio.setSelected(true);
            break;
            case "BRI" :
            briRadio.setSelected(true);
            break;
            case "Mandiri":
            mandiriRadio.setSelected(true);
            break;
            case "Tunai":
            tunaiRadio.setSelected(true);
            break;
        }
             
        for(Kamar second : kamarList){
            if(second.getId_kamar().equals(tableModel.getValueAt(clickedRow,1).toString())){
                indexSingle2 = kamarList.indexOf(second);
            }
        }
        
        for(Customer first : customerList){
            if(first.getId_customer().equals(tableModel.getValueAt(clickedRow, 7).toString())){
                indexSingle = customerList.indexOf(first);
            }
        }

        kamarComboBox.setSelectedIndex(indexSingle2);
        customerComboBox.setSelectedIndex(indexSingle);
        cancelBtn.setEnabled(true);
    }//GEN-LAST:event_TableBookingMouseClicked

    private void hargaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hargaBtnActionPerformed
            
            if(kamarComboBox == null || customerComboBox == null || inputCheckIn == null || inputCheckOut == null){
                JOptionPane.showMessageDialog(this, "Input Belum Lengkap");
                return;
            }
        
            // SET ATRIBUT DAN METODE PEMBAYARAN
            int counter = 0;
            String radio = "";
            Date now = new Date();

            // MENCARI INDEX YANG DITUNJUK OLEH DROPDOWN
            // CUSTOMER
            int selectedIndexCustomer = customerComboBox.getSelectedIndex();
            Customer selectedCustomer = customerList.get(selectedIndexCustomer);

            // Kamar
            int selectedIndexKamar = kamarComboBox.getSelectedIndex();
            Kamar selectedKamar = kamarList.get(selectedIndexKamar);         
            
            String toDate1 = inputCheckIn.getDate().toString();
            String toDate2 = inputCheckOut.getDate().toString();
            String toDate3 = now.toString();
            
            SimpleDateFormat inputFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");            
            Date date1 = null, date2 = null, date3 = null;

            try {               
                date1 = inputFormat.parse(toDate1);
                date2 = inputFormat.parse(toDate2);
                date3 = inputFormat.parse(toDate3);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(date1);
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(date2);
            Calendar cal3 = Calendar.getInstance();
            cal3.setTime(date3);
            
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate1 = outputFormat.format(date1);
            String formattedDate2 = outputFormat.format(date2);
            System.out.println(formattedDate1);
            System.out.println(formattedDate2);
            
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
                       
              
            // Memastikan date valid
            if (date1.before(date2) == false && cal1.equals(cal2) == false ){
                        JOptionPane.showMessageDialog(this, "TANGGAL CHECK IN DAN CHECK OUT TIDAK LOGIS!");
                        return;
            }

            if (cal3.before(cal2) == false || cal3.before(cal1) == false ){   
                    if(cal3.equals(cal2) || cal3.equals(cal1)){
             
                    } else {
                        JOptionPane.showMessageDialog(this, " TANGGAL CHECK IN DAN CHECK OUT TIDAK BOLEH DI MASA LALU!");
                        return; 
                    }
            }
            
            // Harga
            Float tempHarga = setHarga(date1, date2, selectedKamar.getHarga());
            hargaLabel.setText("Rp. " + tempHarga);
            
            
    }//GEN-LAST:event_hargaBtnActionPerformed

    private void idBookingTempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idBookingTempActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idBookingTempActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableBooking;
    private javax.swing.JButton addBtn;
    private javax.swing.JRadioButton bcaRadio;
    private javax.swing.JRadioButton briRadio;
    private javax.swing.JPanel buttonBookingPanel;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JPanel cekHarga;
    private javax.swing.JLabel checkInLabel;
    private javax.swing.JLabel checkOutLabel;
    private costum.JpanelRound countPanel;
    private javax.swing.JComboBox<Customer> customerComboBox;
    private javax.swing.JLabel customerLabel;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private costum.JpanelRound formKamarPanel;
    private costum.JpanelRound formKamarPanel2;
    private javax.swing.JButton hargaBtn;
    private javax.swing.JLabel hargaLabel;
    private javax.swing.JTextField idBookingTemp;
    private com.toedter.calendar.JDateChooser inputCheckIn;
    private com.toedter.calendar.JDateChooser inputCheckOut;
    private javax.swing.JTextField inputSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jenisLabel;
    private javax.swing.JLabel jenisLabel1;
    private javax.swing.JLabel judulHotelLabel;
    private javax.swing.JLabel judulHotelLabel3;
    private javax.swing.JLabel judulKamarLabel2;
    private javax.swing.JPanel judulKamarPanel;
    private javax.swing.JComboBox<Kamar> kamarComboBox;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JRadioButton mandiriRadio;
    private javax.swing.ButtonGroup metodePembayaranGroup;
    private javax.swing.JPanel metodePembayaranPanel;
    private javax.swing.JPanel namaKamarPanel;
    private javax.swing.JLabel namaLabel;
    private javax.swing.JLabel pict;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JPanel tabelBookingPanel;
    private javax.swing.JPanel tanggalBookingPanel;
    private costum.JpanelRound thumbnailPanel;
    private javax.swing.JRadioButton tunaiRadio;
    // End of variables declaration//GEN-END:variables
}
