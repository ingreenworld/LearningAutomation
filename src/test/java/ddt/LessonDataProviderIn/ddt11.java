package ddt.LessonDataProviderIn;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ddt11 {

    @Test(dataProvider = "data")
    void ddt11(String ename, String esal, String eage) {

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        RequestSpecification httpReq = RestAssured.given();

        JSONObject list = new JSONObject();
        list.put("name", ename);
        list.put("salaray", esal);
        list.put("age", eage);

        httpReq.header("Content-type", "application/json");
        httpReq.body(list.toJSONString());
        Response response = httpReq.request(Method.POST, "/create");

        String body = response.getBody().asString();
        System.out.println(body);

        Assert.assertEquals(body.contains(ename), true);
    }


    @DataProvider(name = "data")
    Object[] data() {
        String[][] data = {{"Chica Boom", "2300", "4000"}, {"Nigga Sad", "30000", "44"}};
        return (data);
    }
}
