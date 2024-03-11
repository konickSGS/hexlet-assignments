package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();
    private static final int PAGE_DEFAULT = 1;
    private static final int PER_DEFAULT = 5;
    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            Integer page = ctx.queryParamAsClass("page", Integer.class)
                .getOrDefault(PAGE_DEFAULT);
            Integer per = ctx.queryParamAsClass("per", Integer.class)
                .getOrDefault(PER_DEFAULT);
            var list = getListPaging(USERS, page, per);

            ctx.json(list);
        });
        // END

        return app;

    }

    private static <T> List<T> getListPaging(List<T> list, int page, int per) {
        int startIndex = (page - 1) * per;
        if (startIndex >= list.size()) {
            return List.of();
        }
        int endIndex = Math.min(startIndex + per, list.size());

        return list.subList(startIndex, endIndex);
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
