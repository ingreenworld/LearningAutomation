package apiTesting.postRequests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class postRequests2 {

    @Test
    void post2() {
        RestAssured.baseURI = "http://restapi.demoqa.com/customer";
        RequestSpecification spec = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("FirstName", "Saint");
        requestParams.put("LastName", "John");
        requestParams.put("UserName", "SaintJohn123123");
        requestParams.put("Password", "SaintJohn1234");
        requestParams.put("Email", "SaintJohn123124@gmail.com");

        spec.header("Content-Type", "application/json");
        spec.body(requestParams.toJSONString());

        Response response = spec.request(Method.POST, "/register");

        String successCode = response.jsonPath().get("SuccessCode");
        Assert.assertEquals(successCode, "OPERATION_SUCCESS");

    }
}
