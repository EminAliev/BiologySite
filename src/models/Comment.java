package models;

public class Comment {
    private User username;

    private Integer postId;
    private Theme theme;
    private Integer idComment;
    private Integer idUser;
    private String text;
    private String date;


    public Comment(Integer idComment, Integer idUser, String text, String date) {
        this.idComment = idComment;
        this.idUser = idUser;
        this.text = text;
        this.date = date;
    }

    public Comment(User username, Integer postId, Theme theme, Integer idComment, Integer idUser, String text, String date) {
        this.username = username;
        this.postId = postId;
        this.theme = theme;
        this.idComment = idComment;
        this.idUser = idUser;
        this.text = text;
        this.date = date;
    }

    public Integer getIdComment() {
        return idComment;
    }

    public void setIdComment(Integer idComment) {
        this.idComment = idComment;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }
}