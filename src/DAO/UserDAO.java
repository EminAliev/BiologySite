package DAO;

import models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private Connection connection;

    public UserDAO() {
        connection = SetConnection.createConnection();
    }


    public boolean validateLogin(String email, String password) {
        boolean login = false;

        try {
            PreparedStatement statement = connection
                    .prepareStatement("select * from DatabaseProject where email=? and password=?");
            statement.setString(1, email);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            login = resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return login;
    }


    public User userSession(String email) {
        User user = new User();
        try {
            PreparedStatement statement = connection
                    .prepareStatement("select * from DatabaseProject where email=?");
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setName(resultSet.getString("name"));
                user.setFullname(resultSet.getString("fullname"));
                user.setClassNumber(resultSet.getInt("classNumber"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    public void createUser(User user) {
        try {
            PreparedStatement statement = connection
                    .prepareStatement("insert into DatabaseProject(username,password,email,name,fullname,classNumber) values (?,?,?,?,?,?)");
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getName());
            statement.setString(5, user.getFullname());
            statement.setLong(6, user.getClassNumber());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void editAccount(User user) {
        try {
            PreparedStatement statement = connection
                    .prepareStatement("update DatabaseProject set username=?, password=?" + " where id=?");
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteAccount(int id) {
        try {
            PreparedStatement statement = connection
                    .prepareStatement("delete from DatabaseProject where id=?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<User> listUsers() {
        List<User> userList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from DatabaseProject");
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setName(resultSet.getString("name"));
                user.setFullname(resultSet.getString("fullname"));
                user.setClassNumber(resultSet.getInt("classNumber"));
                userList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }


    public User getUserByID(int id) {
        User user = new User();
        try {
            PreparedStatement statement = connection
                    .prepareStatement("select * from DatabaseProject where id= ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setName(resultSet.getString("name"));
                user.setFullname(resultSet.getString("fullname"));
                user.setClassNumber(resultSet.getInt("classNumber"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}

