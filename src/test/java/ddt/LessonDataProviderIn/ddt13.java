package ddt.LessonDataProviderIn;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ddt13 {

    @Test(dataProvider = "data")
    void ddt13(String ename, String eage, String esal) {
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        RequestSpecification httpreq = RestAssured.given();

        JSONObject list = new JSONObject();
        list.put("name", ename);
        list.put("age", eage);
        list.put("salary", esal);

        httpreq.header("Content-type", "application/json");
        httpreq.body(list.toJSONString());

        Response response = httpreq.request(Method.POST, "/create");
        String body = response.getBody().asString();
        System.out.println(body);

        Assert.assertEquals(body.contains(esal), true);
    }


    @DataProvider(name = "data")
    Object[] data() {
        String[][] data = {{"Shon Poshon", "23000", "23"}, {"Jimmy Cho", "43333", "21"}};
        return data;
    }
}
