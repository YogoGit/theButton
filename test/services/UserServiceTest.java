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

    // the database does not allow data that is longer than 20 characters to be added
    @Test(expected = javax.validation.ConstraintViolationException.class)
    public void addUsernameLong() {
        User user = new User();
        user.setUsername("user1WhichIsLongerThan20Characters");
        assertThat(user.getUsername().length()).isGreaterThan(20);
        userService.addUser(user);
        assertThat(userService.userExists(user.getUsername())).isEqualTo(false);
    }

    // the database does not allow data that is shorter than 3 characters to be added
    @Test(expected = javax.validation.ConstraintViolationException.class)
    public void addUsernameShort() {
        User user = new User();
        user.setUsername("u2");
        assertThat(user.getUsername().length()).isLessThan(3);
        userService.addUser(user);
        assertThat(userService.userExists(user.getUsername())).isEqualTo(false);
    }

    @Test
    public void addNullUser() {
        assertThat(userService.addUser(null)).isEqualTo(false);
    }

    @Test
    public void notInitializedUser() {
        User user = new User();
        assertThat(userService.addUser(user)).isEqualTo(false);
    }

    @Test
    public void nullUserExists() {
        assertThat(userService.userExists(null)).isEqualTo(false);
    }

    @Test
    public void userDoesNotExist() {
        assertThat(userService.userExists("user")).isEqualTo(false);
    }

    @Test
    public void addingMultipleUsers() {
        User user0 = new User();
        user0.setUsername("user0");
        userService.addUser(user0);
        assertThat(userService.userExists(user0.getUsername())).isEqualTo(true);

        User user1 = new User();
        user1.setUsername("user1");
        userService.addUser(user1);
        assertThat(userService.userExists(user1.getUsername())).isEqualTo(true);
    }

    @Test
    public void userDataNotExist() {
        assertThat(userService.getUserData("BobMarley")).isNull();
    }

    @Test
    public void nullUserDatat() {
        assertThat(userService.getUserData(null)).isNull();
    }

    @Test
    public void userDataExists() {
        User user = new User();
        user.setUsername("user0");
        userService.addUser(user);
        assertThat(userService.getUserData(user.getUsername())).isNotNull();
    }
}
