package services;

import DAO.UserDAO;
import helpers.Errors;
import helpers.HashPassword;
import models.User;
import utils.ValidationUtil;

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


    public void createUserValidate(String username, String password, String name, String fullname, String email, int classnumber) {
        error = null;
        if (ValidationUtil.validateString(username) && ValidationUtil.validatePassword(password)) {
            password = HashPassword.md5(password);
            User user = new User(username, password, name, fullname, classnumber, email);
            if (userDAO.findByUsername(username) == null) {
                userDAO.createUser(user);
            } else {
                error = new Errors("userRegistered", "the user is already registered");
            }
        } else if (!ValidationUtil.validatePassword(password)) {
            error = new Errors("wrongPassword", "Wrong password, check the correctness");
        } else if (!ValidationUtil.validateString(username)) {
            error = new Errors("wrongUsername", "wrong username,check the correctness");
        } else {
            error = new Errors("wrongWords", "wrong words, check the correctness");
        }
    }


    public Errors getErrorMessage() {
        return error;
    }
}
