package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public enum PropertiesManager {
    INSTANCE;

    private final Properties properties;
    private static final String propertiesPath = "src/test/resources/properties/config.properties";
    private static final String baseUrl = "baseUrl";
    private static final String app = "app";
    private static final String appPackage = "appPackage";
    private static final String appActivity = "appActivity";
    private static final String deviceName = "deviceName";
    private static final String deviceVersion = "deviceVersion";

    PropertiesManager() {
        properties = new Properties();
        try {
            File propertiesFile = new File(propertiesPath);
            if (propertiesFile.exists()) {
                properties.load(new FileInputStream(propertiesPath));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        if (properties.getProperty(key) != null) {
            return properties.getProperty(key);
        } else {
            return null;
        }
    }

}
