package exercise.util;

public class NamedRoutes {

    public static String rootPath() {
        return "/";
    }

    // BEGIN
    public static String postsPath() {
        return "/posts";
    }
    public static String postPath() {
        return postPath("{id}");
    }

    public static String postPath(Long id) {
        return postPath(String.valueOf(id));
    }
    public static String postPath(String id) {
        return postsPath() + "/" + id;
    }
    // END
}
