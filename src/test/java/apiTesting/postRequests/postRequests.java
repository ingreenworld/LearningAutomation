package apiTesting.postRequests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class postRequests {

    @Test
    void post1() {
        RestAssured.baseURI = "http://restapi.demoqa.com/customer";
        RequestSpecification vikam = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("FirstName", "Saint");
        requestParams.put("LastName", "John");
        requestParams.put("UserName", "SaintJohn1231");
        requestParams.put("Password", "SaintJohn123");
        requestParams.put("Email", "SaintJohn1231@gmail.com");

        vikam.header("Content-Type", "application/json");
        vikam.body(requestParams.toJSONString());

        Response response = vikam.request(Method.POST, "/register");

        String bodyResponse = response.getBody().asString();
        System.out.println(bodyResponse);
        int StatusCode = response.getStatusCode();
        Assert.assertEquals(StatusCode, 201);

        String successCode = response.jsonPath().get("SuccessCode");
        Assert.assertEquals(successCode, "OPERATION_SUCCESS");
    }
}
