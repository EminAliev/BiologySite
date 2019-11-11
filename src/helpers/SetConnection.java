package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SetConnection {
    /*public static Connection createConnection() {
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
    }*/
    private static final String URL = "jdbc:postgresql://localhost:5432/DatabaseProject";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "2w3e4r";
    private static final String DRIVER = "org.postgresql.Driver";

    private static Connection connection = null;

    public static Connection createConnection() {
        if (connection == null) {

            try {
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        }

        return connection;
    }
}


