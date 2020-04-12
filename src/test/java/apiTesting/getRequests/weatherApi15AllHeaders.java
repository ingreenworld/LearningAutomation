package apiTesting.getRequests;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class weatherApi15AllHeaders {

    @Test
    void weather15() {
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city/";
        RequestSpecification zaqvka = RestAssured.given();
        Response otgovor = zaqvka.request(Method.GET, "/Sofia");

        Headers allheaders = otgovor.headers();

        for (Header header : allheaders) {

            System.out.println(header.getName() + "    " + header.getValue());
        }
    }
}
