package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

// BEGIN
public class App {
    public static LinkedHashMap<String, Object> genDiff(
            Map<String, Object> map1,
            Map<String, Object> map2
    ) {
        LinkedHashMap<String, Object> diff = new LinkedHashMap<>();
        Set<String> set1 = map1.keySet();
        Set<String> set2 = map2.keySet();

        Set<String> added = new HashSet<>(set2);
        added.removeAll(set1);
        Set<String> deleted = new HashSet<>(set1);
        deleted.removeAll(set2);
        Set<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        for (String key: added) {
            diff.put(key, "added");
        }
        for (String key: deleted) {
            diff.put(key, "deleted");
        }
        for (String key: intersection) {
            if (map1.get(key).equals(map2.get(key))) {
                diff.put(key, "unchanged");
            } else {
                diff.put(key, "changed");
            }
        }
        return diff;
    }
}
//END
