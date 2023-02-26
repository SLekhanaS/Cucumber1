package steps;
//import packages;
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
//    declare variables

    private WebDriver driver;
    AmazonSearchTest amazonPage;
    String url;
    HashMap<String, String> data;
    Scenario scenario;
//    private byte[] text;

    public StepDefinitions(BrowserManager browserManager) {
        this.driver = browserManager.getDriver();
    }

    @Before(order = 1)
    public void before(Scenario scenario) {
        this.scenario = scenario;

    }


    @Given("the user navigates to the home page")
    public void the_user_navigates_to_the_home_page() {
        url = QaProps.getValue("url");
        driver.get(url);
        data = TestDataReader.getData(scenario.getName());
        amazonPage = new AmazonSearchTest(driver);

        amazonPage.getSearchBar().click();
    }

    @When("the user enter the product name")
    public void the_user_enter_the_product_name() {
        amazonPage.getSearchBar().sendKeys(data.get("SearchProduct"));
        amazonPage.getSearchBar().sendKeys(Keys.ENTER);

    }

    @Then("the product results should be displayed")
    public void the_product_results_should_be_displayed() throws InterruptedException  {
        String text= amazonPage.getSearchBar().getText();
//        Thread.sleep(3000);
        WaitUtils.waitTillVisible(driver,this.amazonPage.getSearchBar());
        WebElement search_info =this.amazonPage.getSearchBar();
        Assert.assertTrue(search_info.isDisplayed());
//        Assert.assertTrue(text.contains(data.get("SearchProduct")));
//        Thread.sleep(3000);
    }

    @Given("the user is on the Amazon homepage")
    public void theUserIsOnTheAmazonHomepage() {
        url = QaProps.getValue("url");
        driver.get(url);
        data = TestDataReader.getData(scenario.getName());
        amazonPage = new AmazonSearchTest(driver);
        amazonPage.getSearchBar().click();
    }

    @When("the user has searched for a product")
    public void theUserHasSearchedForAProduct() {
        amazonPage.getSearchBar().sendKeys(data.get("SearchProduct"));
        amazonPage.getSearchBar().sendKeys(Keys.ENTER);

    }

//    @And("the user selects a product from the search results")
//    public void theUserSelectsAProductFromTheSearchResults() {
    //amazonPage.getSearchBar().click();
//        amazonPage.getSearchBar().sendKeys(data.get("SearchProduct"));
//        amazonPage.getSearchBar().sendKeys(Keys.ENTER);


//    }

    @Then("the user should see the product detail page")
    public void theUserShouldSeeTheProductDetailPage() throws InterruptedException {
        url = QaProps.getValue("url3");
        driver.get(url);
        data = TestDataReader.getData(scenario.getName());
        amazonPage = new AmazonSearchTest(driver);
        amazonPage.getSearchBar().click();
//        String text= amazonPage.getSearchBar().getText();
//       Thread.sleep(3000);
//        WaitUtils.waitTillVisible(driver,this.amazonPage.getSearchBar());
//        WebElement search_info =this.amazonPage.getSearchBar();
//        Assert.assertTrue(search_info.isDisplayed());
//        Assert.assertTrue(text.contains(data.get("SearchProduct")));
//        Thread.sleep(3000);




    }

    @Given("the user back to Amazon homepage")
    public void theUserBackToAmazonHomepage() {

        url = QaProps.getValue("url");
        driver.get(url);
        data = TestDataReader.getData(scenario.getName());
        amazonPage = new AmazonSearchTest(driver);
        amazonPage.getSearchBar().click();
    }

    @When("the user search a product")
    public void theUserSearchAProduct() {
        amazonPage.getSearchBar().sendKeys(data.get("SearchProduct"));
        amazonPage.getSearchBar().sendKeys(Keys.ENTER);


    }

    @Then("the user see particular product detail page")
    public void theUserSeeParticularProductDetailPage() throws InterruptedException {
        String text= amazonPage.getSearchBar().getText();
//        Thread.sleep(3000);
        WaitUtils.waitTillVisible(driver,this.amazonPage.getSearchBar());
        WebElement search_info =this.amazonPage.getSearchBar();
        Assert.assertTrue(search_info.isDisplayed());
//        Assert.assertTrue(text.contains(data.get("SearchProduct")));
//        Thread.sleep(3000);


    }

    @And("the user again back to another url1")
    public void theUserAgainBackToAnotherUrl1() {
        url = QaProps.getValue("url1");
        driver.get(url);
        data = TestDataReader.getData(scenario.getName());
        amazonPage = new AmazonSearchTest(driver);
        amazonPage.getSearchBar().click();
//        this.driver.manage().timeouts().implicitlyWait(450L, TimeUnit.SECONDS);
    }


//    @Given("the user  back to another url")
//    public void theUserBackToAnotherUrl() {
//        url = QaProps.getValue("url");
//        driver.get(url);
//        data = TestDataReader.getData(scenario.getName());
//        amazonPage = new AmazonSearchTest(driver);
//        amazonPage.getSearchBar().click();
//    }
    @And("the user again back to another url2")
    public void theUserAgainBackToAnotherUrl2() {
        url = QaProps.getValue("url2");
        driver.get(url);
        data = TestDataReader.getData(scenario.getName());
        amazonPage = new AmazonSearchTest(driver);
        amazonPage.getSearchBar().click();
//        this.driver.manage().timeouts().implicitlyWait(450L, TimeUnit.SECONDS);
    }
//    @When("the user enters wrong text")
//    public void theUserEntersWrongText() {
//        amazonPage.getSearchBar().sendKeys(data.get("SearchProduct"));
//        amazonPage.getSearchBar().sendKeys(Keys.ENTER);
//
//    }


    @When("the user goes back to the homepage")
    public void theUserGoesBackToTheHomepage() {
//        url = QaProps.getValue("uRl");
//        driver.get(url);
//        data = TestDataReader.getData(scenario.getName());
//        amazonPage = new AmazonSearchTest(driver);
//        amazonPage.getSearchBar().click();

        driver.get("https://www.amazon.in/cart/smart-wagon?newItems=f737b346-42a2-488c-b8f4-93f3eb6db646,2");

    }


    @Then("the user enters {string}")
    public void the_user_enters(String string) {

        driver.get(string);
    }

//    @Given("the user  back to another url")
//    public void theUserBackToAnotherUrl() {
//    }

//    @When("the user enters wrong text")
//    public void theUserEntersWrongText() {
//    }
}