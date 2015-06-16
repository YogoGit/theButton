package services;

import static org.fest.assertions.Assertions.assertThat;

import configs.AppConfig;
import configs.TestDataConfig;

import model.User;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import services.UserService;


@ContextConfiguration(classes={AppConfig.class, TestDataConfig.class})
public class UserServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private UserService userService;

    @Test(expected = java.lang.NoClassDefFoundError.class)
    public void addUsernameTest() {
        User user0 = new User();
        User user1 = new User();
        User user2 = new User();

        user0.setUsername("user0");
        userService.addUser(user0);
        assertThat(userService.userExists(user0.getUsername())).isEqualTo(true);

        //a username > 20 chars should not be added to the database
        user1.setUsername("user1WhichIsLongerThan20Characters");
        userService.addUser(user1);
        assertThat(userService.userExists(user1.getUsername())).isEqualTo(false);

        //a username < 3 chars should not be added to the database
        user2.setUsername("u2");
        userService.addUser(user2);
        assertThat(userService.userExists(user2.getUsername())).isEqualTo(false);
    }

    @Test(expected = javax.persistence.EntityExistsException.class)
    public void uniqueUsernameTest() {
        User user0 = new User();
        User user1 = new User();

        user0.setUsername("user0");
        userService.addUser(user0);
        assertThat(userService.userExists(user0.getUsername())).isEqualTo(true);

        user1.setUsername("user0");
        userService.addUser(user0);
        assertThat(userService.userExists(user0.getUsername())).isEqualTo(false);

        user1.setUsername("user1");
        userService.addUser(user1);
        assertThat(userService.userExists(user1.getUsername())).isEqualTo(true);
    }

    @Test(expected = javax.persistence.EntityExistsException.class)
    public void getUserData() {
        User user0 = new User();
        user0.setUsername("user0");
        userService.addUser(user0);

        User user1 = new User();
        user1.setUsername("user0");
        userService.addUser(user1);

        assertThat(userService.getUserData(user0.getUsername())).isNotNull();
        assertThat(userService.getUserData(user1.getUsername())).isNull();
        assertThat(userService.getUserData("BobMarley")).isNull();
    }
}