package steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.AppiumDriverManager;
import utils.PropertiesManager;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;

public class Hooks extends AppiumDriverManager {

    protected static AppiumDriverLocalService appiumService;
    public static AppiumDriver driver;

    public AppiumDriverLocalService startAppiumServer() throws InterruptedException {
        appiumService = AppiumDriverLocalService.buildService(
                new AppiumServiceBuilder()
                        .usingPort(4723)
                        .withArgument(GeneralServerFlag.ALLOW_INSECURE, "chromedriver_autodownload") // Downloads chrome driver for web
                        .withLogFile(new File("src/test/resources/logs/appiumServer.log")) // Location of logs
        );
        appiumService.start();
        return appiumService;
    }

    @Before("@mobile") // Any tests that have tag @mobile will use this method
    public void setupMobileCapabilities() throws InterruptedException, MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, PropertiesManager.INSTANCE.getProperty("deviceName")); // Use 'adb devices' to get info
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, PropertiesManager.INSTANCE.getProperty("deviceVersion"));
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2"); // Using UiAutomator2 for mobile
        caps.setCapability(MobileCapabilityType.APP, "src/test/resources/apps/" + PropertiesManager.INSTANCE.getProperty("app")); // Use apk this location to run tests
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, PropertiesManager.INSTANCE.getProperty("appPackage")); // Install apk to get APP_PACKAGE 'abd shell pm list packages -f' to see all of app info
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, PropertiesManager.INSTANCE.getProperty("appActivity")); // Get APP_ACTIVITY 'adb shell pm dump com.clearscore.mobile.alpha | grep -A 1 MAIN'
        startAppiumServer();
        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps); // On this driver I want the listed capabilities above
        setAppiumDriver(driver);
    }

    @Before("@web") // Any tests that have tag @web will use this method
    public void setupWebCapabilities() throws InterruptedException, MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, PropertiesManager.INSTANCE.getProperty("deviceName")); // Use 'adb devices' to get info
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, PropertiesManager.INSTANCE.getProperty("deviceVersion"));
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(AndroidMobileCapabilityType.BROWSER_NAME, "Chrome"); // Declares browser to be used for web tests
        caps.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE_DIR, "src/test/resources/drivers"); // Location of the chrome driver
        startAppiumServer();
        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        setAppiumDriver(driver);
    }

    @After
    public void shutdownAppium(Scenario scenario) {
        if(scenario.isFailed()) {
            File file = ((TakesScreenshot) getAppiumDriver()).getScreenshotAs(OutputType.FILE);
            try {
                // If test fails get screenshot of where it failed
                scenario.attach(Files.readAllBytes(file.toPath()), "image/png", "failure" + System.currentTimeMillis() + ".png");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (driver != null) {
            getAppiumDriver().quit();
        }
        if (appiumService != null) {
            appiumService.stop();
        }
    }
}
