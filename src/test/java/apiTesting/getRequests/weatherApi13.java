package apiTesting.getRequests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class weatherApi13 {

    @Test
    void weather14() {
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city/";
        RequestSpecification spasa = RestAssured.given();
        Response spasa1 = spasa.request(Method.GET, "/Kardzhali");
        String tqlotoNaSpasa = spasa1.getBody().asString();
        System.out.println(tqlotoNaSpasa);


    }
}
