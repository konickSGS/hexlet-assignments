package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;

// BEGIN
public class App {
    private static final String ENVIRONMENT = "environment";
    private static final String FORWARD = "X_FORWARDED_";

    public static String getForwardedVariables(String file) {
        List<String> environments = getEnvironments(file);
        return environments.stream()
            .flatMap(line -> Arrays.stream(line.split(",")))
            .filter(value -> value.startsWith(FORWARD))
            .map(forwardValue -> forwardValue.replace(FORWARD, ""))
            .collect(Collectors.joining(","));
        //return String.join(",", forwardedVariables);
    }

    private static List<String> getEnvironments(String file) {
        return getStringStartsWith(file, ENVIRONMENT).stream()
            .map(line -> deleteBeforeAndAfterPairLetter(line, '"'))
            .collect(Collectors.toList());
    }

    private static List<String> getStringStartsWith(String file, String start) {
        return Arrays.stream(file.split("\n"))
            .filter(line -> line.startsWith(start))
            .collect(Collectors.toList());
    }

    private static String deleteBeforeAndAfterPairLetter(String line, char letter) {
        int startIndex = line.indexOf(letter) + 1;
        int endIndex = line.lastIndexOf(letter);
        return line.substring(startIndex, endIndex);
    }
}
//END
