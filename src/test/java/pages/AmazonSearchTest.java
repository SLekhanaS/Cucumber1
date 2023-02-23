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
    @FindBy(xpath = "//input[@id=\"twotabsearchtextbox\"]")
    private WebElement SearchBar;
    public WebElement getSearchBar() {
        return SearchBar;
    }
    public WebElement getSearchInfo() {
        return SearchInfo;
    }
    @FindBy(xpath = "//span[@class=\"a-color-state a-text-bold\"]")

    private WebElement SearchInfo;

//    public WebElement getSearchResult() {
//       return SearchResult;
//    }

//    @FindBy(xpath = "//span[@class=\"a-size-base-plus a-color-base a-text-normal\"]")
//    private WebElement SearchResult;

    public WebElement getSearchInfo1() {
        return SearchInfo1;
    }

    @FindBy(xpath = "//span[@class=\"a-color-state a-text-bold\"]")
    private WebElement SearchInfo1;

//    @FindBy(xpath = "//h1[@ class=\"a-size-base-plus a-text-bold\"]")
//    private WebElement searchInfo2;

//    public WebElement getSearchInfo2() {
//        return searchInfo2;
//    }


    public WebDriver getDriver() {
        return driver;
    }
}