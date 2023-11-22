package automation.model.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class Data {

    String id;
    String email;
    String first_name;
    String last_name;
    String avatar;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public Data(@JsonProperty("id") String id,
                @JsonProperty("email") String email,
                @JsonProperty("first_name") String first_name,
                @JsonProperty("last_name") String last_name,
                @JsonProperty("avatar") String avatar) {

        this.id = id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.avatar = avatar;
    }
}