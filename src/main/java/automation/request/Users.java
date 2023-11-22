package automation.request;

import automation.Configuration;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class Users {
    public Response getUserByID(String userID) {
        return given().spec(Configuration.requestSpecification).when().get(Configuration.users + "/" + userID);
    }

    public Response getAllUsers(){
        return given().spec(Configuration.requestSpecification).when().get(Configuration.users);
    }
}