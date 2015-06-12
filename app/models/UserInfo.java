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

    @Column(name="email")
    private String email;

    public String getUserName() {
        return username;
    }

    public String getEmail(){
        return email;
    }
}