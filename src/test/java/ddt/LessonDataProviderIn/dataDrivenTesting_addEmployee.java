package ddt.LessonDataProviderIn;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class dataDrivenTesting_addEmployee {

    @Test
    void addNewEmployees() {
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        RequestSpecification httpReq = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "Pesheto123");
        requestParams.put("salary", "12312312312312");
        requestParams.put("age", "23");

        httpReq.header("Content-Type", "application/json");
        httpReq.body(requestParams.toJSONString());

        Response response = httpReq.request(Method.POST, "/create");
        String responseBody = response.getBody().asString();

        Assert.assertEquals(responseBody.contains("Pesheto123"), true);
        Assert.assertEquals(responseBody.contains("12312312312312"), true);
        Assert.assertEquals(responseBody.contains("23"), true);

        int ResponseCode = response.getStatusCode();
        Assert.assertEquals(ResponseCode, 200);
    }

}
