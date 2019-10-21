package services;

import DAO.ThemeDAO;
import models.Theme;

import java.util.List;

public class ThemeService {
    private ThemeDAO themeDAO;

    public ThemeService() {
        themeDAO = ThemeDAO.getThemeDAO();
    }

    public List<Theme> listThemes() {
        return themeDAO.listThemes();
    }

    public List<Theme> findTheme(String nameTheme) {
        return themeDAO.findTheme(nameTheme);
    }

    public Theme getThemebyID(int id) {
        return themeDAO.getThemebyID(id);
    }

}
