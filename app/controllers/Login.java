package controllers;

import model.User;
import model.LoginInfo;

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
        return ok(login.render("", Form.form(LoginInfo.class)));
    }

    public static Result authenticate() {
        // I want to post this to the Auth controller
        Form<LoginInfo> form = Form.form(LoginInfo.class).bindFromRequest();

        if (form.hasErrors()) {
            return badRequest(login.render("", form));
        } else {
        return ok(login.render("POOOOOOOSSSSSSSSTTTTTTTTEEEEEEDDDDDDDDDDDDDDDDDDDDDD", Form.form(LoginInfo.class)));

        }
    }

    public String validate() {

        return "balls";
    }
}
