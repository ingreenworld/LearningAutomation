package apiTesting.getRequests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class weatherApi14 {

    @Test
    void apitest14() {

        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city/";
        RequestSpecification vikam = RestAssured.given();
        Response otgovor = vikam.request(Method.GET, "/Sofia");
        String tqlo = otgovor.getBody().asString();
        System.out.println(tqlo);
        int StatusCode = otgovor.getStatusCode();
        Assert.assertEquals(StatusCode, 200);

    }
}
