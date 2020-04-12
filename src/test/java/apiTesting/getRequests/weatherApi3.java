package apiTesting.getRequests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class weatherApi3 {

    @Test
    void weather3() {

        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city/";
        RequestSpecification weatherRequest3 = RestAssured.given();
        Response response = weatherRequest3.request(Method.GET, "/Varna");
        String responseBody = response.getBody().asString();
        System.out.println("Response body is:" + responseBody);
        int StatusCode = response.getStatusCode();
        Assert.assertEquals(StatusCode, 200);
        String StatusLine = response.statusLine();
        System.out.println("Statusline is:" + StatusLine);
        Assert.assertEquals(StatusLine, "HTTP/1.1 200 OK");

    }
}
