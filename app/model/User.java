package model;

import play.data.validation.Constraints.Required;
import play.data.validation.Constraints.MaxLength;

public class User {

    @Required(message="Username is need to create a new account")
    @MaxLength(value = 255)
    private String username;

    @Required(message="Email is Required")
    @MaxLength(value = 255)
    private String email;


    public String getUsername() {
        return username;
    }

    public void setUsername(String user) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}