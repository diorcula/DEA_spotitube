package nl.han.ica.dea.fedor.exceptionMapper;

import javax.mail.AuthenticationFailedException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class AuthenticationFailedExceptionMapper implements ExceptionMapper<AuthenticationFailedException> {

    @Override
    public Response toResponse(AuthenticationFailedException e) {
        return Response.status(Response.Status.NOT_FOUND).entity("Inloggen gaat niet goed").build();
    }
}
