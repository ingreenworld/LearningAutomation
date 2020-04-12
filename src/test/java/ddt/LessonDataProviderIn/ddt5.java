package ddt.LessonDataProviderIn;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ddt5 {

    @Test(dataProvider = "data")
    void ddt5(String ename, String esal, String eage) {
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        RequestSpecification httpreq = RestAssured.given();

        JSONObject list = new JSONObject();
        list.put("name", ename);
        list.put("salary", esal);
        list.put("age", eage);
        httpreq.header("Content-type", "application/json");
        httpreq.body(list.toJSONString());
        Response response = httpreq.request(Method.POST, "/create");

        String responseBody = response.getBody().asString();
        System.out.println(responseBody);

        Assert.assertEquals(responseBody.contains(ename), true);
        Assert.assertEquals(responseBody.contains(esal), true);
        Assert.assertEquals(responseBody.contains(eage), true);


    }


    @DataProvider(name = "data")
    Object[] data() {
        String[][] data = {{"Josh", "23000", "23"}, {"Pesho", "24000", "23"}};
        return (data);
    }
}
