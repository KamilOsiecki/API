package automation.model.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class Account {

    String username;
    String email;
    String password;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public Account(@JsonProperty("username") String username,
                   @JsonProperty("email") String email,
                   @JsonProperty("password") String password) {

        this.username = username;
        this.email = email;
        this.password = password;
    }

    //pola do rejestracji konta
}
