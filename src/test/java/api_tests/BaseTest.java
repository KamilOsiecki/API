package api_tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseTest {


    protected String baseURI = "https://reqres.in/api";
    public String users = "/users";
    protected String register = "/register";
    RequestSpecification requestSpecification = new RequestSpecBuilder().setBaseUri(baseURI).setAccept(ContentType.JSON).setContentType(ContentType.JSON).build();
    Response response;
}