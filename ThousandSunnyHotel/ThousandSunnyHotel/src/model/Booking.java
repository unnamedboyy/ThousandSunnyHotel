package model;

public class Booking {
    private String id_booking;
    private String id_customer;
    private String checkInDate;
    private String checkOutDate;
    private String id_kamar;
    private String metode_pembayaran;
    private float total_harga;
    private Customer customer;
    private Kamar kamar;

    public Booking(String id_booking, String id_customer, String checkInDate, String checkOutDate, String id_kamar, String metode_pembayaran, float total_harga, Customer customer, Kamar kamar) {
        this.id_booking = id_booking;
        this.id_customer = id_customer;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.id_kamar = id_kamar;
        this.metode_pembayaran = metode_pembayaran;
        this.total_harga = total_harga;
        this.customer = customer;
        this.kamar = kamar;
    }

    public Booking(String id_customer, String checkInDate, String checkOutDate, String id_kamar, String metode_pembayaran, float total_harga, Customer customer, Kamar kamar) {
        this.id_customer = id_customer;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.id_kamar = id_kamar;
        this.metode_pembayaran = metode_pembayaran;
        this.total_harga = total_harga;
        this.customer = customer;
        this.kamar = kamar;
    }


    public String getId_booking() {
        return id_booking;
    }

    public void setId_booking(String id_booking) {
        this.id_booking = id_booking;
    }
    
    public String getId_customer(){
        return id_customer;
    }
    
    public void setId_customer(String id_customer){
        this.id_customer = id_customer;
    }
    
    public String getId_kamar(){
        return id_kamar;
    }
    
    public void setId_kamar(String id_kamar){
        this.id_kamar = id_kamar;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getMetode_pembayaran(){
        return metode_pembayaran;
    }
    
    public void setMetode_pembayaran(String metode_pembayaran){
        this.metode_pembayaran = metode_pembayaran;
    }
    
    public float getTotal_harga(){
        return total_harga;
    }
    
    public void setTotal_harga(float total_harga){
        this.total_harga = total_harga;
    }
    
    public Customer getCustomer(){
        return customer;
    }
    
    public void setCustomer(Customer customer){
        this.customer = customer;
    }

    public Kamar getKamar(){
        return kamar;
    }
    
    public void setKamar(Kamar kamar){
        this.kamar = kamar;
    } 
    
    public String toString(){
        return id_booking + " | " + getCustomer().getNama();
    }
}
