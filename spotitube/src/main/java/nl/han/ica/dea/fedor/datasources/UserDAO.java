package nl.han.ica.dea.fedor.datasources;

import javax.inject.Inject;
import java.sql.*;

public class UserDAO {

    private SQLDatabaseConnection dBconnection;

    public String getPasswordForUser(String username) {
        Connection connection = null;
        String gebruikersnaam = username;

        // Prepared statement
        String query = "USE Spotitube SELECT password FROM users WHERE username = '" + gebruikersnaam + "'";

        try {
            connection = dBconnection.createConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

//          connection.prepareStatement(query).execute();

            String a = null;
            while (rs.next()) {
                a = rs.getString("password");
            }
            return a;

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
