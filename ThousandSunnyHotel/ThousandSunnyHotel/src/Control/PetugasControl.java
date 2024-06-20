
package Control;

import java.util.List;
import model.Petugas;
import dao.PetugasDAO;
import table.TablePetugas;

public class PetugasControl {
    PetugasDAO pDAO = new PetugasDAO();
    
    public void InsertDataPetugas(Petugas petugas){
        pDAO.insert(petugas);
    }
    
    public void deleteDataPetugas(String id_petugas){
        pDAO.delete(id_petugas);
    }
    
    public void updatePetugas(Petugas petugas, String id_petugas){
        pDAO.update(petugas, id_petugas);
    }
    
    public TablePetugas showTable(String target){
        List<Petugas> dataKamar = pDAO.showData(target);
        TablePetugas tablePetugas = new TablePetugas(dataKamar);
        
        for (Petugas asData : dataKamar) {
            System.out.println(asData.getId_petugas());
        }
        
        return tablePetugas;
    }
    
    public Petugas searchPetugasById(String id_petugas) {
        return pDAO.search(id_petugas);
    }
    
    public String generateId() {
        return "P" + pDAO.generateId();
    }
    
    public List<Petugas> showListPetugas(){
        List<Petugas> data = pDAO.IShowForDropdown();
        return data;
    }
}
