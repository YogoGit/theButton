package services;

import model.User;

public interface UserService {

    void addUser(User task);
    boolean checkUsername(String username);
    boolean checkEmail(String email);

}