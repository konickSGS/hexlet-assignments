package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import exercise.util.NamedRoutes;
import static exercise.util.Security.encrypt;

import io.javalin.validation.ValidationException;

import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
    public static void login(Context ctx) {
        var formName = ctx.formParam("name");
        try {
            var user = UsersRepository.findByName(formName);

            var repositoryPassword = (user == null ? "" : user.getPassword());
            var formPassword = ctx.formParamAsClass("password", String.class)
                .check(
                    value -> {
                        value = encrypt(value);
                        return value.equals(repositoryPassword);
                    },
                    "Wrong username or password"
                      )
                .get();
            ctx.sessionAttribute("currentUser", formName);
            ctx.redirect(NamedRoutes.rootPath());
        } catch (ValidationException e) {
            var page = new LoginPage(formName, e.getErrors());
            ctx.render("build.jte", model("page", page));
        }
    };

    public static void showLoginForm(Context ctx) {
        var page = new LoginPage();
        ctx.render("build.jte", model("page", page));
    }

    public static void main(Context ctx) {
        var name = ctx.sessionAttribute("currentUser");
        var page = new MainPage(name);

        ctx.render("index.jte", model("page", page));
    }

    public static void delete(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect(NamedRoutes.rootPath());
    }

    // END
}
