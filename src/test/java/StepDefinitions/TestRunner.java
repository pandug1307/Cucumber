package StepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/LoginPage.feature",
        glue = {"StepDefinitions"},
        //monochrome = true,
        //dryRun=false,
        plugin = {"pretty", "html:target/reports"}
//                "pretty", "usage:target/cucumber-usage.json",
//                "pretty", "junit:target/cucumber-results.xml"}
        //tags= "@smoketest"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}