package api_tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class APITestsPractice extends BaseTest{

    //given - request specification
    //when - query params/body etc.
    //then - assertions

    @Test
    public void getUsers() {

        RequestSpecification requestSpecification = new RequestSpecBuilder().setBaseUri(baseURI).setAccept(ContentType.JSON).build();

        given().spec(requestSpecification).log().all()
                .when().get(users)
                .then().statusCode(200).and().header("Content-Type", "application/json; charset=utf-8")
                .and().body("page", equalTo(1)).log().all();
    }

    @Test
    public void postUser() {

        RequestSpecification requestSpecification = new RequestSpecBuilder().setBaseUri(baseURI).setAccept(ContentType.JSON).setContentType(ContentType.JSON).build();

        final String REQUEST_BODY = "{\"username\": \"george.bluth@reqres.in\", \"password\": \"string\"}";

        given().spec(requestSpecification).body(REQUEST_BODY).log().all()
                .when().post(register)
                .then().statusCode(200).log().all();
    }

    @Test
    public void updateUser() {

        RequestSpecification requestSpecification = new RequestSpecBuilder().setBaseUri(baseURI).setAccept(ContentType.JSON).build();

        Response response = given().spec(requestSpecification).log().all()
                        .when().put(users + "/1");

        response.then().statusCode(200).log().all();

        Assertions.assertTrue(response.asString().contains("updatedAt"));
    }
}