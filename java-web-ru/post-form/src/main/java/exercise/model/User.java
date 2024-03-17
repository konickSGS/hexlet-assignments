package exercise.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;

@Getter
@Setter
@ToString
public final class User {

    private Long id;
    private String firstName;

    @ToString.Include
    private String lastName;

    private String email;
    private String password;

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = StringUtils.capitalize(firstName);
        this.lastName = StringUtils.capitalize(lastName);
        this.email = email.trim().toLowerCase();
        this.password = Security.encrypt(password);
    }
}
