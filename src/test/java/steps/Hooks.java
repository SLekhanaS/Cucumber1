// Import necessary classes
package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.BrowserManager;
// Constructor to initialize the driver and hooks.
public class Hooks {
    private final BrowserManager browserManager;

    public Hooks(BrowserManager browserManager) {
        this.browserManager = browserManager;
    }

    @Before(
            order = 0
    )
    public void setUp() {
        this.browserManager.setDriver();
    }

    @After
    public void tearDown() {
        this.browserManager.getDriver();
    }
}