package ddt.LessonDataProviderIn;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ddt8 {

    @Test(dataProvider = "data")
    void ddt8(String ename, String esal, String eage) {

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        RequestSpecification httprequest = RestAssured.given();

        JSONObject list = new JSONObject();
        list.put("name", ename);
        list.put("salary", esal);
        list.put("age", eage);

        httprequest.header("Content-type", "application/json");
        httprequest.body(list.toJSONString());

        Response response = httprequest.request(Method.POST, "/create");

        String body = response.getBody().asString();
        Assert.assertEquals(body.contains(ename), true);


    }


    @DataProvider(name = "data")
    Object[] data() {
        String[][] data = {{"Mek Check", "399993", "44"}, {"Leklek Lek", "9999933", "22"}};
        return (data);
    }
}
