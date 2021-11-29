package pages.mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

// Actions that can be performed on the sign up page
public class SignupPage extends BasePage {

    public SignupPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id="form_sign_up_email_input")
    private MobileElement emailField;

    @AndroidFindBy(id="form_sign_up_continue")
    private MobileElement continueButton;

    @AndroidFindBy(className="android.widget.ImageButton")
    private MobileElement backButton;

    @AndroidFindBy(id="form_input_view_validation_container_text")
    private MobileElement validationError;

    public SignupPage inputEmailAddress(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public SignupPage tapContinueButton() {
        continueButton.click();
        return this;
    }

    public SignupPage tapBackButton() {
        backButton.click();
        return this;
    }

    public boolean isContinueButtonEnabled() {
        return continueButton.isEnabled();
    }

    public boolean isEmailValidationErrorDisplayed() {
        return validationError.isDisplayed()
                && validationError.getText().equals("Please enter a valid email address");
    }

}
