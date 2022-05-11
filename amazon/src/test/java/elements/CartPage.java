package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    WebDriver driver;

    @FindBy(id = "sw-gtc")
    WebElement goCartButton;

    @FindBy(xpath = "//input[@data-action=\"delete\"]")
    WebElement deleteButton;

    @FindBy(id = "sc-subtotal-label-activecart")
    WebElement emptyOption;

    public CartPage(WebDriver driver) {
        this.driver = driver;

        // This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    // Click on go to cart option
    public void clickGoCart() {
        goCartButton.click();
    }

    // Click on delete option
    public void clickDelete() {
        deleteButton.click();
    }

    // Get information of the cart status
    public WebElement getEmpty() {
        return emptyOption;
    }
}
