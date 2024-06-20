package model;

public class Kamar {
    private String id_kamar;
    private String tipe;
    private String fasilitas;
    private float harga;
    
    public Kamar(String id_kamar, String tipe, String fasilitas, float harga){
        this.id_kamar = id_kamar;
        this.tipe = tipe;
        this.fasilitas = fasilitas;
        this.harga = harga;
    }
    
    public Kamar(String tipe, String fasilitas, float harga){
        this.tipe = tipe;
        this.fasilitas = fasilitas;
        this.harga = harga;
    }

    public String getId_kamar() {
        return id_kamar;
    }

    public void setId_kamar(String id_kamar) {
        this.id_kamar = id_kamar;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }
    
    public String getFasilitas(){
        return fasilitas;
    }
    
    public void setFasilitas(String fasilitas){
        this.fasilitas = fasilitas;
    }

    public float getHarga() {
        return harga;
    }

    public void setHarga(float harga) {
        this.harga = harga;
    }
    
    @Override
    public String toString(){
        return id_kamar;
    }
}
