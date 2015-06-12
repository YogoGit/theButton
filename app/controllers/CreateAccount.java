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
        // I don't know what this is
        log.info("something");

        Form<User> form = Form.form(User.class).bindFromRequest();
        if (form.hasErrors()) {
            log.info("form has errors");

            return badRequest(createAccount.render(form));
        }
        User user = form.get();
        if (!userService.checkUsernameExists(user.getUsername())) {
//          if (true){
            log.info("username {} does not exist, adding {}", user.getUsername(), user.getUsername());
            userService.addUser(user);
            return redirect(controllers.routes.Login.login());
        }
        log.info("username {} does exist, can't create account", user.getUsername());
        return badRequest(createAccount.render(form));
    }

}
