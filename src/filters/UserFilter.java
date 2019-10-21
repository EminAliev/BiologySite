package filters;

import helpers.CookieHelps;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "UserFilter")
public class UserFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        if (CookieHelps.addCookie(request) != null) {
            ((HttpServletRequest) request).getSession().setAttribute("curr_user", CookieHelps.addCookie(request));
        }
        if (((HttpServletRequest) request).getSession().getAttribute("curr_user") != null) {

            chain.doFilter(request, response);

            return;

        } else {
            ((HttpServletResponse) response).sendRedirect("/login"); //еще не знаю login ли
            return;

        }
    }


    public void init(FilterConfig config) throws ServletException {

    }

}
