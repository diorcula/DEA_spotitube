package nl.han.ica.dea.fedor.datasources;

import java.sql.*;

public class SQLDatabaseConnection {

    public Connection createConnection() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:sqlserver://FKA:1433";
        String user = "sa";
        String pass = "Boterbloem@666";

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        Connection connection = DriverManager.getConnection(connectionUrl, user, pass);
        System.out.println("Database Connection test succes");

//            Statement stmt = connection.createStatement();
//            ResultSet rs = stmt.executeQuery("USE Spotitube SELECT * FROM users");

//            while (rs.next()) {
//                System.out.println(rs.getString("testtest"));
//
//            }
        return connection;


    }
}