// Importing required libraries
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
// constructor to initialize driver
public class AmazonSearchTest {
    WebDriver driver;

    public AmazonSearchTest(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    // locating and storing the search bar element
    @FindBy(xpath = "//input[@id=\"twotabsearchtextbox\"]")
    private WebElement SearchBar;
    public WebElement getSearchBar() {
        return SearchBar;
    }
    public WebElement getSearchInfo() {
        return SearchInfo;
    }
    // locating and storing the search info element
    @FindBy(xpath = "//span[@class=\"a-color-state a-text-bold\"]")

    private WebElement SearchInfo;
    public WebElement getSearchInfo1() {
        return SearchInfo1;
    }
    // locating and storing the search info 1 element
    @FindBy(xpath = "//span[@class=\"a-color-state a-text-bold\"]")
    private WebElement SearchInfo1;
    // getter method for driver
    public WebDriver getDriver() {
        return driver;
    }
}