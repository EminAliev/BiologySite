package servlets;

import models.Comment;
import models.User;
import services.CommentService;
import services.LoginService;
import utils.HelperConfiq;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CommentServlet")
public class CommentServlet extends HttpServlet {
    private LoginService loginService = new LoginService();
    private CommentService commentService = new CommentService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");

        User user = (User) request.getSession().getAttribute("curr_user");

        user = loginService.findbyID(user.getId());
        int idUser = user.getId();
        request.getSession().setAttribute("curr_user", user);

        String text = request.getParameter("text");
        java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
        String commentDate = date.toString();
        Comment comment = new Comment(idUser, text, commentDate);
        commentService.addComment(comment);
        response.sendRedirect("/comments");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        Map<String, Object> root = new HashMap<>();
        List<Comment> comments = commentService.getComments();
        List<User> userList = loginService.listUsers();
        root.put("comments", comments);
        root.put("users", userList);

        HelperConfiq.render(request, response, "comments.ftl", root);
    }
}
