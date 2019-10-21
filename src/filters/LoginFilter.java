package filters;

import helpers.CookieHelps;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if (CookieHelps.addCookie(req) != null) {
            ((HttpServletRequest) req).getSession().setAttribute("curr_user", CookieHelps.addCookie(req));
        }

        if (((HttpServletRequest) req).getSession().getAttribute("curr_user") != null) {
            ((HttpServletResponse) resp).sendRedirect("/home");//еще не знаю home или что-то другое
        } else
            chain.doFilter(req, resp);
    }


    public void init(FilterConfig config) throws ServletException {

    }

}
