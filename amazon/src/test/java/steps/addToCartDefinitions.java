package steps;

import elements.CartPage;
import elements.HeadsetPage;
import elements.HomePage;
import elements.ProductPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class addToCartDefinitions {

    WebDriver driver;

    HomePage objHomePage;

    HeadsetPage objSearch;

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

    @When("the user clicks on the Headsets of Gaming accesories option")
    public void the_user_clicks_on_the_headsets_of_gaming_accesories_option() {
        // go the Headset page
        objHomePage = new HomePage(driver);
        objHomePage.clickHeadset();
    }

    @When("the page should load")
    public void the_page_should_load() {
        /// Verify Headset page
        objSearch = new HeadsetPage(driver);
        Assert.assertTrue(objSearch.getHeadsetMenu().getText().contains("gaming headsets"));
    }

    @When("the user clicks on the first option")
    public void the_user_clicks_on_the_first_option() {
        // go to the first option from Headset results
        objSearch = new HeadsetPage(driver);
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

    @After
    public void close() {

        // Close the browser
        driver.close();
    }

}
