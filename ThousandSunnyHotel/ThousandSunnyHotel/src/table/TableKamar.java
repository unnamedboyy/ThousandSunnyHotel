
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Kamar;

public class TableKamar extends AbstractTableModel {
    private List<Kamar> list;
    
    public TableKamar(List<Kamar> list){
        this.list = list;
    }
    
    @Override
    public int getRowCount(){
        return list.size();
    }
    
    @Override
    public int getColumnCount(){
        return 4;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getId_kamar();
            case 1:
                return list.get(rowIndex).getTipe();
            case 2:
                return list.get(rowIndex).getFasilitas();
            case 3:
                return list.get(rowIndex).getHarga();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Id Kamar";
            case 1:
                return "Tipe Kamar";
            case 2:
                return "Fasilitas";
            case 3:
                return "Harga";
            default:
                return null;
        }
    }
}
