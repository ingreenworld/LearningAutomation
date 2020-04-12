package apiTesting.getRequests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class weatherApi10 {

    @Test
    void weather10() {
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city/";
        RequestSpecification chocho = RestAssured.given();
        Response send = chocho.request(Method.GET, "/Turnovo");
        String fullBody = send.getBody().asString();
        System.out.println(fullBody);
    }
}
