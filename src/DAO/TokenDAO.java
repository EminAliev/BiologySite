package DAO;

import helpers.SetConnection;

import java.sql.*;

public class TokenDAO {


    private static TokenDAO tokenDAO;
    private Connection connection;

    public static TokenDAO getTokenDAO() {
        if (tokenDAO == null) {
            tokenDAO = new TokenDAO();
        }
        return tokenDAO;
    }

    public TokenDAO() {
        connection = SetConnection.createConnection();
    }


    public void add(int id, String token) {
        if (!token.equals("")) {
            try {
                PreparedStatement statement = connection
                        .prepareStatement("insert into cookies (id,token) values (? ,?)");
                statement.setInt(1, id);
                statement.setString(2, token);
                statement.executeUpdate();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
    }

    public void update(int id, String token) {
        if (!token.equals("")) {
            try {
                PreparedStatement statement = connection
                        .prepareStatement("update cookies set token=?  WHERE id=?");
                statement.setString(1, token);
                statement.setInt(2, id);
                statement.executeUpdate();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
    }

    public void delete(String token) {
        if (!token.equals("")) {
            try {
                PreparedStatement statement = connection
                        .prepareStatement("delete from cookies where token=?");
                statement.setString(1, token);
                statement.executeUpdate();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public String find(String token) {
        if (!token.equals("")) {
            try {
                PreparedStatement statement = connection
                        .prepareStatement("select * from cookies where token=?");
                statement.setString(1, token);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    return resultSet.getString("id");
                }
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
