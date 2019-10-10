package servlets;

import models.User;
import services.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {

    private LoginService service = new LoginService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String fullname = request.getParameter("fullname");
        Integer classNumber = Integer.parseInt(request.getParameter("classNumber"));
        String email = request.getParameter("email");
        String id = request.getParameter("id");

        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setFullname(fullname);
        user.setEmail(email);
        user.setClassNumber(classNumber);

        if (id == null || id.isEmpty()) {
            service.createUser(user);
            /* Переходим на страницу с темами*/
        } else {
            user.setId(Integer.parseInt(id));
            service.editAccount(user);
            request.setAttribute("users", service.listUsers());
            //обновляем профиль
        }

    }
}
