package nl.han.ica.dea.fedor.controllers;

import nl.han.ica.dea.fedor.dto.UserDTO;
import nl.han.ica.dea.fedor.dto.LoginResponseDTO;
import nl.han.ica.dea.fedor.exceptionMapper.NotFoundExceptionMapper;
import nl.han.ica.dea.fedor.services.UserService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

@Path("/login")
public class LoginController {

    private UserService userService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response Login(UserDTO userDTO) {
        if (userService.isValidLogin(userDTO.user, userDTO.password)) {
            String token = "1234-1234-1234";
            userDTO.setToken(token);

            LoginResponseDTO loginResponseDTO = new LoginResponseDTO(userDTO.getToken(), userDTO.getUser());
            System.out.println(userDTO.getToken());

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

