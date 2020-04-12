package ddt.LessonDataProviderIn;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ddt4 {

    @Test(dataProvider = "data")
    void ddt4(String ename, String esal, String eage) {

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
        String[][] data = {{"Johny Bravo1", "400000", "31"}, {"Pesho Bicepsa", "40000000", "43"}};
        return (data);
    }
}
