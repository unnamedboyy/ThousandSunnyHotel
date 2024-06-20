package dao;

import connection.DbConnection;
import interfaceDAO.IDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.*;

public class PenyediaJasaDAO implements IDAO<PenyediaJasa, String>{
    protected DbConnection dbCon = new DbConnection();
    protected Connection con;
    
    @Override
    public void insert(PenyediaJasa data) {
        con = dbCon.makeConnection();
        
        String sql = "INSERT INTO `penyediajasa` "
             + "(`id_layanan`, `id_booking`, `id_petugas`, `jenis_jasa`, "
             + "`total_harga_jasa`, `tanggal_layanan`) "
             + "VALUES ('" + data.getId_layanan() + "', '" + data.getBooking().getId_booking()
             + "', '" + data.getId_petugas() + "', '" + data.getJenis_jasa()
             + "', '" + data.getTotal_harga_jasa() + "', '" + data.getTanggal_layanan()+ "')";
        
        System.out.println("Adding Transaksi Penyedia Jasa...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + "Penyedia Jasa");
            statement.close();
        }catch(Exception e){
            System.out.println("Error adding Penyedia Jasa...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    @Override
    public List<PenyediaJasa> showData(String data) {
        con = dbCon.makeConnection();
        
        String sql = "SELECT * "
                + "FROM penyediajasa pj "
                + "JOIN booking c ON (pj.id_booking = c.id_booking) "
                + "JOIN petugas p ON (pj.id_petugas = p.id_petugas) "
                + "JOIN customer cus ON (c.id_customer = cus.id_customer) "
                + "JOIN kamar k ON (c.id_kamar = k.id_kamar) "
                + "WHERE (pj.jenis_jasa LIKE '%" + data + "%' "
                + "OR pj.tanggal_layanan LIKE '%" + data + "%' "
                + "OR c.id_booking LIKE '%" + data + "%' "
                + "OR p.nama_petugas LIKE '%" + data + "%') ";
        
        System.out.println("Mengambil data Penyedia Jasa...");
        List<PenyediaJasa> listPenyediaJasa = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while(rs.next()){
                    Customer cus = new Customer(
                        rs.getString("cus.id_customer"),
                        rs.getString("cus.nama"),
                        rs.getString("cus.email"),
                        rs.getString("cus.no_telp"),
                        rs.getString("cus.jenis_kelamin")
                    );                 
                    
                    Kamar kmr = new Kamar(
                        rs.getString("k.id_kamar"),
                        rs.getString("k.tipe"),
                        rs.getString("k.fasilitas"),
                        rs.getFloat("k.harga")
                    );
                    
                    Booking c = new Booking(
                        rs.getString("c.id_booking"),
                        rs.getString("c.id_customer"),
                        rs.getString("c.checkInDate"),
                        rs.getString("c.checkOutDate"),
                        rs.getString("c.id_kamar"),
                        rs.getString("c.metode_pembayaran"),
                        rs.getInt("c.total_harga"),
                        cus,
                        kmr
                    );
                    
                    Petugas p = new Petugas(
                        rs.getString("p.id_petugas"),
                        rs.getString("p.nama_petugas"),
                        rs.getString("p.no_telp"),
                        rs.getString("p.jenis_kelamin"),
                        rs.getInt("p.tahun_bekerja")
                    );
                    
                    PenyediaJasa pj = new PenyediaJasa(
                        rs.getString("pj.id_layanan"),
                        rs.getString("pj.id_booking"),
                        rs.getString("pj.id_petugas"),
                        rs.getString("pj.jenis_jasa"),
                        rs.getFloat("pj.total_harga_jasa"),
                        rs.getString("pj.tanggal_layanan"),
                        c,
                        p
                    );
                    listPenyediaJasa.add(pj);
                }
            }
            
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error Fetching data...");
            System.out.println(e);
        }
        
        System.out.println("Berhasil");
        dbCon.closeConnection();
        return listPenyediaJasa;
    }

    @Override
    public void update(PenyediaJasa data, String id_layanan) {
        con = dbCon.makeConnection();
        String sql = "UPDATE `penyediajasa` SET " +
                     "id_petugas='" + data.getId_petugas() + "', " +
                     "jenis_jasa='" + data.getJenis_jasa() + "', " +
                     "total_harga_jasa='" + data.getTotal_harga_jasa() + "', " +
                     "tanggal_layanan='" + data.getTanggal_layanan() + "' " +
                     "WHERE `id_layanan`='" + id_layanan + "';";
        System.out.println(" Penyedia Jasa");

        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " penyedia jasa");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Updating Penyedia Jasa...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
    }

    @Override
    public void delete(String id_layanan) {
        con = dbCon.makeConnection();
        String sql = "DELETE FROM `penyediajasa` WHERE `id_layanan` = '" + id_layanan + "'";
        System.out.println("Deleting Penyedia Jasa...");

        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Deleted " + result + " Penyedia Jasa");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Deleting Penyedia Jasa...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
    }

    @Override
    public PenyediaJasa search(String id_layanan) {
        con = dbCon.makeConnection();
        String sql = "SELECT * FROM booking WHERE `id_layanan`='" + id_layanan + "'";
        System.out.println("Searching booking...");
        PenyediaJasa pj = null;

        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
                    
                    Customer cus = new Customer(
                        rs.getString("c.id_customer"),
                        rs.getString("c.nama"),
                        rs.getString("c.email"),
                        rs.getString("c.no_telp"),
                        rs.getString("c.jenis_kelamin")
                    );                 
                    
                    Kamar kmr = new Kamar(
                        rs.getString("k.id_kamar"),
                        rs.getString("k.tipe"),
                        rs.getString("k.fasilitas"),
                        rs.getFloat("k.harga")
                    );
                    
                    Booking c = new Booking(
                        rs.getString("c.id_booking"),
                        rs.getString("c.id_customer"),
                        rs.getString("c.checkInDate"),
                        rs.getString("c.checkOutDate"),
                        rs.getString("c.id_kamar"),
                        rs.getString("c.metode_pembayaran"),
                        rs.getInt("c.total_harga"),
                        cus,
                        kmr
                    );
                    
                    Petugas p = new Petugas(
                        rs.getString("id_petugas"),
                        rs.getString("nama_petugas"),
                        rs.getString("no_telp"),
                        rs.getString("jenis_kelamin"),
                        rs.getInt("tahun_bekerja")
                    );
                    
                    pj = new PenyediaJasa(
                        rs.getString("pj.id_layanan"),
                        rs.getString("pj.id_booking"),
                        rs.getString("pj.id_petugas"),
                        rs.getString("pj.jenis_jasa"),
                        rs.getFloat("pj.total_harga_jasa"),
                        rs.getString("pj.tanggal_layanan"),
                        c,
                        p
                    );
                }
            }

            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Fetching data...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
        return pj;
    }
    
    //Generate ID
    public int generateId() {
        con = dbCon.makeConnection();
        String sql = "SELECT MAX(CAST(SUBSTRING(id_layanan, 2) AS SIGNED)) AS highest_number FROM penyediajasa WHERE id_layanan LIKE 'J%';";
        System.out.println("Generating Id...");
        int id = 0;

        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs != null && rs.next()) {
                id = rs.getInt("highest_number") + 1;
            }

            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Fetching data...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        System.out.println("Generated ID: " + id);
        return id;
    }
    
    
}

