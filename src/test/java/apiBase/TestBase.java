package apiBase;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

public class TestBase {

    public static RequestSpecification httpReq;
    public static Response response;
    public String empID = "51838";

    public Logger logger;

    @BeforeClass
    public void setup() {

        logger = org.apache.log4j.Logger.getLogger("EmployeesRestAPI");
        PropertyConfigurator.configure("Log4j.properties");
        logger.setLevel(Level.DEBUG);
    }
}
        