// Import necessary packages
package steps;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.AmazonSearchTest;

import utils.BrowserManager;
import utils.QaProps;
import utils.TestDataReader;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import utils.WaitUtils;

public class StepDefinitions {

    // Declare global variables
    private WebDriver driver;
    AmazonSearchTest amazonPage;
    String url;
    HashMap<String, String> data;
    Scenario scenario;


    public StepDefinitions(BrowserManager browserManager) {
        // Constructor to set browser driver
        this.driver = browserManager.getDriver();
    }
    // Method to set the scenario
    @Before(order = 1)
    public void before(Scenario scenario) {
        this.scenario = scenario;

    }

    // Method to navigate to the home page
    @Given("the user navigates to the home page")
    public void the_user_navigates_to_the_home_page() {
        url = QaProps.getValue("url");
        driver.get(url);
        data = TestDataReader.getData(scenario.getName());
        amazonPage = new AmazonSearchTest(driver);

        amazonPage.getSearchBar().click();
    }
    // Method to enter the product name
    @When("the user enter the product name")
    public void the_user_enter_the_product_name() {
        amazonPage.getSearchBar().sendKeys(data.get("SearchProduct"));
        amazonPage.getSearchBar().sendKeys(Keys.ENTER);

    }
    // Method to assert if product results are displayed
    @Then("the product results should be displayed")
    public void the_product_results_should_be_displayed() throws InterruptedException  {
        String text= amazonPage.getSearchBar().getText();
//        Thread.sleep(3000);
        WaitUtils.waitTillVisible(driver,this.amazonPage.getSearchBar());
        WebElement search_info =this.amazonPage.getSearchBar();
        Assert.assertTrue(search_info.isDisplayed());
    }
    // Method to assert if user is on the Amazon homepage
    @Given("the user is on the Amazon homepage")
    public void theUserIsOnTheAmazonHomepage() {
        url = QaProps.getValue("url");
        driver.get(url);
        data = TestDataReader.getData(scenario.getName());
        amazonPage = new AmazonSearchTest(driver);
        amazonPage.getSearchBar().click();
    }
    // Method to search for a product
    @When("the user has searched for a product")
    public void theUserHasSearchedForAProduct() {
        amazonPage.getSearchBar().sendKeys(data.get("SearchProduct"));
        amazonPage.getSearchBar().sendKeys(Keys.ENTER);

    }
    // Method to select a product from the search results
    @Then("the user should see the product detail page")
    public void theUserShouldSeeTheProductDetailPage() throws InterruptedException {
        url = QaProps.getValue("url3");
        driver.get(url);
        data = TestDataReader.getData(scenario.getName());
        amazonPage = new AmazonSearchTest(driver);
    }
    // Method to navigate back to Amazon homepage
    @Given("the user back to Amazon homepage")
    public void theUserBackToAmazonHomepage() {

        url = QaProps.getValue("url");
        driver.get(url);
        data = TestDataReader.getData(scenario.getName());
        amazonPage = new AmazonSearchTest(driver);
        amazonPage.getSearchBar().click();
    }
    // This method checks if the user has landed on the particular product detail page
    @When("the user search a product")
    public void theUserSearchAProduct() {
        amazonPage.getSearchBar().sendKeys(data.get("SearchProduct"));
        amazonPage.getSearchBar().sendKeys(Keys.ENTER);
    }
    // This method takes the user back to another URL and initializes the AmazonSearchTest
    @Then("the user see particular product detail page")
    public void theUserSeeParticularProductDetailPage() throws InterruptedException {
        String text= amazonPage.getSearchBar().getText();
        WaitUtils.waitTillVisible(driver,this.amazonPage.getSearchBar());
        WebElement search_info =this.amazonPage.getSearchBar();
        Assert.assertTrue(search_info.isDisplayed());
    }
    // This method takes the user back to another URL and initializes the AmazonSearchTest
    @And("the user again back to another url1")
    public void theUserAgainBackToAnotherUrl1() {
        url = QaProps.getValue("url1");
        driver.get(url);
        data = TestDataReader.getData(scenario.getName());
        amazonPage = new AmazonSearchTest(driver);
        amazonPage.getSearchBar().click();
    }

// This method takes the user back to the homepage

    @And("the user again back to another url2")
    public void theUserAgainBackToAnotherUrl2() {
        url = QaProps.getValue("url2");
        driver.get(url);
        data = TestDataReader.getData(scenario.getName());
        amazonPage = new AmazonSearchTest(driver);
        amazonPage.getSearchBar().click();
    }

// This method takes the user back to the homepage

    @When("the user goes back to the homepage")
    public void theUserGoesBackToTheHomepage() {

        driver.get("https://www.amazon.in/cart/smart-wagon?newItems=f737b346-42a2-488c-b8f4-93f3eb6db646,2");

    }

    // This method takes the user to a specific URL
    @Then("the user enters {string}")
    public void the_user_enters(String string) {

        driver.get(string);
    }

}