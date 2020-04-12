package ddt.LessonDataProviderIn;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ddt6 {

    @Test(dataProvider = "data")
    void ddt6(String ename, String esal, String eage) {
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        RequestSpecification httpReq = RestAssured.given();

        JSONObject list = new JSONObject();
        list.put("name", ename);
        list.put("salary", esal);
        list.put("eage", eage);

        httpReq.header("Content-type", "application/json");
        httpReq.body(list.toJSONString());

        Response response = httpReq.request(Method.POST, "/create");

        String responseBody = response.getBody().asString();
        System.out.println(responseBody);

        Assert.assertEquals(responseBody.contains(ename), true);
        Assert.assertEquals(responseBody.contains(esal), true);
        Assert.assertEquals(responseBody.contains(eage), true);


    }

    @DataProvider(name = "data")
    Object[] data() {
        String[][] data = {{"Josh Bok", "2300", "40"}, {"Josh NeBok", "2400", "44"}};
        return (data);
    }
}
