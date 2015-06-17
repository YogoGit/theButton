package services;

import static org.fest.assertions.Assertions.assertThat;

import configs.AppConfig;
import configs.TestDataConfig;

import model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration(classes = {
    AppConfig.class, TestDataConfig.class
})
public class UserServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private UserService userService;

    @Test
    public void addValidUsername() {
        User user = new User();
        user.setUsername("user0");
        userService.addUser(user);
        assertThat(userService.userExists(user.getUsername())).isEqualTo(true);
    }

    @Test(expected = javax.validation.ConstraintViolationException.class)
    public void addUsernameLong() {
        User user = new User();
        user.setUsername("user1WhichIsLongerThan20Characters");
        userService.addUser(user);
        assertThat(userService.userExists(user.getUsername())).isEqualTo(false);
    }

    @Test(expected = javax.validation.ConstraintViolationException.class)
    public void addUsernameShort() {
        User user = new User();
        user.setUsername("u2");
        userService.addUser(user);
        assertThat(userService.userExists(user.getUsername())).isEqualTo(false);
    }

    @Test
    public void userDoesNotExist() {
        assertThat(userService.userExists("user")).isEqualTo(false);
    }

    @Test
    public void addingMultipleUsers() {
        User user0 = new User();
        User user1 = new User();

        user0.setUsername("user0");
        userService.addUser(user0);
        assertThat(userService.userExists(user0.getUsername())).isEqualTo(true);

        user1.setUsername("user1");
        userService.addUser(user1);
        assertThat(userService.userExists(user1.getUsername())).isEqualTo(true);
    }

    @Test
    public void UserDataNotExist() {
        assertThat(userService.getUserData("BobMarley")).isNull();
    }

    @Test
    public void notInitializedUser() {
        User user = new User();
        assertThat(userService.addUser(user)).isEqualTo(false);
    }
}
