package ddt.LessonDataProviderIn;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ddt14 {

    @Test(dataProvider = "data")
    void ddt14(String ime, String pari, String god) {
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        RequestSpecification httpreq = RestAssured.given();

        JSONObject list = new JSONObject();
        list.put("name", ime);
        list.put("salary", pari);
        list.put("age", god);

        httpreq.header("Content-type", "application/json");
        httpreq.body(list.toJSONString());

        Response response = httpreq.request(Method.POST, "/create");

        String body = response.getBody().asString();
        System.out.println(body);

        Assert.assertEquals(body.contains(ime), true);
    }

    @DataProvider(name = "data")
    Object[] data() {
        String[][] data = {{"Pesho Mesho", "240000", "29"}, {"Menche Menche", "233300", "24"}};
        return data;
    }
}
