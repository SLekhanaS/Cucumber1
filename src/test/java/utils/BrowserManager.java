// This code is a Java class that manages the WebDriver instance for Chrome browser using WebDriverManager library.

// Importing required libraries
package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserManager {
    // Declaring required class level variables
    private WebDriver driver;
    // Constructor
    public BrowserManager() {
    }
    // A public method that returns the WebDriver instance
    public WebDriver getDriver() {
        return this.driver;
    }
    // A public method that sets up the WebDriver instance for Chrome browser
    public void setDriver() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
    }
}
