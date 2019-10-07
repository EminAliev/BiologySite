package services;

import DAO.UserDAO;
import models.User;

import java.util.List;

public class LoginService {
    private UserDAO userDAO;

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
}
