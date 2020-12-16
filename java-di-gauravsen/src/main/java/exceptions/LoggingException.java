package exceptions;

public class LoggingException extends RuntimeException {

    public LoggingException(Exception ex) {
        super(ex);
    }
}
