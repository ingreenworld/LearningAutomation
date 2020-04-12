package apiTesting.getRequests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class weatherApi6 {

    @Test
    void weather6() {

        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city/";
        RequestSpecification vikane = RestAssured.given();
        Response response = vikane.request(Method.GET, "Chicago");
        String body = response.getBody().asString();
        System.out.println("Responsebody is :" + body);
    }
}
