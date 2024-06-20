package model;

public class Customer {
    private String id_customer;
    private String nama;
    private String email;
    private String no_telp;
    private String jenis_kelamin;
    
    public Customer (String id_customer, String nama, String email, String no_telp, String jenis_kelamin ){
        this.id_customer = id_customer;
        this.nama = nama;
        this.email = email;
        this.no_telp = no_telp;
        this.jenis_kelamin = jenis_kelamin;
    }
    
    public Customer (String nama, String email, String no_telp, String jenis_kelamin ){
        this.nama = nama;
        this.email = email;
        this.no_telp = no_telp;
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getId_customer() {
        return id_customer;
    }

    public void setId_customer(String id_customer) {
        this.id_customer = id_customer;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }
    
    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }
    
    @Override
    public String toString(){
        return nama;
    }
}
