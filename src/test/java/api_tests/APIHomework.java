package api_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;

public class APIHomework extends BaseTest {

    //given - request specification
    //when - query params/body etc.
    //then - assertions

    @Test
    public void getUsersID() {

        response = given().spec(requestSpecification)
                .when().get(users);

        List<Integer> listOfId = response
                .jsonPath().getList("data.id");

        System.out.println(listOfId);
        System.out.println(listOfId.get(0));
        String userID = listOfId.get(0).toString();

        response.then().statusCode(200);
    }

    @Test
    public void getUserByID() {

        response = given().spec(requestSpecification)
                .when().get(users + "/1");

        response.then().statusCode(200).log().all();

        Assertions.assertEquals("george.bluth@reqres.in", response.jsonPath().getString("data.email"));
    }

    @Test
    public void addUser() {

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