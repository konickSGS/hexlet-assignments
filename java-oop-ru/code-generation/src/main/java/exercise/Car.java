package exercise;

import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

@Value
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public String serialize() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }

    public static Car unserialize(String jsonString) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Car jsonCar = mapper.readValue(jsonString, Car.class);
        return jsonCar;
    }
    // END
}
