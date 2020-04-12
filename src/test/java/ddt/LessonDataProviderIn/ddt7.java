package ddt.LessonDataProviderIn;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ddt7 {

    @Test(dataProvider = "data")
    void ddt7(String ename, String esal, String eage) {
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        RequestSpecification httpReq = RestAssured.given();

        JSONObject list = new JSONObject();
        list.put("name", ename);
        list.put("salary", esal);
        list.put("age", eage);
        httpReq.header("Content-type", "application/json");
        httpReq.body(list.toJSONString());
        Response response = httpReq.request(Method.POST, "/create");

        String Body = response.body().asString();
        Assert.assertEquals(Body.contains(ename), true);

    }

    @DataProvider(name = "data")
    Object[] data() {
        String[][] data = {{"Joshya Patek", "2300", "25"}, {"Joshua Chuek", "300", "44"}};
        return (data);
    }

}
