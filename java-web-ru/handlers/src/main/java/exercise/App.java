package exercise;

import io.javalin.Javalin;

public final class App {

    public static Javalin getApp() {

        Javalin app = Javalin.create(config -> {
            // Включаем логгирование при разработке
            config.plugins.enableDevLogging();
        });
        // Получаем список телефонов
        appGet(app, "/phones", Data.getPhones());
        // Получаем список доменных имен
        appGet(app, "/domains", Data.getDomains());

        return app;
    }

    private static void appGet(Javalin app, String path, Object data) {
        app.get(path, cth -> {
            cth.json(data);
        });
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
