package steps;

import elements.CartPage;
import elements.SearchPage;
import elements.HomePage;
import elements.ProductPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class addToCartSteps {

    WebDriver driver;

    HomePage objHomePage;

    SearchPage objSearch;

    ProductPage objAdd;

    CartPage objCart;

    @Before
    public void setup() {

        // Initialize the webdriver and open the browser
        //System.setProperty("webdriver.gecko.driver", driverPath);
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Given("the user visits the Amazon website")
    public void the_user_visits_the_amazon_website() {
        // open Amazon page
        driver.get("https://www.amazon.com");
    }

    @When("^the user clicks on the product of Gaming accessories option (.*)$")
    public void the_user_clicks_on_the_product_of_gaming_accessories_option(String producto) {
        // go the product page
        objHomePage = new HomePage(driver);
        objHomePage.clickOption(producto);
    }

   @When("the page should load")
    public void the_page_should_load() {
        /// Verify product page
        objSearch = new SearchPage(driver);
        Assert.assertTrue(objSearch.getHeadsetMenu().getText().isEmpty());
    }

    @When("the user clicks on the first option")
    public void the_user_clicks_on_the_first_option() {
        // go to the first option from Headset results
        objSearch = new SearchPage(driver);
        objSearch.clickFirstOption();
    }

    @When("the user clicks on Add to Cart option")
    public void the_user_clicks_on_add_to_cart_option() {
        // go the Headset page
        objAdd = new ProductPage(driver);
        objAdd.clickCart();
    }

    @When("the user clicks on Go to Cart option")
    public void the_user_clicks_on_go_to_cart_option() {
        // go the Go-to cart page
        objCart = new CartPage(driver);
        objCart.clickGoCart();
    }

    @When("the user clicks on Delete option")
    public void the_user_clicks_on_delete_option() {
        // click on delete option
        objCart = new CartPage(driver);
        objCart.clickDelete();
    }

    @Then("the amazon cart should be empty")
    public void the_amazon_cart_should_be_empty() {
        /// Verify empty page
        objCart = new CartPage(driver);
        //Assert.assertTrue(objCart.getEmpty().getText().contains("Subtotal (0 items):"));
        Assert.assertEquals("Subtotal (0 items):", objCart.getEmpty().getText());
    }

    @When("the user select a random product from Gaming accessories option")
    public void the_user_select_a_random_product_from_gaming_accessories_option() {
        // go the product page
        objHomePage = new HomePage(driver);
        objHomePage.clickRandom();

    }

    @And("^the user select the country (.*)$")
    public void theUserSelectTheCountryColombia(String country) {
        objHomePage = new HomePage(driver);
        objHomePage.clickAddress(country);
    }

    @After
    public void close() {

        // Close the browser
        driver.close();
    }


}
