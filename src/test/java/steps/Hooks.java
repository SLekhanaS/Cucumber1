// This code is a Java class that defines hooks to be executed before and after each scenario in a Cucumber test.
// Importing required libraries
package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.BrowserManager;

public class Hooks {
    // Declaring required class level variables
    private final BrowserManager browserManager;

    public Hooks(BrowserManager browserManager) {
        // Constructor to set the browser manager object
        this.browserManager = browserManager;
    }
    // Before hook to set up the driver
    @Before(order = 0)
    public void setUp() {
        this.browserManager.setDriver();
    }
    // Calling the setDriver method to set up the driver
    // After hook to tear down the driver
    @After
    // Calling the getDriver method to tear down the driver
    public void tearDown() {
        this.browserManager.getDriver();
    }
}