package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class SetConnection {
    public static Connection createConnection() {
        Connection connection = null;
        String url = "jdbc:postgresql://localhost:5432/database";
        String username = "postgres";
        String password = "2w3e4r";

        try {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}

