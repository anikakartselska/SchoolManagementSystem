package schoolproject.dao.exceptions;

public class BusyClassException extends Exception{
    public BusyClassException() {
    }

    public BusyClassException(String message) {
        super(message);
    }

    public BusyClassException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusyClassException(Throwable cause) {
        super(cause);
    }
}
