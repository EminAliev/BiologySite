package servlets;

import models.User;
import services.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {

    private LoginService service = new LoginService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        PrintWriter pw = response.getWriter();


        if (service.validateLogin(email, password)) {
            User user = service.userSession(email);
            HttpSession session = request.getSession(true);
            session.setAttribute("username", user.getUsername());
            session.setAttribute("email", email);
            Cookie nameCookie = new Cookie("email", email);
            Cookie passwordCookie = new Cookie("password", password);
            response.addCookie(nameCookie);
            response.addCookie(passwordCookie);
            //переходим в страницу с темами/тестами;
        }
        else {
            pw.println("Incorrect");
            //доделать
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
