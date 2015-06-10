package controllers;

import models.LoginForm;
import views.html.login;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Login extends Controller {

    public static Result get(){
        session("connected", "user@gmail.com");
        return ok(login.render("", Form.form(LoginForm.class)));
    }

    public static Result post(){
            // I want to post this to the Auth controller
        return ok(login.render("", Form.form(LoginForm.class)));
    }
}
