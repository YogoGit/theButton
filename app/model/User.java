package model;

import play.data.validation.Constraints.Required;
import play.data.validation.Constraints.MaxLength;

public class User {

    @play.data.validation.Constraints.Required(message="Username is need to create a new account")
    @MaxLength(value = 255)
    private String user;

    @Required(message="Email is Required")
    @MaxLength(value = 255)
    private String email;


    public String getUsername() {
        return user;
    }

    public void setUsername(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}