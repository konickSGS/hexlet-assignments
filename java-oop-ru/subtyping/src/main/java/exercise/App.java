package exercise;

import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;
// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> temp = new HashMap<>(storage.toMap());

        for (String key: temp.keySet()) {
            storage.unset(key);
        }

        for (Map.Entry<String, String> entry: temp.entrySet()) {
            storage.set(entry.getValue(), entry.getKey());
        }
    }
}
// END
