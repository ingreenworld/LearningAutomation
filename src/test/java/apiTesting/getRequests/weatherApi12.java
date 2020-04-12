package apiTesting.getRequests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class weatherApi12 {

    @Test
    void weather12() {
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city/";
        RequestSpecification reqspec = RestAssured.given();
        Response spectype = reqspec.request(Method.GET, "/Pazardzhik");
        String bodytype = spectype.getBody().asString();
        System.out.println(bodytype);
        int StatusCode = spectype.getStatusCode();
        Assert.assertEquals(StatusCode, 200);
        String StatusLine = spectype.getStatusLine();
        System.out.println(StatusLine);
        Assert.assertEquals(StatusLine, "HTTP/1.1 200 OK");
    }
}
