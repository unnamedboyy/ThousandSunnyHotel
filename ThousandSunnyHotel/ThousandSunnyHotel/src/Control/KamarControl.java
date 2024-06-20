
package Control;

import java.util.List;
import model.Kamar;
import dao.KamarDAO;
import table.TableKamar;

public class KamarControl {
    KamarDAO KamarDao = new KamarDAO();
    
    public void InsertDataKamar(Kamar k){
        KamarDao.insert(k);
    }
    
    public void deleteDataKamar(String id_kamar){
        KamarDao.delete(id_kamar);
    }
    
    public void updateKamar(Kamar k, String id_kamar){
        KamarDao.update(k, id_kamar);
    }
    
    public TableKamar showTable(String target){
        List<Kamar> dataKamar = KamarDao.showData(target);
        TableKamar tableKamar = new TableKamar(dataKamar);
        
        for (Kamar asData : dataKamar) {
            System.out.println(asData.getId_kamar());
        }
        
        return tableKamar;
    }
    
    public List<Kamar> showListKamar(){
        List<Kamar> data = KamarDao.IShowForDropdown();
        return data;
    }
    
    public Kamar searchKamarByNomor(String nomorKamar) {
        return KamarDao.search(nomorKamar);
    }
    
    public String generateId() {
        return "K" + KamarDao.generateId();
    }
}
