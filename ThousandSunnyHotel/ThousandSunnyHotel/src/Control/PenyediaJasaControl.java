
package Control;

import dao.PenyediaJasaDAO;
import java.util.List;
import model.PenyediaJasa;
import table.TablePenyediaJasa;

public class PenyediaJasaControl {
    private PenyediaJasaDAO pjDao = new PenyediaJasaDAO();
    
    public void insertData(PenyediaJasa data){
        pjDao.insert(data);
    }
    
    public TablePenyediaJasa showTable(String target){
        List<PenyediaJasa> dataPenyediaJasa = pjDao.showData(target);
        TablePenyediaJasa tablePenyediaJasa = new TablePenyediaJasa (dataPenyediaJasa);
        
        for (PenyediaJasa penyediaJasa : dataPenyediaJasa){
            System.out.println(penyediaJasa.getBooking().getCustomer().getNama());
        }
        
        return tablePenyediaJasa;
    }
    
    public void updateData(PenyediaJasa data, String id_layanan){
        pjDao.update(data, id_layanan);
    }
    
    public void deleteData(String id_layanan){
        pjDao.delete(id_layanan);
    }
    
    public String generateId() {
        return "J" + pjDao.generateId();
    }
}

