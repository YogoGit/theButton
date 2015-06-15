package model;

import play.data.validation.Constraints.Required;
import play.data.validation.Constraints.MaxLength;

public class LoginInfo {
    @Required(message="Username is required to login")
    @MaxLength(value = 255)
    private String username;

    @Required(message="Email is required to login")
    @MaxLength(value = 255)
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String input) {
        this.username = input;
    }
}