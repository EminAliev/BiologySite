package servlets;

import models.User;
import services.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {

    private LoginService service = new LoginService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        String username = request.getParameter("username").toLowerCase();
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String fullname = request.getParameter("fullname");
        Integer classNumber = Integer.parseInt(request.getParameter("classNumber"));
        String email = request.getParameter("email");

        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setFullname(fullname);
        user.setEmail(email);
        user.setClassNumber(classNumber);


        service.createUserValidate(username, password, name, fullname, email, classNumber);
        if (service.getErrorMessage() == null) {
            Cookie cookie = new Cookie("language", "russian");
            cookie.setMaxAge(30 * 24 * 60 * 60 * 364);
            response.addCookie(cookie);
            response.sendRedirect("/login");
        } else {
            response.sendRedirect("/registration?error=" + service.getErrorMessage().getError_message());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // обработка (шаблон)

    }
}
