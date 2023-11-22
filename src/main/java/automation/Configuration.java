package automation;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public final class Configuration {

    public static String baseURI = "https://reqres.in/api";
    public static String users = "/users";
    public static String register = "/register";
    public static RequestSpecification requestSpecification = new RequestSpecBuilder().setBaseUri(baseURI).setAccept(ContentType.JSON).setContentType(ContentType.JSON).build();
    public static Response response;
}