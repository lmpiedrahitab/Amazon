package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    WebDriver driver;

    @FindBy(id = "add-to-cart-button")
    WebElement cartButton;

    public ProductPage(WebDriver driver) {
        this.driver = driver;

        // This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    // Click on add to cart product
    public void clickCart() {
        cartButton.click();
    }
}
