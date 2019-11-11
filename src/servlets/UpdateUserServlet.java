package servlets;

import helpers.HashPassword;
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

@WebServlet(name = "UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {

    private LoginService service = new LoginService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("curr_user");
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username").toLowerCase();
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String fullname = request.getParameter("fullaname");
        int classNumber = Integer.parseInt(request.getParameter("classnumber"));
        String email = request.getParameter("email");

        user.setId(id);

        user.setUsername(username);

        user.setPassword(HashPassword.md5(password));

        user.setName(name);

        user.setFullname(fullname);


        user.setEmail(email);

        user.setClassNumber(classNumber);


        service.editAccount(user);
        response.sendRedirect("/profile");

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("curr_user");
        Map<String, Object> root = new HashMap<>();
        root.put("id", user.getId());
        root.put("username", user.getName());
        root.put("password", user.getPassword());
        root.put("name", user.getName());
        root.put("fullname", user.getFullname());
        root.put("classnumber", user.getClassNumber());
        root.put("email", user.getEmail());


        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HelperConfiq.render(request, response, "update.ftl", (HashMap) root);
    }
}
