package nl.han.ica.dea.fedor.exceptionMapper;

import nl.han.ica.dea.fedor.exceptionMapper.exceptions.UnauthorizedLoginException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class LoginExceptionHandler implements ExceptionMapper<UnauthorizedLoginException> {

    @Override
    public Response toResponse(UnauthorizedLoginException e) {
        return Response.status(401).entity("Unauthorized Exception Error: " + e.getMessage()).build();
    }
}