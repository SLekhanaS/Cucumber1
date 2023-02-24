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

public class StepDefinitions {
    // Declare global variables
    private WebDriver driver;
    AmazonSearchTest amazonPage;
    String url;
    HashMap<String, String> data;
    Scenario scenario;
    // Constructor to set browser driver
    public StepDefinitions(BrowserManager browserManager) {
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
        amazonPage.getSearchBar().sendKeys("The Ordinary Serum");
        amazonPage.getSearchBar().sendKeys(Keys.ENTER);

    }
    // Method to assert if product results are displayed
    @Then("the product results should be displayed")
    public void the_product_results_should_be_displayed() {
        String search_info = amazonPage.getSearchInfo().getText();
        Assert.assertEquals(search_info, "\"The Ordinary Serum\"");
    }
    // Method to assert if user is on the Amazon homepage
    @Then("the user is on the Amazon homepage")
    public void theUserIsOnTheAmazonHomepage() {
        url = QaProps.getValue("url");
        driver.get(url);
        data = TestDataReader.getData(scenario.getName());
        amazonPage = new AmazonSearchTest(driver);
        amazonPage.getSearchBar().click();
    }
    // Method to search for a product
    @And("the user has searched for a product")
    public void theUserHasSearchedForAProduct() {
        amazonPage.getSearchBar().sendKeys("Smart Watch");
        amazonPage.getSearchBar().sendKeys(Keys.ENTER);

    }
    // Method to select a product from the search results
    @When("the user selects a product from the search results")
    public void theUserSelectsAProductFromTheSearchResults() {
        //amazonPage.getSearchBar().click();
        amazonPage.getSearchBar().sendKeys("Noise smart watch for women");
        amazonPage.getSearchBar().sendKeys(Keys.ENTER);


    }
    // Method to assert if user is on the product detail page
    @Then("the user should see the product detail page")
    public void theUserShouldSeeTheProductDetailPage() {

        String search_info = amazonPage.getSearchInfo().getText();
        //amazonPage.getSearchInfo().click();
        Assert.assertEquals(search_info, "\"smart watch noise smart watch for women\"");
    }
// Method to navigate back to Amazon homepage

    @Then("the user back to Amazon homepage")
    public void theUserBackToAmazonHomepage() {

        url = QaProps.getValue("url");
        driver.get(url);
        data = TestDataReader.getData(scenario.getName());
        amazonPage = new AmazonSearchTest(driver);
        amazonPage.getSearchBar().click();
    }

    @And("the user search a product")
    public void theUserSearchAProduct() {
        amazonPage.getSearchBar().sendKeys("Lakme lipstick");
        amazonPage.getSearchBar().sendKeys(Keys.ENTER);


    }
    // This method checks if the user has landed on the particular product detail page
    @Then("the user see particular product detail page")
    public void theUserSeeParticularProductDetailPage() {
        String search_info = amazonPage.getSearchInfo1().getText();
        //amazonPage.getSearchInfo().click();
        Assert.assertEquals(search_info, "\"Lakme lipstick\"");


    }
    // This method takes the user back to another URL and initializes the AmazonSearchTest
    @And("the user again back to another url1")
    public void theUserAgainBackToAnotherUrl1() {
        url = QaProps.getValue("url1");
        driver.get(url);
        data = TestDataReader.getData(scenario.getName());
        amazonPage = new AmazonSearchTest(driver);
        amazonPage.getSearchBar().click();
//        this.driver.manage().timeouts().implicitlyWait(450L, TimeUnit.SECONDS);




    }
// This method takes the user back to another URL and initializes the AmazonSearchTest

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