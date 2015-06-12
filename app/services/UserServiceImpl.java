package services;

import model.User;

import models.UserInfo;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class UserServiceImpl implements UserService {

    // this is an interface used to interact with the persistence context
    @PersistenceContext
    private EntityManager em;

    @Override
    public void addUser(User user) {
        UserInfo newUser = new UserInfo();
        newUser.setUsername(user.getUsername());
        newUser.setEmail(user.getUsername());
        em.persist(newUser);
        return;
    }

    @Override
    public boolean checkUsernameExists(String username) {
        UserInfo ui = em.createQuery("SELECT a FROM UserInfo a WHERE a.user_name = :username", UserInfo.class)
                         .setParameter("username", username)
                         .getSingleResult();
        return (ui != null);
    }

    @Override
    public boolean checkEmailExists(String email){
        return false;
    }

}
