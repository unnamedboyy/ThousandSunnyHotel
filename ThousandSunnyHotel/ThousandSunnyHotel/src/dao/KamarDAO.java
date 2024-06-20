
package dao;

import connection.DbConnection;
import interfaceDAO.IDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import interfaceDAO.IShowForDropdown;
import java.util.ArrayList;
import java.util.List;
import model.Kamar;

public class KamarDAO implements IDAO<Kamar, String>, IShowForDropdown<Kamar>{
    protected DbConnection dbCon = new DbConnection();
    protected Connection con;
    
    @Override
    public void insert(Kamar data) {
       con = dbCon.makeConnection();
        String sql = "INSERT INTO `kamar` (`id_kamar`, `tipe`, `fasilitas`, `harga`) " +
                     "VALUES ('" + data.getId_kamar() + "', '" + data.getTipe() + "', '" + data.getFasilitas() + "', '" + data.getHarga() + "');";

        System.out.println("Adding Kamar...");

        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Kamar");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error adding Kamar...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    @Override
    public List<Kamar> showData(String data) {
        con = dbCon.makeConnection();
        
        String sql = "SELECT * "
                + "FROM kamar r "
                + "WHERE (r.id_kamar LIKE '%" + data + "%' "
                + "OR r.tipe LIKE '%" + data + "%' "
                + "OR r.fasilitas LIKE '%" + data + "%') ";

        System.out.println("Fetching Data...");
        List<Kamar> r = new ArrayList<>();

        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
                    r.add(new Kamar(
                        rs.getString("id_kamar"),
                        rs.getString("tipe"),
                        rs.getString("fasilitas"),
                        rs.getFloat("harga")
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
        return r;
    }

    @Override
    public void update(Kamar data, String id_kamar) {
       con = dbCon.makeConnection();
        String sql = "UPDATE `kamar` SET " +
                     "tipe='" + data.getTipe() + "', " +
                     "fasilitas='" + data.getFasilitas() + "', " +
                     "harga='" + data.getHarga() + "' " +
                     "WHERE `id_kamar`='" + id_kamar + "';";
        System.out.println("Updating Kamar");

        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " Kamar");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Updating Kamar...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
    }

    @Override
    public void delete(String id_kamar) {
        con = dbCon.makeConnection();
        String sql = "DELETE FROM `kamar` WHERE `id_kamar` = '" + id_kamar + "'";
        System.out.println("Deleting Kamar...");

        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Deleted " + result + " Kamar");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Deleting Kamar...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
    }

    @Override
    public Kamar search(String id_kamar) {
        con = dbCon.makeConnection();
        String sql = "SELECT * FROM kamar WHERE `id_kamar`='" + id_kamar + "'";
        System.out.println("Searching Kamar...");
        Kamar k = null;

        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
                    k = new Kamar(
                        rs.getString("id_kamar"),
                        rs.getString("tipe"),
                        rs.getString("fasilitas"),
                        rs.getFloat("harga")
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
        return k;
    }
    
    //Generate ID
    public int generateId() {
        con = dbCon.makeConnection();
        String sql = "SELECT MAX(CAST(SUBSTRING(id_kamar, 2) AS SIGNED)) AS highest_number FROM kamar WHERE id_kamar LIKE 'K%';";
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
    public List<Kamar> IShowForDropdown() {
        
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM kamar";
        System.out.println("Fetching Data...");
        List<Kamar> k = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null)
                while(rs.next())
                    k.add(new Kamar(
                        rs.getString("id_kamar"),
                        rs.getString("tipe"),
                        rs.getString("fasilitas"),
                        rs.getFloat("harga")
                    ));
            
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error Fetching data...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return k;
    
    }
    
}
