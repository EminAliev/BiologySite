package servlets;

import helpers.HashPassword;
import models.User;
import services.LoginService;
import services.TokenService;
import utils.HelperConfiq;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {

    private LoginService service = new LoginService();
    private TokenService tokenService = new TokenService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username").toLowerCase();
        String password = request.getParameter("password");
        String r = "";
        if (request.getParameter("switch") != null)
            r = "on";

        User user = service.findbyUsername(username);

        if (user != null) {
            if (HashPassword.md5(password).equals(user.getPassword())) {
                request.getSession().setAttribute("curr_user", user);
                if (r.equals("on")) {
                    String token = TokenService.getToken();
                    Cookie cookie = new Cookie("curr_user", token);
                    cookie.setMaxAge(30 * 24 * 60 * 60);
                    response.addCookie(cookie);
                    tokenService.add(user.getId(), token);
                }

                response.sendRedirect("/home");

            } else {
                response.sendRedirect("/login?error=wrong_password&username=" + username);
            }
        } else {
            response.sendRedirect("/login?error=" + service.getErrorMessage().getError_message());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Object> root = new HashMap<>();

        root.put("error", request.getParameter("error"));
        root.put("username", request.getParameter("username"));

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HelperConfiq.render(request, response, "login.ftl", (HashMap) root);

    }
}
