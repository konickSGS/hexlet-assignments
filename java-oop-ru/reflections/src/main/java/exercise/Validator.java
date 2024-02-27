package exercise;

import java.lang.reflect.Field;
import java.util.List;
import java.util.ArrayList;
// BEGIN
public class Validator {
    public static List<String> validate(Address address) {
        List<String> notValidateMethods = new ArrayList<>();

        try {
            Field[] fields = address.getClass().getDeclaredFields();
            for (Field field: fields) {
                if (!field.isAnnotationPresent(NotNull.class)) {
                    continue;
                }
                field.setAccessible(true);
                Object value = field.get(address);
                if (value == null) {
                    notValidateMethods.add(field.getName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return notValidateMethods;
    }
}
// END
