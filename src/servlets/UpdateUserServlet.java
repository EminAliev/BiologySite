package servlets;

import helpers.HashPassword;
import models.User;
import services.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {

    private LoginService service = new LoginService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("curr_user");
        if (!request.getParameter("username").equals("")) {
            user.setUsername(request.getParameter("username"));
        }
        if (!request.getParameter("password").equals("")) {
            user.setPassword(HashPassword.md5(request.getParameter("password")));
        }
        if (!request.getParameter("name").equals("")) {
            user.setName(request.getParameter("name"));
        }
        if (!request.getParameter("fullname").equals("")) {
            user.setFullname(request.getParameter("fullname"));
        }
        if (!request.getParameter("email").equals("")) {
            user.setEmail(request.getParameter("email"));
        }
        if (!request.getParameter("classnumber").equals("")) {
            user.setClassNumber(Integer.parseInt(request.getParameter("classnumber")));
        }

        service.editAccount(user);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("curr_user");
        request.setAttribute("curr_user", user);
        //обработка (шаблон)
    }
}
