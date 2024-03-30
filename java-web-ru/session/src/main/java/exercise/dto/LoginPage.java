package exercise.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;

import io.javalin.validation.ValidationError;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class LoginPage {
    private String name;
    //private String error;
    private Map<String, List<ValidationError<Object>>> errors;
}
