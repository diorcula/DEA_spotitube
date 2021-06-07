package nl.han.ica.dea.fedor.dao;

import nl.han.ica.dea.fedor.dao.Properties.DatabaseProperties;
import nl.han.ica.dea.fedor.dto.UserDTO;
import nl.han.ica.dea.fedor.exceptionMapper.exceptions.DatabaseException;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO {
    private final Logger logger = Logger.getLogger(getClass().getName());
    private final DatabaseProperties databaseProperties;

    public UserDAO() {
        databaseProperties = new DatabaseProperties();
        tryLoadJdbcDriver(databaseProperties);
    }

    public void tryLoadJdbcDriver(DatabaseProperties databaseProperties) {
        try {
            Class.forName(databaseProperties.driver());
        } catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE, "Can't load JDBC Driver " + databaseProperties.driver(), e);
            throw new DatabaseException("Error communicating with database ");
        }
    }

    public UserDTO getUserDTO(String username) {
        ResultSet rs;

        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionURL(), databaseProperties.connectionUSER(), databaseProperties.connectionPASS());

            PreparedStatement statement = connection.prepareStatement("USE Spotitube SELECT * FROM users WHERE username = ?");
            statement.setString(1, username);//1 specifies the first parameter in the query i.e. name
            rs = statement.executeQuery();

            while (rs.next()) {
                UserDTO user = new UserDTO();
                user.setUser(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setToken(rs.getString("token"));

                statement.close();
                connection.close();
                return user;
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionURL(), e);
            throw new DatabaseException("Error communicating with database ");
        }
        return null;
    }

    public boolean userExists(String userName) {
        ResultSet rs;

        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionURL(), databaseProperties.connectionUSER(), databaseProperties.connectionPASS());

            PreparedStatement statement = connection.prepareStatement("USE Spotitube SELECT * FROM users WHERE username = ?");
            statement.setString(1, userName); //1 specifies the first parameter in the query i.e. name
            rs = statement.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "error retrieving data from database " + e.getMessage());
            throw new DatabaseException("Error communicating with database ");
        }
        return false;
    }

}


