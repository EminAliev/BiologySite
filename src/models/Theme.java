package models;

public class Theme {
    private String id;
    private String nameTheme;
    private String textTheme;

    public Theme(String id, String nameTheme, String textTheme) {
        this.id = id;
        this.nameTheme = nameTheme;
        this.textTheme = textTheme;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
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
