package apiTesting.getRequests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class weatherApi5 {

    @Test
    void weather5() {

        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city/";
        RequestSpecification request = RestAssured.given();
        Response response = request.request(Method.GET);
        String bodyResponse = response.getBody().asString();
        int StatusCode = response.getStatusCode();
        String StatusLine = response.getStatusLine();
        String sessionId = response.getSessionId();
        System.out.println(sessionId);
    }
}
