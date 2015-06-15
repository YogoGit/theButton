package controllers;

//this class is kind of stupid. I should have a class for each page rather than bundling torial and theButton on one page.

import play.mvc.Controller;
import play.mvc.Result;

import model.User;

import views.html.torial;
import views.html.theButton;
import views.html.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@org.springframework.stereotype.Controller
public class Application extends Controller {
    private static final String nav1 = "tutorial";
    private static final String nav2 = "the button";
    private static final Logger log = LoggerFactory.getLogger(Login.class);

    public Result torial() {
        if (checkUser()) {
            return ok(torial.render(nav1, nav2));
        } else {
            log.info("Trying to enter torial without verification");
            return redirect(controllers.routes.Login.login());
        }
    }

    public Result theButton() {
        if (checkUser()) {
            log.info("User is authorized");
            return ok(theButton.render(nav1, nav2));
        } else {
            log.info("Trying to enter theButton without verification");
            return redirect(controllers.routes.Login.login());
        }

    }

    private boolean checkUser() {
        String user = session("username");
        log.info("checking User. user = {}",user);
        return (user != null);
    }

}
