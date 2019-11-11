package servlets;

import models.Test;
import models.Theme;
import services.TestService;
import services.ThemeService;
import utils.HelperConfiq;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ThemeServlet")
public class ThemeServlet extends HttpServlet {
    private ThemeService service = new ThemeService();
    private TestService testService = new TestService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Object> root = new HashMap<>();
        List<Theme> themeList = service.listThemes();
        List<Test> testList = testService.listTest();
        root.put("themes", themeList);
        root.put("url", request.getContextPath());
        if (request.getParameter("themeId") != null) {
            root.put("theme", themeList.get(Integer.parseInt(request.getParameter("themeId")) - 1));
        }

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HelperConfiq.render(request, response, "theme.ftl", root);
    }
}




