package controllers;

//this class is kind of stupid. I should have a class for each page rather than bundling torial and theButton on one page.

import play.mvc.Controller;
import play.mvc.Result;

import views.html.torial;
import views.html.theButton;
import views.html.login;

@org.springframework.stereotype.Controller
public class Application extends Controller {
    private static final String nav1 = "tutorial";
    private static final String nav2 = "the button";

    public Result torial() {
        if (checkUser()) {
            return ok(torial.render(nav1, nav2));
        } else {
            return redirect(controllers.routes.Login.login());
        }
    }

    public Result theButton() {
        if (checkUser()) {
            return ok(theButton.render(nav1, nav2));
        } else {
            return redirect(controllers.routes.Login.login());
        }

    }

    private boolean checkUser() {
        String user = session("User");
        return (user != null);
    }

}
