package nl.han.ica.dea.fedor.exceptionMapper;

import nl.han.ica.dea.fedor.exceptionMapper.exceptions.DatabaseException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DatabaseExceptionHandler implements ExceptionMapper<DatabaseException> {

    @Override
    public Response toResponse(DatabaseException e) {
        return Response.status(500).entity("Database error: " + e.getMessage()).build();
    }
}
