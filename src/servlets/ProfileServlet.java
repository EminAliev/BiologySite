package servlets;

import models.User;
import services.LoginService;
import utils.HelperConfiq;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ProfileServlet")
public class ProfileServlet extends HttpServlet {
    private LoginService service = new LoginService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("curr_user");
        user = service.findbyUsername(user.getUsername());
        request.getSession().setAttribute("curr_user", user);


        Map<String, Object> root = new HashMap<>();

        root.put("username", user.getUsername());
        root.put("name", user.getName());
        root.put("fullname", user.getFullname());
        root.put("email", user.getEmail());
        root.put("classnumber", user.getClassNumber());

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HelperConfiq.render(request, response, "profile.ftl", (HashMap) root);

    }
}
