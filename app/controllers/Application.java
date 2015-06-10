package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

// Here I will annotate a spring controller.

public class Application extends Controller {
    private static final String nav1 = "tutorial";
    private static final String nav2 = "the button";

    public static Result login(){
        session("connected", "user@gmail.com");
        return ok("");

    }
    public static Result index() {
        String title = nav1;
        return ok(index.render(title,nav1, nav2, play.data.Form.form(models.Task.class)));
    }

    public static Result addTask() {
        play.data.Form<models.Task> form = play.data.Form.form(models.Task.class).bindFromRequest();
        if (form.hasErrors()) {
            return badRequest(index.render(nav1, nav1, nav2, form));
        }
        else {
            models.Task task = form.get();
            task.save();
            return redirect(routes.Application.index());
        }
    }

    public static Result getTasks() {
        java.util.List<models.Task> tasks = new play.db.ebean.Model.Finder(String.class, models.Task.class).all();
        return ok(play.libs.Json.toJson(tasks));
    }

    public static Result theButton(){
        String title = nav2;
        return ok(theButton.render(title, nav1, nav2));
    }

}
