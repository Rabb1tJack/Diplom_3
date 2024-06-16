package Models;

public class UserData {
    public static final String EMAIL = "mailskjuhyfjh@fort.est";
    public static final String PASSWORD = "pashstest";
    public static final String SHORT_PASSWORD = "pashs";
    public static final String NAME = "Василий";
    private String email;
    private String password;
    private String name;

    public UserData() {
    }

    public UserData(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserData(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
