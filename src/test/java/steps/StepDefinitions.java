package steps;
//?fjhef
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

    private WebDriver driver;
    AmazonSearchTest amazonPage;
    String url;
    HashMap<String, String> data;
    Scenario scenario;

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
        amazonPage.getSearchBar().sendKeys("The Ordinary Serum");
        amazonPage.getSearchBar().sendKeys(Keys.ENTER);

    }

    @Then("the product results should be displayed")
    public void the_product_results_should_be_displayed() {
        String search_info = amazonPage.getSearchInfo().getText();
        Assert.assertEquals(search_info, "\"The Ordinary Serum\"");
    }

    @Then("the user is on the Amazon homepage")
    public void theUserIsOnTheAmazonHomepage() {
        url = QaProps.getValue("url");
        driver.get(url);
        data = TestDataReader.getData(scenario.getName());
        amazonPage = new AmazonSearchTest(driver);
        amazonPage.getSearchBar().click();
    }

    @And("the user has searched for a product")
    public void theUserHasSearchedForAProduct() {
        amazonPage.getSearchBar().sendKeys("Smart Watch");
        amazonPage.getSearchBar().sendKeys(Keys.ENTER);

    }

    @When("the user selects a product from the search results")
    public void theUserSelectsAProductFromTheSearchResults() {
        //amazonPage.getSearchBar().click();
        amazonPage.getSearchBar().sendKeys("Noise smart watch for women");
        amazonPage.getSearchBar().sendKeys(Keys.ENTER);


    }

    @Then("the user should see the product detail page")
    public void theUserShouldSeeTheProductDetailPage() {

        String search_info = amazonPage.getSearchInfo().getText();
        //amazonPage.getSearchInfo().click();
        Assert.assertEquals(search_info, "\"smart watch noise smart watch for women\"");
    }


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

    @Then("the user see particular product detail page")
    public void theUserSeeParticularProductDetailPage() {
        String search_info = amazonPage.getSearchInfo1().getText();
        //amazonPage.getSearchInfo().click();
        Assert.assertEquals(search_info, "\"Lakme lipstick\"");


    }

    @And("the user again back to another url1")
    public void theUserAgainBackToAnotherUrl1() {
        url = QaProps.getValue("url1");
        driver.get(url);
        data = TestDataReader.getData(scenario.getName());
        amazonPage = new AmazonSearchTest(driver);
        amazonPage.getSearchBar().click();
        this.driver.manage().timeouts().implicitlyWait(450L, TimeUnit.SECONDS);

        //throw new io.cucumber.java.PendingException();
//        @Test
//        public void testcase4() throws InterruptedException{
//            By by = By.id("twotabsearchtextbox");
//            WebElement element = driver.findElement(by);
//            element.sendKeys("perfumes");
//            Thread.sleep(1000);
//            element.sendKeys(Keys.ENTER);
//            Thread.sleep(2000);
//            driver.findElement(By.xpath("//a[@class=\"a-link-normal s-no-outline\"][1]")).click();
//            Thread.sleep(2000);
//        }

    }

    //    @When("the user go back to homepage")
//    public void theUserGobackToHomepage() {
//        url = QaProps.getValue("url");
//        driver.get(url);
//        data = TestDataReader.getData(scenario.getName());
//        amazonPage = new AmazonSearchTest(driver);
//        amazonPage.getSearchBar().click();
//
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
//    WebDriver driver;


    @When("the user goes back to the homepage")
    public void theUserGoesBackToTheHomepage() {

        driver.get("https://www.amazon.in/cart/smart-wagon?newItems=f737b346-42a2-488c-b8f4-93f3eb6db646,2");

    }


    @Then("the user enters {string}")
    public void the_user_enters(String string) {

        driver.get(string);
    }

//
//
//      driver.findElement(By.id("twotabsearchtextbox")).sendKeys(url);
//      driver.findElement(By.id("nav-search-submit-button")).click();
//      String currentUrl = driver.getCurrentUrl();
//      Assert.assertEquals(url, currentUrl);
//
//   }

//        @Then("The product price is displayed correctly")
//        public void theProductPriceIsDisplayedCorrectly() {


    //amazonPage.getSearchInfo2();
//        String search_info = amazonPage.getSearchInfo2().getText();
//       Assert.assertEquals(search_info, "About this item");

    //  }
//    @When("the user go back to homepage")
//    public void theUserGobackToHomepage() {
//        url = QaProps.getValue("url");
//        driver.get(url);
//        data = TestDataReader.getData(scenario.getName());
//        amazonPage = new AmazonSearchTest(driver);
//        amazonPage.getSearchBar().click();

//    }
    //    @When("the user search wrong text")
//    public void theUserSearchWrongText() {
//        amazonPage.getSearchBar().sendKeys(",ass';l;kd;andl,s'jlkadlkd;");
//        amazonPage.getSearchBar().sendKeys(Keys.ENTER);
//    }
//    @Then("the user enter wrong another uRl")
//    public void theUserEnterWrongAnotherURl() {
//        url = QaProps.getValue("uRl");
//        driver.get(url);
//        data = TestDataReader.getData(scenario.getName());
//        amazonPage = new AmazonSearchTest(driver);
//        amazonPage.getSearchBar().click();
//
//
//    }
//    @When("the user goes back to the homepage")
//    public void theUserGoesBackToTheHomepage() {
//    }
//
//    @Then("the user enters \\{string}")
//    public void theUserEntersString() {
//    }

//    @Then("the user gets no results page")
//    public void theUserGetsNoResultsPage() {
//        String search_info = amazonPage.getSearchInfo().getText();
//        Assert.assertEquals(search_info, "\",ass';l;kd;andl,s'jlkadlkd;\"");
//    }


    // @And("the product detail page should display all the relevant information such as price, description,images, etc.")
    //public void theProductDetailPageShouldDisplayAllTheRelevantInformationSuchAsPriceDescriptionImagesEtc() {
    //}

    //@When("the user applies filters like price range, product type, etc.")
    //public void theUserAppliesFiltersLikePriceRangeProductTypeEtc() {
    //}

    //@Then("the user should see the filtered results")
    //public void theUserShouldSeeTheFilteredResults() {
    //}

}