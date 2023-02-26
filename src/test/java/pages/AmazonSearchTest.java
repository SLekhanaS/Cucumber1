package pages;
// It imports necessary libraries
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
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
// declare variables

public class AmazonSearchTest {
    private WebDriver driver;

    public AmazonSearchTest(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    //web elements for searchbar
    @FindBy(xpath = "//input[@id=\"twotabsearchtextbox\"]")
    @Getter
    WebElement SearchBar;
    @FindBy(xpath = "//span[@class=\"a-color-state a-text-bold\"]")

    WebElement SearchInfo;
    @FindBy(xpath = "//span[@class=\"a-size-base-plus a-color-base a-text-normal\"]")
    WebElement SearchResult;
    @FindBy(xpath = "//span[@class=\"a-color-state a-text-bold\"]")
    WebElement SearchInfo1;

//    public AbstractButton getSearchInfo() {
//       return SearchInfo;
//    }


//   public WebElement getSearchBar() {
//       return SearchBar;
//    }

    //web elements for search info
//    public WebElement getSearchInfo() {
//        return SearchInfo;
//    }

    //web elements for search results

//   public WebElement getSearchResult() {
//    return SearchResult;
//   }


//    public WebElement getSearchInfo1() {
//        return SearchInfo1;
//    }



//    @FindBy(xpath = "//h1[@ class=\"a-size-base-plus a-text-bold\"]")
//    private WebElement searchInfo2;

//    public WebElement getSearchInfo2() {
//        return searchInfo2;
//    }


//    public WebDriver getDriver() {
//        return driver;
//    }
}