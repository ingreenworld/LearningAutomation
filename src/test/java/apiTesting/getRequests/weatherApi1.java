package apiTesting.getRequests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class weatherApi1 {

    @Test
    void getWeatherCondition() {
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city/";
        RequestSpecification httprequest = RestAssured.given();
        Response response = httprequest.request(Method.GET, "/Sofia");
        String responseBody = response.getBody().asString();
        System.out.println("Response body is:" + responseBody);
        int statusCode = response.getStatusCode();
        System.out.println("Status code is: + " + statusCode);
        Assert.assertEquals(statusCode, 200);
        String statusLine = response.getStatusLine();
        System.out.println("Status line is:" + statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

    }

}
