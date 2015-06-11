package controllers;

import model.User;
import model.LoginInfo;

import models.LoginForm;

import services.UserService;

import views.html.login;

import org.springframework.beans.factory.annotation.Autowired;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

@org.springframework.stereotype.Controller
public class Login extends Controller {

//    @Autowired
//    private UserService userService;

    public static Result login() {
        //session("connected", "user@gmail.com");
        return ok(login.render("", Form.form(LoginForm.class)));
    }

    public static Result authenticate() {
        // I want to post this to the Auth controller
        Form<Login> loginForm = Form.form(Login.class).bindFromRequest();

        return ok(login.render("POOOOOOOSSSSSSSSTTTTTTTTEEEEEEDDDDDDDDDDDDDDDDDDDDDD", Form.form(LoginForm.class)));
    }

    public String validate() {

        return "balls";
    }
}
