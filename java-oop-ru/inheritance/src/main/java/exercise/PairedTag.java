package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private String tagBody;
    private List<Tag> childTags;
    public PairedTag(
            String tagName,
            Map<String, String> attributes,
            String tagBody,
            List<Tag> childTags
    ) {
        super(tagName, attributes);
        this.tagBody = tagBody;
        this.childTags = childTags;
    }

    public String getBody() {
        return tagBody;
    }

    @Override
    public String toString() {
        String childTagsString = childTags.stream()
            .map(Tag::toString)
            .collect(Collectors.joining(""));
        String stringAttributes = getStringAttributes();
        if (stringAttributes.length() != 0) {
            stringAttributes = " " + stringAttributes;
        }

        return String.format(
               "<%s%s>%s%s</%s>",
               getName(),
               stringAttributes,
               tagBody,
               childTagsString,
               getName()
               );
    }
}
// END
