package apiTesting.getRequests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class weatherApi7 {

    @Test
    void weather7() {
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city/";
        RequestSpecification chocho = RestAssured.given();
        Response body = chocho.request(Method.GET, "/Moscow");
        String fullbody = body.getBody().asString();


    }
}
