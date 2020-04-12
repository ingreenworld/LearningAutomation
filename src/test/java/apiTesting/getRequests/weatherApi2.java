package apiTesting.getRequests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class weatherApi2 {

    @Test
    void regApiTest() {
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city/";
        RequestSpecification weatherRequest = RestAssured.given();
        Response response = weatherRequest.request(Method.GET, "/Plovdiv");
        String responseBody = response.getBody().asString();
        System.out.println("Response body is:" + responseBody);
        int StatusCode = response.getStatusCode();
        System.out.println("Status code is:" + StatusCode);
        Assert.assertEquals(StatusCode, 200);
        String SystemLine = response.getStatusLine();
        System.out.println("System Line is:" + SystemLine);
        Assert.assertEquals(SystemLine, "HTTP/1.1 200 OK");
    }
}