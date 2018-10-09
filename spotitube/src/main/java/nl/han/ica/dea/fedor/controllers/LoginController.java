package nl.han.ica.dea.fedor.controllers;

import nl.han.ica.dea.fedor.datasources.UserDAO;
import nl.han.ica.dea.fedor.dto.LoginRequestDTO;
import nl.han.ica.dea.fedor.dto.LoginResponseDTO;
import nl.han.ica.dea.fedor.services.UserService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/login")
public class LoginController {

    private UserService userService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response Login(LoginRequestDTO loginRequestDTO) {

//        if (loginRequestDTO.user.equals("meron") && loginRequestDTO.password.equals("koekje")) {

//               if (userService.isValidLogin(loginRequestDTO.user, loginRequestDTO.password) ) {
        if (userService.isValidLogin(loginRequestDTO.user, loginRequestDTO.password) == true) {
            LoginResponseDTO loginResponseDTO = new LoginResponseDTO("1234-1234-1234", "Meron Brouwer");

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