package exercise.util;

public class NamedRoutes {

    public static String rootPath() {
        return "/";
    }

    public static String postsPath() {
        return "/posts";
    }

    public static String buildPostPath() {
        return "/posts/build";
    }

    public static String postPath(Long id) {
        return postPath(String.valueOf(id));
    }

    public static String postPath(String id) {
        return "/posts/" + id;
    }

    public static String postPath() {
        return postPath("{id}");
    }

    // BEGIN
    public static String editPath(Long id) {
        return postPath(id) + "/edit";
    }

    public static String editPath() {
        return postPath() + "/edit";
    }
    // END
}
