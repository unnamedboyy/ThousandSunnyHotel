
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Customer;

public class TableCustomer extends AbstractTableModel{
    private List<Customer> list;
    
    public TableCustomer(List<Customer> list){
        this.list = list;
    }
    
    public int getRowCount(){
        return list.size();
    }
    
    public int getColumnCount(){
        return 5;
    }
    
    public Object getValueAt(int rowIndex, int columnIndex){
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getId_customer();
            case 1:
                return list.get(rowIndex).getNama();
            case 2:
                return list.get(rowIndex).getEmail();
            case 3:
                return list.get(rowIndex).getNo_telp();
            case 4:
                return list.get(rowIndex).getJenis_kelamin();
            default:
                return null;
        }
    }
    
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Id Customer";
            case 1:
                return "Nama Customer";
            case 2:
                return "Email Customer";
            case 3:
                return "Nomer Telpon";
            case 4:
                return "Jenis Kelamin";
            default:
                return null;
        }
    }
}
