// This code is a Java class file for testing Amazon search functionality using Selenium WebDriver.
// It imports necessary libraries, sets up the driver, and initializes web elements using Page Factory.

package pages;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import javax.naming.directory.SearchResult;
import javax.swing.*;
import static org.openqa.selenium.By.*;
// Constructor to initialize the driver and Page Factory elements.
public class AmazonSearchTest {
    WebDriver driver;

    public AmazonSearchTest(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    // Method to set up the driver before the test is run.
    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    // Web element for the search bar on Amazon.
    @FindBy(xpath = "//input[@id=\"twotabsearchtextbox\"]")
    private WebElement SearchBar;
    public WebElement getSearchBar() {
        return SearchBar;
    }
    // Web element for the search result info on Amazon.
    public WebElement getSearchInfo() {
        return SearchInfo;
    }
    @FindBy(xpath = "//span[@class=\"a-color-state a-text-bold\"]")

    private WebElement SearchInfo;

    // Web element for another search result info on Amazon.

    public WebElement getSearchInfo1() {
        return SearchInfo1;
    }
    // Method to get the other search result info element.
    @FindBy(xpath = "//span[@class=\"a-color-state a-text-bold\"]")
    private WebElement SearchInfo1;


// Method to get the driver instance.

    public WebDriver getDriver() {
        return driver;
    }
}