package ddt.LessonDataProviderIn;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ddt12 {
    @Test(dataProvider = "data")
    void ddt12(String ename, String esal, String eage) {
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        RequestSpecification httpReq = RestAssured.given();

        JSONObject list = new JSONObject();
        list.put("name", ename);
        list.put("salary", esal);
        list.put("age", eage);

        httpReq.header("Content-type", "application/json");
        httpReq.body(list.toJSONString());

        Response response = httpReq.request(Method.POST, "/create");

        String responceBody = response.getBody().asString();
        System.out.println(responceBody);
        Assert.assertEquals(responceBody.contains(ename), true);

        int responseCode = response.getStatusCode();
        System.out.println(responceBody);

    }


    @DataProvider(name = "data")
    Object[] data() {
        String[][] data = {{"Pesho Mesho", "24000", "23"}, {"Chocho Cho", "23000", "22"}};
        return (data);
    }
}
