package exercise;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static <K, V> List<Map<K, V>> findWhere(List<Map<K, V>> books, Map<K, V> where
    ) {
        return books
            .stream()
            .filter(map -> matchMap(map, where))
            .collect(Collectors.toList());
    }

    private static <K, V> boolean matchMap(Map<K, V> map, Map<K, V> where) {
        return map.entrySet().containsAll(where.entrySet());
    }
}
//END
