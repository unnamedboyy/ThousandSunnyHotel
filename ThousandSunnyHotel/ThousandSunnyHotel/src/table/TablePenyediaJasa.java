/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.PenyediaJasa;

public class TablePenyediaJasa extends AbstractTableModel{
    private List<PenyediaJasa> list;

    public TablePenyediaJasa(List<PenyediaJasa> list) {
        this.list = list;
    }
    
    @Override
    public int getRowCount() {
       return list.size();
    }

    @Override
    public int getColumnCount() {
       return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getBooking().getCustomer().getNama();
            case 1:
                return list.get(rowIndex).getPetugas().getNama_petugas();
            case 2:
                return list.get(rowIndex).getJenis_jasa();
            case 3:
                return list.get(rowIndex).getTanggal_layanan();
            case 4:
                return list.get(rowIndex).getTotal_harga_jasa();
            case 5:
                return list.get(rowIndex).getId_layanan();
            case 6:
                return list.get(rowIndex).getId_booking();
            case 7:
                return list.get(rowIndex).getId_petugas();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Nama Customer";
            case 1:
                return "Nama Petugas";
            case 2:
                return "Jenis Jasa";
            case 3:
                return "Tanggal Layanan";
            case 4:
                return "Total Harga Jasa";
            default:
                return null;
        }
    }
    
}
