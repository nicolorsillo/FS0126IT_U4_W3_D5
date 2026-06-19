package nicolorsillo.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super("Non è stato trovato nessun record con " + message);
    }
}
