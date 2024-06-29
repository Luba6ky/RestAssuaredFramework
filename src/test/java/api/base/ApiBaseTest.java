package api.base;

import api.utils.logging.Log;
import api.utils.config.PropertyReader;
import io.restassured.RestAssured;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ApiBaseTest extends PropertyReader {

    @BeforeMethod(alwaysRun = true)
    public void setup() throws Exception {
        Log.env = "API";
        Log.startLog("RestAssured Tests Started");
        String baseUri = getProperties().getProperty("baseUri");
        if (baseUri != null) {
            RestAssured.baseURI = baseUri;
            Log.info("Base URI set to: " + baseUri);
        } else {
            Log.error(new RuntimeException("Base URI is not set in the properties file."), "Base URI is not set. Check the properties file.");
            throw new RuntimeException("Base URI is not set in the properties file.");
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        Log.endLog("RestAssured Tests Completed");
    }
}
