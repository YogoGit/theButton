package services;

import model.User;

import models.UserInfo;

import java.util.List;

public interface UserService {

    void addUser(User task);
    boolean userExists(String username);
    UserInfo getUserData(String username);

}