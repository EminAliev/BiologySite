package servlets;


import services.TestService;
import utils.HelperConfiq;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "TestServlet")
public class TestServlet extends HttpServlet {
    private TestService service = new TestService();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] checked = request.getParameterValues("option");
        HttpSession session = request.getSession(false);
        int count = 0;

        for (int i = 0; i < checked.length; i++) {
            if (checked[i].equals("a1")) {
                count++;
            }
            if (checked[i].equals("a2")) {
                count++;
            }
            if (checked[i].equals("a3")) {
                count++;
            }
            if (checked[i].equals("a4")) {
                count++;
            }
        }
        response.sendRedirect("/result");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Object> root = new HashMap<>();
        root.put("url", request.getContextPath());

        if (request.getParameter("testId") != null) {
            root.put("questions", service.getTestsByThemeId(Long.parseLong(request.getParameter("testId"))));
        }

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HelperConfiq.render(request, response, "tests.ftl", root);
    }
}

