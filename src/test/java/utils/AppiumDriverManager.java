package utils;

import io.appium.java_client.AppiumDriver;

public class AppiumDriverManager {

    public static AppiumDriver appiumDriver;

    public static AppiumDriver getAppiumDriver() {
        return appiumDriver;
    }

    public void setAppiumDriver(AppiumDriver driver) {
        this.appiumDriver = driver;
    }
}
