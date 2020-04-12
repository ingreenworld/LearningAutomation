package ddt.LessonDataProviderIn;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ddt3 {

    @Test(dataProvider = "data")
    void ddt3(String ename, String esal, String eage) {
        System.out.println(System.getProperty("user.dir"));
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        RequestSpecification httpRequest = RestAssured.given();

        JSONObject list = new JSONObject();
        list.put("name", ename);
        list.put("salary", esal);
        list.put("age", eage);

        httpRequest.header("Content-type", "application/json");
        httpRequest.body(list.toJSONString());

        Response response = httpRequest.request(Method.POST, "/create");

        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
        Assert.assertEquals(responseBody.contains(ename), true);
        Assert.assertEquals(responseBody.contains(esal), true);
        Assert.assertEquals(responseBody.contains(eage), true);

    }

    @DataProvider(name = "data")
    Object[] data() {
        String[][] data = {{"Pesho Peshev", "35000", "33"}, {"Cinco Cincev", "40000", "55"}};
        return (data);
    }
}
