package DAO;

import helpers.RowMapper;
import helpers.SetConnection;
import models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static UserDAO userDAO;
    private Connection connection;
    // Connection connection = SetConnection.createConnection();

    public static UserDAO getUserDAODataBase() {
        if (userDAO == null) {
            userDAO = new UserDAO();
        }
        return userDAO;
    }

    public UserDAO() {
        connection = SetConnection.createConnection();
    }


    private RowMapper<User> userRowMapper = row -> {
        Integer id = row.getObject("id", Integer.class);
        String username = row.getString("username");
        String password = row.getString("password");
        Integer classnumber = row.getObject("classnumber", Integer.class);
        String name = row.getString("name");
        String fullname = row.getString("fullname");
        String email = row.getString("email");
        return new User(id, username, password, name, fullname, classnumber, email);
    };


    public boolean validateLogin(String email, String password) {
        connection = SetConnection.createConnection();
        boolean login = false;

        try {
            PreparedStatement statement = connection
                    .prepareStatement("select * from users where email=? and password=?");
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
                    .prepareStatement("select * from users where email=?");
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = userRowMapper.mapRow(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    public void createUser(User user) {
        connection = SetConnection.createConnection();
        try {
            PreparedStatement statement = connection
                    .prepareStatement("insert into users(username,password,name,fullname,classnumber,email) values (?,?,?,?,?,?)");
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            statement.setString(4, user.getFullname());
            statement.setLong(5, user.getClassNumber());
            statement.setString(6, user.getEmail());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void editAccount(User user) {
        connection = SetConnection.createConnection();
        try {
            PreparedStatement statement = connection
                    .prepareStatement("update users set username=?, password=?" + " where id=?");
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteAccount(int id) {
        connection = SetConnection.createConnection();
        try {
            PreparedStatement statement = connection
                    .prepareStatement("delete from users where id=?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<User> listUsers() {
        connection = SetConnection.createConnection();
        List<User> userList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users");
            while (resultSet.next()) {
                User user = userRowMapper.mapRow(resultSet);
                userList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }


    public User getUserByID(int id) {
        connection = SetConnection.createConnection();
        User user = new User();
        try {
            PreparedStatement statement = connection
                    .prepareStatement("select * from users where id= ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = userRowMapper.mapRow(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public User findByUsername(String username) {
        connection = SetConnection.createConnection();
        User user = null;
        try {
            PreparedStatement statement = connection
                    .prepareStatement("select * from users WHERE username = ?");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = userRowMapper.mapRow(resultSet);
            }
            statement.close();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return user;
    }

    public User findbyID(int id) {
        connection = SetConnection.createConnection();
        User user = null;
        try {
            PreparedStatement statement = connection
                    .prepareStatement("select * from users where id =?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = userRowMapper.mapRow(resultSet);
            }
            statement.close();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return user;
    }

    public boolean uploadPhoto(String photo, User user) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("UPDATE users SET photo = ? where id = ?");
        statement.setString(1, photo);
        statement.setInt(2, user.getId());
        return statement.execute();
    }
}

