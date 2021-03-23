package nl.han.ica.dea.fedor.services;

import nl.han.ica.dea.fedor.dao.UserDAO;
import nl.han.ica.dea.fedor.dto.UserDTO;
import nl.han.ica.dea.fedor.exceptionMapper.exceptions.UnauthorizedLoginException;

import javax.inject.Inject;

/**
 * The type User service.
 */
public class UserService {
    /**
     * The User dao.
     */
    @Inject
    UserDAO userDAO;

    /**
     * Is valid login boolean.
     *
     * @param userName the user name
     * @param password the password
     * @return the boolean
     */
    public boolean isValidLogin(String userName, String password) {
        if (userDAO.userExists(userName)) {

            UserDTO user = userDAO.getUserDTO(userName);

            return password.equals(user.getPassword());

        } else {
            System.out.println("Login credentials do not match");
            return false;
        }
    }

}