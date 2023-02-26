// This code is a class that manages the browser and sets up a WebDriver for Selenium tests.
// It imports necessary libraries and sets up a ChromeDriver.
package utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
// Constructor for BrowserManager class.
public class BrowserManager {
    private WebDriver driver;

    public BrowserManager() {
    }
    // Getter method for WebDriver object.
    public WebDriver getDriver() {
        return this.driver;
    }

    // Method to set up the WebDriver and manage the browser.
    public void setDriver() {
        // Sets up the WebDriver for Chrome.
        WebDriverManager.chromedriver().setup();
        // Initializes the driver with a new ChromeDriver instance.
        this.driver = new ChromeDriver();
        // Maximizes the browser window.
        this.driver.manage().window().maximize();
        // Sets the implicit wait time to 5 seconds.
        this.driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
    }
}