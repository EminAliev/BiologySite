package models;

public class Comment {

    private int id;
    private int idUser;
    private String text;
    private String date;

    public Comment(int id, int idUser, String text, String date) {
        this.id = id;
        this.idUser = idUser;
        this.text = text;
        this.date = date;
    }

    public Comment(int idUser, String text, String date) {
        this.idUser = idUser;
        this.text = text;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
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