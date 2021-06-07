package nl.han.ica.dea.fedor.exceptionMapper.exceptions;

/**
 * Throws a 401 error in LoginExceptionHandler
 */
public class UnauthorizedLoginException extends RuntimeException {
    public UnauthorizedLoginException(String errorMessage) {
        super(errorMessage);
    }
}
