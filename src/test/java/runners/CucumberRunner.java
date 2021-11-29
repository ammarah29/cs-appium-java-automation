package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

// Cucumber test runner
@CucumberOptions(
        features = {"src/test/resources/features"}, // Location of the feature files
        glue = {"steps"}, // Location of the step defs
        plugin = {"pretty", "html:src/test/resources/reports/cucumber.html"}, // Produces the report
        monochrome = true,
        tags = "@web or @mobile") // Tags available to pick up

public class CucumberRunner extends AbstractTestNGCucumberTests { // Uses TestNG to run tests

}
