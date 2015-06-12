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

@org.springframework.stereotype.Controller
public class CreateAccount extends Controller {

    @Autowired
    private UserService userService;

    public static Result add() {
        return ok(createAccount.render(Form.form(User.class)));
    }

    public static Result addUser() {
        //I dont know what this is
        Form<User> form = Form.form(User.class).bindFromRequest();
        if (form.hasErrors()) {
            return badRequest(createAccount.render(form));
        }
        User user = form.get();
//        if (userService.checkUsername(user.getUsername())) {
          if (true){
//           userService.addUser(user);
           return redirect(controllers.routes.Login.login());
        }

        return badRequest(createAccount.render(form));
    }

}
