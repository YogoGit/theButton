package controllers;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.torial;
import views.html.theButton;
// Here I will annotate a spring controller.

@org.springframework.stereotype.Controller
public class Application extends Controller {
    private static final String nav1 = "tutorial";
    private static final String nav2 = "the button";

    public static Result torial() {
        return ok(torial.render(nav1, nav2));
    }

    public static Result theButton() {
        String title = nav2;
        return ok(theButton.render(nav1, nav2));
    }

}
