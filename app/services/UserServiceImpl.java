package services;

import models.UserInfo;

import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

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
    public boolean userExists(String username) {
        UserInfo ui = getUserData(username);
        return (ui != null);
    }

    @Override
    public UserInfo getUserData(String username) {
        List<UserInfo> ui = em.createQuery("SELECT a FROM UserInfo a WHERE a.username = :username", UserInfo.class)
                              .setParameter("username", username)
                              .getResultList();
        if (ui.size() > 0) {
            return ui.get(0);
        }
        log.info("Trying to getUserInfo for a {} that doesn't exist ", username);
        return null;

    }
}
