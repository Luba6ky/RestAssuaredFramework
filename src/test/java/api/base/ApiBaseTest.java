package api.base;

import api.utils.logging.Log;
import api.utils.config.PropertyReader;
import io.restassured.RestAssured;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ApiBaseTest extends PropertyReader {

    @BeforeMethod
    public void setup() {
        Log.env = "API";
        Log.startLog("RestAssured Tests Started");
        RestAssured.baseURI = getProperties().getProperty("baseUri");
    }

    @AfterMethod
    public void tearDown() {
        Log.endLog("RestAssured Tests Completed");
    }
}
