package apiTesting.getRequests;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class getAuthentication {

    @Test
    void authentication() {

        RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
        RequestSpecification httpRequest = RestAssured.given();

        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme(); //username and passwords
        authScheme.setUserName("ToolsQA");
        authScheme.setPassword("TestPassword");
        RestAssured.authentication = authScheme;

        Response response = httpRequest.request(Method.GET, "/");
        String resposeBody = response.getBody().asString();
        System.out.println(resposeBody);


    }
}
