package nl.han.ica.dea.fedor.services;

import nl.han.ica.dea.fedor.datasources.UserDAO;
import nl.han.ica.dea.fedor.dto.UserDTO;


import javax.inject.Inject;

public class UserService {

    private UserDAO userDAO;

    @Inject
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean isValidLogin(String userName, String password) {
       // String passwordForUser = userDAO.getPasswordForUser(userName);
        UserDTO user = userDAO.getUserDTO(userName);

        if (password.equals(user.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

//    public boolean isValidToken(String userName, String token){
//
//        UserDTO userDTO = userDAO.getUserDTO(userName);
//        return true;
//    }
}
