package controllers;

import services.UserService;
import views.html.createAccount;

import model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

@org.springframework.stereotype.Controller
public class CreateAccount extends Controller {

    private static final Logger log = LoggerFactory.getLogger(CreateAccount.class);

    @Autowired
    private UserService userService;

    public Result add() {
        return ok(createAccount.render(Form.form(User.class)));
    }

    public Result addUser() {
        log.info("trying to add a new user");

        Form<User> form = Form.form(User.class).bindFromRequest();
        if (form.hasErrors()) {
            log.info("form has errors");

            return badRequest(createAccount.render(form));
        }
        User user = form.get();
        if (!userService.checkUsernameExists(user.getUsername())) {
//          if (true){
            log.info("username {} does not exist, adding {}", user.getUsername(), user.getUsername());
            session("username", user.getUsername());
            userService.addUser(user);
            return redirect(controllers.routes.Login.login());
        }
        //should display an error message that that account already exists
        log.info("username '{}' already exists, can't create account", user.getUsername());
        form.reject("username","please enter a unique username");
        log.info("This is skipping form.reject for some reason");
        return badRequest(createAccount.render(form));
    }

}
