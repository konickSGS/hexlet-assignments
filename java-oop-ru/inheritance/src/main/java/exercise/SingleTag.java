package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {
    public SingleTag(String tagName, Map<String, String> attributes) {
        super(tagName, attributes);
    }
    @Override
    public String toString() {
        String stringAttributes = getStringAttributes();
        if (stringAttributes.length() != 0) {
            stringAttributes = " " + stringAttributes;
        }
        return String.format("<%s%s>", getName(), stringAttributes);
    }
}
// END
