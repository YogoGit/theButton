package services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import configs.AppConfig;
import configs.TestDataConfig;

import model.User;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import javax.inject.Inject;

@ContextConfiguration(classes = {
    AppConfig.class, TestDataConfig.class
})
public class UserServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Inject
    private UserService userService;

    @Test
    public void addValidUsername() {
        User user = new User();
        user.setUsername("user0");
        userService.addUser(user);
        assertTrue(userService.userExists(user.getUsername()));
    }

    // the database does not allow data that is longer than 20 characters to be added
    @Test(expected = javax.validation.ConstraintViolationException.class)
    public void addUsernameLong() {
        User user = new User();
        user.setUsername("user1WhichIsLongerThan20Characters");
        assertTrue(user.getUsername().length() > 20);
        userService.addUser(user);
        assertFalse(userService.userExists(user.getUsername()));
    }

    // the database does not allow data that is shorter than 3 characters to be added
    @Test(expected = javax.validation.ConstraintViolationException.class)
    public void addUsernameShort() {
        User user = new User();
        user.setUsername("u2");
        assertTrue(user.getUsername().length() < 3);
        userService.addUser(user);
        assertFalse(userService.userExists(user.getUsername()));
    }

    @Test
    public void addNullUser() {
        assertFalse(userService.addUser(null));
    }

    @Test
    public void notInitializedUser() {
        User user = new User();
        assertFalse(userService.addUser(user));
    }

    @Test
    public void nullUserExists() {
        assertFalse(userService.userExists(null));
    }

    @Test
    public void userDoesNotExist() {
        assertFalse(userService.userExists("user"));
    }

    @Test
    public void addingMultipleUsers() {
        User user0 = new User();
        user0.setUsername("user0");
        userService.addUser(user0);
        assertTrue(userService.userExists(user0.getUsername()));

        User user1 = new User();
        user1.setUsername("user1");
        userService.addUser(user1);
        assertTrue(userService.userExists(user1.getUsername()));
    }

    @Test
    public void userDataNotExist() {
        assertNull(userService.getUserData("BobMarley"));
    }

    @Test
    public void nullUserDatat() {
        assertNull(userService.getUserData(null));
    }

    @Test
    public void userDataExists() {
        User user = new User();
        user.setUsername("user0");
        userService.addUser(user);
        assertNotNull(userService.getUserData(user.getUsername()));
    }
}
