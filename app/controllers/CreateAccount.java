package controllers;

import model.LoginInfo;
import model.User;


import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import org.springframework.beans.factory.annotation.Autowired;

import services.UserService;

import views.html.createAccount;


public class CreateAccount extends Controller{

    @Autowired
    private static UserService userService;

    public static Result add() {
        return ok(createAccount.render("Adding User", Form.form(User.class)));
    }

    public static Result addUser() {
        Form<User> form = Form.form(User.class).bindFromRequest();

        User user = form.get();
        if (userService.checkUsername(user.getUser())) {
           userService.addUser(user);
           return redirect(controllers.routes.Login.login());
        }

        return badRequest(createAccount.render("Bad Request", form));
    }

}
