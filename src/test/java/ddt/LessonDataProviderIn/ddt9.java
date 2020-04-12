package ddt.LessonDataProviderIn;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ddt9 {

    @Test(dataProvider = "data")
    void ddt9(String ename, String esal, String eage) {
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        RequestSpecification httpReq = RestAssured.given();

        JSONObject list = new JSONObject();
        list.put("name", ename);
        list.put("salary", esal);
        list.put("age", eage);

        httpReq.header("Content-type", "application/json");
        httpReq.body(list.toJSONString());

        Response response = httpReq.request("Post", "/create");

        String body = response.getBody().asString();
        Assert.assertEquals(body.contains(ename), true);

    }


    @DataProvider(name = "data")
    Object[] data() {
        String[][] data = {{"Josh Mosh", "30000", "23"}, {"Gosh Hosh", "3000", "42"}};
        return (data);
    }
}
