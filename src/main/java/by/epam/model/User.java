package by.epam.model;

public class User {

    private String email;

    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(final String email, final String password) {
        this.email = email;
        this.password = password;
    }
}
