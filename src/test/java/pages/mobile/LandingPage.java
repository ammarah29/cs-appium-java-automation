package pages.mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

// Actions that can be performed on the landing page
public class LandingPage extends BasePage {

    public LandingPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id="clearscore_logo")
    private MobileElement landingLogo;

    @AndroidFindBy(id="signupButton")
    private MobileElement createNewAccount;

    @AndroidFindBy(id="loginButton")
    private MobileElement loginButton;

    public SignupPage tapCreateNewAccountButton() {
        createNewAccount.click();
        return new SignupPage(driver);
    }

    public LandingPage tapLoginButton() {
        loginButton.click();
        return this;
    }

    public boolean isLandingLogoImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(landingLogo));
        return landingLogo.isDisplayed();
    }

}
