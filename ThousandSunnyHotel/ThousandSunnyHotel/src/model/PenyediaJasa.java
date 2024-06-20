package model;

public class PenyediaJasa {
    
    private String id_layanan;
    private String id_booking;
    private String id_petugas;
    private String jenis_jasa;
    private float total_harga_jasa;
    private String tanggal_layanan;
    private Booking booking;
    private Petugas petugas;

    public PenyediaJasa(String id_layanan, String id_booking, String id_petugas, String jenis_jasa, float total_harga_jasa, String tanggal_layanan, Booking booking, Petugas petugas) {
        this.id_layanan = id_layanan;
        this.id_booking = id_booking;
        this.id_petugas = id_petugas;
        this.jenis_jasa = jenis_jasa;
        this.total_harga_jasa = total_harga_jasa;
        this.tanggal_layanan = tanggal_layanan;
        this.booking = booking;
        this.petugas = petugas;
    }

    public PenyediaJasa(String id_booking, String id_petugas, String jenis_jasa, float total_harga_jasa, String tanggal_layanan, Booking booking, Petugas petugas) {
        this.id_booking = id_booking;
        this.id_petugas = id_petugas;
        this.jenis_jasa = jenis_jasa;
        this.total_harga_jasa = total_harga_jasa;
        this.tanggal_layanan = tanggal_layanan;
        this.booking = booking;
        this.petugas = petugas;
    }

    public String getId_layanan() {
        return id_layanan;
    }
    
    public void setId_layanan(String id_layanan) {
        this.id_layanan = id_layanan;
    }
    
    public String getId_booking() {
        return id_booking;
    }
    
    public void setId_booking(String id_booking) {
        this.id_booking = id_booking;
    }

    public String getId_petugas() {
        return id_petugas;
    }
    
    public void setId_petugas(String id_petugas) {
        this.id_petugas = id_petugas;
    }

    public String getJenis_jasa() {
        return jenis_jasa;
    }
    
    public void setJenis_jasa(String jenis_jasa) {
        this.jenis_jasa = jenis_jasa;
    }

    public float getTotal_harga_jasa() {
        return total_harga_jasa;
    }
    
    public void setTotal_harga_jasa(float total_harga_jasa) {
        this.total_harga_jasa = total_harga_jasa;
    }

    public String getTanggal_layanan() {
        return tanggal_layanan;
    }
    
    public void setTanggal_layanan(String tanggal_layanan) {
        this.tanggal_layanan = tanggal_layanan;
    }

    public Booking getBooking() {
        return booking;
    }
    
    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Petugas getPetugas() {
        return petugas;
    }

    public void setPetugas(Petugas petugas) {
        this.petugas = petugas;
    }

}
