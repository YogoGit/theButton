package services;

import models.UserInfo;

import model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class UserServiceImpl implements UserService {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void addUser(User user) {
        UserInfo newUser = new UserInfo();
        newUser.setUsername(user.getUsername());
        em.persist(newUser);
    }

    @Override
    public boolean checkUsernameExists(String username) {
        List<UserInfo> ui = em.createQuery("SELECT a FROM UserInfo a WHERE a.username = :username", UserInfo.class)
                              .setParameter("username", username)
                              .getResultList();
        return (ui.size() > 0);
    }
}
