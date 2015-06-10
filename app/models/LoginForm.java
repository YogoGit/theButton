package models;

import play.data.validation.Constraints.Required;

public class LoginForm {
    @Required(message="email.required")
    private String email;

    @Required(message="password")
    private String password;

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
}