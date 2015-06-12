package services;

import model.User;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class UserServiceImpl implements UserService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addUser(User task) {
        return;
    }

    @Override
    public boolean checkUsername(String username) {
        return false;
    }

    @Override
    public boolean checkEmail(String email){
        return false;
    }

}
