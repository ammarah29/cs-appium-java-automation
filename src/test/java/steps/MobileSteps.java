package steps;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.mobile.LandingPage;
import pages.mobile.SignupPage;
import utils.AppiumDriverManager;

public class MobileSteps {

    private final AppiumDriver driver = AppiumDriverManager.getAppiumDriver();

    @Given("I am a ClearScore customer")
    public void i_am_a_clearscore_customer() {
        new LandingPage(driver).tapLoginButton();
    }

    @Given("I am not a ClearScore customer")
    public void i_am_not_a_clearscore_customer() {
        new LandingPage(driver).tapCreateNewAccountButton();
    }

    @When("I enter email address {string}")
    public void i_enter_email_address(String email) {
        new SignupPage(driver).inputEmailAddress(email);
    }

    @When("I try to log in with email {string} and password {string}")
    public void i_try_to_log_in_with_email_and_password(String email, String password) {
        // Unable to see login page due to connection error
    }

    @Then("I am shown an invalid login alert")
    public void i_am_shown_an_invalid_login_alert() {
        // Unable to see login page due to connection error
    }

    @When("I tap on the continue button")
    public void i_tap_on_the_continue_button() {
        new SignupPage(driver).tapContinueButton();
    }

    @Then("I am taken to step one of registration")
    public void i_am_taken_to_step_one_of_registration() {
        // Unable to see registration page due to connection error
    }

    @Then("^I expect the continue button (is|is not) enabled")
    public void i_expect_the_continue_button_is_enabled(String expectedVisibility) {
        boolean isContinueButtonEnabled = new SignupPage(driver).isContinueButtonEnabled();
        if (expectedVisibility.equals("is")) {
            Assert.assertTrue(isContinueButtonEnabled);
        } else if (expectedVisibility.equals("is not")) {
            Assert.assertFalse(isContinueButtonEnabled);
        }
    }

    @Then("I expect an email validation error is displayed")
    public void i_expect_an_email_validation_error_is_displayed() {
        Assert.assertTrue(new SignupPage(driver).isEmailValidationErrorDisplayed());
    }

    @When("I tap on the back button")
    public void i_tap_on_the_back_button() {
        new SignupPage(driver).tapBackButton();
    }

    @Then("I go back to the landing page")
    public void i_go_back_to_the_landing_page() {
        Assert.assertTrue(new LandingPage(driver).isLandingLogoImageDisplayed());
    }

}
