package apiTesting.getRequests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class weatherApi4 {

    @Test
    void weatherApiCheck() {

        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city/";
        RequestSpecification weather4 = RestAssured.given();
        Response weather45 = weather4.request(Method.GET, "Burgas");
        String responseBody = weather45.getBody().asString();
        System.out.println(responseBody);
        int StatusCode = weather45.getStatusCode();
        String StatusLine = weather45.getStatusLine();
    }
}
