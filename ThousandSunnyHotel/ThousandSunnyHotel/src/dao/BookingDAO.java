
package dao;

import connection.DbConnection;
import interfaceDAO.IDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import interfaceDAO.IShowForDropdown;
import java.util.ArrayList;
import java.util.List;
import model.*;

public class BookingDAO implements IDAO<Booking, String>, IShowForDropdown<Booking>{
    protected DbConnection dbCon = new DbConnection();
    protected Connection con;

    //Create
    @Override
    public void insert(Booking data) {
        con = dbCon.makeConnection();
        
        System.out.println("ID CUSTOMERNYA = " + data.getId_customer());
        System.out.println("ID CUSTOMERNYA = " + data.getId_kamar());
        
        String sql = "INSERT INTO `booking` "
             + "(`id_booking`, `id_customer`, `checkInDate`, `checkOutDate`, "
             + "`id_kamar`, `metode_pembayaran`, `total_harga`) "
             + "VALUES ('" + data.getId_booking() + "', '" + data.getId_customer() 
             + "', '" + data.getCheckInDate() + "', '" + data.getCheckOutDate() 
             + "', '" + data.getId_kamar() + "', '" + data.getMetode_pembayaran() 
             + "', '" + data.getTotal_harga() + "')";
        

        System.out.println("Adding Booking...");

        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " booking");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error adding Booking...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    @Override
    public List<Booking> showData(String data) {
        con = dbCon.makeConnection();
        String sql ="SELECT * "
                    + "FROM booking b "
                    + "JOIN customer c ON (b.id_customer = c.id_customer) "
                    + "JOIN kamar k ON (b.id_kamar = k.id_kamar) "
                    + "WHERE (k.id_kamar LIKE '%" + data + "%' "
                    + "OR c.nama LIKE '%" + data + "%' "
                    + "OR b.checkInDate LIKE '%" + data + "%' "
                    + "OR b.checkOutDate LIKE '%" + data + "%') "; 
                    
        System.out.println("Fetching Data...");
        List<Booking> listBooking = new ArrayList<>();

        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if(rs != null){
                while(rs.next()){
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
                    
                    Booking b = new Booking(
                        rs.getString("b.id_booking"),
                        rs.getString("b.id_customer"),
                        rs.getString("b.checkInDate"),
                        rs.getString("b.checkOutDate"),
                        rs.getString("b.id_kamar"),
                        rs.getString("b.metode_pembayaran"),
                        rs.getInt("b.total_harga"),
                        cus,
                        kmr
                    );
                    
                    listBooking.add(b);
                }
            }

            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Fetching data...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
        return listBooking;
    }

    @Override
    public void update(Booking data, String id_booking) {
       con = dbCon.makeConnection();
        String sql = "UPDATE `booking` SET " +
                     "id_kamar='" + data.getId_kamar() + "', " +
                     "checkInDate='" + data.getCheckInDate() + "', " +
                     "checkOutDate='" + data.getCheckOutDate() + "', " +
                     "metode_pembayaran='" + data.getMetode_pembayaran() + "', " +
                     "total_harga='" + data.getTotal_harga() + "' " +
                     "WHERE `id_booking`='" + id_booking + "';";
        System.out.println(" Booking");

        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " booking");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Updating booking...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
    }

    @Override
    public void delete(String id_booking) {
        con = dbCon.makeConnection();
        String sql = "DELETE FROM `booking` WHERE `id_booking` = '" + id_booking + "'";
        System.out.println("Deleting booking...");

        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Deleted " + result + " booking");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Deleting booking...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
    }

    @Override
    public Booking search(String id_booking) {

        con = dbCon.makeConnection();
        String sql = "SELECT * FROM booking WHERE `id_booking`='" + id_booking + "'";
        System.out.println("Searching booking...");
        Booking b = null;

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
                    
                    b = new Booking(
                        rs.getString("b.id_booking"),
                        rs.getString("b.id_customer"),
                        rs.getString("b.checkInDate"),
                        rs.getString("b.checkOutDate"),
                        rs.getString("b.id_kamar"),
                        rs.getString("b.metode_pembayaran"),
                        rs.getInt("b.total_harga"),
                        cus,
                        kmr
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
        return b;
        
    }
    
    //Generate ID
    public int generateId() {
        con = dbCon.makeConnection();
        String sql = "SELECT MAX(CAST(SUBSTRING(id_booking, 2) AS SIGNED)) AS highest_number FROM booking WHERE id_booking LIKE 'B%';";
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
    public List<Booking> IShowForDropdown() {
       con = dbCon.makeConnection();
        
        String sql ="SELECT * "
                    + "FROM booking b "
                    + "JOIN customer c ON (b.id_customer = c.id_customer) "
                    + "JOIN kamar k ON (b.id_kamar = k.id_kamar) ";
        
        System.out.println("Fetching Data...");
        List<Booking> listBooking = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null)
                while(rs.next()){
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
                    
                    Booking b = new Booking(
                        rs.getString("b.id_booking"),
                        rs.getString("b.id_customer"),
                        rs.getString("b.checkInDate"),
                        rs.getString("b.checkOutDate"),
                        rs.getString("b.id_kamar"),
                        rs.getString("b.metode_pembayaran"),
                        rs.getInt("b.total_harga"),
                        cus,
                        kmr
                    );
                    
                    listBooking.add(b);
                }
                   
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error Fetching data...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return listBooking;
    }

}
