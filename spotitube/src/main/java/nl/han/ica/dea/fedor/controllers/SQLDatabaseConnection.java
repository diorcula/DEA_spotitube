package nl.han.ica.dea.fedor.controllers;

import java.sql.*;

public class SQLDatabaseConnection {
    // Connect to your database.
    // Replace server name, username, and password with your credentials
    public static void main(String[] args) {
        String connectionUrl =
                //   "jdbc:sqlserver://FKA/1434;"
                // "jdbc:sqlserver://FKA.Spotitube.windows.net:1434;"
                "jdbc:sqlserver://localhost:1433";
                      //  + "user=sa;"
                       // + "password=Boterbloem@666;";
                String user = "sa";
                String pass = "Boterbloem@666";
        try (Connection connection = DriverManager.getConnection(connectionUrl,user,pass)) {
            // Code here.
            System.out.println("Database Connection werkt");

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("USE Spotitube SELECT * FROM test");
            System.out.print(rs);

            while (rs.next()) {
                System.out.println(rs.getInt(2) + " " + rs.getInt(3));
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}