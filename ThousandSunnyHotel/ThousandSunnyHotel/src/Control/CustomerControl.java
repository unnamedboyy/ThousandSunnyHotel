
package Control;

import java.util.List;
import model.Customer;
import dao.CustomerDAO;
import table.TableCustomer;

public class CustomerControl {
    CustomerDAO CustomerDao = new CustomerDAO();
    
    public void InsertDataCustomer(Customer customer){
        CustomerDao.insert(customer);
    }
    
    public void deleteDataCustomer(String id_customer){
        CustomerDao.delete(id_customer);
    }
    
    public void updateCustomer(Customer customer, String id_customer){
        CustomerDao.update(customer, id_customer);
    }
    
    public TableCustomer showTable(String target){
        List<Customer> dataCustomer = CustomerDao.showData(target);
        TableCustomer tableCustomer = new TableCustomer(dataCustomer);
        
        for (Customer asData : dataCustomer) {
            System.out.println(asData.getId_customer());
        }
        
        return tableCustomer;
    }
    
    public List<Customer> showListCustomer(){
        List<Customer> data = CustomerDao.IShowForDropdown();
        return data;
    }
    
    public Customer searchCustomerById(String id_customer) {
        return CustomerDao.search(id_customer);
    }
    
    public String generateId() {
        return "C" + CustomerDao.generateId();
    }
}
