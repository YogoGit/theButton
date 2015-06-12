package services;

import model.User;

public interface UserService {

    void addUser(User task);
    boolean checkUsernameExists(String username);
    boolean checkEmailExists(String email);

}