package models;

public class User {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String fullname;
    private Integer classNumber;
    private String email;

    public User() {
    }

    public User(Integer id, String login, String password, String name, String fullname, Integer classNumber, String email) {
        this.id = id;
        this.username = login;
        this.password = password;
        this.name = name;
        this.fullname = fullname;
        this.classNumber = classNumber;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String login) {
        this.username = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Integer getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(Integer classNumber) {
        this.classNumber = classNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
