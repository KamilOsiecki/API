package automation.data;

import automation.model.request.Account;
import automation.model.response.Data;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.SneakyThrows;

public class UserData {

    public Data generateExpectedUserData() {
        return Data.builder()
                .id("1")
                .email("george.bluth@reqres.in")
                .first_name("George")
                .last_name("Bluth")
                .avatar("https://reqres.in/img/faces/1-image.jpg").build();
    }

    @SneakyThrows
    public String generateAccountBody(String username, String email, String password) {
        return JsonMapper.builder().enable(SerializationFeature.INDENT_OUTPUT).build().writeValueAsString(Account.builder()
                .username(username).email(email).password(password));
    }
    //dane do stworzenia usera
}