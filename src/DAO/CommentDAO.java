package DAO;

import models.Comment;
import models.User;
import services.LoginService;

import java.sql.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class CommentDAO {
    private static CommentDAO commentDAO;
    private Connection connection;

    public static CommentDAO getCommentDAODataBase() {
        if (commentDAO == null) {
            commentDAO = new CommentDAO();
        }
        return commentDAO;
    }

    public CommentDAO() {
        connection = SetConnection.createConnection();
    }


    private RowMapper<Comment> commentRowMapper = row -> {
        Integer idComment = row.getObject("idComment", Integer.class);
        Integer idUser = row.getObject("idUser", Integer.class);
        String text = row.getString("text");
        String date = row.getString("date");
        return new Comment(idComment, idUser, text, date);
    };

    public List<Comment> getComments() {
        List<Comment> comments = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from comments");
            while (resultSet.next()) {
                LoginService service = new LoginService();
                User user = service.findbyID(resultSet.getInt("idUser"));
                comments.add(new Comment(resultSet.getInt("idComment"), user.getId(), resultSet.getString("text"), resultSet.getString("date")));
            }
            return comments;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addComment(Comment comment) {
        if (comment != null) {
            try {
                PreparedStatement statement = connection
                        .prepareStatement("INSERT INTO comments(idComment, idUser ,text,date) VALUES (?,?,?,?)");
                statement.setInt(1, comment.getIdUser());
                statement.setInt(2, comment.getIdComment());
                statement.setString(3, comment.getText());
                statement.setTimestamp(4, new Timestamp(new Date().getTime()));
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}