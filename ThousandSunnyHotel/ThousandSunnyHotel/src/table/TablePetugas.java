/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Petugas;

public class TablePetugas extends AbstractTableModel{
    private List<Petugas> list;

    public TablePetugas(List<Petugas> list) {
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
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getId_petugas();
            case 1:
                return list.get(rowIndex).getNama_petugas();
            case 2:
                return list.get(rowIndex).getNo_telp();
            case 3:
                return list.get(rowIndex).getJenis_kelamin();
            case 4:
                return list.get(rowIndex).getTahun_bekerja();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Id Petugas";
            case 1:
                return "Nama Petugas";
            case 2:
                return "Nomer Telpon";
            case 3:
                return "Jenis Kelamin";
            case 4:
                return "Tahun Bekerja";
            default:
                return null;
        }
    }
    
}
