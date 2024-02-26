package exercise;

import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    private String filename;
    public FileKV(String filename, Map<String, String> map) {
        this.filename = filename;
        String serializeString = Utils.serialize(map);
        Utils.writeFile(filename, serializeString);
    }

    public void set(String key, String value) {
        Map<String, String> map = getMapFromFile();
        map.put(key, value);
    }
    public void unset(String key) {
        Map<String, String> map = getMapFromFile();
        if (map.containsKey(key)) {
            map.remove(key);
        }
        String serializeString = Utils.serialize(map);
        Utils.writeFile(filename, serializeString);
    }
    public String get(String key, String defaultValue) {
        Map<String, String> map = getMapFromFile();
        return map.getOrDefault(key, defaultValue);
    }

    public Map<String, String> toMap() {
        return getMapFromFile();
    }

    private Map<String, String> getMapFromFile() {
        String serializeString = Utils.readFile(filename);
        return Utils.unserialize(serializeString);
    }
}
// END
