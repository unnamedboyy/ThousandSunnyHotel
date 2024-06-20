
package costum;
 
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
 
public class JtableColor extends DefaultTableCellRenderer {
 
    private static final long serialVersionUID = 47612794125L;
 
    private Color ganjil;
    private Color genap;
 

    public JtableColor(Color ganjil, Color genap) {
        this.ganjil = ganjil;
        this.genap = genap;
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
 
        if (row % 2 == 1) {
            // ganjil
            component.setBackground(ganjil);
        } else {
            // genap
            component.setBackground(genap);
        }
        return component;
    }   
}
