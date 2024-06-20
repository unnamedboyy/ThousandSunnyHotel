
package exception;

public class InvalidTanggalException extends Exception{
    public String message(){
        return "TANGGAL CHECK IN DAN CHECK OUT TIDAK LOGIS";
    }
}
