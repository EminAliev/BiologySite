package servlets;

import services.TokenService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LogoutServlet")
public class LogoutServlet extends HttpServlet {

    private TokenService service = new TokenService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();

        for (Cookie cookie : cookies
        ) {
            if (cookie.getName().equals("curr_user")) {
                String token = cookie.getValue();
                cookie.setValue("");
                cookie.setMaxAge(0);
                if (service.findToken(token) != null) {
                    service.delete(token);
                }
                response.addCookie(cookie);
            }
        }
        request.getSession().invalidate();
        response.sendRedirect("/login");

    }
}
