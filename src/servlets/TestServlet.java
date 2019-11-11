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

@WebServlet(name = "TestServlet")
public class TestServlet extends HttpServlet {
    private TestService service = new TestService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Object> root = new HashMap<>();
        List<Test> testList = service.listTest();
        root.put("tests", testList);
        root.put("url", request.getContextPath());

        if (request.getParameter("testId") != null) {
            root.put("test", testList.get(Integer.parseInt(request.getParameter("testId")) - 1));
        }

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HelperConfiq.render(request, response, "test.ftl", root);
    }
}

