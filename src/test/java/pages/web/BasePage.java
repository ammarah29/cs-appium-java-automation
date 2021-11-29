package pages.web;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

// Common actions for web pages
public class BasePage {

    public AppiumDriver driver;
    public WebDriverWait wait;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    public void refereshPage() {
        driver.navigate().refresh();
    }

}
