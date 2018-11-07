package nl.han.ica.dea.fedor.datasources;

import nl.han.ica.dea.fedor.datasources.Properties.DatabaseProperties;
import nl.han.ica.dea.fedor.dto.UserDTO;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO {
    private Logger logger = Logger.getLogger(getClass().getName());
  //  private SQLDatabaseConnection dBconnection = null;
    private DatabaseProperties databaseProperties;

    public UserDAO() {
        databaseProperties = new DatabaseProperties();
        tryLoadJdbcDriver(databaseProperties);
    }

    private void tryLoadJdbcDriver(DatabaseProperties databaseProperties) {
        try {
            Class.forName(databaseProperties.driver());
        } catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE, "Can't load JDBC Driver " + databaseProperties.driver(), e);
        }
    }

    public UserDTO getUserDTO(String username) {

        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        // Prepared statement
        String query = "USE Spotitube SELECT * FROM users WHERE username = '" + username + "'";

        try {
           // connection = dBconnection.createConnection();
            Connection connection = DriverManager.getConnection(databaseProperties.connectionURL(),databaseProperties.connectionUSER(),databaseProperties.connectionPASS());
            preparedStatement = connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();

            rs.next();
            UserDTO user = new UserDTO();
            user.setUser(rs.getString("username"));
            user.setPassword(rs.getString("password"));

            return user;

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionURL(), e);
        }

        return null;

    }

}
