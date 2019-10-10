package filters;

import utils.ValidationUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "ProfileFilter")
public class ProfileFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();

        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");


        if (name == null || !ValidationUtil.validateString(name)) {
            pw.print("<font size='3' color='red'>Invalid first name input </font>");
            req.getRequestDispatcher("personalDetail.html").include(request, response);

        } else if (fullname == null && !ValidationUtil.validateString(fullname)) {
            pw.print("<font size='3' color='red'>Invalid father name input </font>");
            req.getRequestDispatcher("personalDetail.html").include(request, response);

        } else if (email == null || !ValidationUtil.validateEmail(email)) {
            pw.print("<font size='3' color='red'>Invalid email input </font>");
            req.getRequestDispatcher("personalDetail.html").include(request, response);

        } else if (username == null && !ValidationUtil.validateString(username)) {
            pw.print("<font size='3' color='red'>Invalid father name input </font>");
            req.getRequestDispatcher("personalDetail.html").include(request, response);
        } else if (password == null && !ValidationUtil.validatePassword(password)) {
            pw.print("<font size='3' color='red'>Invalid father name input </font>");
            req.getRequestDispatcher("personalDetail.html").include(request, response);
        } else {
            chain.doFilter(request, response);
        }

    }


    public void init(FilterConfig config) throws ServletException {

    }

}
