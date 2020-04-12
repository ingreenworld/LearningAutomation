package ddt.LessonDataProviderIn;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dd15 {

    @Test(dataProvider = "data")
    void ddt14(String ename, String eage, String esal) {
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        RequestSpecification httReq = RestAssured.given();

        JSONObject list = new JSONObject();
        list.put("name", ename);
        list.put("age", eage);
        list.put("salary", esal);

        httReq.body(list.toJSONString());
        httReq.header("Content-type", "application/json");
        Response response = httReq.request(Method.POST, "create");

        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
    }


    @DataProvider(name = "data")
    Object[] data() {
        String[][] data = {{"Pesho Petoto", "24", "40000"}};
        return (data);
    }
}
