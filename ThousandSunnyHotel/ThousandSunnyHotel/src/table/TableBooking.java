
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Booking;

public class TableBooking extends AbstractTableModel{
     
    private List<Booking> list;
    
    public TableBooking(List<Booking> list){
        this.list = list;
    }
    
    public int getRowCount(){
        return list.size();
    }
    
    public int getColumnCount(){
        return 7;
    }
    
    public Object getValueAt(int rowIndex, int columnIndex){
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getId_booking();
            case 1:
                return list.get(rowIndex).getId_kamar();
            case 2:
                return list.get(rowIndex).getCustomer().getNama();
            case 3:
                return list.get(rowIndex).getCheckInDate();
            case 4:
                return list.get(rowIndex).getCheckOutDate();
            case 5:
                return list.get(rowIndex).getMetode_pembayaran();
            case 6:
                return list.get(rowIndex).getTotal_harga();
            case 7:
                return list.get(rowIndex).getId_customer();
            default:
                return null;
        }
    }
    
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "ID Booking";
            case 1:
                return "Nomor Kamar";
            case 2:
                return "Nama Customer";
            case 3:
                return "Tanggal Check IN";
            case 4:
                return "Tanggal Check OUT";
            case 5:
                return "Metode Pembayaran";
            case 6:
                return "Total Harga";
            default:
                return null;
        }
    }
}
