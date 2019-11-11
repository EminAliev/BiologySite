package models;

public class Theme {
    private Integer id;
    private String nameTheme;
    private String textTheme;

    public Theme() {
    }

    public Theme(String nameTheme) {
        this.nameTheme = nameTheme;
    }

    public Theme(Integer id, String nameTheme, String textTheme) {
        this.id = id;
        this.nameTheme = nameTheme;
        this.textTheme = textTheme;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameTheme() {
        return nameTheme;
    }

    public void setNameTheme(String nameTheme) {
        this.nameTheme = nameTheme;
    }

    public String getTextTheme() {
        return textTheme;
    }

    public void setTextTheme(String textTheme) {
        this.textTheme = textTheme;
    }
}
