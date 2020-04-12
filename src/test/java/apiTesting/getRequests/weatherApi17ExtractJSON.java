package apiTesting.getRequests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class weatherApi17ExtractJSON {

    @Test
    void weather16() {
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city/";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/Sofia");


        JsonPath json = response.jsonPath();
        json.get("City");
        json.get("Temperature");
        json.get("Humidity");
        json.get("WeatherDescription");
        json.get("WindSpeed");
        json.get("WindDirectionDegree");

        Assert.assertEquals(json.get("Temperature"), "0.83000000000004 Degree celsius");
        Assert.assertEquals(json.get("Humidity"), "74 Percent");
        Assert.assertEquals(json.get("WeatherDescription"), "light snow");
        Assert.assertEquals(json.get("WindSpeed"), "5.1 Km per hour");
        Assert.assertEquals(json.get("WindDirectionDegree"), "80 Degree");


    }
}
