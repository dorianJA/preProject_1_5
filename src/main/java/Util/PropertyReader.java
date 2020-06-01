package Util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    public static Properties getProperties(InputStream propertyFile) {
        Properties properties = new Properties();
        try {
            properties.load(propertyFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
