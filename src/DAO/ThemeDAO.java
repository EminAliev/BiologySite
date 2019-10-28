package DAO;

import helpers.RowMapper;
import helpers.SetConnection;
import models.Theme;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ThemeDAO {
    private static ThemeDAO themeDAO;
    private Connection connection;

    public static ThemeDAO getThemeDAO() {
        if (themeDAO == null) {
            themeDAO = new ThemeDAO();
        }
        return themeDAO;
    }

    public ThemeDAO() {
        connection = SetConnection.createConnection();
    }

    private RowMapper<Theme> themeRowMapper = row -> {
        Integer id = row.getObject("id", Integer.class);
        String nameTheme = row.getString("nametheme");
        String textTheme = row.getString("texttheme");
        return new Theme(id, nameTheme, textTheme);
    };

    public List<Theme> listThemes() {
        List<Theme> themeList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from themes");
            while (resultSet.next()) {
                Theme theme = themeRowMapper.mapRow(resultSet);
                themeList.add(theme);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return themeList;
    }

    public List<Theme> findTheme(String nameTheme) {
        List<Theme> foundsThemes = new ArrayList<>();
        try {
            PreparedStatement statement = connection
                    .prepareStatement("select * from themes where nametheme=?");
            statement.setString(1, nameTheme);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Theme theme = themeRowMapper.mapRow(resultSet);
                foundsThemes.add(theme);
            }
            return foundsThemes;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Theme getThemebyID(int id) {
        try {
            PreparedStatement statement = connection
                    .prepareStatement("select * from themes where id=?");
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                return null;
            } else {
                Theme theme = themeRowMapper.mapRow(resultSet);
                return theme;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

