package api_tests;

import automation.data.UserData;
import automation.request.Users;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class APIHomework extends BaseTest {

    //given - request specification
    //when - query params/body etc.
    //then - assertions
    Users userBody = new Users();
    UserData userData = new UserData();

    @Test
    public void getUsersID() {
        Response response = userBody.getAllUsers();
//        ValidatableResponse validatableResponse = response1.then().statusCode(200);

        List<String> usersID = response.jsonPath().getList("data.id");

        response.then().statusCode(200);
    }

    @Test
    public void getUserByID() {

        userBody.getUserByID("1")
                .then().statusCode(200).body("data.email", equalTo(userData.generateExpectedUserData().getEmail())).log().all();

    }

    @Test
    public void registerUser() {

        String requestBody = """
                {
                  "username": "george.bluth@reqres.in",
                  "email": "george.bluth@reqres.in",
                  "password": "1234"
                }
                """;

        response = given().spec(requestSpecification)
                .body(requestBody)
                .when().post(register);

        //który sposób polecasz? asercja w then czy asercja Junit?
        response.then().statusCode(200).log().all();

        Assertions.assertEquals(200, response.statusCode());
    }

    @Test
    public void updateUser() {

        String requestBody = """
                {
                  "username": "updated_name",
                  "email": "update@gmail.com",
                  "password": "new_password"
                }
                """;

        response = given().spec(requestSpecification)
                .body(requestBody)
                .when().put(users + "/1");

        response.then().statusCode(200).log().all();

        Assertions.assertAll(
                () -> Assertions.assertEquals("updated_name", response.jsonPath().getString("username")),
                () -> Assertions.assertEquals("update@gmail.com", response.jsonPath().getString("email")),
                () -> Assertions.assertEquals("new_password", response.jsonPath().getString("password"))
        );
    }

    @Test
    public void deleteUser() {

        response = given().spec(requestSpecification)
                .when().delete(users + "/1");

        response.then().statusCode(204);
    }
}