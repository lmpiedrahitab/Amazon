package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    @FindBy(css = "[aria-label=Headsets]")
    WebElement headsetOption;

    public HomePage(WebDriver driver) {
        this.driver = driver;

        // This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    // Click on Headset option from Home Page
    public void clickHeadset() {
        headsetOption.click();
    }
}
