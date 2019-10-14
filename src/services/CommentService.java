package services;

import DAO.CommentDAO;
import helpers.Errors;
import models.Comment;

import java.util.List;

public class CommentService {
    private CommentDAO commentDAO;
    private Errors error;

    public CommentService() {
        commentDAO = CommentDAO.getCommentDAODataBase();
    }

    public List<Comment> getComments() {
        error = null;
        if (commentDAO.getComments() == null) {
            error = new Errors("commentNotFound", "Comment not found");
            return null;
        } else {
            return commentDAO.getComments();
        }
    }


    public void addComment(int idUser, int idComment, String text) {
        Comment comment = new Comment(idUser, idComment, text, "DATE");
        commentDAO.addComment(comment);
    }

}
