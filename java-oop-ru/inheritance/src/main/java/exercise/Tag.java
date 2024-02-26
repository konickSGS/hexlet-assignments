package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public abstract class Tag {
    private Map<String, String> attributes;
    private String tagName;
    public Tag(String tagName, Map<String, String> attributes) {
        this.tagName = tagName;
        this.attributes = attributes;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    protected String getStringAttributes() {
        return attributes.entrySet()
            .stream()
            .map(atr -> String.format("%s=\"%s\"", atr.getKey(), atr.getValue()))
            .collect(Collectors.joining(" "));
    }

    public String getName() {
        return tagName;
    }
}
// END
