package nl.han.ica.dea.fedor.datasources;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {

    private SQLDatabaseConnection dBconnection;

    public String getPasswordForUser(String username) {
        Connection connection = null;
        String gebruikersnaam = username;
        try {
            connection = dBconnection.createConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("USE Spotitube SELECT * FROM users WHERE username ="+gebruikersnaam);
            return rs.toString();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return "password";
    }

    @Inject
    public void setConnection(SQLDatabaseConnection connection) {
        this.dBconnection = connection;
    }
}
