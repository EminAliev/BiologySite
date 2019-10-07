package servlets;

import models.User;
import services.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
            HttpSession session = request.getSession();
            session.setAttribute("username", user.getUsername());
            session.setAttribute("email", email);
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
