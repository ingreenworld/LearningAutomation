package apiTesting.getRequests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class weatherApi11 {

    @Test
    void weather11() {
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city/";
        RequestSpecification send1 = RestAssured.given();
        Response send = send1.request(Method.GET, "Haskovo");
        String fullbody = send.getBody().asString();
        int StatusCode = send.getStatusCode();
        Assert.assertEquals(StatusCode, 200);
        String CodeLine = send.statusLine();
        System.out.println(CodeLine);
    }
}
