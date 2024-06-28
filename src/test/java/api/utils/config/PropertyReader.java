package api.utils.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    Properties properties;

    public Properties getProperties() {
        properties = new Properties();
        InputStream configFile = null;
        try {
            configFile = getClass().getClassLoader().getResourceAsStream("api/config/zetta.properties");
            if (configFile != null) {
                properties.load(configFile);
            } else {
                throw new RuntimeException("Property file 'api/config/zetta.properties' not found in the classpath");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
