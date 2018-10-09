package nl.han.ica.dea.fedor.services;

import nl.han.ica.dea.fedor.datasources.UserDAO;


import javax.inject.Inject;

public class UserService {

    @Inject
    UserDAO userDAO;

//    public boolean isValidLogin(String userName, String password) {
//        String passwordForUser = userDAO.getPasswordForUser(userName);
//
//        return password.equals(passwordForUser);
//    }

    public boolean isValidLogin(String userName, String password) {
        String passwordForUser = userDAO.getPasswordForUser(userName);

        if (password.equals(passwordForUser)) {
            return true;
        } else {
            return false;
        }
    }
}
