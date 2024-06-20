package model;

public class Petugas {
    private String id_petugas;
    private String nama_petugas;
    private String no_telp;
    private String jenis_kelamin;
    private int tahun_bekerja;

    public Petugas(String id_petugas, String nama_petugas, String no_telp, String jenis_kelamin, int tahun_bekerja) {
        this.id_petugas = id_petugas;
        this.nama_petugas = nama_petugas;
        this.no_telp = no_telp;
        this.jenis_kelamin = jenis_kelamin;
        this.tahun_bekerja = tahun_bekerja;
    }

    public Petugas(String nama_petugas, String no_telp, String jenis_kelamin, int tahun_bekerja) {
        this.nama_petugas = nama_petugas;
        this.no_telp = no_telp;
        this.jenis_kelamin = jenis_kelamin;
        this.tahun_bekerja = tahun_bekerja;
    }
    
    public String getId_petugas() {
        return id_petugas;
    }
    
    public void setId_petugas(String id_petugas) {
        this.id_petugas = id_petugas;
    }
    
    public String getNama_petugas() {
        return nama_petugas;
    }
    
    public void setNama_petugas(String nama_petugas) {
        this.nama_petugas = nama_petugas;
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
    
    public int getTahun_bekerja() {
        return tahun_bekerja;
    }

    public void setTahun_bekerja(int tahun_bekerja) {
        this.tahun_bekerja = tahun_bekerja;
    }
    
    @Override
    public String toString(){
        return nama_petugas;
    }
}
