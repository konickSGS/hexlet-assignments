package exercise;

import java.nio.file.Files;
import java.nio.file.Path;

// BEGIN
public class App {
    public static void save(Path path, Car car) {
        try {
            String jsonString = car.serialize();
            Files.write(path, jsonString.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Car extract(Path path) {
        try {
            byte[] bytes = Files.readAllBytes(path);
            String jsonString = new String(bytes);
            return Car.unserialize(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
// END
