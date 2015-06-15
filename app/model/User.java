package model;

import play.data.validation.Constraints.Required;
import play.data.validation.Constraints.MaxLength;

public class User {

    @Required(message="Username is Required to create an account")
    @MaxLength(value = 255)
    private String username;

    @Required(message="Email is Required to create an account")
    @MaxLength(value = 255)
    private String email;

    private int timePressed;

    public int getTimePressed() {
        return timePressed;
    }

    public void setTimePressed(int timePressed) {
        this.timePressed = timePressed;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}