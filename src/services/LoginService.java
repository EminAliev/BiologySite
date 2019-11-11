package services;

import DAO.UserDAO;
import helpers.Errors;
import helpers.HashPassword;
import models.User;
import utils.ValidationUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class LoginService {
    private UserDAO userDAO;
    private Errors error;

    public LoginService() {
        userDAO = UserDAO.getUserDAODataBase();
    }

    public boolean validateLogin(String email, String password) {
        return userDAO.validateLogin(email, password);
    }

    public User userSession(String email) {
        return userDAO.userSession(email);
    }

    public List<User> listUsers() {
        return userDAO.listUsers();
    }

    public User getUserByID(int id) {
        return userDAO.getUserByID(id);
    }

    public void createUser(User user) {
        userDAO.createUser(user);
    }

    public void editAccount(User user) {
        userDAO.editAccount(user);
    }

    public void deleteAccount(int id) {
        userDAO.deleteAccount(id);
    }

    public User findbyUsername(String username) {
        return userDAO.findByUsername(username);
    }

    public User findbyID(int id) {
        return userDAO.findbyID(id);
    }


    public void createUserValidate(String username, String password, String name, String fullname, int classnumber, String email) {
        error = null;
        if (ValidationUtil.validateUsernamePassword(username) && ValidationUtil.validateUsernamePassword(password)) {
            password = HashPassword.md5(password);
            User user = new User(username, password, name, fullname, classnumber, email);
            if (userDAO.findByUsername(username) == null) {
                userDAO.createUser(user);
            } else {
                error = new Errors("userRegistered", "the user is already registered");
            }
        } else {
            error = new Errors("incorrectData", "enter the correct data");
        }
    }

    public boolean uploadPicture(InputStream is, User user) throws IOException {
        String root = "/Users/aliev/BiologySite/";
        String pathname = "/images/" + new Date() + ".jpg";
        File file = new File(root + pathname);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream out = new FileOutputStream(file, false);

        byte[] bytes = new byte[512];

        int c = is.read(bytes);
        while (c != -1) {
            out.write(bytes);
            c = is.read(bytes);
        }
        is.close();
        out.close();

        try {
            return userDAO.uploadPhoto(pathname, user);
        } catch (SQLException e) {
            return false;
        }
    }


    public Errors getErrorMessage() {
        return error;
    }


}
