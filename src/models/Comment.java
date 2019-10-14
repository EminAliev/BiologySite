package models;

public class Comment {
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
}