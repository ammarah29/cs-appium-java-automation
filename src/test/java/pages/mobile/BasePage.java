package pages.mobile;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

// Common actions for mobile screens, I haven't added anything here but have left this in for good practise
public class BasePage {

    public AppiumDriver driver;
    public WebDriverWait wait;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

}
