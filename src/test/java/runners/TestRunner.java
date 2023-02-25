// This package contains the Test Runner class
// Importing necessary classes from Cucumber and TestNG
package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

// Annotation specifying the Cucumber options for running the tests
@CucumberOptions(features = "src/test/resources/features",
        glue = "steps",publish = true,
        plugin = {"pretty", "html:target/cucumber-reports.html","json:target/cucumber-reports.json"},
        monochrome = true
)
// The Test Runner class extends the AbstractTestNGCucumberTests class
public class TestRunner extends AbstractTestNGCucumberTests {
    // DataProvider annotation specifies that this method returns test data for parallel execution
    @DataProvider(parallel = true)
    public Object[][] scenarios(){
        return super.scenarios();
    }
}