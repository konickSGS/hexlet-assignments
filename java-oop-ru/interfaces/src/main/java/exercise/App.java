package exercise;

import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> homes, int limitCount) {
        return homes.stream()
            .sorted()
            .limit(limitCount)
            .map(Object::toString)
            .collect(Collectors.toList());
    }
}
// END
