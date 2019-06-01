package nl.han.ica.dea.fedor.services;

import nl.han.ica.dea.fedor.datasources.UserDAO;
import nl.han.ica.dea.fedor.dto.UserDTO;
import nl.han.ica.dea.fedor.exceptionMapper.NotFoundExceptionMapper;


import javax.inject.Inject;
import javax.ws.rs.NotFoundException;

public class UserService {

    private UserDAO userDAO;

    @Inject
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean isValidLogin(String userName, String password) {
        UserDTO user = userDAO.getUserDTO(userName);

        if (password.equals(user.getPassword())) {
            return true;
        } else {
            throw new NotFoundException();
        }
    }

//    public boolean isValidToken(String userName, String token){
//
//        UserDTO userDTO = userDAO.getUserDTO(userName);
//        return true;
//    }
}
