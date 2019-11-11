package DAO;

import helpers.RowMapper;
import helpers.SetConnection;
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
        Integer idComment = row.getObject("id", Integer.class);
        Integer idUser = row.getObject("iduser", Integer.class);
        String text = row.getString("text");
        String date = row.getString("date");
        return new Comment(idComment, idUser, text, date);
    };

    public List<Comment> getComments() {
        connection = SetConnection.createConnection();
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
        connection = SetConnection.createConnection();
        if (comment != null) {
            try {
                PreparedStatement statement = connection
                        .prepareStatement("INSERT INTO comments(idUser ,text,date) VALUES (?,?,?)");
                statement.setInt(1, comment.getIdUser());
                statement.setString(2, comment.getText());
                statement.setTimestamp(3, new Timestamp(new Date().getTime()));
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /*public Comment newComment(User username, Theme theme, String date, String text) throws SQLException {
        connection = SetConnection.createConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO comments (iduser, id, text, date) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, username.getId());
        statement.setInt(2, theme.getId());
        statement.setString(3, date);
        statement.setString(4, text);
        statement.executeUpdate();
        ResultSet keys = statement.getGeneratedKeys();
        if (keys.next()) {
            Comment comment = commentRowMapper.mapRow(keys);
            return comment;
        }
        return null;
    }*/

    public boolean deleteComment(int id) throws SQLException {
        connection = SetConnection.createConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM comments WHERE id = ?");
        statement.setInt(1, id);
        return statement.execute();
    }

}
