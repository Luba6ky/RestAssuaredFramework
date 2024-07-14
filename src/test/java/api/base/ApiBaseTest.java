package api.base;

import api.utils.logging.Log;
import api.utils.config.PropertyReader;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class ApiBaseTest extends PropertyReader {

    @BeforeEach
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

    @AfterEach
    public void tearDown() {
        Log.endLog("RestAssured Tests Completed");
    }
}
