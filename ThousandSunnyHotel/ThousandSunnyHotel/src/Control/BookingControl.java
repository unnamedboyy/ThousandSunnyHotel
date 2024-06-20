
package Control;

import java.util.List;
import model.Booking;
import dao.BookingDAO;
import table.TableBooking;

public class BookingControl {
    BookingDAO BookingDao = new BookingDAO();
    
    public void InsertDataBooking(Booking booking){
        BookingDao.insert(booking);
    }
    
    public void deleteDataBooking(String id_booking){
        BookingDao.delete(id_booking);
    }
    
    public void updateDataBooking(Booking booking, String id_booking){ //hehe, tdi String diganti int
        BookingDao.update(booking, id_booking);
    }
    
    public TableBooking showTable(String target){
        List<Booking> dataBooking = BookingDao.showData(target);
        TableBooking tableBooking = new TableBooking(dataBooking);
        
        for (Booking booking : dataBooking){
            System.out.println(booking.getKamar().getId_kamar());
        }
        
        return tableBooking;
    }
    
    public String generateId() {
        return "B" + BookingDao.generateId();
    }
    
    public Booking searchBookingById(String id_booking) {
        return BookingDao.search(id_booking);
    }
    
    public List<Booking> showListBooking(){
        List<Booking> data = BookingDao.IShowForDropdown();
        return data;
    }
}

