package servlets;

import helpers.HashPassword;
import models.User;
import services.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {

    private LoginService service = new LoginService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username").toLowerCase();
        String password = request.getParameter("password");


        //обраотка нажатия кнопки "запомнить меня"
        User user = service.findbyUsername(username);

        if (user != null) {
            if (HashPassword.md5(password).equals(user.getPassword())) {
                request.getSession().setAttribute("user", user);
                //нужна обраотка "запомнить меня"

                response.sendRedirect("/home");

            } else {
                response.sendRedirect("/login?error=wrong_password&username=" + username);
            }
        } else {
            response.sendRedirect("/login?error=" + service.getErrorMessage().getError_message());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //обработка (шаблон)
    }
}
