// This code is a TestNG test runner class for running Cucumber tests.
// Importing required libraries
package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/resources/features",
        glue = "steps",// Location of step definitions
         publish = true,
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)
// Test runner class that extends AbstractTestNGCucumberTests
public class TestRunner extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = true)
    // A DataProvider that returns scenarios for parallel execution
    public Object[][] scenarios(){
        return super.scenarios();
    }
}