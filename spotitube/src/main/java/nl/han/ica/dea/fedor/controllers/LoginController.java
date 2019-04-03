package nl.han.ica.dea.fedor.controllers;

import nl.han.ica.dea.fedor.dto.UserDTO;
import nl.han.ica.dea.fedor.dto.LoginResponseDTO;
import nl.han.ica.dea.fedor.services.UserService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/login")
public class LoginController {

    private UserService userService;

    @Path("")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response Login(UserDTO userDTO) {
        System.out.println("voor if" );
        if (userService.isValidLogin(userDTO.user, userDTO.password)) {
            System.out.println("in if");
            String token = "1234-1234-1234";
            userDTO.setToken(token);
            System.out.println("na set token");
            LoginResponseDTO loginResponseDTO = new LoginResponseDTO(userDTO.getToken(), userDTO.getUser());

            return Response.ok(loginResponseDTO).build();

        } else {
            return Response.status(401).build();
        }

    }

    @Inject
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}

