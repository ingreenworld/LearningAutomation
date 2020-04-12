package apiTesting.getRequests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class weatherApi8 {

    @Test
    void weather8() {

        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city/";
        RequestSpecification vikane = RestAssured.given();
        Response responsebody = vikane.request(Method.GET, "/London");
        String response = responsebody.getBody().asString();
    }
}
