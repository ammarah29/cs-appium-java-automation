package pages.web;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import utils.PropertiesManager;

// Actions that can be performed on the home page
public class HomePage extends BasePage {

    public HomePage (AppiumDriver driver) {
        super(driver);
    }

    public static final By cookieNotification = By.xpath("//*[@data-qa='notification']");
    public static final By dismissButton = By.xpath("//*[@data-qa='notification']//*[@data-qa='button']");

    public HomePage navigateToHomePage() {
        driver.get(PropertiesManager.INSTANCE.getProperty("baseUrl"));
        return this;
    }

    public boolean isCookieNotificationDisplayed() {
        try {
            return driver.findElement(cookieNotification).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public HomePage tapDismissButton() {
        driver.findElement(dismissButton).click();
        return this;
    }

    public boolean isClearScoreCookieSet() {
        return driver.manage().getCookieNamed("CS_ACCEPT_COOKIES").getValue().equals("true");
    }
}
