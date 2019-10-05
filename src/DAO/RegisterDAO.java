package DAO;

import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAO {

    public String registerUser(User user) {
        String fullName = user.getFullname();
        String email = user.getEmail();
        String userName = user.getUsername();
        String password = user.getPassword();

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = SetConnection.createConnection();
            String query = "insert into users(SlNo,fullName,Email,userName,password) values (NULL,?,?,?,?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, fullName);
            statement.setString(2, email);
            statement.setString(3, userName);
            statement.setString(4, password);

            int i = statement.executeUpdate();

            if (i != 0)
                return "SUCCESS";
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "Oops.. Something went wrong there..!";
    }
}

