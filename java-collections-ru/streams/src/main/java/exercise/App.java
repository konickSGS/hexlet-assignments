package exercise;

import java.util.List;
import java.util.Set;

// BEGIN
public class App {
    private static Set<String> freeDomains = Set.of(
            "gmail.com",
            "yandex.ru",
            "hotmail.com"
    );
    public static int getCountOfFreeEmails(List<String> emails) {
        return (int) emails.stream()
            .map(email -> email.split("@")[1])
            .filter(domain -> freeDomains.contains(domain))
            .count();
    }
}
// END
