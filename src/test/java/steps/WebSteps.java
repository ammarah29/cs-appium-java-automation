package steps;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.web.HomePage;
import utils.AppiumDriverManager;

public class WebSteps {

    private final AppiumDriver driver = AppiumDriverManager.getAppiumDriver();

    @Given("I navigate to the ClearScore home page")
    public void i_navigate_to_the_clearscore_home_page() {
        new HomePage(driver).navigateToHomePage();
    }

    @Then("^I expect the cookie notification (is|is not) displayed")
    public void i_expect_the_cookie_notification_is_displayed(String expectedVisibility) {
        boolean isNotificationDisplayed = new HomePage(driver).isCookieNotificationDisplayed();
        if (expectedVisibility.equals("is")) {
            Assert.assertTrue(isNotificationDisplayed);
        } else if (expectedVisibility.equals("is not")) {
            Assert.assertFalse(isNotificationDisplayed);
        }
    }

    @When("I dismiss the cookie notification")
    public void i_dismiss_the_cookie_notification() {
        new HomePage(driver).tapDismissButton();
    }

    @When("I refresh the page")
    public void i_refresh_the_page() {
        new HomePage(driver).refereshPage();
    }

    @Then("I expect the appropriate cookies are set")
    public void i_expect_the_appropriate_cookies_are_set() {
        Assert.assertTrue(new HomePage(driver).isClearScoreCookieSet());
    }

}
