package apiTesting.getRequests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class weatherApi9 {

    @Test
    void weather9() {

        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city/";
        RequestSpecification chocho = RestAssured.given();
        Response response = chocho.request(Method.GET, "/Ruse");
        String body = response.getBody().asString();
        System.out.println(body);

    }
}
