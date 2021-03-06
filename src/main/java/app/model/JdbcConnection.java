package app.model;

import java.sql.*;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcConnection {
    private static final Logger LOGGER =
            Logger.getLogger(JdbcConnection.class.getName());
    private static Connection connection = null;

    public static Connection getConnection() throws ClassNotFoundException {
        try {
            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
        }
        System.out.println("PostgreSQL JDBC Driver is found");
        String url = "jdbc:postgresql://localhost:5432/Test_db";
        String user = "postgres";

        String password = "12345";

        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Успех!");

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
            System.out.println("Фейл!");
        }
        return connection;
    }
}
