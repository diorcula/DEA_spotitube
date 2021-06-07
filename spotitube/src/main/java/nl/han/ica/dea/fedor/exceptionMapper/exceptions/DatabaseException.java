package nl.han.ica.dea.fedor.exceptionMapper.exceptions;

public class DatabaseException extends RuntimeException {
    public DatabaseException(String errorMessage) {
        super(errorMessage);
    }
}
