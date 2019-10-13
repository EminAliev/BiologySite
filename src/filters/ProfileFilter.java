package filters;

import utils.ValidationUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "ProfileFilter")
public class ProfileFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpServletResponse httpRes = (HttpServletResponse) response;

        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");


        if (name == null || !ValidationUtil.validateString(name)) {
            //httpReq.getRequestDispatcher("").include(request, response);
            //снова на форму

        } else if (fullname == null && !ValidationUtil.validateString(fullname)) {
            //httpReq.getRequestDispatcher("").include(request, response);
            //снова на форму

        } else if (email == null || !ValidationUtil.validateEmail(email)) {
            //httpReq.getRequestDispatcher("").include(request, response);
            //снова на форму

        } else if (username == null && !ValidationUtil.validateString(username)) {
            //httpReq.getRequestDispatcher("").include(request, response);
            //снова на форму
        } else if (password == null && !ValidationUtil.validatePassword(password)) {
            //httpReq.getRequestDispatcher("").include(request, response);
            //снова на форму
        } else {
            chain.doFilter(request, response);
        }

    }


    public void init(FilterConfig config) throws ServletException {

    }

}
