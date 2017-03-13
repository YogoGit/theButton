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

import javax.inject.Named;

@Named
public class Application extends Controller {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    private static final String nav1 = "tutorial";
    private static final String nav2 = "the button";

    public Result torial() {
        String user = session("username");
        if (user != null) {
            return ok(torial.render(nav1, nav2));
        } else {
            log.info("Trying to enter torial without verification");
            return redirect(controllers.routes.Login.login());
        }
    }

    public Result theButton() {
        String user = session("username");
        if (user != null) {
            log.info("{} is authorized", user);
            return ok(theButton.render(nav1, nav2));
        } else {
            log.info("Trying to enter theButton without verification");
            return redirect(controllers.routes.Login.login());
        }
    }
}
