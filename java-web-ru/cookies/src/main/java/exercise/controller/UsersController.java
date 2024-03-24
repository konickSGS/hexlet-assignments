package exercise.controller;

import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;
import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.repository.UserRepository;
import exercise.dto.users.UserPage;
import io.javalin.http.Context;

public class UsersController {

    public static void register(Context ctx) throws Exception {
        var firstName = ctx.formParamAsClass("firstName", String.class)
            .check(
                value -> value.length() >= 0,
                "Поле должно содержать больше символов"
        ).get();
        var lastName = ctx.formParam("lastName");
        var email = ctx.formParam("email");
        var password = ctx.formParam("password");

        String token = Security.generateToken();

        User user = new User(firstName, lastName, email, password, token);
        UserRepository.save(user);

        ctx.redirect(NamedRoutes.userPath(user.getId()));
        ctx.cookie("token", token);
    }

    public static void showBuild(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    public static void show(Context ctx) throws Exception {
        String token = ctx.cookie("token");
        Long id = ctx.pathParamAsClass("id", Long.class).get();
        User user = UserRepository.find(id)
            .orElse(null);
        if (user == null || token == null || !token.equals(user.getToken())) {
            ctx.redirect(NamedRoutes.buildUserPath());
            return;
        }

        UserPage page = new UserPage(user);
        ctx.render("users/show.jte", model("page", page));
    }
}
