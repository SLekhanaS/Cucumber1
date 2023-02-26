// Declaring required class level variables
package steps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.BrowserManager;

public class Hooks {
    private final BrowserManager browserManager;
    // Getting the worksheet from workbook
    public Hooks(BrowserManager browserManager) {
        this.browserManager = browserManager;
    }

    @Before(
            order = 0
    )
    public void setUp() {
        this.browserManager.setDriver();
    }
    // Adding column value to row data map
    @After
    public void tearDown() {
        this.browserManager.getDriver();
    }
}