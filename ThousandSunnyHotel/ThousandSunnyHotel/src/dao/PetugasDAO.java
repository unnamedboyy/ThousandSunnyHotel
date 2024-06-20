
package dao;

import connection.DbConnection;
import interfaceDAO.IDAO;
import interfaceDAO.IShowForDropdown;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Petugas;

public class PetugasDAO implements IDAO<Petugas, String>, IShowForDropdown<Petugas>{
    protected DbConnection dbCon = new DbConnection();
    protected Connection con;

    @Override
    public void insert(Petugas data) {
        con = dbCon.makeConnection();
        String sql = "INSERT INTO `petugas` (`id_petugas`, `nama_petugas`, `no_telp`, `jenis_kelamin`, `tahun_bekerja`) " +
                     "VALUES ('" + data.getId_petugas() + "', '" + data.getNama_petugas() + "', '" + data.getNo_telp() + "', '" + data.getJenis_kelamin() + "', '" + data.getTahun_bekerja() + "');";
        System.out.println("Adding Petugas...");

        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Petugas");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error adding Petugas...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    @Override
    public List<Petugas> showData(String data) {
        con = dbCon.makeConnection();
        String sql = "SELECT * "
                + "FROM petugas p "
                + "WHERE (p.id_petugas LIKE '%" + data + "%' "
                + "OR p.nama_petugas LIKE '%" + data + "%' "
                + "OR p.jenis_kelamin LIKE '%" + data + "%' "
                + "OR p.tahun_bekerja LIKE '%" + data + "%') ";
        
        System.out.println("Fetching Data...");
        List<Petugas> p = new ArrayList<>();

        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
                    p.add(new Petugas(
                        rs.getString("id_petugas"),
                        rs.getString("nama_petugas"),
                        rs.getString("no_telp"),
                        rs.getString("jenis_kelamin"),
                        rs.getInt("tahun_bekerja")
                    ));
                }
            }

            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Fetching data...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
        return p;
    }

    @Override
    public void update(Petugas p, String id_petugas) {
        con = dbCon.makeConnection();
        String sql = "UPDATE `petugas` SET " +
                     "nama_petugas='" + p.getNama_petugas() + "', " +
                     "no_telp='" + p.getNo_telp() + "', " +
                     "jenis_kelamin='" + p.getJenis_kelamin()+ "', " +
                     "tahun_bekerja='" + p.getTahun_bekerja() + "' " +
                     "WHERE `id_petugas`='" + id_petugas + "';";
        System.out.println("Updating Petugas");

        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " Petugas");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Updating Petugas...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
    }

    @Override
    public void delete(String id_petugas) {
        con = dbCon.makeConnection();
        String sql = "DELETE FROM `petugas` WHERE `id_petugas` = '" + id_petugas + "'";
        System.out.println("Deleting Petugas...");

        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Deleted " + result + " Petugas");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Deleting Customer...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
    }

    @Override
    public Petugas search(String id_petugas){
        con = dbCon.makeConnection();
        String sql = "SELECT * FROM petugas WHERE `id_petugas`='" + id_petugas + "'";
        System.out.println("Searching Petugas...");
        Petugas p = null;

        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
                    p = new Petugas(
                        rs.getString("id_petugas"),
                        rs.getString("nama_petugas"),
                        rs.getString("no_telp"),
                        rs.getString("jenis_kelamin"),
                        rs.getInt("tahun_bekerja")
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
        return p;
    }
    
    public int generateId() {
        con = dbCon.makeConnection();
        String sql = "SELECT MAX(CAST(SUBSTRING(id_petugas, 2) AS SIGNED)) AS highest_number FROM petugas WHERE id_petugas LIKE 'P%';";
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
    
    @Override
    public List<Petugas> IShowForDropdown() {
        
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM petugas";
        System.out.println("Fetching Data...");
        List<Petugas> p = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null)
                while(rs.next())
                    p.add(new Petugas(
                        rs.getString("id_petugas"),
                        rs.getString("nama_petugas"),
                        rs.getString("no_telp"),
                        rs.getString("jenis_kelamin"),
                        rs.getInt("tahun_bekerja")
                    ));
            
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error Fetching data...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return p;
    }
}

