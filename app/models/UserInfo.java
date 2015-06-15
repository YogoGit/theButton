package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class UserInfo {

    @Id
    @Column(name="username")
    private String username;

    @Column(name="time_pressed")
    private Integer timePressed;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getTimePressed() {
        return timePressed;
    }

    public void setTimePressed(Integer timePressed) {
        this.timePressed = timePressed;
    }
}