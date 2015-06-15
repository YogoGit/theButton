package controllers;

import model.User;
import model.LoginInfo;

import services.UserService;

import views.html.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

@org.springframework.stereotype.Controller
public class Login extends Controller {

    private static final Logger log = LoggerFactory.getLogger(Login.class);

    @Autowired
    private UserService userService;

    public Result login() {
        //session("connected", "user@gmail.com");
        log.info("someone entering the login page");
        session().clear();
        return ok(login.render("", Form.form(LoginInfo.class)));
    }

    public Result authenticate() {
        log.info("checking authorization");
        // I want to post this to the Auth controller
        Form<LoginInfo> form = Form.form(LoginInfo.class).bindFromRequest();
        if (form.hasErrors()) {
            log.info("the errors are : {}", form.data());
            return badRequest(login.render("", form));
        }
        String username = form.get().getUsername();
        log.info("checking if '{}' exists", username);
        if (userService.checkUsernameExists(username)) {
            log.info("username exists. redirecting to theButton()");
            session("username", username);
            return redirect(controllers.routes.Application.theButton());
        }
        log.info("'{}' does not exist, should display an error to the user eventually", username);
        return badRequest(login.render("", form));
    }

    public String validate() {

        return "balls";
    }
}
