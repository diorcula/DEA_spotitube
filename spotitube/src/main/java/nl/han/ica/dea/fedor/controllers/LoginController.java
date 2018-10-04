package nl.han.ica.dea.fedor.controllers;

import nl.han.ica.dea.fedor.dto.LoginRequestDTO;
import nl.han.ica.dea.fedor.dto.LoginResponseDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/login")
public class LoginController {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response Login(LoginRequestDTO loginRequestDTO) {

        if (loginRequestDTO.user.equals("fedor") && loginRequestDTO.password.equals("koekje")) {

            LoginResponseDTO loginResponseDTO = new LoginResponseDTO("1234-1234-1234", "Meron Brouwer");

            return Response.ok(loginResponseDTO).build();

        } else {
            return Response.status(401).build();
        }

    }

}