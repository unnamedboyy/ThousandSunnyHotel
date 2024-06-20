
package dao;

import connection.DbConnection;
import interfaceDAO.IDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import interfaceDAO.IShowForDropdown;
import java.util.ArrayList;
import java.util.List;
import model.Customer;

public class CustomerDAO implements IDAO<Customer, String>, IShowForDropdown<Customer> {
    
    protected DbConnection dbCon = new DbConnection();
    protected Connection con;
    
    //Creat
    @Override
    public void insert(Customer c) {
        con = dbCon.makeConnection();
        String sql = "INSERT INTO `customer` (`id_customer`, `nama`, `email`, `no_telp`, `jenis_kelamin`) " +
                     "VALUES ('" + c.getId_customer() + "', '" + c.getNama() + "', '" + c.getEmail() + "', '" + c.getNo_telp() + "', '" + c.getJenis_kelamin() + "');";
        System.out.println("Adding Customer...");

        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Customer");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error adding Reviewer...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    //Read
    @Override
    public List<Customer> showData(String data) {
        con = dbCon.makeConnection();
        String sql = "SELECT * "
                + "FROM customer c "
                + "WHERE (c.id_customer LIKE '%" + data + "%' "
                + "OR c.nama LIKE '%" + data + "%' "
                + "OR c.jenis_kelamin LIKE '%" + data + "%') ";
        
        System.out.println("Fetching Data...");
        List<Customer> r = new ArrayList<>();

        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
                    r.add(new Customer(
                        rs.getString("id_customer"),
                        rs.getString("nama"),
                        rs.getString("email"),
                        rs.getString("no_telp"),
                        rs.getString("jenis_kelamin")
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
    
    //Update
    @Override
    public void update(Customer c, String id_customer) {
        con = dbCon.makeConnection();
        String sql = "UPDATE `customer` SET " +
                     "nama='" + c.getNama() + "', " +
                     "email='" + c.getEmail() + "', " +
                     "no_telp='" + c.getNo_telp() + "', " +
                     "jenis_kelamin='" + c.getJenis_kelamin()+ "' " +
                     "WHERE `id_customer`='" + id_customer + "';";
        System.out.println("Updating Reviewer");

        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " Customer");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Updating Customer...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
    }
    
    //Delete
    @Override
    public void delete(String id_customer) {
        con = dbCon.makeConnection();
        String sql = "DELETE FROM `customer` WHERE `id_customer` = '" + id_customer + "'";
        System.out.println("Deleting Customer...");

        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Deleted " + result + " Customer");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Deleting Customer...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
    }
    
    //Search
    @Override
    public Customer search(String id_customer) {
        con = dbCon.makeConnection();
        String sql = "SELECT * FROM customer WHERE `id_customer`='" + id_customer + "'";
        System.out.println("Searching Customer...");
        Customer c = null;

        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
                    c = new Customer(
                        rs.getString("id_customer"),
                        rs.getString("nama"),
                        rs.getString("email"),
                        rs.getString("no_telp"),
                        rs.getString("jenis_kelamin")
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
        return c;
    }
    
    //Generate ID
    public int generateId() {
        con = dbCon.makeConnection();
        String sql = "SELECT MAX(CAST(SUBSTRING(id_customer, 2) AS SIGNED)) AS highest_number FROM customer WHERE id_customer LIKE 'C%';";
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
    public List<Customer> IShowForDropdown() {
        
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM customer";
        System.out.println("Fetching Data...");
        List<Customer> c = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null)
                while(rs.next())
                    c.add(new Customer(
                        rs.getString("id_customer"),
                        rs.getString("nama"),
                        rs.getString("email"),
                        rs.getString("no_telp"),
                        rs.getString("jenis_kelamin")
                    ));
            
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error Fetching data...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return c;
    }
    
    

    
}
