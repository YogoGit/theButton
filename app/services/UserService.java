package services;

import models.UserInfo;

import model.User;

public interface UserService {
    boolean addUser(User task);

    boolean userExists(String username);

    UserInfo getUserData(String username);
}
