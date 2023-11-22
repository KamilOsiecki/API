package automation.data;

import automation.model.response.Data;

public class UserData {

    public Data generateData() {
        return Data.builder()
                .id("1")
                .email("george.bluth@reqres.in")
                .first_name("George")
                .last_name("Bluth")
                .avatar("https://reqres.in/img/faces/1-image.jpg").build();
    }

    //dane do stworzenia usera
}