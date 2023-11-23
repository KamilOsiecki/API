package automation.request;

import automation.Configuration;
import automation.data.UserData;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Account {

    public Response createUser() {
        return given().spec(Configuration.requestSpecification).when().get(Configuration.register).then().body()
    }

    //tutaj stwórz metode do stworzenia usera - analogicznie do klasy ponizej Users;
}
