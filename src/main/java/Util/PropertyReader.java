package Util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    private String propertyFileName;

    public PropertyReader(String propertyFileName) {
        this.propertyFileName = propertyFileName;
    }

    public String getProperties(String propertyName) {
        Properties properties = new Properties();
        String property = null;
        try (InputStream inputStream = PropertyReader.class.getClassLoader().getResourceAsStream(propertyFileName)) {
            properties.load(inputStream);
            property = properties.getProperty(propertyName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property;
    }
}
